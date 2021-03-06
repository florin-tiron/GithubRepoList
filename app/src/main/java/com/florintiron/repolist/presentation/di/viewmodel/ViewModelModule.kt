package com.florintiron.repolist.presentation.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.florintiron.repolist.presentation.details.RepoDetailsViewModel
import com.florintiron.repolist.presentation.list.ListRepoViewModel
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
    abstract fun bindListRepoViewModel(listRepoViewModel: ListRepoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepoDetailsViewModel::class)
    abstract fun bindRepoDetailsViewModel(repoDetailsViewModel: RepoDetailsViewModel): ViewModel
}