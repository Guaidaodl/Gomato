package me.guaidaodl.gomato.ui.list

import android.os.Bundle
import android.support.v7.widget.Toolbar
import me.guaidaodl.gomato.R
import me.guaidaodl.gomato.ui.base.BaseActivity

/**
 * @author Guaidaodl
 */
class TaskListActivity: BaseActivity() {

	companion object {
		val LIST_FRAGMENT_TAG = "fragment_list_tag"
	}

	private lateinit var listFragment: TaskListFragment
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_list)

		val toolbar: Toolbar = findViewById(R.id.toolbar)
		setSupportActionBar(toolbar)

		if (savedInstanceState == null) {
			listFragment = TaskListFragment()
			supportFragmentManager.beginTransaction()
					.add(R.id.fragment_container, listFragment, LIST_FRAGMENT_TAG)
					.commit()
		} else {
			listFragment = supportFragmentManager.findFragmentByTag(LIST_FRAGMENT_TAG)
								as TaskListFragment
		}
	}

}