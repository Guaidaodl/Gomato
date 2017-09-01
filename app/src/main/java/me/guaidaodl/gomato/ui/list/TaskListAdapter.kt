package me.guaidaodl.gomato.ui.list

import android.databinding.BaseObservable
import android.databinding.Bindable
import me.guaidaodl.common.ui.recyclerview.BaseDataBindingAdapter
import me.guaidaodl.gomato.R
import me.guaidaodl.gomato.api.model.Task
import java.util.UUID

class TaskListAdapter: BaseDataBindingAdapter<TaskListAdapter.TaskViewModel, TaskListAdapter.Delegate>() {

	private val taskList: MutableList<TaskViewModel>

	init {
		taskList = ArrayList<TaskViewModel>()
		taskList.add(TaskViewModel("Task1", "A Simple Task"))
		taskList.add(TaskViewModel("Task2", "A Simple Task"))
		taskList.add(TaskViewModel("Task3", "A Simple Task"))
		taskList.add(TaskViewModel("Task4", "A Simple Task"))
		taskList.add(TaskViewModel("Task5", "A Simple Task"))
	}

	override fun getItemCount() = taskList.size

	override fun getLayoutId(position: Int) = R.layout.task_list_item

	override fun getItem(position: Int) = taskList[position]

	interface Delegate

	class TaskViewModel(subject: String, description: String):BaseObservable(), Task {
		private var id: String = UUID.randomUUID().toString()
		private var subject: String
		private var description: String

		init {
			this.subject = subject
			this.description = description
		}

		override fun getId(): String = id

		override fun setId(id: String) {
			this.id = id
		}

		@Bindable
		override fun getSubject(): String = subject

		override fun setSubject(subject: String?) {
			this.subject = subject ?: ""
		}

		@Bindable
		override fun getDescription(): String = description

		override fun setDescription(description: String?) {
			this.description = description ?: ""
		}
	}
}