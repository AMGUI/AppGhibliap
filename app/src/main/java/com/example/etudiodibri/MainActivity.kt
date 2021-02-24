package com.example.etudiodibri

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.etudiodibri.fragment.ErroLoadingFragment
import com.example.etudiodibri.fragment.LoandingFragment
import com.example.etudiodibri.fragment.favorites.FavoritesFragment
import com.example.etudiodibri.fragment.movies.MoviesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, MoviesFragment.OnLoadingListener {

    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Iniciar presenter
        presenter = MainPresenter(this)

        //Configurar bottomNavigation
        setupBottomNav()
    }

    /**
     * Realizar configuração da bottomNavigation
     */
    private fun setupBottomNav() {
        //Definir eventos de click
        bottomNav.setOnNavigationItemSelectedListener() {
            when(it.itemId) {
                //ID's que foram definidos no menu.xml
                R.id.menu_movies -> presenter.onBottomNavItemSelect(MoviesFragment())
                R.id.menu_favs   -> presenter.onBottomNavItemSelect(FavoritesFragment())
            }
            return@setOnNavigationItemSelectedListener true
        }

        //Definir qual fragment será exibido primeiro
        bottomNav.selectedItemId = R.id.menu_movies
    }

    /**
     * Realizar a trocar de fragment no container do xml (activity_main.xml)
     * @param fragment fragment passado pela função do presenter
     */
    override fun navToFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    override fun exibirLoading() {
        frame_loading.visibility = View.VISIBLE
        fragmentContainer.visibility = View.GONE
        val transacao1 = supportFragmentManager.beginTransaction()
        val loadingFragment = LoandingFragment()
        transacao1.add(R.id.frame_loading, loadingFragment)
        transacao1.commit()
    }

    override fun esconderLoading() {
        frame_loading.visibility = View.GONE
        fragmentContainer.visibility = View.VISIBLE
    }

    override fun onLoadingChange(isLoading: Boolean, hasError: Boolean) {
        if(!hasError) {
            presenter.onLoadingStateChange(isLoading)
        } else {
            presenter.onLoadingError()
        }
    }

    override fun exibirLoadingError() {
        frame_loading.visibility = View.VISIBLE
        fragmentContainer.visibility = View.GONE
        val erroLoadingFragment = ErroLoadingFragment()
        val transacao2 = supportFragmentManager.beginTransaction()
        transacao2.replace(R.id.frame_loading, erroLoadingFragment)
        transacao2.commit()
    }
}