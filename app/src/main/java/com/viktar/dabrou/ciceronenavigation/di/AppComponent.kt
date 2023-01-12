package com.viktar.dabrou.ciceronenavigation.di

import com.viktar.dabrou.ciceronenavigation.localbottom.BottomNavigationActivity
import com.viktar.dabrou.ciceronenavigation.Fragment1
import com.viktar.dabrou.ciceronenavigation.Fragment2
import com.viktar.dabrou.ciceronenavigation.Fragment3
import com.viktar.dabrou.ciceronenavigation.Fragment4
import com.viktar.dabrou.ciceronenavigation.MainActivity
import com.viktar.dabrou.ciceronenavigation.MainFragment
import com.viktar.dabrou.ciceronenavigation.localbottom.BottomNavigationContainerFragment
import com.viktar.dabrou.ciceronenavigation.local.Fragment41
import com.viktar.dabrou.ciceronenavigation.local.Fragment42
import com.viktar.dabrou.ciceronenavigation.local.Fragment43
import com.viktar.dabrou.ciceronenavigation.localbottom.ForwardFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigationModule::class,
        LocalNavigationModule::class]
)
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
    fun inject(fragment: Fragment1)
    fun inject(fragment: Fragment2)
    fun inject(fragment: Fragment3)
    fun inject(fragment: Fragment4)

    fun inject(fragment: Fragment41)
    fun inject(fragment: Fragment42)
    fun inject(fragment: Fragment43)

    fun inject(activity: BottomNavigationActivity)
    fun inject(fragment: BottomNavigationContainerFragment)
    fun inject(fragment: ForwardFragment)
}