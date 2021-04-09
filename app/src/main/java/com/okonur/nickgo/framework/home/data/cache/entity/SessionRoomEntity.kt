package com.okonur.nickgo.framework.home.data.cache.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "session")
data class SessionRoomEntity(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "session")
        @NonNull
        var session: String,

        @ColumnInfo(name = "timestamp")
        @NonNull
        var timestamp: Long,

        @ColumnInfo(name = "active")
        @NonNull
        var active: Boolean
)
