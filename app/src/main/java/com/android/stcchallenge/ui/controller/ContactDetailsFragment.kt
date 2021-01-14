package com.android.stcchallenge.ui.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.android.stcchallenge.databinding.ContactDetailsFragmentBinding

class ContactDetailsFragment: Fragment() {
    private var _binding: ContactDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private val args: ContactDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ContactDetailsFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}
