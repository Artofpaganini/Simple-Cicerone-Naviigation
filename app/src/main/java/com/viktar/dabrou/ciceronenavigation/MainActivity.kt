package com.viktar.dabrou.ciceronenavigation

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : FragmentActivity() {

    @Inject
    lateinit var navholder: NavigatorHolder

    private val navigator by lazy {
        AppNavigator(this, R.id.container_view, supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navholder.setNavigator(navigator)
    }

    override fun onPause() {
        navholder.removeNavigator()
        super.onPause()
    }

}