package nktn.smn.muskhub.composable_sdui.dto.chains

import android.os.Parcelable
import androidx.constraintlayout.compose.ChainStyle
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
@Serializable
sealed class ChainType : Parcelable {
    @Parcelize
    @Serializable
    @SerialName("spread")
    object Spread : ChainType()

    @Parcelize
    @Serializable
    @SerialName("spread_inside")
    object SpreadInside : ChainType()

    @Parcelize
    @Serializable
    @SerialName("packed")
    class Packed(@SerialName("bias") val bias: Float = 0.5f) : ChainType()
}

fun ChainType.toStyle(): ChainStyle =
    when (this) {
        is ChainType.Spread -> ChainStyle.Spread
        is ChainType.SpreadInside -> ChainStyle.SpreadInside
        is ChainType.Packed -> ChainStyle.Packed(bias)
    }