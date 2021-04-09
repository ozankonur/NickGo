package com.okonur.nickgo.framework.chat.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.okonur.nickgo.R
import com.okonur.nickgo.framework.chat.data.model.ChatViewHolder
import com.okonur.nickgo.framework.chat.data.model.MessageModel

class ChatAdapter : ListAdapter<MessageModel, ChatViewHolder>(ChatDiffCallback()) {

    lateinit var context: Context
    private val _sender = 1

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ChatViewHolder {
        val view = when (viewType) {
            _sender -> {
                LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.chat_bubble_reply, viewGroup, false)
            }
            else -> {
                LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.chat_bubble, viewGroup, false)
            }
        }
        context = viewGroup.context
        return ChatViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).userModel.id == "0")
            _sender
        else
            super.getItemViewType(position)
    }

    override fun onBindViewHolder(chatViewHolder: ChatViewHolder, position: Int) {
        chatViewHolder.bindTo(getItem(position), context)
    }

    class ChatDiffCallback : DiffUtil.ItemCallback<MessageModel>() {
        override fun areItemsTheSame(oldItem: MessageModel, newItem: MessageModel): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: MessageModel, newItem: MessageModel): Boolean {
            return oldItem == newItem
        }
    }
}
