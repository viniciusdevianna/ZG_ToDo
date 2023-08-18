package com.devianna.zgtodo.view;

import com.devianna.zgtodo.control.TaskController;
import com.devianna.zgtodo.models.Task;

public class TaskListView {
    private final TaskController taskController;

    public TaskListView(TaskController tc) {
        taskController = tc;
    }

    public void showAllTasks() {
        for (Task t : taskController.allTasks()) {
            System.out.println(t);
        }
    }
}
