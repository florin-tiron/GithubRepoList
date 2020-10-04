package com.florintiron.xaporepolist.presentation.di

import com.florintiron.xaporepolist.presentation.MyApplication
import com.florintiron.xaporepolist.presentation.base.BaseFragment
import com.florintiron.xaporepolist.presentation.di.viewmodel.ViewModelModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Florin Tiron on 04/10/2020.
 */

@Component(
    modules = [
        ViewModelModule::class]
)
@Singleton
interface ApplicationComponent {
    fun inject(application: MyApplication)
    fun inject(fragment: BaseFragment)
}