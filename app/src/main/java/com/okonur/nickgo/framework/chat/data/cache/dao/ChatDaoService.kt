package com.okonur.nickgo.framework.chat.data.cache.dao

import com.okonur.nickgo.framework.chat.data.cache.entity.MessageRoomEntity

interface ChatDaoService {
    suspend fun insertMessage(messageRoomEntity: MessageRoomEntity) : Long
    suspend fun getMessages() : List<MessageRoomEntity>
}