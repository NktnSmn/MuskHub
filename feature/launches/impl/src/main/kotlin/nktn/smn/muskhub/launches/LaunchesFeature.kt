package nktn.smn.muskhub.launches

import nktn.smn.muskhub.feature.Feature
import nktn.smn.muskhub.launches.api.LaunchesScreenFactory
import nktn.smn.muskhub.launches.screen.LaunchesScreen
import nktn.smn.muskhub.launches.screen.plusScreenDI
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
object LaunchesFeature : Feature {

    override val diModule: Module = module {
        single<LaunchesScreenFactory> { LaunchesScreen.Companion }
        plusScreenDI()
    }
}