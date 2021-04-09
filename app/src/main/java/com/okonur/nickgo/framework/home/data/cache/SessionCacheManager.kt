package com.okonur.nickgo.framework.home.data.cache

import com.okonur.nickgo.framework.home.data.model.SessionModel

interface SessionCacheManager {
    suspend fun insertSession(sessionRoomModel: SessionModel)
    suspend fun updateSessionActiveInfo(isActive: Boolean)
    suspend fun getSession() : List<SessionModel>
}