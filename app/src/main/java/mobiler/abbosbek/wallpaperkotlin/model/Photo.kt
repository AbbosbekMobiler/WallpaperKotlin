package mobiler.abbosbek.wallpaperkotlin.model

import java.io.Serializable

data class Photo(
    val id : Int,
    val photographer : String,
    val photographer_url : String,
    val photographer_id : Int,
    val src : Src,
    val liked : Boolean
):Serializable
