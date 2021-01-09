package com.paw.ferreter

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.paw.ferreter.databinding.FragmentAccountsBinding

class AccountsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)

        val binding: FragmentAccountsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_accounts, container, false
        )

        val adapter = AccountsAdapter()
        binding.accountsList.adapter = adapter

        // Just to test the RecyclerView for now
        adapter.data = listOf(
            AccountItem(AccountItemType.SECTION_HEADER, "Accounts", "$20,000,000.00"),
            AccountItem(AccountItemType.ACCOUNT, "Account 1", "$10,000,000.00"),
            AccountItem(AccountItemType.ACCOUNT, "Account 2", "$10,000,000.00"),
            AccountItem(AccountItemType.SECTION_HEADER, "Savings", "$10,000,000.00"),
            AccountItem(AccountItemType.ACCOUNT, "Account 3", "$10,000,000.00"),
        )

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.accounts_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
