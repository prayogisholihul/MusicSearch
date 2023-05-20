package com.zogik.favorite.di

import android.content.Context
import com.zogik.favorite.presentation.FavoriteFragment
import com.zogik.musicsearch.dynamicfeature.di.UseCaseModule
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [UseCaseModule.DfDependency::class],
)
interface ModuleComponent {

    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun create(dependencies: UseCaseModule.DfDependency): Builder
        fun build(): ModuleComponent
    }
}
