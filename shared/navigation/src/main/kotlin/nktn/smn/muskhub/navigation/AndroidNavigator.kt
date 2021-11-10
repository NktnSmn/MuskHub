package nktn.smn.muskhub.navigation

import androidx.fragment.app.Fragment

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
internal interface AndroidNavigator : Navigator {

    fun attachTo(fragment: Fragment)

    fun detach()
}