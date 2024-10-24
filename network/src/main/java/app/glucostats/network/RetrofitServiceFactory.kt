package app.glucostats.network

import retrofit2.Retrofit

object RetrofitServiceFactory {

    fun <T> createService(retrofit: Retrofit, serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}