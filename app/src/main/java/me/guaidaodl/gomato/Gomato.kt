package me.guaidaodl.gomato

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import me.guaidaodl.common.debug.initDebugTools
import me.guaidaodl.gomato.di.AppComponent
import me.guaidaodl.gomato.di.AppModule
import me.guaidaodl.gomato.di.DaggerAppComponent
import me.guaidaodl.gomato.wall.di.ModelModule

/**
 * @author Guaidaodl
 */
class Gomato : Application() {
	companion object {
		lateinit var appComponent: AppComponent
	}

	override fun onCreate() {
		super.onCreate()
		if (LeakCanary.isInAnalyzerProcess(this)) {
			return
		}

		initDebugTools(this)
		appComponent = DaggerAppComponent.builder()
				.appModule(AppModule(app = this))
				.modelModule(ModelModule(this))
				.build()
	}
}
