package com.florintiron.repolist.presentation.di

import com.florintiron.repolist.data.repodata.di.DataRepositoryModule
import com.florintiron.repolist.mapper.DataMapperModule
import com.florintiron.repolist.presentation.MyApplication
import com.florintiron.repolist.presentation.base.BaseFragment
import com.florintiron.repolist.presentation.di.viewmodel.ViewModelModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Florin Tiron on 04/10/2020.
 */

@Component(
    modules = [
        DataRepositoryModule::class,
        DataMapperModule::class,
        ViewModelModule::class]
)
@Singleton
interface ApplicationComponent {
    fun inject(application: MyApplication)
    fun inject(fragment: BaseFragment)
}