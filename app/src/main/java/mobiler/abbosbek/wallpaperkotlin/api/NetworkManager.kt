package mobiler.abbosbek.wallpaperkotlin.api

import mobiler.abbosbek.wallpaperkotlin.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    var retrofit : Retrofit ?= null
    var api : Api ?= null

    fun getApiService() : Api{
        if (api == null){
            retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            api = retrofit!!.create(Api::class.java)
        }
        return api!!
    }
}