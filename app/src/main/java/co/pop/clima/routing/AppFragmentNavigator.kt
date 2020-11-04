package co.pop.clima.routing

import androidx.fragment.app.FragmentActivity
import co.pop.clima.R
import co.pop.clima.common.extensions.showFragment
import co.pop.clima.ui.weather.view.fragments.WeatherDetailsFragment

class AppFragmentNavigator(private val activity: FragmentActivity) : FragmentNavigator {
    override fun showWeatherDetails() = activity.showFragment(WeatherDetailsFragment.newInstance(), R.id.fragmentContainer, true)
}