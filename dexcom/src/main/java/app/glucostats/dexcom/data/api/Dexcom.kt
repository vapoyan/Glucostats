package app.glucostats.dexcom.data.api

import app.glucostats.dexcom.data.model.AlertsResponse
import app.glucostats.dexcom.data.model.CalibrationsResponse
import app.glucostats.dexcom.data.model.DataRangeResponse
import app.glucostats.dexcom.data.model.DevicesResponse
import app.glucostats.dexcom.data.model.EgvsResponse
import app.glucostats.dexcom.data.model.EventsResponse
import app.glucostats.dexcom.data.model.TokenResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * DexcomApi - Defines endpoints and methods to interact with Dexcom APIs.
 */
interface Dexcom {

    /**
     * Authenticate with Dexcom to get an access token.
     * @param clientId The client ID assigned by Dexcom.
     * @param clientSecret The client secret assigned by Dexcom.
     * @param code The authorization code received after user authorization.
     * @param grantType The type of OAuth grant (default: authorization_code).
     * @param redirectUri The redirect URI used in the authorization process.
     * @return A TokenResponse object containing the access token.
     */
    @POST("v2/oauth2/token")
    @FormUrlEncoded
    suspend fun authenticate(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String,
        @Field("grant_type") grantType: String = "authorization_code",
        @Field("redirect_uri") redirectUri: String
    ): TokenResponse

    /**
     * Refresh the access token using the refresh token.
     * @param clientId The client ID assigned by Dexcom.
     * @param clientSecret The client secret assigned by Dexcom.
     * @param refreshToken The refresh token obtained from previous authentication.
     * @param grantType The type of OAuth grant (default: refresh_token).
     * @return A TokenResponse object containing the new access token.
     */
    @POST("v2/oauth2/token")
    @FormUrlEncoded
    suspend fun refreshAccessToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("refresh_token") refreshToken: String,
        @Field("grant_type") grantType: String = "refresh_token"
    ): TokenResponse

    /**
     * Retrieve estimated glucose values (EGVs) for a specific time range.
     * @param accessToken The access token for authorization.
     * @param startDate The start date of the range in ISO 8601 format.
     * @param endDate The end date of the range in ISO 8601 format.
     * @return An EgvsResponse object containing the list of EGVs.
     */
    @GET("v3/users/self/egvs")
    suspend fun getEgvs(
        @Header("Authorization") accessToken: String,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): EgvsResponse

    /**
     * Retrieve alerts for a specific time range.
     * @param accessToken The access token for authorization.
     * @param startDate The start date of the range in ISO 8601 format.
     * @param endDate The end date of the range in ISO 8601 format.
     * @return An AlertsResponse object containing the list of alerts.
     */
    @GET("v3/users/self/alerts")
    suspend fun getAlerts(
        @Header("Authorization") accessToken: String,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): AlertsResponse

    /**
     * Retrieve calibration events for a specific time range.
     * @param accessToken The access token for authorization.
     * @param startDate The start date of the range in ISO 8601 format.
     * @param endDate The end date of the range in ISO 8601 format.
     * @return A CalibrationsResponse object containing the list of calibrations.
     */
    @GET("v3/users/self/calibrations")
    suspend fun getCalibrations(
        @Header("Authorization") accessToken: String,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): CalibrationsResponse

    /**
     * Retrieve events for a specific time range.
     * @param accessToken The access token for authorization.
     * @param startDate The start date of the range in ISO 8601 format.
     * @param endDate The end date of the range in ISO 8601 format.
     * @return An EventsResponse object containing the list of events.
     */
    @GET("v3/users/self/events")
    suspend fun getEvents(
        @Header("Authorization") accessToken: String,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String
    ): EventsResponse

    /**
     * Retrieve the user's devices.
     * @param accessToken The access token for authorization.
     * @return A DevicesResponse object containing the list of devices.
     */
    @GET("v3/users/self/devices")
    suspend fun getDevices(
        @Header("Authorization") accessToken: String
    ): DevicesResponse

    /**
     * Retrieve the data range available for the user.
     * @param accessToken The access token for authorization.
     * @return A DataRangeResponse object containing the data range.
     */
    @GET("v3/users/self/dataRange")
    suspend fun getDataRange(
        @Header("Authorization") accessToken: String
    ): DataRangeResponse
}