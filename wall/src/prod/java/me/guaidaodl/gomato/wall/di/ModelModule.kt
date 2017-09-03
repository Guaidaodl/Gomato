package me.guaidaodl.gomato.wall.di

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import me.guaidaodl.gomato.api.dao.TaskDao
import me.guaidaodl.gomato.persistence.room.TaskDatabase
import me.guaidaodl.gomato.persistence.room.wrapper.TaskDaoImpl
import javax.inject.Singleton

/**
 * @author Guaidaodl
 */
@Module
class ModelModule(context: Context) {
	private val database: TaskDatabase
			= Room.databaseBuilder(context, TaskDatabase::class.java, "Gomato")
					.build()

	@Provides
	@Singleton
	fun getTaskDao(): TaskDao {
		return TaskDaoImpl(database.taskDao)
	}
}
