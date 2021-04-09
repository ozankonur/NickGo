package com.okonur.nickgo.framework.chat.data.remote.retrofit

import com.okonur.nickgo.framework.chat.data.remote.entity.ChatRetrofitEntity

interface ChatRetrofitService {
    suspend fun getChat(): ChatRetrofitEntity
}