package com.okonur.nickgo.di.dataModule

import android.content.Context
import androidx.room.Room
import com.okonur.nickgo.framework.chat.data.cache.ChatCacheManager
import com.okonur.nickgo.framework.chat.data.cache.ChatCacheManagerImpl
import com.okonur.nickgo.framework.chat.data.cache.dao.ChatDao
import com.okonur.nickgo.framework.chat.data.cache.dao.ChatDaoService
import com.okonur.nickgo.framework.chat.data.cache.dao.ChatDaoServiceImpl
import com.okonur.nickgo.framework.chat.data.cache.entity.MessageRoomEntity
import com.okonur.nickgo.framework.chat.data.cache.util.ChatCacheMapper
import com.okonur.nickgo.framework.chat.data.model.MessageModel
import com.okonur.nickgo.util.mapper.EntityMapper
import com.okonur.nickgo.util.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ChatRoomModule {

    @Singleton
    @Provides
    fun provideChatDB(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideChatDao(chatDatabase: AppDatabase): ChatDao {
        return chatDatabase.chatDao()
    }

    @Singleton
    @Provides
    fun provideChatDaoService(chatDao: ChatDao): ChatDaoService {
        return ChatDaoServiceImpl(chatDao)
    }

    @Singleton
    @Provides
    fun provideChatCacheMapper(): EntityMapper<MessageRoomEntity, MessageModel> {
        return ChatCacheMapper()
    }

    @Singleton
    @Provides
    fun provideChatCacheManager(
        chatDaoService: ChatDaoService,
        chatCacheMapper: ChatCacheMapper
    ): ChatCacheManager {
        return ChatCacheManagerImpl(chatDaoService, chatCacheMapper)
    }

}