package me.guaidaodl.gomato.ui.editor

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.Toolbar
import android.view.Menu
import me.guaidaodl.gomato.R
import me.guaidaodl.gomato.api.model.Task
import me.guaidaodl.gomato.ui.base.BaseActivity

/**
 * @author Guaidaodl
 */

class EditorActivity : BaseActivity(), EditorFragment.Delegate {
	companion object {
		private val FRAGMENT_TAG = "editorFragment"
		private val EXTRA_TASK_ID = "extra_task_id"

		fun startForNewTask(context: Context) {
			val i = Intent(context, EditorActivity::class.java)

			context.startActivity(i)
		}

		fun startToEdit(context: Context, task: Task) {
			val i = Intent(context, EditorActivity::class.java)
			i.putExtra(EXTRA_TASK_ID, task.id)
		}
	}

	private var editorFragment: EditorFragment? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContentView(R.layout.activity_editor)
		val t = findViewById<Toolbar>(R.id.toolbar)
		setSupportActionBar(t)

		val fab = findViewById<FloatingActionButton>(R.id.fab)
		fab.setOnClickListener {
			editorFragment?.save()
			finish()
		}

		if (!initFragment(savedInstanceState)) {
			finish()
		}
	}

	private fun initFragment(savedInstanceState: Bundle?): Boolean {
		if (savedInstanceState == null) {
			val id: String? = intent.getStringExtra(EXTRA_TASK_ID)
			editorFragment = EditorFragment.newInstance(id)
			supportFragmentManager.beginTransaction()
					.add(R.id.fragment_container, editorFragment, FRAGMENT_TAG)
					.commit()
		} else {
			val f = supportFragmentManager
					.findFragmentByTag(FRAGMENT_TAG)
			if (f != null) {
				editorFragment = f as EditorFragment
			}
		}

		return editorFragment != null
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		super.onCreateOptionsMenu(menu)

		supportActionBar?.let {
			it.setDisplayHomeAsUpEnabled(true)
			it.title = getString(R.string.title_activity_editor)
		}

		return true
	}

	override fun exit() {
		finish()
	}

}
