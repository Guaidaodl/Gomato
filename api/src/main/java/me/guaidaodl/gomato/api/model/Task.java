package me.guaidaodl.gomato.api.model;

/**
 * @author Guaidaodl
 */

public interface Task {
	String getId();
	void setId(String id);

	String getSubject();
	void setSubject(String subject);

	String getDescription();
	void setDescription(String description);
}
