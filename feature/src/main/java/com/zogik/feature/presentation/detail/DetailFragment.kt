package com.zogik.feature.presentation.detail

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import coil.transform.RoundedCornersTransformation
import com.zogik.core.domain.model.Track
import com.zogik.core.presentation.BaseFragment
import com.zogik.core.utils.gone
import com.zogik.core.utils.visible
import com.zogik.feature.R
import com.zogik.feature.databinding.FragmentDetailBinding
import com.zogik.feature.presentation.detail.viewmodel.DetailViewModel
import com.zogik.feature.presentation.detail.viewmodel.Observer
import com.zogik.feature.presentation.detail.viewmodel.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment :
    BaseFragment<FragmentDetailBinding>(),
    MenuProvider,
    State,
    SearchView.OnQueryTextListener {

    private val args: DetailFragmentArgs by navArgs()
    private val viewModel by viewModels<DetailViewModel>()

    private val adapter by lazy {
        ArtistTrackAdapter(viewModel)
    }

    private lateinit var menuHost: MenuHost

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

        menuHost = requireActivity()
        (menuHost as FragmentActivity).addMenuProvider(
            this@DetailFragment,
            viewLifecycleOwner,
            Lifecycle.State.RESUMED,
        )
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
        showLoading()
    }

    override fun onSuccessTrackArtist(data: List<Track>) {
        super.onSuccessTrackArtist(data)
        hideLoading()
        adapter.setDataSearch(data)
        adapter.filter.filter("")
    }

    override fun onErrorTrackArtist(error: String) {
        super.onErrorTrackArtist(error)
        Log.d("error", error)
        hideLoading()
    }

    private fun showLoading() {
        binding.apply {
            loading.visible()
            rvContent.gone()
        }
    }

    private fun hideLoading() {
        binding.apply {
            loading.gone()
            rvContent.visible()
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.search_detail, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.action_search -> {
                val searchView: SearchView = menuItem.actionView as SearchView
                searchView.setOnQueryTextListener(this@DetailFragment)
                searchView.setIconifiedByDefault(false)
                true
            }

            else -> false
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        adapter.filter.filter(newText.orEmpty())
        return true
    }
}
