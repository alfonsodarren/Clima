package co.pop.clima.ui.weather.view.fragments

import co.pop.clima.R
import co.pop.clima.ui.base.BaseFragment

class WeatherDetailsFragment : BaseFragment() {

    override fun getLayout() = R.layout.fragment_weather_details

    override fun viewReady() {}

    companion object {
        fun newInstance() = WeatherDetailsFragment()
    }
}