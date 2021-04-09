package com.okonur.nickgo.framework.home.data.cache.dao

import com.okonur.nickgo.framework.home.data.cache.entity.SessionRoomEntity

class SessionDaoServiceImpl(
    private val sessionDao: SessionDao
) : SessionDaoService {
    override suspend fun insertSession(sessionRoomEntity: SessionRoomEntity) {
        return sessionDao.insertSession(sessionRoomEntity)
    }

    override suspend fun updateSessionActiveInfo(isActive: Boolean) {
        sessionDao.updateSessionActiveInfo(isActive)
    }

    override suspend fun getSession() : List<SessionRoomEntity> {
       return sessionDao.getSession()
    }
}