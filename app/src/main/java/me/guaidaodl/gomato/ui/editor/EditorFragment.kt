package me.guaidaodl.gomato.ui.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

import me.guaidaodl.gomato.R
import me.guaidaodl.gomato.ui.base.BaseFragment

class EditorFragment : BaseFragment() {

	lateinit var emptyView: View
	lateinit var descriptionEditor: EditText

	companion object {

		private val ARGS_TASK_ID = "args_task_id"

		fun newInstance(taskId: Long): EditorFragment {
			val args = Bundle()
			args.putLong(ARGS_TASK_ID, taskId)

			val f = EditorFragment()
			f.arguments = args

			return f
		}
	}

	override fun onCreateView(inflater: LayoutInflater,
							  container: ViewGroup?,
							  savedInstanceState: Bundle?): View? {
		val root = inflater.inflate(R.layout.fragment_editor, container, false)
		emptyView = root.findViewById(R.id.empty_touch_receiver)
		descriptionEditor = root.findViewById(R.id.description)
		emptyView.setOnClickListener { _ ->
			descriptionEditor.requestFocus()
			descriptionEditor.setSelection(descriptionEditor.text.length)
		}

		return root
	}

}
