package com.android.stcchallenge

import android.accounts.AuthenticatorDescription
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.stcchallenge.databinding.ViewHolderBinding
import com.android.stcchallenge.model.User
import com.squareup.picasso.Picasso
import timber.log.Timber

class MyListAdapter: ListAdapter<User, MyListAdapter.MyViewHolder>(AutoFillDiffCallback()) {
    private var _binding: ViewHolderBinding? = null
    private val binding get() = _binding!!
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        _binding = ViewHolderBinding.inflate(layoutInflater, parent, false)
        Timber.d("There is a create")
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(
            "",
            "${item.person.firstname} ${item.person.lastname}",
            item.party?:"",
            item.description

        )
    }

    inner class MyViewHolder(private val bindingHolder: ViewHolderBinding):
        RecyclerView.ViewHolder(bindingHolder.root) {

        fun bind(url: String, name: String, party: String, partyDescription: String) {
//            Picasso.get().load(url).fit().into(bindingHolder.profilePhoto)
            bindingHolder.run {
                nameText.text = name
                partyText.text = party
                partyDescriptionText.text = partyDescription
            }
        }
    }

    class AutoFillDiffCallback: DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.person.bioguideid == newItem.person.bioguideid

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem == newItem
    }

}
