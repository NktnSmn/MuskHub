package nktn.smn.muskhub.composable_sdui.dto

import android.os.Parcelable
import nktn.smn.muskhub.composable_sdui.dto.chains.Chain
import nktn.smn.muskhub.composable_sdui.dto.constraint.Constraint
import nktn.smn.muskhub.composable_sdui.dto.elements.Element
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
@Parcelize
@Serializable
class Layout(
    @SerialName("elements") val elements: Array<Element> = emptyArray(),
    @SerialName("vertical_chains") val verticalChains: Array<Chain> = emptyArray(),
    @SerialName("horizontal_chains") val horizontalChains: Array<Chain> = emptyArray(),
    @SerialName("constraints") val constraints: Array<Constraint> = emptyArray()
) : Parcelable