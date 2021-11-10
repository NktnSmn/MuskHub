package nktn.smn.muskhub.main.api

import android.content.Context
import android.content.Intent

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
interface MainScreenFactory {

    fun createMainScreenIntent(context: Context): Intent
}