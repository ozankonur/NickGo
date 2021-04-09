package com.okonur.nickgo.framework.home.data.cache.util

import com.okonur.nickgo.framework.home.data.cache.entity.SessionRoomEntity
import com.okonur.nickgo.framework.home.data.model.SessionModel
import com.okonur.nickgo.util.mapper.EntityMapper
import javax.inject.Inject

class SessionCacheMapper @Inject constructor() : EntityMapper<SessionRoomEntity,SessionModel> {
    override fun modelFromEntity(entity: SessionRoomEntity): SessionModel {
        return SessionModel(
            session = entity.session,
            timestamp = entity.timestamp,
            active = entity.active
        )
    }

    override fun modelToEntity(model: SessionModel): SessionRoomEntity {
        return SessionRoomEntity(
            session = model.session,
            timestamp = model.timestamp,
            active = model.active
        )
    }

    fun sessionListFromSessionRoomList(entities: List<SessionRoomEntity>) : List<SessionModel>{
        return entities.map { modelFromEntity(it) }
    }

}