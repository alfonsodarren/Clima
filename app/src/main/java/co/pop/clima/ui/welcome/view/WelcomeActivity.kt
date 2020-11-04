package co.pop.clima.ui.welcome.view

import android.os.Bundle
import co.pop.clima.R
import co.pop.clima.common.extensions.onClick
import co.pop.clima.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        nextScreen.onClick {
            appNavigator.showWeatherActivity()
            finish()
        }
    }
}