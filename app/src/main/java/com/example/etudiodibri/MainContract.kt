package com.example.etudiodibri

import androidx.fragment.app.Fragment

interface MainContract {
    interface View {
        fun navToFragment(fragment: Fragment)
        fun exibirLoading()
        fun esconderLoading()
        fun exibirLoadingError()
    }

    interface Presenter {
        fun onBottomNavItemSelect(fragment: Fragment)
        fun onLoadingStateChange(isLoading: Boolean)
        fun onLoadingError()
    }
}