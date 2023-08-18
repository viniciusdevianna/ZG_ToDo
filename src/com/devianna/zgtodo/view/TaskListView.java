package com.devianna.zgtodo.view;

import com.devianna.zgtodo.control.TaskController;
import com.devianna.zgtodo.models.Priority;
import com.devianna.zgtodo.models.Status;
import com.devianna.zgtodo.models.Task;

import java.util.stream.Stream;

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

    public <T> void showAllTasksFiltered(T filterBy) {
        if (filterBy instanceof Priority) {
            taskController.allTasks().stream().filter(t -> t.getPriority().equals(filterBy)).forEach(System.out::println);
        } else if (filterBy instanceof Status) {
            taskController.allTasks().stream().filter(t -> t.getStatus().equals(filterBy)).forEach(System.out::println);
        } else if (filterBy instanceof String) {
            taskController.allTasks().stream().filter(t -> t.getCategory().equals(filterBy)).forEach(System.out::println);
        }
    }
}
