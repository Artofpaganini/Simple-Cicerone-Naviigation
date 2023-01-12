package com.viktar.dabrou.ciceronenavigation.local

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.viktar.dabrou.ciceronenavigation.App
import com.viktar.dabrou.ciceronenavigation.R
import com.viktar.dabrou.ciceronenavigation.RouterProvider
import com.viktar.dabrou.ciceronenavigation.Screens
import com.viktar.dabrou.ciceronenavigation.databinding.Fragment41Binding
import com.viktar.dabrou.ciceronenavigation.utils.viewBinding
import javax.inject.Inject

class Fragment41 : Fragment(R.layout.fragment_4_1), RouterProvider {

    private val binding by viewBinding(Fragment41Binding::bind)

    @Inject
    override lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNext.setOnClickListener { router.navigateTo(Screens.openFragment42("Ya Betmen")) }
    }

    companion object {
        const val SCREEN_KEY_FRAGMENT41 = "Fragment 41"

        fun getNewInstance(): Fragment41 {
            return Fragment41()
        }
    }

}