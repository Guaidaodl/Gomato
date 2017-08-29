package me.guaidaodl.gomato.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.guaidaodl.gomato.R
import me.guaidaodl.gomato.databinding.FragmentListBinding
import me.guaidaodl.gomato.ui.base.BaseFragment
import me.guaidaodl.gomato.ui.editor.EditorActivity


/**
 * @author Guaidaodl
 */

class TaskListFragment: BaseFragment() {

	private lateinit var binding:FragmentListBinding

	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val root = inflater?.inflate(R.layout.fragment_list, container, false)
		binding = FragmentListBinding.bind(root)

		binding.fab.setOnClickListener { _ -> EditorActivity.startForNewTask(context) }

		return root
	}
}
