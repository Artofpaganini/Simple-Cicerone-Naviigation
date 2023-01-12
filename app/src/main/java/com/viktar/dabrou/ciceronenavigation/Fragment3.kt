package com.viktar.dabrou.ciceronenavigation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.viktar.dabrou.ciceronenavigation.databinding.Fragment3Binding
import com.viktar.dabrou.ciceronenavigation.utils.viewBinding
import javax.inject.Inject

class Fragment3 : Fragment(R.layout.fragment_3) {

    private val binding by viewBinding(Fragment3Binding::bind)

    @Inject
    lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNext.setOnClickListener { router.navigateTo(Screens.openFragment4()) }
        binding.buttonBack.setOnClickListener { router.navigateTo(Screens.openFragment1()) }
    }

    companion object {
        const val SCREEN_KEY_FRAGMENT3 = "Fragment 3"

        fun getNewInstance(): Fragment3 {
            return Fragment3()
        }
    }
}