package me.guaidaodl.gomato.persistence.room.dao

import android.arch.persistence.room.*
import me.guaidaodl.gomato.persistence.room.entity.TaskEntity

@Dao
interface RoomTaskDao {
	@Query("SELECT * FROM tasks WHERE id= :taskId")
	fun findTask(taskId: String): TaskEntity?

	@Query("SELECT * FROM tasks")
	fun listAllTask(): MutableList<TaskEntity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insert(task: TaskEntity)

	@Update
	fun update(task: TaskEntity)
}
