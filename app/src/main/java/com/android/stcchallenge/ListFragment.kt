package com.android.stcchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import com.android.stcchallenge.databinding.ListFragmentBinding
import com.android.stcchallenge.viewmodel.ListViewModel
import kotlinx.coroutines.flow.collect

class ListFragment: Fragment() {
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var myAdapter: MyListAdapter
    private val listViewModel: ListViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listViewModel.jsonConverter(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListFragmentBinding.inflate(inflater, container, false)

        myAdapter = MyListAdapter()
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