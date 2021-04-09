package com.okonur.nickgo.framework.home.data.cache

import com.okonur.nickgo.framework.home.data.cache.dao.SessionDaoService
import com.okonur.nickgo.framework.home.data.cache.util.SessionCacheMapper
import com.okonur.nickgo.framework.home.data.model.SessionModel

class SessionCacheManagerImpl(
    private val sessionDaoService: SessionDaoService,
    private val sessionCacheMapper: SessionCacheMapper
) : SessionCacheManager {
    override suspend fun insertSession(sessionRoomModel: SessionModel) {
        return sessionDaoService.insertSession(sessionCacheMapper.modelToEntity(sessionRoomModel))
    }

    override suspend fun updateSessionActiveInfo(isActive: Boolean) {
        sessionDaoService.updateSessionActiveInfo(isActive)
    }

    override suspend fun getSession() : List<SessionModel> {
        return sessionCacheMapper.sessionListFromSessionRoomList(sessionDaoService.getSession())
    }

}