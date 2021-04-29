package com.paw.ferreter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.paw.ferreter.databinding.FragmentAddAccountsBinding

class AddAccountsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)

        val binding: FragmentAddAccountsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_accounts, container, false
        )

        val types = listOf("Investment", "Others")
        val adapter = ArrayAdapter(requireContext(), R.layout.account_type_item, types)
        binding.accountTypeAutoComplete.setAdapter(adapter)

        return binding.root
    }
}
