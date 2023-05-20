package com.zogik.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import kotlin.reflect.KClass

class ViewModelFactory @Inject constructor(
    private val coroutineScope: CoroutineScope,
    private val useCase: KClass<*>,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass != useCase::class.java) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return ViewModelFactory(
            coroutineScope,
            useCase,
        ) as T
    }
}
