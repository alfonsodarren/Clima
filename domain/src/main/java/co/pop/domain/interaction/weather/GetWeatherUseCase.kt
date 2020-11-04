package co.pop.domain.interaction.weather

import co.pop.domain.base.BaseUseCase
import co.pop.domain.model.Result
import co.pop.domain.model.WeatherInfo

interface GetWeatherUseCase : BaseUseCase<String, WeatherInfo> {

    override suspend operator fun invoke(location: String): Result<WeatherInfo>
}