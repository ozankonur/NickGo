package com.okonur.nickgo.util.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.okonur.nickgo.framework.chat.data.cache.dao.ChatDao
import com.okonur.nickgo.framework.chat.data.cache.entity.MessageRoomEntity
import com.okonur.nickgo.framework.chat.data.cache.entity.UserRoomEntity
import com.okonur.nickgo.framework.home.data.cache.dao.SessionDao
import com.okonur.nickgo.framework.home.data.cache.entity.SessionRoomEntity

@Database(entities = [MessageRoomEntity::class, UserRoomEntity::class, SessionRoomEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao
    abstract fun sessionDao(): SessionDao
    companion object{
        const val DATABASE_NAME: String = "nick_go_db"
    }
}