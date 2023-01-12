package com.viktar.dabrou.ciceronenavigation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.viktar.dabrou.ciceronenavigation.databinding.Fragment2Binding
import com.viktar.dabrou.ciceronenavigation.utils.viewBinding
import javax.inject.Inject

class Fragment2 : Fragment(R.layout.fragment_2) {

    private val binding by viewBinding(Fragment2Binding::bind)


    @Inject
    lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNext.setOnClickListener { router.navigateTo(Screens.openFragment3()) }

    }

    companion object {
        const val SCREEN_KEY_FRAGMENT2 = "Fragment 2"

        fun getNewInstance(): Fragment2 {
            return Fragment2()
        }
    }
}