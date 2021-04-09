package com.okonur.nickgo.di.apiModule

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.okonur.nickgo.BuildConfig
import com.okonur.nickgo.framework.chat.data.model.MessageModel
import com.okonur.nickgo.framework.chat.data.remote.ChatApiManager
import com.okonur.nickgo.framework.chat.data.remote.ChatApiManagerImpl
import com.okonur.nickgo.framework.chat.data.remote.entity.MessageRetrofitEntity
import com.okonur.nickgo.framework.chat.data.remote.retrofit.ChatRetrofitInterface
import com.okonur.nickgo.framework.chat.data.remote.retrofit.ChatRetrofitService
import com.okonur.nickgo.framework.chat.data.remote.retrofit.ChatRetrofitServiceImpl
import com.okonur.nickgo.framework.chat.data.remote.util.ChatApiMapper
import com.okonur.nickgo.util.mapper.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ChatApiModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideChatRetrofitInterface(retrofit: Retrofit.Builder): ChatRetrofitInterface {
        return retrofit
            .build()
            .create(ChatRetrofitInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideChatService(chatRetrofitInterface: ChatRetrofitInterface): ChatRetrofitService {
        return ChatRetrofitServiceImpl(chatRetrofitInterface)
    }

    @Singleton
    @Provides
    fun provideApiMapper(): EntityMapper<MessageRetrofitEntity, MessageModel> {
        return ChatApiMapper()
    }

    @Singleton
    @Provides
    fun provideChatApiManager(chatRetrofitService: ChatRetrofitService): ChatApiManager {
        return ChatApiManagerImpl(chatRetrofitService, ChatApiMapper())
    }
}