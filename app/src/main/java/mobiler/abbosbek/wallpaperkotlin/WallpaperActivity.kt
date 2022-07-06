package mobiler.abbosbek.wallpaperkotlin

import android.app.DownloadManager
import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.squareup.picasso.Picasso
import mobiler.abbosbek.wallpaperkotlin.databinding.ActivityWallpaperBinding
import mobiler.abbosbek.wallpaperkotlin.model.Photo
import mobiler.abbosbek.wallpaperkotlin.utils.Constants
import java.lang.Exception


class WallpaperActivity : AppCompatActivity() {
    lateinit var binding: ActivityWallpaperBinding
    lateinit var items : Photo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        items = intent.getSerializableExtra(Constants.PHOTO) as Photo

        Picasso
            .get()
            .load(items.src.large2x)
            .placeholder(R.drawable.placeholder)
            .into(binding.imageWallpaper)

        binding.btnDownload.setOnClickListener {
            var downloadManager : DownloadManager ?= null

            downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val uri = Uri.parse(items.src.large2x)

            var request = DownloadManager.Request(uri)

            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI )
                .setAllowedOverRoaming(false)
                .setTitle("Wallpaper_"+items.photographer)
                .setMimeType("image/jpg")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES,"Wallpaper_"+items.photographer+".jpg")

            downloadManager.enqueue(request)
            Toast.makeText(this,"Download completed!",Toast.LENGTH_SHORT).show()
        }

        binding.btnWallpaper.setOnClickListener {
            var wallpaperManager = WallpaperManager.getInstance(this)
            val bitmap = binding.imageWallpaper.drawable.toBitmap()

            try {
                wallpaperManager.setBitmap(bitmap)
                Toast.makeText(this,"Wallpaper applied",Toast.LENGTH_SHORT).show()
            }catch (e : Exception){
                e.printStackTrace()
                Toast.makeText(this, "Couldn't add Wallpaper", Toast.LENGTH_SHORT).show();
            }
        }

    }
}