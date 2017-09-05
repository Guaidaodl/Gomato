package me.guaidaodl.gomato.ui.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.guaidaodl.gomato.Gomato
import me.guaidaodl.gomato.R
import me.guaidaodl.gomato.api.dao.TaskDao
import me.guaidaodl.gomato.databinding.FragmentListBinding
import me.guaidaodl.gomato.ui.base.BaseFragment
import me.guaidaodl.gomato.ui.editor.EditorActivity
import javax.inject.Inject

/**
 * @author Guaidaodl
 */
class TaskListFragment: BaseFragment<TaskListFragment.Delegate>(), TaskListAdapter.Delegate {

	@Inject
	lateinit var taskDao: TaskDao
	private lateinit var binding:FragmentListBinding
	private var taskListAdapter: TaskListAdapter? = null

	init {
		Gomato.appComponent.inject(this)
	}

	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val root = inflater?.inflate(R.layout.fragment_list, container, false)
		binding = FragmentListBinding.bind(root)

		binding.fab.setOnClickListener { _ -> onClickFab() }

		binding.list.layoutManager = LinearLayoutManager(context)

		return root
	}

	override fun onResume() {
		super.onResume()
		taskListAdapter = TaskListAdapter(taskDao)
		taskListAdapter?.delegate = this
		binding.list.adapter = taskListAdapter
	}

	private fun onClickFab() {
		EditorActivity.startForNewTask(context)
	}

	interface Delegate
}
