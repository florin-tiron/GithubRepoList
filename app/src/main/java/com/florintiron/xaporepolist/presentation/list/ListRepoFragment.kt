package com.florintiron.xaporepolist.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.florintiron.xaporepolist.R
import com.florintiron.xaporepolist.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list_repo.*


/**
 * Created by Florin Tiron on 04/10/2020.
 */

class ListRepoFragment : BaseFragment() {


    private lateinit var listRepoViewModel: ListRepoViewModel

    private val listRepoAdapter = ListRepoAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listRepoViewModel = ViewModelProvider(this, viewModelFactory)
            .get(ListRepoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_repo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupObservers()
        listRepoViewModel.loadList()
    }

    private fun setupView() {
        activity?.title = getString(R.string.list_repo_title)
        repoList.layoutManager = LinearLayoutManager(requireContext())
        repoList.addItemDecoration(
            DividerItemDecoration(
                requireContext(), DividerItemDecoration.VERTICAL
            )
        )
        repoList.adapter = listRepoAdapter
        listRepoAdapter.clickListener = {
            navigateToDetails(it)
        }
    }

    private fun setupObservers() {
        listRepoViewModel.isLoadingData.observe(viewLifecycleOwner, {
            loadingPb.visibility = if (it) View.VISIBLE else View.GONE
        })

        listRepoViewModel.errorMessage.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        })
        listRepoViewModel.repoList.observe(viewLifecycleOwner, {
            listRepoAdapter.repoCollection = it.orEmpty()
        })
    }


    private fun navigateToDetails(model: RepoListItemModel) {
        findNavController().navigate(ListRepoFragmentDirections.displayRepositoryDetails(model.id))
    }
}