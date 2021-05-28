package com.paw.ferreter

enum class AccountType() {
    INVESTMENT {
        override fun toString(): String = "Investment"
    },
    OTHERS {
        override fun toString(): String = "Others"
    }
}
