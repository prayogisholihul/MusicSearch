package com.zogik.favorite.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zogik.favorite.presentation.viewmodel.FavoriteViewModel
import com.zogik.favorite.presentation.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelFactoryModule {

    @Provides
    fun provideViewModel(fragment: Fragment, factory: ViewModelFactory) =
        ViewModelProvider(fragment, factory)[FavoriteViewModel::class.java]
}
