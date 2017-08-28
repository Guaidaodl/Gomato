package me.guaidaodl.gomato.ui.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.support.v7.app.AppCompatActivity

/**
 * @author Guaidaodl
 */

abstract class BaseActivity : AppCompatActivity(), LifecycleOwner {

	private val lifecycle = LifecycleRegistry(this)

	override fun getLifecycle(): Lifecycle {
		return lifecycle
	}
}
