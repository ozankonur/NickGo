package com.okonur.nickgo.framework.chat.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.okonur.nickgo.framework.chat.data.cache.entity.MessageRoomEntity

@Dao
interface ChatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(messageRoomEntity: MessageRoomEntity) : Long

    @Query("SELECT * FROM chat")
    suspend fun getMessages() : List<MessageRoomEntity>
}