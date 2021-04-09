package com.okonur.nickgo.framework.chat.data.model

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okonur.nickgo.R

data class MessageModel(
        var id: String,
        var text: String,
        var timestamp: Long,
        var userModel: UserModel,
)

class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val messageText: TextView = view.findViewById(R.id.messageText)
    private val profileImageView: ImageView = view.findViewById(R.id.profileImage)

    fun bindTo(messageModel: MessageModel, context: Context) {
        messageText.text = messageModel.text
        Glide.with(context)
                .load(messageModel.userModel.avatarURL)
                .circleCrop()
                .into(profileImageView)
    }
}