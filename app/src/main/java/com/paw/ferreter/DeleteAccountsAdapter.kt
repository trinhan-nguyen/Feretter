package com.paw.ferreter

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DeleteAccountsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var data = listOf<AccountItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            AccountItemType.SECTION_HEADER.ordinal -> {
                val view = layoutInflater.inflate(
                    R.layout.account_section_header_item,
                    parent,
                    false
                )
                AccountSectionHeaderItemViewHolder(view)
            }
            else -> {
                val view = layoutInflater.inflate(
                    R.layout.delete_account_item,
                    parent,
                    false
                )
                DeleteAccountItemViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        when (holder.itemViewType) {
            AccountItemType.SECTION_HEADER.ordinal -> {
                val viewHolder = holder as AccountSectionHeaderItemViewHolder
                viewHolder.headerTextView.text = item.name
                viewHolder.balanceTextView.visibility = GONE
            }
            else -> {
                val viewHolder = holder as DeleteAccountItemViewHolder
                viewHolder.nameTextView.text = item.name
            }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = data[position].type.ordinal
}

class DeleteAccountItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameTextView: TextView = view.findViewById(R.id.account_name)
}
