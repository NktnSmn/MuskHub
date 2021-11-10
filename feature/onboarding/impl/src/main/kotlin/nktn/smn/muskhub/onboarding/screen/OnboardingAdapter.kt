package nktn.smn.muskhub.onboarding.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import coil.compose.rememberImagePainter
import nktn.smn.muskhub.composable_sdui.dto.Layout
import nktn.smn.muskhub.composable_sdui.dto.elements.Element
import nktn.smn.muskhub.composable_sdui.dto.elements.ImageElement
import nktn.smn.muskhub.composable_sdui.dto.elements.TextElement
import nktn.smn.muskhub.composable_sdui.ui.createHorizontalChains
import nktn.smn.muskhub.composable_sdui.ui.createVerticalChains
import nktn.smn.muskhub.composable_sdui.ui.linkToHorizontal
import nktn.smn.muskhub.composable_sdui.ui.linkToVertical
import nktn.smn.muskhub.onboarding.R

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
internal class OnboardingAdapter : RecyclerView.Adapter<OnboardingPageViewHolder>() {

    var pageLayouts: List<Layout> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = pageLayouts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingPageViewHolder =
        OnboardingPageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.onboarding_page, parent, false))

    override fun onBindViewHolder(holder: OnboardingPageViewHolder, position: Int) {
        holder.bind(pageLayouts[position])
    }
}

internal class OnboardingPageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val composeView: ComposeView = view.findViewById(R.id.composeView)

    fun bind(layout: Layout) {
        val constrainSet =
            ConstraintSet {
                createVerticalChains(layout.verticalChains)
                createHorizontalChains(layout.horizontalChains)
                layout.constraints.forEach { constraint ->
                    val ref: ConstrainedLayoutReference = createRefFor(constraint.elementId)
                    constrain(ref) {
                        constraint.horizontal?.let { linkToHorizontal(it) }
                        constraint.vertical?.let { linkToVertical(it) }
                    }
                }
            }
        composeView.setContent {
            ConstraintLayout(constraintSet = constrainSet, modifier = Modifier.fillMaxSize()) {
                layout.elements.forEach { element ->
                    when (element) {
                        is TextElement ->
                            Text(text = element.content, modifier = Modifier.onElement(element))
                        is ImageElement ->
                            Image(
                                painter = rememberImagePainter(data = element.url),
                                contentDescription = null,
                                modifier = Modifier.onElement(element)
                            )
                    }
                }
            }
        }
    }

    private fun Modifier.onElement(element: Element): Modifier =
        then(
            Modifier
                .layoutId(element.id)
                .width(element.width.dp)
                .height(element.height.dp)
        )
}