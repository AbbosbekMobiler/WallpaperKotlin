package mobiler.abbosbek.wallpaperkotlin.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import mobiler.abbosbek.wallpaperkotlin.api.NetworkManager
import mobiler.abbosbek.wallpaperkotlin.model.Photo
import mobiler.abbosbek.wallpaperkotlin.response.BaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WallpaperRepository {

    fun getWallpaper(error : MutableLiveData<String>,success:MutableLiveData<List<Photo>>,page : String,per_page:String){
        NetworkManager.getApiService().getWallpaper(page,per_page).enqueue(object : Callback<BaseResponse<List<Photo>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<Photo>>>,
                response: Response<BaseResponse<List<Photo>>>,
            ) {
                if (!response.isSuccessful){
                    error.value = "Failed"
                }else{
                    success.value = response.body()?.photos
                }
            }

            override fun onFailure(call: Call<BaseResponse<List<Photo>>>, t: Throwable) {
                error.value = t.localizedMessage
            }
        })
    }
}