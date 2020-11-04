package co.pop.clima.ui.weather.view.fragments

import co.pop.clima.R
import co.pop.clima.common.convertKelvinToCelsius
import co.pop.clima.common.extensions.hideKeyboard
import co.pop.clima.common.extensions.onClick
import co.pop.clima.common.extensions.snackbar
import co.pop.clima.common.extensions.subscribe
import co.pop.clima.ui.base.*
import co.pop.clima.ui.weather.presentation.WeatherViewModel
import co.pop.domain.model.WeatherInfo
import kotlinx.android.synthetic.main.fragment_weather.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherFragment : BaseFragment() {

    private val viewModel: WeatherViewModel by viewModel()

    override fun getLayout() = R.layout.fragment_weather

    override fun viewReady() {
//    viewModel.getWeatherForLocation()
        subscribeToData()

        getWeather.onClick {
            weatherFragmentContainer.hideKeyboard()
            viewModel.getWeatherForLocation(cityInput.text.toString())
        }

        showWeatherDetails.onClick { appFragmentNavigator.showWeatherDetails() }
    }

    private fun subscribeToData() {
        viewModel.viewState.subscribe(this, ::handleViewState)
    }

    private fun handleViewState(viewState: ViewState<WeatherInfo>) {
        when (viewState) {
            is Loading -> showLoading(weatherLoadingProgress)
            is Success -> showWeatherData(viewState.data)
            is Error -> handleError(viewState.error.localizedMessage)
            is NoInternetState -> showNoInternetError()
        }
    }

    private fun handleError(error: String) {
        hideLoading(weatherLoadingProgress)
        showError(error, weatherFragmentContainer)
    }

    private fun showNoInternetError() {
        hideLoading(weatherLoadingProgress)
        snackbar(getString(R.string.no_internet_error_message), weatherFragmentContainer)
    }

    private fun showWeatherData(weatherInfo: WeatherInfo) {
        hideLoading(weatherLoadingProgress)
        temperature.text = convertKelvinToCelsius(weatherInfo.temperature)
        pressure.text = weatherInfo.pressure.toString()
        humidity.text = weatherInfo.humidity.toString()
    }

    companion object {
        fun newInstance() = WeatherFragment()
    }
}