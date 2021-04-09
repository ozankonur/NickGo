package com.okonur.nickgo.framework.chat.data.remote

import com.okonur.nickgo.framework.chat.data.model.MessageModel

interface ChatApiManager {
    suspend fun getChatFromApi() : List<MessageModel>
}