package com.viktar.dabrou.ciceronenavigation.localbottom

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.redmadrobot.extensions.viewbinding.viewBinding
import com.viktar.dabrou.ciceronenavigation.R
import com.viktar.dabrou.ciceronenavigation.RouterProvider
import com.viktar.dabrou.ciceronenavigation.Screens
import com.viktar.dabrou.ciceronenavigation.databinding.FragmentForwardBinding
import javax.inject.Inject

class ForwardFragment : Fragment(R.layout.fragment_forward), RouterProvider {

    @Inject
    override lateinit var router: Router

    private val binding: FragmentForwardBinding by viewBinding()

    private var nameFragment: String? = null
    private var numberFragment: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameFragment = requireArguments().getString(SCREEN_KEY_FORWARD_FRAGMENT_NAME).toString()
        numberFragment = requireArguments().getInt(SCREEN_KEY_FORWARD_FRAGMENT_NUMBER)
        binding.buttonDeep.setOnClickListener {
            (parentFragment as RouterProvider).router.navigateTo(
                Screens.openForwardFragment(
                    nameFragment,
                    numberFragment + 1
                )
            )
        }
        binding.textView.text = "$nameFragment and number $numberFragment "
    }

    companion object {
        const val SCREEN_KEY_FORWARD_FRAGMENT_NAME = "SCREEN_KEY_FORWARD_FRAGMENT_NAME"
        const val SCREEN_KEY_FORWARD_FRAGMENT_NUMBER = "SCREEN_KEY_FORWARD_FRAGMENT_NUMBER"

        fun getNewInstance(fragmentName: String?, number: Int?): ForwardFragment {
            return ForwardFragment().apply {
                arguments = bundleOf(
                    SCREEN_KEY_FORWARD_FRAGMENT_NAME to fragmentName,
                    SCREEN_KEY_FORWARD_FRAGMENT_NUMBER to number,
                )
            }
        }
    }

}