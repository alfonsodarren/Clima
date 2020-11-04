package co.pop.clima.ui.weather.view.activities

import android.os.Bundle
import co.pop.clima.R
import co.pop.clima.routing.AppNavigator
import co.pop.clima.routing.ScreenType
import co.pop.clima.ui.base.BaseActivity
import co.pop.clima.ui.weather.view.fragments.WeatherFragment

class WeatherActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        when (intent.getSerializableExtra(AppNavigator.SCREEN_TYPE)) {
            ScreenType.WEATHER -> addFragment(WeatherFragment.newInstance(), R.id.fragmentContainer, true)
            else -> finish()
        }
    }
}