package com.viktar.dabrou.ciceronenavigation.localbottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.viktar.dabrou.ciceronenavigation.App
import com.viktar.dabrou.ciceronenavigation.R
import com.viktar.dabrou.ciceronenavigation.Screens
import com.viktar.dabrou.ciceronenavigation.databinding.ActivityBottomNavigationBinding
import javax.inject.Inject

class BottomNavigationActivity : FragmentActivity() {

    @Inject
    lateinit var navholder: NavigatorHolder

    @Inject
    lateinit var globalRouter: Router

    private lateinit var binding: ActivityBottomNavigationBinding

    private val navigator by lazy {
        AppNavigator(this, R.id.tab_container, supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initBottomTabsNavigation()

        if (savedInstanceState == null) {
            selectTab("first")
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navholder.setNavigator(navigator)
    }

    override fun onPause() {
        navholder.removeNavigator()
        super.onPause()
    }

    private fun initBottomTabsNavigation() = with(binding) {
        bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.second -> selectTab("second")
                R.id.third -> selectTab("third")
                else -> selectTab("first")
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun selectTab(tab: String) = with(supportFragmentManager) {
        var currentFragment: Fragment? = null
        fragments.map { if (it.isVisible) currentFragment = it }

        val newFragment = findFragmentByTag(tab)
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return
        val transaction = beginTransaction()

        if (newFragment == null) {
            transaction.add(
                R.id.tab_container,
                Screens.openBottomNavigationContainerFragment(tab).createFragment(fragmentFactory),
                tab
            )
        }
        currentFragment?.let { transaction.hide(it) }
        newFragment?.let { transaction.show(it) }
        transaction.commitNow()
    }
}