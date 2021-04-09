package com.okonur.nickgo.framework.home.repository

import com.okonur.nickgo.framework.home.data.cache.SessionCacheManager
import com.okonur.nickgo.framework.home.data.model.SessionModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SessionRepository(
    private val sessionCacheManager: SessionCacheManager
) {

    suspend fun insertSession(sessionModel: SessionModel) {
        sessionCacheManager.insertSession(sessionModel)
    }

    suspend fun updateSessionActiveInfo(isSessionActive : Boolean) {
        sessionCacheManager.updateSessionActiveInfo(isSessionActive)
    }

    suspend fun getSession(): Flow<List<SessionModel>> = flow {
        emit(sessionCacheManager.getSession())
    }
}