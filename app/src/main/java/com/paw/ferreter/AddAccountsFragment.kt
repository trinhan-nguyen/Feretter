package com.paw.ferreter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.paw.ferreter.databinding.FragmentAddAccountsBinding

class AddAccountsFragment : Fragment() {

    private val viewModel: AddAccountsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)

        val binding: FragmentAddAccountsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_accounts, container, false
        )

        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.account_type_item,
            viewModel.getAccountTypesList()
        )
        binding.accountTypeAutoComplete.setAdapter(adapter)

        binding.accountTypeAutoComplete.setOnItemClickListener { _, _, position, _ ->
            viewModel.setAccountType(position)
        }

        binding.accountNameEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.setAccountName(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        return binding.root
    }
}
