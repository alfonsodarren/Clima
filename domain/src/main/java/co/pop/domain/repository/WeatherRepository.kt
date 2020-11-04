package co.pop.domain.repository

import co.pop.domain.model.Result
import co.pop.domain.model.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherForLocation(location: String): Result<WeatherInfo>
}