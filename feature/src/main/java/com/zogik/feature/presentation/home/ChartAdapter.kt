package com.zogik.feature.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.zogik.core.domain.model.Track
import com.zogik.feature.databinding.ChartViewBinding

class ChartAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<ChartAdapter.ChartViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Track>() {
        override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
            return oldItem == newItem
        }
    }

    val asyncData = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        return ChartViewHolder(
            ChartViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun getItemCount(): Int = asyncData.currentList.size

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) {
        holder.bind(asyncData.currentList[position])
    }

    inner class ChartViewHolder(private val binding: ChartViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Track) = with(binding) {
            imageView.load(data.artist.pictureMedium) {
                transformations(CircleCropTransformation())
            }
            artistName.text = data.artist.name
            trackName.text = data.title

            root.setOnClickListener {
                onClick.invoke()
            }
        }
    }
}
