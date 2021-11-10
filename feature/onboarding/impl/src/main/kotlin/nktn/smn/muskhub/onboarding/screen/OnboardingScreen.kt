package nktn.smn.muskhub.onboarding.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import nktn.smn.muskhub.composable_sdui.dto.Layout
import nktn.smn.muskhub.onboarding.R
import nktn.smn.muskhub.onboarding.api.OnboardingScreenFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
internal class OnboardingScreen : Fragment() {

    companion object : OnboardingScreenFactory {
        override fun createOnboardingScreen(): Fragment = OnboardingScreen()
    }

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val onboardingAdapter = OnboardingAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView: View = inflater.inflate(R.layout.onboarding_screen, container, false)
        viewPager = rootView.findViewById(R.id.viewPager)
        tabLayout = rootView.findViewById(R.id.tabLayout)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val json =
            Json {
                encodeDefaults = true
                ignoreUnknownKeys = true
                isLenient = true
            }
        val jsonString: String = json.encodeToString(pageLayoutWithChains)
        val layout = json.decodeFromString<Layout>(jsonString)

        onboardingAdapter.pageLayouts = listOf(layout)
        viewPager.adapter = onboardingAdapter
        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()
    }
}