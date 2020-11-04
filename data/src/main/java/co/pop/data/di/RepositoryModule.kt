package co.pop.data.di

import co.pop.data.common.utils.Connectivity
import co.pop.data.common.utils.ConnectivityImpl
import co.pop.data.repository.weather.WeatherRepositoryImpl
import co.pop.domain.repository.WeatherRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }
    factory<Connectivity> { ConnectivityImpl(androidContext()) }
}
