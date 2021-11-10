package nktn.smn.muskhub.composable_sdui.dto.constraint

import android.os.Parcelable
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
class SingleConstraint<T : ConstraintType>(
    @SerialName("element_id") val elementId: Int,
    @SerialName("type") val type: T,
    @SerialName("margin") val margin: Int = 0
) : Parcelable