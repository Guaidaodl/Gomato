package me.guaidaodl.gomato.ui.editor

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import me.guaidaodl.gomato.R
import me.guaidaodl.gomato.ui.base.BaseActivity

/**
 * @author Guaidaodl
 */

class EditorActivity : BaseActivity() {

	companion object {
		private val FRAGMENT_TAG = "editorFragment"
		private val EXTRA_TASK_ID = "extra_task_id"

		fun startForNewTask(context: Context) {
			val i = Intent(context, EditorActivity::class.java)

			context.startActivity(i)
		}
	}

	private var editorFragment: EditorFragment? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContentView(R.layout.activity_editor)
		val t = findViewById<Toolbar>(R.id.toolbar)
		setSupportActionBar(t)
		if (!initFragment(savedInstanceState)) {
			finish()
		}
	}

	private fun initFragment(savedInstanceState: Bundle?): Boolean {
		if (savedInstanceState == null) {
			editorFragment = EditorFragment.newInstance(0)
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

}
