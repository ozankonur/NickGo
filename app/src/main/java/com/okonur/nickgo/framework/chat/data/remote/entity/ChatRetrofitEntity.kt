package com.okonur.nickgo.framework.chat.data.remote.entity


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChatRetrofitEntity(
    @SerializedName("messages")
    @Expose
    var messageRetrofitEntities: List<MessageRetrofitEntity>
)