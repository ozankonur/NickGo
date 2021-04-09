package com.okonur.nickgo.framework.chat.data.remote.util

import com.okonur.nickgo.framework.chat.data.model.MessageModel
import com.okonur.nickgo.framework.chat.data.model.UserModel
import com.okonur.nickgo.framework.chat.data.remote.entity.ChatRetrofitEntity
import com.okonur.nickgo.framework.chat.data.remote.entity.MessageRetrofitEntity
import com.okonur.nickgo.framework.chat.data.remote.entity.UserRetrofitEntity
import com.okonur.nickgo.util.mapper.EntityMapper

class ChatApiMapper : EntityMapper<MessageRetrofitEntity, MessageModel> {
    override fun modelFromEntity(entity: MessageRetrofitEntity): MessageModel {
        return MessageModel(
            id = entity.id,
            text = entity.text,
            timestamp = entity.timestamp,
            userModel = UserModel(
                entity.userRetrofitEntity.avatarURL,
                entity.userRetrofitEntity.id,
                entity.userRetrofitEntity.nickname
            )
        )
    }

    override fun modelToEntity(model: MessageModel): MessageRetrofitEntity {
        return MessageRetrofitEntity(
            id = model.id,
            text = model.text,
            timestamp = model.timestamp,
            userRetrofitEntity = UserRetrofitEntity(
                model.userModel.avatarURL,
                model.userModel.id,
                model.userModel.nickname
            )
        )
    }

    fun chatListFromChatApiEntityList(entity: ChatRetrofitEntity): List<MessageModel> {
        return entity.messageRetrofitEntities.map { modelFromEntity(it) }
    }
}