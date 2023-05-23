package com.zogik.feature.presentation

import android.os.Bundle
import android.view.View
import com.zogik.core.presentation.BaseFragment
import com.zogik.feature.databinding.FragmentProfileBinding

class Profile : BaseFragment<FragmentProfileBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initAction()
        initObserver()
        initObserver()
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
