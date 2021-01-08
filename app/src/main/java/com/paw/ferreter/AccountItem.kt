package com.paw.ferreter

enum class AccountItemType {
    SECTION_HEADER,
    ACCOUNT
}

class AccountItem(
    val type: AccountItemType,
    val name: String,
    val balance: String
)
