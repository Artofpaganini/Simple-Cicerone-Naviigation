package com.viktar.dabrou.ciceronenavigation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.viktar.dabrou.ciceronenavigation.databinding.FragmentMainBinding
import com.viktar.dabrou.ciceronenavigation.utils.viewBinding
import javax.inject.Inject

class MainFragment : Fragment(
    R.layout.fragment_main
) {
    private val binding by viewBinding(FragmentMainBinding::bind)

    @Inject
    lateinit var router: Router

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button1.setOnClickListener { router.navigateTo(Screens.openFragment1()) }
        binding.button2.setOnClickListener { router.navigateTo(Screens.openFragment2()) }
        binding.button3.setOnClickListener { router.navigateTo(Screens.openFragment3()) }
        binding.button4.setOnClickListener { router.navigateTo(Screens.openFragment4()) }
        binding.button5.setOnClickListener { router.navigateTo(Screens.openBottomNavActivity()) }
    }

}