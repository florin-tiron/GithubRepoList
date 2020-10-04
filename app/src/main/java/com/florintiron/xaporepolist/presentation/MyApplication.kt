package com.florintiron.xaporepolist.presentation

import android.app.Application
import com.florintiron.xaporepolist.presentation.di.ApplicationComponent
import com.florintiron.xaporepolist.presentation.di.DaggerApplicationComponent

/**
 * Created by Florin Tiron on 04/10/2020.
 */

class MyApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .build()
    }


    override fun onCreate() {
        super.onCreate()
        injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)

}
