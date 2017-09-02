package me.guaidaodl.gomato.persistence.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import me.guaidaodl.gomato.persistence.room.dao.RoomTaskDao
import me.guaidaodl.gomato.persistence.room.entity.TaskEntity

/**
 * @author Guaidaodl
 */
@Database(entities = arrayOf(TaskEntity::class), version = 1)
abstract class TaskDatabase : RoomDatabase() {
	abstract val taskDao: RoomTaskDao
}
