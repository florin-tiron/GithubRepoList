package com.florintiron.repolist.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.florintiron.repolist.R
import com.florintiron.repolist.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_details_repo.*

/**
 * Created by Florin Tiron on 04/10/2020.
 */
class RepoDetailsFragment : BaseFragment() {

    private lateinit var repoDetailsViewModel: RepoDetailsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repoDetailsViewModel = ViewModelProvider(this, viewModelFactory)
            .get(RepoDetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details_repo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: RepoDetailsFragmentArgs by navArgs()
        repoDetailsViewModel.getDetails(args.id)
        setupObservers()
    }

    private fun setupObservers() {
        repoDetailsViewModel.repoDetails.observe(viewLifecycleOwner, {
            nameTv.text = it.name
            descriptionTv.text = it.description
            issuesTv.text =
                getString(if (it.hasIssue) R.string.repo_details_yes else R.string.repo_details_no)
            ownerTv.text = it.ownerName
            starsTv.text = it.stars.toString()
            activity?.title = it.name
        })
    }
}