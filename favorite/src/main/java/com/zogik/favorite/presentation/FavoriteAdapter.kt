package com.zogik.favorite.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.zogik.core.R
import com.zogik.core.domain.model.Track
import com.zogik.core.utils.visible
import com.zogik.feature.databinding.ChartViewBinding

class FavoriteAdapter(
    private val toDetail: (Track) -> Unit,
    private val unFavorite: (Track) -> Unit,
) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Track>() {
        override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem == newItem
        }
    }

    val asyncData = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            ChartViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun getItemCount(): Int = asyncData.currentList.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(asyncData.currentList[position])
    }

    inner class FavoriteViewHolder(private val binding: ChartViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Track) = with(binding) {
            imageView.load(data.album.coverSmall) {
                transformations(CircleCropTransformation())
            }
            artistName.text = data.artist.name
            trackName.text = data.title
            trackName.isSelected = true

            buttonFav.setImageResource(R.drawable.ic_favorite_clicked)
            buttonFav.visible()

            root.setOnClickListener {
                toDetail.invoke(data)
            }

            buttonFav.setOnClickListener {
                unFavorite.invoke(data)
            }
        }
    }
}
