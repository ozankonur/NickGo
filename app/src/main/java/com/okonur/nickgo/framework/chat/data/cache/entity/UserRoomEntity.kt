package com.okonur.nickgo.framework.chat.data.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserRoomEntity(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "uid")
        var uid: String,

        @ColumnInfo(name = "avatar")
        var avatarURL: String,

        @ColumnInfo(name = "nickname")
        var nickname: String
)
