package me.guaidaodl.gomato.api.dao;

import java.util.List;

import me.guaidaodl.gomato.api.model.Task;

/**
 * @author Guaidaodl
 */
// TODO: 2017/8/29 use RxJava
public interface TaskDao {
	Task findTask(String uuid);

	List<? extends Task> listAllTask();

	void insertOrUpdate(Task task);
}
