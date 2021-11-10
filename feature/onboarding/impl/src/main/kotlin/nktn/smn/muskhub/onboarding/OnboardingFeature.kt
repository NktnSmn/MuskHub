package nktn.smn.muskhub.onboarding

import nktn.smn.muskhub.feature.Feature
import nktn.smn.muskhub.onboarding.api.OnboardingScreenFactory
import nktn.smn.muskhub.onboarding.screen.OnboardingScreen
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
object OnboardingFeature : Feature {

    override val diModule: Module = module {
        single<OnboardingScreenFactory> { OnboardingScreen.Companion }
    }
}