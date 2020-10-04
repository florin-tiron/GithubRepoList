package com.florintiron.xaporepolist.presentation.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.florintiron.xaporepolist.presentation.list.ListRepoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Florin Tiron on 04/10/2020.
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListRepoViewModel::class)
    abstract fun bindRepositoryViewModel(listRepoViewModel: ListRepoViewModel): ViewModel
}