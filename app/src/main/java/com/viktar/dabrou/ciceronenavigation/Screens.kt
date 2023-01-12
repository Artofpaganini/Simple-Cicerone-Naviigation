package com.viktar.dabrou.ciceronenavigation

import android.content.Intent
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.viktar.dabrou.ciceronenavigation.local.Fragment41
import com.viktar.dabrou.ciceronenavigation.local.Fragment42
import com.viktar.dabrou.ciceronenavigation.local.Fragment43
import com.viktar.dabrou.ciceronenavigation.localbottom.BottomNavigationActivity
import com.viktar.dabrou.ciceronenavigation.localbottom.BottomNavigationContainerFragment
import com.viktar.dabrou.ciceronenavigation.localbottom.ForwardFragment

object Screens {

    fun openFragment1() = FragmentScreen {
        Fragment1.getNewInstance()
    }

    fun openFragment2() = FragmentScreen {
        Fragment2.getNewInstance()
    }

    fun openFragment3() = FragmentScreen {
        Fragment3.getNewInstance()
    }

    fun openFragment4() = FragmentScreen {
        Fragment4.getNewInstance()
    }

    fun openFragment41() = FragmentScreen {
        Fragment41.getNewInstance()
    }

    fun openFragment42(result: String) = FragmentScreen {
        Fragment42.getNewInstance(result)
    }

    fun openFragment43() = FragmentScreen {
        Fragment43.getNewInstance()
    }

    fun openBottomNavActivity() = ActivityScreen {
        Intent(it, BottomNavigationActivity::class.java)
    }

    fun openBottomNavigationContainerFragment(tab:String) = FragmentScreen {
        BottomNavigationContainerFragment.getNewInstance(tab)
    }

    fun openForwardFragment(fragmentName: String?, number: Int?) = FragmentScreen {
        ForwardFragment.getNewInstance(fragmentName, number)
    }
}