package com.florintiron.repolist.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.florintiron.repolist.presentation.MyApplication
import com.florintiron.repolist.presentation.di.ApplicationComponent
import javax.inject.Inject

/**
 * Created by Florin Tiron on 04/10/2020.
 */
abstract class BaseFragment : Fragment() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity?.applicationContext as MyApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

}