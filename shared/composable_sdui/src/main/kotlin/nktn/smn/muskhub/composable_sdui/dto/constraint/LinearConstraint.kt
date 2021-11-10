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
class LinearConstraint<T : ConstraintType>(
    @SerialName("start") val start: SingleConstraint<T>? = null,
    @SerialName("end") val end: SingleConstraint<T>? = null,
    @SerialName("bias") val bias: Float = 0.5f
) : Parcelable