package com.okonur.nickgo.framework.chat.data.cache

import com.okonur.nickgo.framework.chat.data.model.MessageModel

interface ChatCacheManager {
    suspend fun insertMessage(messageModel: MessageModel) : Long
    suspend fun insertMessageList(messageList: List<MessageModel>)
    suspend fun getChat() : List<MessageModel>
}