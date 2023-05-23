package com.zogik.feature.presentation.detail

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.zogik.core.R
import com.zogik.core.domain.model.Track
import com.zogik.core.utils.visible
import com.zogik.feature.databinding.ChartViewBinding
import java.util.Locale

class ArtistTrackAdapter(
    private val local: List<Track>,
    private val favorite: (Track) -> Unit,
    private val unFavorite: (Track) -> Unit,
) :
    RecyclerView.Adapter<ArtistTrackAdapter.ArtistTrackViewHolder>(), Filterable {

    private var filterData = arrayListOf<Track>()
    private val trackList = arrayListOf<Track>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistTrackViewHolder {
        return ArtistTrackViewHolder(
            ChartViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )
    }

    override fun getItemCount(): Int = filterData.size

    override fun onBindViewHolder(holder: ArtistTrackViewHolder, position: Int) {
        holder.bind(filterData[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataSearch(data: List<Track>) {
        trackList.clear()
        trackList.addAll(data)
        notifyDataSetChanged()
    }

    inner class ArtistTrackViewHolder(private val binding: ChartViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Track) = with(binding) {
            val localTrack = local.find { it.id == data.id }

            imageView.load(data.album.coverSmall) {
                transformations(CircleCropTransformation())
            }
            artistName.text = data.artist.name
            trackName.text = data.title
            trackName.isSelected = true
            buttonFav.visible()

            if (localTrack != null) {
                favorite(data, localTrack)
            }

            root.setOnClickListener {
                Log.d("localadapter", localTrack?.id.toString())
                Log.d("dataadapter", data.id)
            }

            var click = data.id == localTrack?.id
            buttonFav.setOnClickListener {
                click = if (click) {
                    buttonFav.setImageResource(R.drawable.ic_favorite)
                    if (localTrack != null) {
                        unFavorite.invoke(localTrack)
                    }
                    false
                } else {
                    buttonFav.setImageResource(R.drawable.ic_favorite_clicked)
                    favorite.invoke(data)
                    true
                }
            }
        }

        private fun favorite(
            track: Track,
            local: Track,
        ) = with(binding) {
            if (track.id == local.id) {
                buttonFav.setImageResource(R.drawable.ic_favorite_clicked)
            } else {
                buttonFav.setImageResource(R.drawable.ic_favorite)
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                filterData = if (constraint.isNullOrEmpty()) {
                    trackList
                } else {
                    val filteredList = arrayListOf<Track>()
                    val filterPattern = constraint.toString().lowercase(Locale.ROOT).trim()
                    Log.d("Search", "charSearch: $filterPattern")
                    for (item in trackList) {
                        if (item.title.lowercase(Locale.ROOT).contains(filterPattern)) {
                            filteredList.add(item)
                        }
                    }
                    filteredList
                }
                val results = FilterResults()
                results.values = filterData
                return results
            }

            @Suppress("UNCHECKED_CAST")
            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterData = results?.values as ArrayList<Track>
                notifyDataSetChanged()
            }
        }
    }
}
