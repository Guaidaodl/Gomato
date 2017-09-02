package me.guaidaodl.gomato.di

import android.app.Application
import dagger.Module
import dagger.Provides
import me.guaidaodl.gomato.Gomato
import javax.inject.Singleton

@Module
class AppModule(val app: Gomato) {
	@Provides
	@Singleton
	fun providerApplication(): Application = app
}