package nktn.smn.muskhub.onboarding.screen

import nktn.smn.muskhub.composable_sdui.dto.Layout
import nktn.smn.muskhub.composable_sdui.dto.chains.Chain
import nktn.smn.muskhub.composable_sdui.dto.chains.ChainType
import nktn.smn.muskhub.composable_sdui.dto.constraint.Constraint
import nktn.smn.muskhub.composable_sdui.dto.constraint.ConstraintType
import nktn.smn.muskhub.composable_sdui.dto.constraint.LinearConstraint
import nktn.smn.muskhub.composable_sdui.dto.constraint.SingleConstraint
import nktn.smn.muskhub.composable_sdui.dto.elements.ImageElement
import nktn.smn.muskhub.composable_sdui.dto.elements.TextElement

internal val pageLayout = Layout(
    elements = arrayOf(
        ImageElement(
            id = 1,
            width = 150,
            height = 150,
            url = "https://3.bp.blogspot.com/-VVp3WvJvl84/X0Vu6EjYqDI/AAAAAAAAPjU/ZOMKiUlgfg8ok8DY8Hc-ocOvGdB0z86AgCLcBGAsYHQ/s1600/jetpack%2Bcompose%2Bicon_RGB.png"
        ),
        TextElement(
            id = 2,
            width = 250,
            height = 100,
            content = "Hello, world"
        )
    ),
    constraints = arrayOf(
        Constraint(
            elementId = 1,
            horizontal = LinearConstraint(start = SingleConstraint(-1, ConstraintType.Horizontal.TOP)),
            vertical = LinearConstraint(
                start = SingleConstraint(-1, ConstraintType.Vertical.START),
                end = SingleConstraint(-1, ConstraintType.Vertical.END)
            )
        ),
        Constraint(
            elementId = 2,
            horizontal = LinearConstraint(start = SingleConstraint(1, ConstraintType.Horizontal.BOTTOM, 16)),
            vertical = LinearConstraint(
                start = SingleConstraint(-1, ConstraintType.Vertical.START),
                end = SingleConstraint(-1, ConstraintType.Vertical.END)
            )
        )
    )
)

internal val pageLayoutWithChains = Layout(
    elements = arrayOf(
        ImageElement(
            id = 1,
            width = 150,
            height = 150,
            url = "https://st.depositphotos.com/2547675/3009/i/450/depositphotos_30094505-stock-photo-time-clock.jpg"
        ),
        TextElement(
            id = 2,
            width = 250,
            height = 100,
            content = "Hello, world"
        )
    ),
    verticalChains = arrayOf(Chain(elementIds = arrayOf(1, 2), ChainType.Packed(0.2f))),
    constraints = arrayOf(
        Constraint(
            elementId = 1,
            vertical = LinearConstraint(
                start = SingleConstraint(-1, ConstraintType.Vertical.START),
                end = SingleConstraint(-1, ConstraintType.Vertical.END),
                bias = 0.8f
            )
        ),
        Constraint(
            elementId = 2,
            vertical = LinearConstraint(
                start = SingleConstraint(-1, ConstraintType.Vertical.START),
                end = SingleConstraint(-1, ConstraintType.Vertical.END),
                bias = 0.2f
            )
        )
    )
)