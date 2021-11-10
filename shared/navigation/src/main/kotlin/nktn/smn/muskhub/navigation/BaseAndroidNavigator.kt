package nktn.smn.muskhub.navigation

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
internal open class BaseAndroidNavigator(
    protected val containerId: Int
) : AndroidNavigator {

    protected val localStackCopy = mutableListOf<String>()
    private val pendingRoutes = mutableListOf<SimpleRoute>()
    private var fragment: Fragment? = null

    override fun attachTo(fragment: Fragment) {
        this.fragment = fragment
        pendingRoutes.forEach { executeRoute(fragment, it) }
        pendingRoutes.clear()
    }

    override fun detach() {
        this.fragment = null
    }

    override fun executeRoute(route: SimpleRoute) {
        //TODO Не забыть про "FragmentManager is already executing transactions"
        fragment
            ?.let { executeRoute(it, route) }
            ?: kotlin.run { pendingRoutes.add(route) }
    }

    private fun executeRoute(fragment: Fragment, route: SimpleRoute) {
        when (route) {
            is Add -> executeAdd(fragment.requireActivity(), fragment.childFragmentManager, route)
            is Replace -> executeReplace(fragment.requireActivity(), fragment.childFragmentManager, route)
            is Back -> executeBack(fragment.requireActivity(), fragment.childFragmentManager, route)
        }
    }

    protected open fun executeAdd(activity: Activity, fragmentManager: FragmentManager, route: Add) {
        when (route.screen) {
            is ActivityScreen -> checkAndStartActivity(activity, route.screen)
            is FragmentScreen -> commitNewFragmentScreen(fragmentManager, route.screen, true)
        }
    }

    protected open fun executeReplace(activity: Activity, fragmentManager: FragmentManager, route: Replace) {
        when (val screen = route.screen) {
            is ActivityScreen -> {
                checkAndStartActivity(activity, screen)
                activity.finish()
            }
            is FragmentScreen -> {
                if (localStackCopy.isNotEmpty()) {
                    fragmentManager.popBackStack()
                    localStackCopy.removeAt(localStackCopy.lastIndex)
                    commitNewFragmentScreen(fragmentManager, screen, true)
                } else {
                    commitNewFragmentScreen(fragmentManager, screen, false)
                }
            }
        }
    }

    protected open fun executeBack(activity: Activity, fragmentManager: FragmentManager, back: Back) {
        if (localStackCopy.isNotEmpty()) {
            fragmentManager.popBackStack()
            localStackCopy.removeAt(localStackCopy.lastIndex)
        } else {
            activity.finish()
        }
    }

    protected open fun commitNewFragmentScreen(
        fragmentManager: FragmentManager,
        screen: FragmentScreen,
        addToBackStack: Boolean
    ) {
        val fragment = screen.createFragment()
        val transaction = fragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        setupFragmentTransaction(
            screen,
            transaction,
            fragmentManager.findFragmentById(containerId),
            fragment
        )
        if (screen.clearContainer) {
            transaction.replace(containerId, fragment, screen.screenKey)
        } else {
            transaction.add(containerId, fragment, screen.screenKey)
        }
        if (addToBackStack) {
            transaction.addToBackStack(screen.screenKey)
            localStackCopy.add(screen.screenKey)
        }
        transaction.commit()
    }

    /**
     * Override this method to setup fragment transaction [FragmentTransaction].
     * For example: setCustomAnimations(...), addSharedElement(...) or setReorderingAllowed(...)
     *
     * @param fragmentTransaction fragment transaction
     * @param currentFragment     current fragment in container
     *                            (for [Replace] route it will be screen previous in new chain, NOT replaced screen)
     * @param nextFragment        next screen fragment
     */
    protected open fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        // Do nothing by default
    }

    private fun checkAndStartActivity(activity: Activity, screen: ActivityScreen) {
        // Check if we can start activity
        val activityIntent = screen.createIntent(activity)
        try {
            activity.startActivity(activityIntent, screen.startActivityOptions)
        } catch (e: ActivityNotFoundException) {
            unexistingActivity(screen, activityIntent)
        }
    }

    /**
     * Called when there is no activity to open `screenKey`.
     *
     * @param screen         screen
     * @param activityIntent intent passed to start Activity for the `screenKey`
     */
    protected open fun unexistingActivity(
        screen: ActivityScreen,
        activityIntent: Intent
    ) {
        // Do nothing by default
    }
}