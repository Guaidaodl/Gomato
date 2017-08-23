package me.guaidaodl.gomato.ui.editor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.guaidaodl.gomato.R;
import me.guaidaodl.gomato.ui.base.BaseFragment;

/**
 * @author Guaidaodl
 */

public class EditorFragment extends BaseFragment {

	private static final String ARGS_TASK_ID = "args_task_id";

	public static EditorFragment newInstance(long taskId) {
		Bundle args = new Bundle();
		args.putLong(ARGS_TASK_ID, taskId);

		EditorFragment f = new EditorFragment();
		f.setArguments(args);

		return f;
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater,
	                         @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_editor, container, false);

		return root;
	}
}
