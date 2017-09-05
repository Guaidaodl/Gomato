package me.guaidaodl.gomato.api.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import me.guaidaodl.gomato.api.model.Task;

/**
 * @author Guaidaodl
 */
// TODO: 2017/8/29 use RxJava
public interface TaskDao {
	/**
	 * 创建一个新的 Task
	 */
	@NotNull Task createTask();
	/**
	 * 根据 uuid 查找 Task, 没有找到则返回 null
	 */
	@Nullable
	Task findTask(@NotNull String uuid);

	@NotNull
	List<? extends Task> listAllTask();

	void insertOrUpdate(@NotNull Task task);
}
