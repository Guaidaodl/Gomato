package me.guaidaodl.gomato.persistence.room.wrapper

import me.guaidaodl.gomato.api.dao.TaskDao
import me.guaidaodl.gomato.api.model.Task
import me.guaidaodl.gomato.persistence.room.dao.RoomTaskDao
import me.guaidaodl.gomato.persistence.room.entity.TaskEntity

/**
 * @author Guaidaodl
 */

class TaskDaoImpl(private val impl: RoomTaskDao): TaskDao {
	override fun listAllTask(): MutableList<out Task> {
		return impl.listAllTask()
	}

	override fun insertOrUpdate(task: Task?) {
		if (task is TaskEntity) {
			impl.insert(task)
		}
	}

	override fun findTask(id: String): Task? {
		return impl.findTask(id)
	}

}
