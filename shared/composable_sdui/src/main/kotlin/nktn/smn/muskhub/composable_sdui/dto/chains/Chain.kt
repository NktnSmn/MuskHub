package nktn.smn.muskhub.composable_sdui.dto.chains

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
class Chain(@SerialName("element_ids") val elementIds: Array<Int>, @SerialName("type") val type: ChainType) : Parcelable