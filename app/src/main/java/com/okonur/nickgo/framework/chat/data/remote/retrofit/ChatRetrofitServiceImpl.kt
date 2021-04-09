package com.okonur.nickgo.framework.chat.data.remote.retrofit

import com.okonur.nickgo.framework.chat.data.remote.entity.ChatRetrofitEntity

class ChatRetrofitServiceImpl(
    private var chatRetrofitInterface: ChatRetrofitInterface
) : ChatRetrofitService {
    override suspend fun getChat(): ChatRetrofitEntity {
        return chatRetrofitInterface.getChat()
    }
}