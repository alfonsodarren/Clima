package co.pop.clima.ui.weather.presentation

import co.pop.clima.common.DEFAULT_CITY_NAME
import co.pop.clima.ui.base.BaseViewModel
import co.pop.clima.ui.base.Error
import co.pop.clima.ui.base.Loading
import co.pop.clima.ui.base.Success
import co.pop.clima.ui.weather.view.WeatherViewEffects
import co.pop.domain.interaction.weather.GetWeatherUseCase
import co.pop.domain.model.WeatherInfo
import co.pop.domain.model.onFailure
import co.pop.domain.model.onSuccess

class WeatherViewModel(private val getWeather: GetWeatherUseCase) : BaseViewModel<WeatherInfo, WeatherViewEffects>() {

    fun getWeatherForLocation(location: String = DEFAULT_CITY_NAME) = executeUseCase {
        getWeather(location)
            .onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }
}
