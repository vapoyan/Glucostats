package app.glucostats.network

import okio.IOException
import retrofit2.HttpException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
    return try {
        Result.success(apiCall())
    } catch (throwable: Throwable) {
        when (throwable) {
            is IOException -> Result.failure(IOException("Network Error: ${throwable.localizedMessage}"))
            is HttpException -> {
                val message = throwable.response()?.errorBody()?.string() ?: throwable.message()
                Result.failure(Exception("API Error: Code ${throwable.code()}, Message: $message"))
            }
            else -> Result.failure(Exception("Unexpected Error: ${throwable.localizedMessage}"))
        }
    }
}