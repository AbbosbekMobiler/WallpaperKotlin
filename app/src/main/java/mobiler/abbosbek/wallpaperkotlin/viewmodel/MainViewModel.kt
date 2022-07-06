package mobiler.abbosbek.wallpaperkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mobiler.abbosbek.wallpaperkotlin.model.Photo
import mobiler.abbosbek.wallpaperkotlin.repository.WallpaperRepository
import mobiler.abbosbek.wallpaperkotlin.response.BaseResponse

class MainViewModel : ViewModel() {
    val repository = WallpaperRepository()
    val error = MutableLiveData<String>()
    val wallData = MutableLiveData<List<Photo>>()

    fun getWallpaper(page:String,per_page:String){
        repository.getWallpaper(error,wallData,page,per_page)
    }

}