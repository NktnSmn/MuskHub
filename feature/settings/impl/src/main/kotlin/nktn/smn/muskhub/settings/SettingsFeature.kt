package nktn.smn.muskhub.settings

import nktn.smn.muskhub.feature.Feature
import nktn.smn.muskhub.settings.api.SettingsScreenFactory
import nktn.smn.muskhub.settings.screen.SettingsScreen
import nktn.smn.muskhub.settings.screen.plusScreenDI
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
object SettingsFeature : Feature {

    override val diModule: Module = module {
        single<SettingsScreenFactory> { SettingsScreen.Companion }
        plusScreenDI()
    }
}