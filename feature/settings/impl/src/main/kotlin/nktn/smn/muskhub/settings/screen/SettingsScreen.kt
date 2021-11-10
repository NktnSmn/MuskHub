package nktn.smn.muskhub.settings.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nktn.smn.muskhub.settings.R
import nktn.smn.muskhub.settings.api.SettingsScreenFactory

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
internal class SettingsScreen : Fragment() {

    companion object : SettingsScreenFactory {
        override fun createSettingsActivityScreen(): Fragment = SettingsScreen()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = layoutInflater.inflate(R.layout.settings_screen, container, false)
        view.findViewById<View>(R.id.backBtn).setOnClickListener {
            parentFragment?.childFragmentManager?.popBackStack() ?: requireActivity().onBackPressed()
        }
        return view
    }
}