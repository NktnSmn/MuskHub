package nktn.smn.muskhub

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import nktn.smn.muskhub.launches.api.LaunchesScreenFactory
import nktn.smn.muskhub.onboarding.api.OnboardingScreenFactory
import nktn.smn.muskhub.settings.api.SettingsScreenFactory
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val launchesScreenFactory: LaunchesScreenFactory by inject()
    private val settingsScreenFactory: SettingsScreenFactory by inject()
    private val onboardingScreenFactory: OnboardingScreenFactory by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.launchesBtn).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.screenContainer, launchesScreenFactory.createLaunchesScreen(), "LAUNCHES")
                .addToBackStack(null)
                .commit()
        }
        findViewById<View>(R.id.settingsBtn).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.screenContainer, settingsScreenFactory.createSettingsActivityScreen(), "SETTINGS")
                .addToBackStack(null)
                .commit()
        }
        findViewById<View>(R.id.onboardingBtn).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.screenContainer, onboardingScreenFactory.createOnboardingScreen(), "ONBOARDING")
                .addToBackStack(null)
                .commit()
        }
    }
}