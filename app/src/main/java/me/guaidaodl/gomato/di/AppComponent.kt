package me.guaidaodl.gomato.di

import dagger.Component
import me.guaidaodl.gomato.ui.editor.EditorFragment
import me.guaidaodl.gomato.ui.list.TaskListFragment
import me.guaidaodl.gomato.wall.di.ModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ModelModule::class))
interface AppComponent {
	fun inject(f: TaskListFragment)

	fun inject(f: EditorFragment)
}