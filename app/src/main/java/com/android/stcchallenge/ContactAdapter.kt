package com.android.stcchallenge

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.stcchallenge.databinding.ContactViewBinding
import com.android.stcchallenge.model.User
import com.squareup.picasso.Picasso
import timber.log.Timber


class ContactAdapter(val nav: (User) -> Unit): ListAdapter<User, ContactAdapter.ContactViewHolder>(
    ContactDiffCallback()
) {
    private var _binding: ContactViewBinding? = null
    private val binding get() = _binding!!
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        _binding = ContactViewBinding.inflate(layoutInflater, parent, false)
        Timber.d("There is a create")
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(
            "${item.person.firstname} ${item.person.lastname}",
            item.party ?: "",
            item.description
        )

        holder.itemView.setOnClickListener {
            nav(item)
        }
    }

    inner class ContactViewHolder(private val bindingHolder: ContactViewBinding):
        RecyclerView.ViewHolder(bindingHolder.root) {

        fun bind(name: String, party: String, partyDescription: String) {
            bindingHolder.run {
                profilePhoto.setImageResource()
                Picasso.get().load(R.drawable.)
                profilePhoto.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
                nameText.text = name
                partyText.text = party
                partyDescriptionText.text = partyDescription
            }
        }
    }

    class ContactDiffCallback: DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.person.bioguideid == newItem.person.bioguideid

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem == newItem
    }

//    fun textToImage(party: String) = when(party) {
//        "Democrat" -> R.drawable.ic_party_r
//        else -> R.drawable.ic_party_d
//    }

}
