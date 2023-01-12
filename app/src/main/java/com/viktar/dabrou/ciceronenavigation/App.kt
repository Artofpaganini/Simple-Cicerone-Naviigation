package com.viktar.dabrou.ciceronenavigation

import android.app.Application
import com.viktar.dabrou.ciceronenavigation.di.AppComponent
import com.viktar.dabrou.ciceronenavigation.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy { DaggerAppComponent.create() }

}