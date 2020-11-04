package co.pop.domain.interaction.weather

import co.pop.domain.repository.WeatherRepository

class GetWeatherUseCaseImpl (private val weatherRepository: WeatherRepository) : GetWeatherUseCase
{
    override suspend operator fun invoke (location: String) = weatherRepository.getWeatherForLocation(location)
}