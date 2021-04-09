package com.okonur.nickgo.framework.chat.data.remote.retrofit

import com.okonur.nickgo.framework.chat.data.remote.entity.ChatRetrofitEntity
import retrofit2.http.GET

interface ChatRetrofitInterface {
    @GET("files/chatdata-example.json")
    suspend fun getChat(): ChatRetrofitEntity
}