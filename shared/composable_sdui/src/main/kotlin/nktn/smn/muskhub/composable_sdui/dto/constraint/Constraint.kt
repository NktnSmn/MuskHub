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
class Constraint(
    @SerialName("element_id") val elementId: Int,
    @SerialName("horizontal") val horizontal: LinearConstraint<ConstraintType.Horizontal>? = null,
    @SerialName("vertical") val vertical: LinearConstraint<ConstraintType.Vertical>? = null
) : Parcelable