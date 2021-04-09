package com.okonur.nickgo.framework.chat.data.cache.util

import com.okonur.nickgo.framework.chat.data.cache.entity.MessageRoomEntity
import com.okonur.nickgo.framework.chat.data.cache.entity.UserRoomEntity
import com.okonur.nickgo.framework.chat.data.model.MessageModel
import com.okonur.nickgo.framework.chat.data.model.UserModel
import com.okonur.nickgo.util.mapper.EntityMapper
import javax.inject.Inject

class ChatCacheMapper @Inject constructor() : EntityMapper<MessageRoomEntity,MessageModel> {
    override fun modelFromEntity(entity: MessageRoomEntity): MessageModel {
        return MessageModel(
            id = entity.uidMessage,
            text = entity.text,
            timestamp = entity.timestamp,
            userModel = UserModel(entity.userRoom.avatarURL,entity.userRoom.uid,entity.userRoom.nickname)
        )
    }

    override fun modelToEntity(model: MessageModel): MessageRoomEntity {
        return MessageRoomEntity(
            uidMessage = model.id,
            text = model.text,
            timestamp = model.timestamp,
            userRoom = UserRoomEntity(model.userModel.id,model.userModel.avatarURL,model.userModel.nickname)
        )
    }

    fun chatListFromChatRoomList(entities: List<MessageRoomEntity>) : List<MessageModel>{
        return entities.map { modelFromEntity(it) }
    }
}