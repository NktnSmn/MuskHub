package nktn.smn.muskhub.composable_sdui.ui

import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import nktn.smn.muskhub.composable_sdui.dto.chains.Chain
import nktn.smn.muskhub.composable_sdui.dto.chains.toStyle
import nktn.smn.muskhub.composable_sdui.dto.constraint.ConstraintType
import nktn.smn.muskhub.composable_sdui.dto.constraint.LinearConstraint
import nktn.smn.muskhub.composable_sdui.dto.constraint.SingleConstraint

fun ConstraintSetScope.createVerticalChains(chains: Array<Chain>) {
    createChains(chains) { elementIds, style -> createVerticalChain(*elementIds, chainStyle = style) }
}

fun ConstraintSetScope.createHorizontalChains(chains: Array<Chain>) {
    createChains(chains) { elementIds, style -> createHorizontalChain(*elementIds, chainStyle = style) }
}

private fun ConstraintSetScope.createChains(
    chains: Array<Chain>,
    createChain: ConstraintSetScope.(elementIds: Array<ConstrainedLayoutReference>, style: ChainStyle) -> Unit
) {
    chains.forEach { createChain(it.elementIds.map(::createRefFor).toTypedArray(), it.type.toStyle()) }
}

fun ConstrainScope.linkToHorizontal(constraint: LinearConstraint<ConstraintType.Horizontal>) {
    if (constraint.start != null && constraint.end != null) {
        linkTo(
            top = anchorFor(constraint = constraint.start),
            bottom = anchorFor(constraint = constraint.end),
            topMargin = constraint.start.margin.dp,
            bottomMargin = constraint.end.margin.dp,
            bias = constraint.bias
        )
    } else {
        linkTo(anchorable = top, constraint = constraint.start)
        linkTo(anchorable = bottom, constraint = constraint.end)
    }
}

fun ConstrainScope.linkToVertical(constraint: LinearConstraint<ConstraintType.Vertical>) {
    if (constraint.start != null && constraint.end != null) {
        linkTo(
            start = anchorFor(constraint = constraint.start),
            end = anchorFor(constraint = constraint.end),
            startMargin = constraint.start.margin.dp,
            endMargin = constraint.end.margin.dp,
            bias = constraint.bias
        )
    } else {
        linkTo(anchorable = start, constraint = constraint.start)
        linkTo(anchorable = end, constraint = constraint.end)
    }
}

private fun ConstrainScope.linkTo(
    anchorable: HorizontalAnchorable,
    constraint: SingleConstraint<ConstraintType.Horizontal>?
) {
    anchorable.linkTo(anchorFor(constraint ?: return), constraint.margin.dp)
}

private fun ConstrainScope.linkTo(
    anchorable: VerticalAnchorable,
    constraint: SingleConstraint<ConstraintType.Vertical>?
) {
    anchorable.linkTo(anchorFor(constraint ?: return), constraint.margin.dp)
}

private fun ConstrainScope.anchorFor(
    constraint: SingleConstraint<ConstraintType.Horizontal>
): ConstraintLayoutBaseScope.HorizontalAnchor =
    when (constraint.type) {
        ConstraintType.Horizontal.TOP -> refFor(constraint).top
        ConstraintType.Horizontal.BOTTOM -> refFor(constraint).bottom
    }

private fun ConstrainScope.anchorFor(
    constraint: SingleConstraint<ConstraintType.Vertical>
): ConstraintLayoutBaseScope.VerticalAnchor =
    when (constraint.type) {
        ConstraintType.Vertical.START -> refFor(constraint).start
        ConstraintType.Vertical.END -> refFor(constraint).end
    }

private fun ConstrainScope.refFor(constraint: SingleConstraint<*>): ConstrainedLayoutReference =
    if (constraint.elementId == -1) parent else ConstrainedLayoutReference(constraint.elementId)