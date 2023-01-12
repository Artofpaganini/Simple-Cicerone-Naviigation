package com.viktar.dabrou.ciceronenavigation.localbottom

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.viktar.dabrou.ciceronenavigation.App
import com.viktar.dabrou.ciceronenavigation.R
import com.viktar.dabrou.ciceronenavigation.RouterProvider
import com.viktar.dabrou.ciceronenavigation.Screens
import com.viktar.dabrou.ciceronenavigation.subnavigation.LocalCiceroneHolder
import javax.inject.Inject

class BottomNavigationContainerFragment : Fragment(
    R.layout.fragment_bottom_navigation_container
), RouterProvider {

    private val containerFragmentName: String
        get() = requireArguments().getString(SCREEN_KEY_BOTTOM_NAV_CONTAINER_FRAGMENT).toString()

    private val localCicerone: Cicerone<Router>
        get() = localCiceroneHolder.getCicerone(containerFragmentName)

    @Inject
    lateinit var localCiceroneHolder: LocalCiceroneHolder

    override val router: Router
        get() = localCicerone.router

    private val localNavigator: Navigator by lazy {
        AppNavigator(requireActivity(), R.id.fragment_nav_container, childFragmentManager)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (childFragmentManager.findFragmentById(R.id.fragment_nav_container) == null) {
            localCicerone.router.replaceScreen(Screens.openForwardFragment(containerFragmentName, 0))
        }
    }

    override fun onResume() {
        super.onResume()
        localCicerone.getNavigatorHolder().setNavigator(localNavigator)
    }

    override fun onPause() {
        localCicerone.getNavigatorHolder().removeNavigator()
        super.onPause()
    }

    companion object {
        const val SCREEN_KEY_BOTTOM_NAV_CONTAINER_FRAGMENT = "SCREEN_KEY_BOTTOM_NAV_CONTAINER_FRAGMENT"

        fun getNewInstance(tab: String): BottomNavigationContainerFragment {
            return BottomNavigationContainerFragment().apply {
                arguments = bundleOf(SCREEN_KEY_BOTTOM_NAV_CONTAINER_FRAGMENT to tab)
            }
        }
    }
}