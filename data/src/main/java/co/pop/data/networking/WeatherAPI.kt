package co.pop.data.networking

import co.pop.data.di.API_KEY
import co.pop.data.networking.model.WeatherInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI
{
    @GET("weather")
    suspend fun getWeatherForLocation(@Query("q") location: String, @Query("appid") apikey: String = API_KEY): Response<WeatherInfoResponse>
}