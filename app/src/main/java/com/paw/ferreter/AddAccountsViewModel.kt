package com.paw.ferreter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddAccountsViewModel : ViewModel() {
    var accountType = MutableLiveData<AccountType>()
    var accountName = MutableLiveData<String>()

    init {
        accountType.value = AccountType.values().first()
    }

    fun getAccountTypesList() = AccountType.values().map { it.toString() }

    fun setAccountType(position: Int) {
        accountType.value = AccountType.values()[position]
    }

    fun setAccountName(name: String) {
        accountName.value = name
    }
}
