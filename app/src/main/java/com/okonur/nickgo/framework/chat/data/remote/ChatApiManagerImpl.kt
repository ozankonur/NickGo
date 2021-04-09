package com.okonur.nickgo.framework.chat.data.remote

import com.okonur.nickgo.framework.chat.data.model.MessageModel
import com.okonur.nickgo.framework.chat.data.remote.retrofit.ChatRetrofitService
import com.okonur.nickgo.framework.chat.data.remote.util.ChatApiMapper

class ChatApiManagerImpl(
    private val chatRetrofitService: ChatRetrofitService,
    private val mapper: ChatApiMapper
) : ChatApiManager {
    override suspend fun getChatFromApi(): List<MessageModel> {
        return mapper.chatListFromChatApiEntityList(chatRetrofitService.getChat())
    }
}