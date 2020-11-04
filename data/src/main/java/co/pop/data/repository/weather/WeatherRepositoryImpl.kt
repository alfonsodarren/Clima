package co.pop.data.repository.weather

import co.pop.data.database.dao.WeatherDAO
import co.pop.data.database.model.WeatherEntity
import co.pop.data.networking.WeatherAPI
import co.pop.data.networking.base.getData
import co.pop.domain.model.Result
import co.pop.domain.model.WeatherInfo
import co.pop.domain.repository.WeatherRepository

class WeatherRepositoryImpl (private val weatherAPI: WeatherAPI, private val weatherDAO: WeatherDAO) : BaseRepository<WeatherInfo, WeatherEntity>(), WeatherRepository {
    override suspend fun getWeatherForLocation(location: String) : Result<WeatherInfo> {
        return fetchData(
            apiDataProvider = {
                weatherAPI.getWeatherForLocation(location).getData(
                    fetchFromCacheAction = { weatherDAO.getWeatherInfoForCity(location) },
                    cacheAction = { weatherDAO.saveWeatherInfo(it) }
                )
            },
            dbDataProvider = { weatherDAO.getWeatherInfoForCity(location) }
        )
    }
}