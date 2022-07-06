package mobiler.abbosbek.wallpaperkotlin.response

data class BaseResponse<T>(
    val page : Int,
    val per_page : Int,
    val photos : T,
    val next_page : String
)
