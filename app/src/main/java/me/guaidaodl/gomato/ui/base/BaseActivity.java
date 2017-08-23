package me.guaidaodl.gomato.ui.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Guaidaodl
 */

public abstract class BaseActivity extends AppCompatActivity implements LifecycleOwner {

	private LifecycleRegistry lifecycle = new LifecycleRegistry(this);

	@Override
	public Lifecycle getLifecycle() {
		return lifecycle;
	}
}
