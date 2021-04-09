package com.okonur.nickgo.di.repositoryModule

import com.okonur.nickgo.framework.chat.data.cache.ChatCacheManager
import com.okonur.nickgo.framework.chat.data.remote.ChatApiManager
import com.okonur.nickgo.framework.chat.repository.Repository
import com.okonur.nickgo.framework.home.data.cache.SessionCacheManager
import com.okonur.nickgo.framework.home.repository.SessionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideChatRepository(
        chatCacheManager: ChatCacheManager,
        chatApiManager: ChatApiManager
    ): Repository {
        return Repository(chatCacheManager, chatApiManager)
    }

    @Singleton
    @Provides
    fun provideSessionRepository(
        sessionCacheManager: SessionCacheManager
    ): SessionRepository {
        return SessionRepository(sessionCacheManager)
    }
}