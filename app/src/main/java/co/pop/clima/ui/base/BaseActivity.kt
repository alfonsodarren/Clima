package co.pop.clima.ui.base

import android.view.View
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import co.pop.clima.common.EMPTY_STRING
import co.pop.clima.common.extensions.*
import co.pop.clima.routing.AppNavigator
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class BaseActivity : AppCompatActivity() {

    protected val appNavigator: AppNavigator by inject { parametersOf(this) }

    fun showError(@StringRes errorMessage: Int, rootView: View) = snackbar(errorMessage, rootView)

    fun showError(errorMessage: String?, rootView: View) = snackbar(errorMessage ?: EMPTY_STRING, rootView)

    fun showLoading(progressBar: ProgressBar) = progressBar.visible()

    fun hideLoading(progressBar: ProgressBar) = progressBar.gone()

    fun addFragment(fragment: Fragment, containerId: Int, addToBackStack: Boolean = false) {
        showFragment(fragment, containerId, addToBackStack)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) finish() else goBack()
    }
}