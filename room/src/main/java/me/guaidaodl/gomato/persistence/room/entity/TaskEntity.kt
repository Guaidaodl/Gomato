package me.guaidaodl.gomato.persistence.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import me.guaidaodl.gomato.api.model.Task
import java.util.*

/**
 * @author Guaidaodl
 */

@Entity(tableName = "tasks")
class TaskEntity: Task {
	@PrimaryKey
	@ColumnInfo(name = "id")
	private var id = UUID.randomUUID().toString()

	@ColumnInfo(name = "subject")
	private var subject: String? = null

	@ColumnInfo(name = "description")
	private var description:String? = null

	override fun getId(): String {
		return id
	}

	fun setId(id: String) {
		this.id = id
	}

	override fun getSubject(): String? {
		return subject
	}

	override fun setSubject(subject: String?) {
		this.subject = subject
	}

	override fun getDescription(): String? {
		return description
	}

	override fun setDescription(description: String?) {
		this.description = description
	}
}
