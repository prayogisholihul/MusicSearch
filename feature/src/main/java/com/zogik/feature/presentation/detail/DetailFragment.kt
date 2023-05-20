package com.zogik.feature.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.zogik.core.domain.model.Track
import com.zogik.core.presentation.BaseFragment
import com.zogik.core.utils.ToastHelper.showToast
import com.zogik.feature.databinding.FragmentDetailBinding
import com.zogik.feature.presentation.detail.viewmodel.DetailViewModel
import com.zogik.feature.presentation.detail.viewmodel.Observer
import com.zogik.feature.presentation.detail.viewmodel.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(), State {

    private val args: DetailFragmentArgs by navArgs()
    private val viewModel by viewModels<DetailViewModel>()

    private val adapter by lazy {
        ArtistTrackAdapter(viewModel) {
            showToast(requireContext(), it.toString())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initAction()
        initObserver()
        initData()
    }

    override fun initUI(): Unit = with(binding) {
        profilePicture.load(args.data.artist.pictureMedium) {
            transformations(RoundedCornersTransformation(25f))
        }
        artistName.text = args.data.artist.name
        chartPosition.text = String.format("Chart Position: ${args.data.position}")

        rvContent.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@DetailFragment.adapter
        }
    }

    override fun initObserver() {
        lifecycle.addObserver(Observer(viewModel, this))
    }

    override fun initAction() {
    }

    override fun initData() {
        viewModel.getTrackArtist(args.data.artist.id)
    }

    override fun onLoadingTrackArtist() {
        super.onLoadingTrackArtist()
    }

    override fun onSuccessTrackArtist(data: List<Track>) {
        super.onSuccessTrackArtist(data)
        adapter.asyncData.submitList(data)
    }

    override fun onErrorTrackArtist(error: String) {
        super.onErrorTrackArtist(error)
    }
}
