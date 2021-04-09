package com.okonur.nickgo.util.mapper

interface EntityMapper<Entity, Model> {
    fun modelFromEntity(entity: Entity): Model
    fun modelToEntity(model: Model): Entity
}