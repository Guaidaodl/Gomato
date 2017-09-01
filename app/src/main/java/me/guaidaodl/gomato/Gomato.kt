package me.guaidaodl.gomato

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import me.guaidaodl.common.debug.initDebugTools

/**
 * @author Guaidaodl
 */
class Gomato : Application() {
	override fun onCreate() {
		super.onCreate()
		if (LeakCanary.isInAnalyzerProcess(this)) {
			return
		}

		initDebugTools(this)
	}
}
