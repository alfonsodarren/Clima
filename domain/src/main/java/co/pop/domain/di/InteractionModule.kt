package co.pop.domain.di

import co.pop.domain.interaction.weather.GetWeatherUseCase
import co.pop.domain.interaction.weather.GetWeatherUseCaseImpl
import org.koin.dsl.module

val interactionModule = module {
    factory<GetWeatherUseCase> { GetWeatherUseCaseImpl(get()) }
}
