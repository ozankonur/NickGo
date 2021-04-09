package com.okonur.nickgo.framework.chat.data.cache.dao

import com.okonur.nickgo.framework.chat.data.cache.entity.MessageRoomEntity

class ChatDaoServiceImpl(
    private val chatDao: ChatDao
) : ChatDaoService {
    override suspend fun insertMessage(messageRoomEntity: MessageRoomEntity): Long {
        return chatDao.insertMessage(messageRoomEntity)
    }

    override suspend fun getMessages(): List<MessageRoomEntity> {
        return chatDao.getMessages()
    }
}