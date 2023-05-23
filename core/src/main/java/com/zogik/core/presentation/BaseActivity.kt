package com.zogik.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.zogik.core.utils.ToastHelper.showToast
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: B

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bindingClass =
            (this::class.java.genericSuperclass as? ParameterizedType)?.actualTypeArguments.takeIf { it?.isNotEmpty() == true }
                ?.get(0) as? Class<B>
        val inflateMethod = bindingClass?.getMethod("inflate", LayoutInflater::class.java)
        (inflateMethod?.invoke(null, layoutInflater) as? B)?.also { binding = it }

        if (::binding.isInitialized) {
            setContentView(binding.root)
        } else {
            showToast("View Not Found")
        }
    }
}
