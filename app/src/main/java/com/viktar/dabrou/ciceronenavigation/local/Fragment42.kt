package com.viktar.dabrou.ciceronenavigation.local

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.viktar.dabrou.ciceronenavigation.App
import com.viktar.dabrou.ciceronenavigation.R
import com.viktar.dabrou.ciceronenavigation.RouterProvider
import com.viktar.dabrou.ciceronenavigation.Screens
import com.viktar.dabrou.ciceronenavigation.databinding.Fragment42Binding
import com.viktar.dabrou.ciceronenavigation.utils.viewBinding
import javax.inject.Inject

class Fragment42 : Fragment(R.layout.fragment_4_2), RouterProvider {

    private val binding by viewBinding(Fragment42Binding::bind)

    @Inject
    override lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.result.text = requireArguments().getString(SCREEN_KEY_FRAGMENT42)
        binding.buttonNext.setOnClickListener { router.navigateTo(Screens.openFragment43()) }
    }

    companion object {
        const val SCREEN_KEY_FRAGMENT42 = "Fragment 42"

        fun getNewInstance(result: String): Fragment42 {
            return Fragment42().apply {
                arguments = bundleOf(SCREEN_KEY_FRAGMENT42 to result)

            }
        }
    }
}