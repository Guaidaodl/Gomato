package me.guaidaodl.gomato.ui.editor

import android.databinding.BaseObservable
import android.databinding.Bindable
import me.guaidaodl.gomato.BR
import me.guaidaodl.gomato.api.model.Task

data class TaskEditorModel(val task: Task): BaseObservable() {
	var subject: String
		@Bindable
		get() = task.subject ?: ""

		set(value) {
			task.subject = value

			notifyPropertyChanged(BR.subject)
		}

	var description: String
		@Bindable
		get() = task.description ?: ""

		set(value) {
			task.description = value

			notifyPropertyChanged(BR.description)
		}
}
