package com.viktar.dabrou.ciceronenavigation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.viktar.dabrou.ciceronenavigation.databinding.Fragment4Binding
import com.viktar.dabrou.ciceronenavigation.utils.viewBinding
import javax.inject.Inject

class Fragment4 : Fragment(
    R.layout.fragment_4
), RouterProvider {
    private val binding by viewBinding(Fragment4Binding::bind)

    @Inject
    override lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNext.setOnClickListener { router.navigateTo(Screens.openFragment41()) }
    }

    companion object {
        const val SCREEN_KEY_FRAGMENT4 = "Fragment 4"

        fun getNewInstance(): Fragment4 {
            return Fragment4()
        }
    }

}