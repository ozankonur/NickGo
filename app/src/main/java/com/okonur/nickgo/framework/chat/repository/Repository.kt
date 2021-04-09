package com.okonur.nickgo.framework.chat.repository

import com.okonur.nickgo.framework.chat.data.cache.ChatCacheManager
import com.okonur.nickgo.framework.chat.data.model.MessageModel
import com.okonur.nickgo.framework.chat.data.remote.ChatApiManager
import com.okonur.nickgo.util.data.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository(
    private val chatCacheManager: ChatCacheManager,
    private val chatApiManager: ChatApiManager
) {
    suspend fun getChat(): Flow<DataState<List<MessageModel>>> = flow {

        emit(DataState.Loading)

        delay(100)

        val chat = chatApiManager.getChatFromApi()

        if (chat.isNotEmpty())
            chatCacheManager.insertMessageList(chat)

        emit(DataState.Success(chatCacheManager.getChat().sortedWith(compareBy { it.timestamp })))
    }

    suspend fun pushMessage(message : MessageModel){
        chatCacheManager.insertMessage(message)
    }
}