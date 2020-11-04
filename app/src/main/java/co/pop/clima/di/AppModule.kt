package co.pop.clima.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import co.pop.clima.routing.AppFragmentNavigator
import co.pop.clima.routing.AppNavigator
import co.pop.data.common.coroutine.CoroutineContextProvider
import org.koin.dsl.module

val appModule = module {
    single { CoroutineContextProvider() }
    single { (activity: AppCompatActivity) -> AppNavigator(activity) }
    single { (activity: FragmentActivity) -> AppFragmentNavigator(activity) }
}