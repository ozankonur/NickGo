package com.okonur.nickgo.framework.home.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.okonur.nickgo.framework.home.data.cache.entity.SessionRoomEntity

@Dao
interface SessionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(sessionRoomEntity: SessionRoomEntity)

    @Query("UPDATE session SET active = :isActive")
    suspend fun updateSessionActiveInfo(isActive: Boolean)

    @Query("Select * from session")
    suspend fun getSession() : List<SessionRoomEntity>
}