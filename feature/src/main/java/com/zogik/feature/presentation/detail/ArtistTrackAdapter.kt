package com.zogik.feature.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.zogik.core.domain.model.Track
import com.zogik.feature.databinding.ChartViewBinding
import com.zogik.feature.presentation.detail.viewmodel.DetailViewModel

class ArtistTrackAdapter(
    private val viewModel: DetailViewModel,
    private val onClick: (Boolean) -> Unit,
) :
    RecyclerView.Adapter<ArtistTrackAdapter.ArtistTrackViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Track>() {
        override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem == newItem
        }
    }

    val asyncData = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistTrackViewHolder {
        return ArtistTrackViewHolder(
            ChartViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun getItemCount(): Int = asyncData.currentList.size

    override fun onBindViewHolder(holder: ArtistTrackViewHolder, position: Int) {
        holder.bind(asyncData.currentList[position])
    }

    inner class ArtistTrackViewHolder(private val binding: ChartViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Track) = with(binding) {
            val localTrack = viewModel.getLocalTrack(data.id)

            imageView.load(data.album.coverSmall) {
                transformations(CircleCropTransformation())
            }
            artistName.text = data.artist.name
            trackName.text = data.title

            root.setOnClickListener {
                if (data.id == localTrack.id) onClick.invoke(localTrack.isFavorite)
            }
        }
    }
}
