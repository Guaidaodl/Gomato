package me.guaidaodl.gomato.ui.list

import me.guaidaodl.common.ui.recyclerview.BaseDataBindingAdapter
import me.guaidaodl.gomato.R
import me.guaidaodl.gomato.api.dao.TaskDao
import me.guaidaodl.gomato.api.model.Task

class TaskListAdapter(taskDao: TaskDao): BaseDataBindingAdapter<Task, TaskListAdapter.Delegate>() {

	private val taskList: List<Task> = taskDao.listAllTask()

	var delegate: Delegate? = null

	override fun getItemCount() = taskList.size

	override fun getLayoutId(position: Int) = R.layout.task_list_item

	override fun getItem(position: Int) = taskList[position]

	override fun getDelegate(position: Int): Delegate? = delegate

	interface Delegate
}