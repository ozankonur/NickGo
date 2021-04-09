package com.okonur.nickgo.framework.chat.data.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat")
data class MessageRoomEntity(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "uidMessage")
        var uidMessage: String,

        @ColumnInfo(name = "text")
        var text: String,

        @ColumnInfo(name = "timestamp")
        var timestamp: Long,

        @Embedded var userRoom: UserRoomEntity
)
