package me.guaidaodl.gomato.wall.di

import android.content.Context
import dagger.Module
import dagger.Provides
import me.guaidaodl.gomato.api.dao.TaskDao
import me.guaidaodl.gomato.wall.mock.dao.TaskDaoImpl
import javax.inject.Singleton

/**
 * @author Guaidaodl
 */
@Module
class ModelModule(context: Context) {
	@Provides
	@Singleton
	fun getTaskDao(): TaskDao {
		return TaskDaoImpl()
	}
}
