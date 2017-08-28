package me.guaidaodl.gomato.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.guaidaodl.gomato.R
import me.guaidaodl.gomato.ui.base.BaseFragment

/**
 * @author Guaidaodl
 */

class TaskListFragment: BaseFragment() {
	override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val root = inflater?.inflate(R.layout.fragment_list, container, false)

		return root
	}
}
