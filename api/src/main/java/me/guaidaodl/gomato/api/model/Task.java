package me.guaidaodl.gomato.api.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Guaidaodl
 */

public interface Task {
	@NotNull
	String getId();

	@Nullable
	String getSubject();
	void setSubject(@Nullable String subject);

	@Nullable
	String getDescription();
	void setDescription(@Nullable String description);
}
