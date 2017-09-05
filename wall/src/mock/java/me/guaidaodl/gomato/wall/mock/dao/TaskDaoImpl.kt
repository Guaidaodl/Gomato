package me.guaidaodl.gomato.wall.mock.dao

import me.guaidaodl.gomato.api.dao.TaskDao
import me.guaidaodl.gomato.api.model.Task
import me.guaidaodl.gomato.wall.mock.model.TaskEntity
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author Guaidaodl
 */
internal class TaskDaoImpl: TaskDao {
	private val taskList: MutableList<Task>
	private var id = AtomicInteger(0)

	init {
		taskList = ArrayList()
		taskList.add(TaskEntity("" + id.getAndIncrement(), "Task 1", "empty"))
		taskList.add(TaskEntity("" + id.getAndIncrement(), "Task 2", "empty"))
		taskList.add(TaskEntity("" + id.getAndIncrement(), "Task 3", "empty"))
		taskList.add(TaskEntity("" + id.getAndIncrement(), "Task 4", "empty"))
		taskList.add(TaskEntity("" + id.getAndIncrement(), "Task 5", "empty"))
		taskList.add(TaskEntity("" + id.getAndIncrement(), "Task 6", "empty"))
		taskList.add(TaskEntity("" + id.getAndIncrement(), "Task 7", "empty"))
		taskList.add(TaskEntity("" + id.getAndIncrement(), "Task 8", "empty"))
	}

	override fun createTask(): Task {
		return TaskEntity("" + id.getAndIncrement())
	}

	override fun findTask(id: String): Task? {
		val task = taskList.asSequence().filter { it.id == id }.firstOrNull()

		return if (task != null)  TaskEntity(task) else null
	}

	override fun listAllTask(): MutableList<out Task> {
		return ArrayList<Task>(taskList)
	}

	override fun insertOrUpdate(task: Task) {
		val t = findTask(task.id)

		if (t == null) {
			taskList.add(TaskEntity(task))
		} else {
			t.subject = task.subject
			t.description = task.description
		}
	}

}