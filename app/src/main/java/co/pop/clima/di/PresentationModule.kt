package co.pop.clima.di

import co.pop.clima.ui.weather.presentation.WeatherViewModel
import co.pop.clima.ui.welcome.presentation.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { WeatherViewModel(get()) }
    viewModel { WelcomeViewModel() }
}