package com.example.newsapp.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM: BaseViewModel, T: ViewBinding> : Fragment() {

    protected open lateinit var viewModel: VM
    protected var layoutId: Int = 0
    protected lateinit var binding: T
    protected abstract fun getViewBinding(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[viewModelClass()]
        binding = getViewBinding()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    protected abstract fun viewModelClass(): Class<VM>

    protected lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
    }

    fun findNavController(): NavController {
        var fragment: Fragment? = this
        lateinit var navController: NavController
        while (fragment != null) {
            if (fragment is NavHostFragment) {
                navController = fragment.navController.also { navController = it }
            }
            fragment = fragment.parentFragment
        }
        return navController
    }
}