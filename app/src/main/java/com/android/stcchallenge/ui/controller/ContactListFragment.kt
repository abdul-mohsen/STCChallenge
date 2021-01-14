package com.android.stcchallenge.ui.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.android.stcchallenge.ContactAdapter
import com.android.stcchallenge.R
import com.android.stcchallenge.databinding.ContactListFragmentBinding
import com.android.stcchallenge.ui.viewmodel.ListViewModel
import kotlinx.coroutines.flow.collect

class ContactListFragment: Fragment() {
    private var _binding: ContactListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var myAdapter: ContactAdapter
    private val listViewModel: ListViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        listViewModel.jsonConverter(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ContactListFragmentBinding.inflate(inflater, container, false)

        myAdapter = ContactAdapter() { user ->
            findNavController().navigate(
                ContactListFragmentDirections.actionListFragmentToContactDetailsFragment(user)
            )

        }
        binding.grid.adapter = myAdapter

        observeUserList()
        return binding.root
    }


    private fun observeUserList() {
        lifecycle.coroutineScope.launchWhenStarted {
            listViewModel.userList.collect { list ->
                myAdapter.submitList(list)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}