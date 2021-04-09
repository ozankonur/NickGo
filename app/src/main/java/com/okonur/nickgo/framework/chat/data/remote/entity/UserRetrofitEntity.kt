package com.okonur.nickgo.framework.chat.data.remote.entity


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserRetrofitEntity(
    @SerializedName("avatarURL")
    @Expose
    var avatarURL: String,

    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("nickname")
    @Expose
    var nickname: String
)