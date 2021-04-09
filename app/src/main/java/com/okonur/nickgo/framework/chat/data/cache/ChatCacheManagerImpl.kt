package com.okonur.nickgo.framework.chat.data.cache

import com.okonur.nickgo.framework.chat.data.cache.dao.ChatDaoService
import com.okonur.nickgo.framework.chat.data.cache.util.ChatCacheMapper
import com.okonur.nickgo.framework.chat.data.model.MessageModel

class ChatCacheManagerImpl(
    private val chatDaoService: ChatDaoService,
    private val mapper: ChatCacheMapper
) : ChatCacheManager {
    override suspend fun insertMessage(messageModel: MessageModel) : Long {
        return chatDaoService.insertMessage(mapper.modelToEntity(messageModel))
    }

    override suspend fun insertMessageList(messageList: List<MessageModel>) {
        for (message in messageList){
            chatDaoService.insertMessage(mapper.modelToEntity(message))
        }
    }

    override suspend fun getChat(): List<MessageModel> {
        return mapper.chatListFromChatRoomList(chatDaoService.getMessages())
    }
}