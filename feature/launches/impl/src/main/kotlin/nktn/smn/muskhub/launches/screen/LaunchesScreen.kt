package nktn.smn.muskhub.launches.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nktn.smn.muskhub.launches.R
import nktn.smn.muskhub.launches.api.LaunchesScreenFactory

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
internal class LaunchesScreen : Fragment() {

    companion object : LaunchesScreenFactory {
        override fun createLaunchesScreen(): Fragment = LaunchesScreen()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = layoutInflater.inflate(R.layout.launches_screen, container, false)
        view.findViewById<View>(R.id.backBtn).setOnClickListener { requireActivity().onBackPressed() }

        return view
    }
}