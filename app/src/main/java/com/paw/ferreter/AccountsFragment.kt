package com.paw.ferreter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.paw.ferreter.databinding.FragmentAccountsBinding

class AccountsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentAccountsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_accounts, container, false
        )

        val adapter = AccountsAdapter()
        binding.accountsList.adapter = adapter

        // Just to test the RecyclerView for now
        adapter.data = listOf(AccountItem(AccountItemType.ACCOUNT, "Account name", "$10,000,000.00"))

        return binding.root
    }
}
