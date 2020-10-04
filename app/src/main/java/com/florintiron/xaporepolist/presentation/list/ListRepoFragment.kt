package com.florintiron.xaporepolist.presentation.list

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.florintiron.xaporepolist.presentation.base.BaseFragment

/**
 * Created by Florin Tiron on 04/10/2020.
 */

class ListRepoFragment : BaseFragment() {


    private lateinit var listRepoViewModel: ListRepoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listRepoViewModel = ViewModelProvider(this, viewModelFactory)
            .get(ListRepoViewModel::class.java)
    }

}