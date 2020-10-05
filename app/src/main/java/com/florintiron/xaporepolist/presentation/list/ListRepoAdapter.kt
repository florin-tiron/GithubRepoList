package com.florintiron.xaporepolist.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.florintiron.xaporepolist.R
import kotlinx.android.synthetic.main.list_item_repo.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by Florin Tiron on 04/10/2020.
 */

class ListRepoAdapter @Inject constructor() :
    RecyclerView.Adapter<ListRepoAdapter.ViewHolder>() {

    internal var repoCollection: List<RepoListItemModel>
            by Delegates.observable(emptyList()) { _, _, _ ->
                notifyDataSetChanged()
            }

    internal var clickListener: ((RepoListItemModel) -> Unit) = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_repo, parent, false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repoCollection[position], clickListener)
    }

    override fun getItemCount(): Int {
        return repoCollection.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            repoListItemModel: RepoListItemModel,
            clickListener: ((RepoListItemModel) -> Unit)
        ) {
            itemView.repoName.text = repoListItemModel.name
            itemView.setOnClickListener { clickListener(repoListItemModel) }
        }
    }
}