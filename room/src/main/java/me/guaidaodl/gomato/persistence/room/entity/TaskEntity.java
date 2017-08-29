package me.guaidaodl.gomato.persistence.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import me.guaidaodl.gomato.api.model.Task;

/**
 * @author Guaidaodl
 */

@Entity(tableName = "tasks")
public class TaskEntity implements Task {
	@NonNull
	@PrimaryKey
	@ColumnInfo(name = "id")
	private String id = UUID.randomUUID().toString();

	@NonNull
	@ColumnInfo(name = "subject")
	private String subject = "";

	@NonNull
	@ColumnInfo(name = "description")
	private String description = "";

	@NonNull
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(@NonNull String id) {
		this.id = id;
	}

	@NotNull
	@Override
	@NonNull
	public String getSubject() {
		return subject;
	}

	@Override
	public void setSubject(@NonNull String subject) {
		this.subject = subject;
	}

	@Override
	@NonNull
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(@NonNull String description) {
		this.description = description;
	}
}
