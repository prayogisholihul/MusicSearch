package com.zogik.favorite.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.zogik.core.di.favorite.UseCaseModule
import com.zogik.core.domain.model.Track
import com.zogik.core.presentation.BaseFragment
import com.zogik.core.utils.visible
import com.zogik.favorite.databinding.FragmentFavoriteBinding
import com.zogik.favorite.di.DaggerModuleComponent
import com.zogik.favorite.presentation.viewmodel.FavoriteViewModel
import com.zogik.favorite.presentation.viewmodel.Observer
import com.zogik.favorite.presentation.viewmodel.State
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(), State {

    @Inject
    lateinit var viewModel: FavoriteViewModel

    private lateinit var adapter: FavoriteAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initModule()
    }

    private fun initModule() {
        DaggerModuleComponent.builder()
            .context(requireContext())
            .create(
                EntryPointAccessors.fromApplication(
                    requireContext(),
                    UseCaseModule.DfDependency::class.java,
                ),
            )
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initAction()
        initObserver()
        initData()
    }

    override fun initUI() = with(binding) {
        adapter = FavoriteAdapter(
            toDetail = {
                val navigation = FavoriteFragmentDirections.favoriteToDetail(it)
                findNavController().navigate(navigation)
            },
            unFavorite = {
                viewModel.setDeleteFavorite(it)
                initData()
            },
        )

        rvContent.layoutManager = LinearLayoutManager(requireContext())
        rvContent.adapter = adapter
    }

    override fun initObserver() {
        lifecycle.addObserver(Observer(viewModel, this))
    }

    override fun initAction() {
    }

    override fun initData() {
        viewModel.getFavorite()
    }

    override fun getFavorite(data: List<Track>) {
        super.getFavorite(data)
        if (data.isEmpty()) {
            binding.tvEmptyData.visible()
        }
        adapter.asyncData.submitList(data)
    }

    override fun onDestroyView() {
        binding.root.removeAllViews()
        super.onDestroyView()
    }
}
