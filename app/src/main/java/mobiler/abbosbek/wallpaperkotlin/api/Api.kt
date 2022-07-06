package mobiler.abbosbek.wallpaperkotlin.api

import mobiler.abbosbek.wallpaperkotlin.model.Photo
import mobiler.abbosbek.wallpaperkotlin.response.BaseResponse
import mobiler.abbosbek.wallpaperkotlin.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @Headers("Authorization:${Constants.API_KEY}")
    @GET("curated/")
    fun getWallpaper(
        @Query("page") page : String,
        @Query("per_page") per_page: String
    ) : Call<BaseResponse<List<Photo>>>

}