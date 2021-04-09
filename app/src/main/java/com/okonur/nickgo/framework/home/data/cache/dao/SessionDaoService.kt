package com.okonur.nickgo.framework.home.data.cache.dao

import com.okonur.nickgo.framework.home.data.cache.entity.SessionRoomEntity

interface SessionDaoService {
    suspend fun insertSession(sessionRoomEntity: SessionRoomEntity)
    suspend fun updateSessionActiveInfo(isActive: Boolean)
    suspend fun getSession() : List<SessionRoomEntity>
}