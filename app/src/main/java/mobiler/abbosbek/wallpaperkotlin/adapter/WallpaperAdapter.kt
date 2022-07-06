package mobiler.abbosbek.wallpaperkotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mobiler.abbosbek.wallpaperkotlin.R
import mobiler.abbosbek.wallpaperkotlin.WallpaperActivity
import mobiler.abbosbek.wallpaperkotlin.databinding.WallpaperItemLayoutBinding
import mobiler.abbosbek.wallpaperkotlin.model.Photo
import mobiler.abbosbek.wallpaperkotlin.utils.Constants

class WallpaperAdapter(val items : List<Photo>) : RecyclerView.Adapter<WallpaperAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: WallpaperItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(WallpaperItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = items[position]

        Picasso
            .get()
            .load(item.src.medium)
            .placeholder(R.drawable.placeholder)
            .into(holder.binding.wallpaperImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,WallpaperActivity::class.java)
            intent.putExtra(Constants.PHOTO,item)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}