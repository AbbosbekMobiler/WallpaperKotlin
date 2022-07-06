package mobiler.abbosbek.wallpaperkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import mobiler.abbosbek.wallpaperkotlin.adapter.WallpaperAdapter
import mobiler.abbosbek.wallpaperkotlin.databinding.ActivityMainBinding
import mobiler.abbosbek.wallpaperkotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    var count = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding.recyclerWallpaper.layoutManager = GridLayoutManager(this,2)

        viewModel.error.observe(this,Observer{
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })

        viewModel.wallData.observe(this,Observer{
            binding.recyclerWallpaper.adapter = WallpaperAdapter(it)
        })
        loadData(count)
        binding.btnNext.setOnClickListener{
            count++
            loadData(count)
        }
        binding.btnPrev.setOnClickListener {
            if (count>1){
                count--
                loadData(count)
            }
        }
    }
    fun loadData(count : Int){
        viewModel.getWallpaper("$count","20")
    }
}