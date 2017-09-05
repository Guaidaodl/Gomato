package me.guaidaodl.gomato.ui.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.guaidaodl.gomato.Gomato

import me.guaidaodl.gomato.R
import me.guaidaodl.gomato.api.dao.TaskDao
import me.guaidaodl.gomato.api.model.Task
import me.guaidaodl.gomato.databinding.FragmentEditorBinding
import me.guaidaodl.gomato.ui.base.BaseFragment
import javax.inject.Inject

class EditorFragment : BaseFragment<EditorFragment.Delegate>() {

	companion object {

		private val ARGS_TASK_ID = "args_task_id"
		private val EXTRAS_TASK_TD = "extras_task_id"

		fun newInstance(taskId: String?): EditorFragment {
			val f = EditorFragment()

			val args = Bundle()
			if (taskId != null) {
				args.putString(ARGS_TASK_ID, taskId)
			}
			f.arguments = args

			return f
		}
	}

	@Inject
	lateinit var taskDao: TaskDao
	lateinit var task: Task
	lateinit var binding: FragmentEditorBinding

	var editorModel: TaskEditorModel? = null

	init {
		Gomato.appComponent.inject(this)
	}

	override fun onCreateView(inflater: LayoutInflater,
							  container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val root = inflater.inflate(R.layout.fragment_editor, container, false)
		binding = FragmentEditorBinding.bind(root)

		binding.emptyTouchReceiver.setOnClickListener { _ ->
			val editor = binding.descriptionEditor
			editor.requestFocus()
			editor.setSelection(editor.text.length)
		}

		return root
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)

		val taskId: String?
		if (savedInstanceState == null) {
			taskId = arguments.getString(ARGS_TASK_ID)
		} else {
			taskId = savedInstanceState.getString(EXTRAS_TASK_TD)
		}

		val t: Task?
		if (taskId == null) {
			t = taskDao.createTask()
		} else {
			t = taskDao.findTask(taskId)
		}

		if (t == null) {
			delegate.exit()
			return
		}
		editorModel = TaskEditorModel(t)
		binding.model = editorModel
	}

	override fun onSaveInstanceState(outState: Bundle) {
		super.onSaveInstanceState(outState)
		outState.putString(EXTRAS_TASK_TD, task.id)
	}

	fun save() {
		editorModel?.let {
			taskDao.insertOrUpdate(it.task)
		}
	}

	interface Delegate {
		fun exit()
	}
}
