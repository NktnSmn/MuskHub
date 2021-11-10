package nktn.smn.muskhub.composable_sdui.dto.elements

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
@Serializable
sealed class Element : Parcelable {
    abstract val id: Int
    abstract val width: Int
    abstract val height: Int
}

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
@Parcelize
@Serializable
@SerialName("image_element")
class ImageElement(
    @SerialName("id") override val id: Int,
    @SerialName("width") override val width: Int,
    @SerialName("height") override val height: Int,
    @SerialName("url") val url: String
) : Element()

/**
 * TODO WIP
 *
 * @author sa.nikitin
 */
@Parcelize
@Serializable
@SerialName("text_element")
class TextElement(
    @SerialName("id") override val id: Int,
    @SerialName("width") override val width: Int,
    @SerialName("height") override val height: Int,
    @SerialName("content") val content: String
) : Element()