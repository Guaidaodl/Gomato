package me.guaidaodl.gomato.wall.mock.model

import me.guaidaodl.gomato.api.model.Task

/**
 * @author Guaidaodl
 */

class TaskEntity(private var id: String,
				 private var subject: String? = "",
				 private var description: String? = "") : Task {

	constructor(task: Task): this(task.id, task.subject, task.description)

	override fun getId(): String {
		return id
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
