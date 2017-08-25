package me.guaidaodl.common.debug

import android.app.Application
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary

fun initDebugTools(application: Application) {
	Stetho.initializeWithDefaults(application)
	LeakCanary.install(application)
}
