package nktn.smn.muskhub.main

import nktn.smn.muskhub.feature.Feature
import nktn.smn.muskhub.main.api.MainScreenFactory
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
object MainFeature : Feature {

    override val diModule: Module = module {
        single<MainScreenFactory> { MainScreen.Companion }
    }
}