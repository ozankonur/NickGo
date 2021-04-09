package com.okonur.nickgo.framework.chat.data.remote.entity


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MessageRetrofitEntity(
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("text")
    @Expose
    var text: String,

    @SerializedName("timestamp")
    @Expose
    var timestamp: Long,

    @SerializedName("user")
    @Expose
    var userRetrofitEntity: UserRetrofitEntity
)