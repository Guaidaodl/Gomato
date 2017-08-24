package me.guaidaodl.gomato.ui.editor;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import me.guaidaodl.gomato.R;
import me.guaidaodl.gomato.ui.base.BaseActivity;

/**
 * @author Guaidaodl
 */

public class EditorActivity extends BaseActivity {
	private static final String FRAGMENT_TAG = "editorFragment";

	private EditorFragment editorFragment;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_editor);
		Toolbar t = findViewById(R.id.toolBar);
		setSupportActionBar(t);
		if(!initFragment(savedInstanceState)) {
			finish();
		}
	}

	private boolean initFragment(@Nullable Bundle savedInstanceState) {
		if (savedInstanceState == null) {
			editorFragment = EditorFragment.Companion.newInstance(0);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragmentContainer, editorFragment, FRAGMENT_TAG)
					.commit();
		} else {
			Fragment f = getSupportFragmentManager()
					.findFragmentByTag(FRAGMENT_TAG);
			if (f != null) {
				editorFragment = (EditorFragment) f;
			}
		}

		return editorFragment != null;
	}
}
