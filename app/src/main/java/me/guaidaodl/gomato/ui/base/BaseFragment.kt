package me.guaidaodl.gomato.ui.base

import android.arch.lifecycle.LifecycleFragment
import android.content.Context

/**
 * @author Guaidaodl
 */

open class BaseFragment<out Delegate> : LifecycleFragment() {
	protected val delegate: Delegate by lazy {
		@Suppress("UNCHECKED_CAST")
		activity as Delegate
	}

	override fun onAttach(context: Context) {
		super.onAttach(context)
	}
}

