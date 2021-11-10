package nktn.smn.muskhub.composable_sdui.dto.constraint

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
sealed interface ConstraintType : java.io.Serializable {
    /**
     * TODO WIP
     *
     * @author sa.nikitin
     */
    @Serializable
    enum class Horizontal : ConstraintType {
        @SerialName("top")
        TOP,

        @SerialName("bottom")
        BOTTOM
    }

    /**
     * TODO WIP
     *
     * @author sa.nikitin
     */
    @Serializable
    enum class Vertical : ConstraintType {
        @SerialName("start")
        START,

        @SerialName("end")
        END
    }
}


