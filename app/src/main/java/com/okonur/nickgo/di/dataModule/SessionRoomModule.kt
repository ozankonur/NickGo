package com.okonur.nickgo.di.dataModule

import com.okonur.nickgo.framework.home.data.cache.SessionCacheManager
import com.okonur.nickgo.framework.home.data.cache.SessionCacheManagerImpl
import com.okonur.nickgo.framework.home.data.cache.dao.SessionDao
import com.okonur.nickgo.framework.home.data.cache.dao.SessionDaoService
import com.okonur.nickgo.framework.home.data.cache.dao.SessionDaoServiceImpl
import com.okonur.nickgo.framework.home.data.cache.entity.SessionRoomEntity
import com.okonur.nickgo.framework.home.data.cache.util.SessionCacheMapper
import com.okonur.nickgo.framework.home.data.model.SessionModel
import com.okonur.nickgo.util.mapper.EntityMapper
import com.okonur.nickgo.util.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object SessionRoomModule {

    @Singleton
    @Provides
    fun provideSessionDao(sessionDatabase: AppDatabase): SessionDao {
        return sessionDatabase.sessionDao()
    }

    @Singleton
    @Provides
    fun provideSessionDaoService(sessionDao : SessionDao): SessionDaoService {
        return SessionDaoServiceImpl(sessionDao)
    }

    @Singleton
    @Provides
    fun provideSessionCacheMapper(): EntityMapper<SessionRoomEntity, SessionModel> {
        return SessionCacheMapper()
    }

    @Singleton
    @Provides
    fun provideSessionCacheManager(
        sessionDaoService: SessionDaoService,
        sessionCacheMapper: SessionCacheMapper
    ): SessionCacheManager {
        return SessionCacheManagerImpl(sessionDaoService, sessionCacheMapper)
    }
}