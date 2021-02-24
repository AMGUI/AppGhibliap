package com.example.etudiodibri

import androidx.fragment.app.Fragment

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    override fun onBottomNavItemSelect(fragment: Fragment) {
        view.navToFragment(fragment)
    }

    override fun onLoadingStateChange(isLoading: Boolean) {
        if(isLoading) view.exibirLoading() else view.esconderLoading()
    }

    override fun onLoadingError() {
        view.exibirLoadingError()
    }
}