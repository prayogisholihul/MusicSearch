package com.zogik.favorite.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.zogik.core.domain.model.Track
import com.zogik.core.presentation.BaseFragment
import com.zogik.favorite.databinding.FragmentFavoriteBinding
import com.zogik.favorite.di.DaggerModuleComponent
import com.zogik.favorite.presentation.viewmodel.FavoriteViewModel
import com.zogik.favorite.presentation.viewmodel.Observer
import com.zogik.favorite.presentation.viewmodel.State
import com.zogik.feature.presentation.home.ChartAdapter
import com.zogik.musicsearch.dynamicfeature.di.UseCaseModule
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(), State {

    @Inject
    lateinit var viewModel: FavoriteViewModel

    private val adapter: ChartAdapter by lazy {
        ChartAdapter {

        }
    }

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
        adapter.asyncData.submitList(data)
    }
}
