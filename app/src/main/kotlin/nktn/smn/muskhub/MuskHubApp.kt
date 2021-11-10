package nktn.smn.muskhub

import android.app.Application
import nktn.smn.muskhub.feature.Feature
import nktn.smn.muskhub.main.MainFeature
import nktn.smn.muskhub.settings.SettingsFeature
import nktn.smn.muskhub.onboarding.OnboardingFeature
import nktn.smn.muskhub.launches.LaunchesFeature
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
internal class MuskHubApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val features: List<Feature> = listOf(
            SettingsFeature,
            LaunchesFeature,
            MainFeature,
            OnboardingFeature
        )
        startKoin {
            androidContext(this@MuskHubApp)
            modules(features.map(Feature::diModule))
        }
    }
}