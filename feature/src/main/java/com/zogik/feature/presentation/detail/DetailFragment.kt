package com.zogik.feature.presentation.detail

import android.os.Bundle
import android.view.View
import com.zogik.core.presentation.BaseFragment
import com.zogik.feature.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initAction()
        initObserver()
        initData()
    }

    override fun initUI() {
    }

    override fun initObserver() {
    }

    override fun initAction() {
    }

    override fun initData() {
    }
}
