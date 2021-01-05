package com.paw.ferreter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter


class AccountsAdapter: Adapter<AccountItemViewHolder>() {
    var data = listOf<AccountItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.account_item, parent, false)
        return AccountItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountItemViewHolder, position: Int) {
        val item = data[position]
        holder.nameTextView.text = item.name
        holder.balanceTextView.text = item.balance
    }

    override fun getItemCount(): Int = data.size

}

class AccountItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val nameTextView: TextView = view.findViewById(R.id.account_name)
    val balanceTextView: TextView = view.findViewById(R.id.account_balance)
}
