package com.devianna.zgtodo.view;

import com.devianna.zgtodo.control.TaskController;
import com.devianna.zgtodo.models.OrderBy;
import com.devianna.zgtodo.models.Priority;
import com.devianna.zgtodo.models.Status;
import com.devianna.zgtodo.models.Task;

import java.util.Comparator;

public class TaskListView {
    private final TaskController taskController;

    public TaskListView(TaskController tc) {
        taskController = tc;
    }

    public void showAllTasks(OrderBy orderBy) {
        taskController.allTasks()
                .stream().
                sorted(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                switch (orderBy) {
                    case PRIORITY:
                        return t1.getPriority().compareTo(t2.getPriority());
                    case CATEGORY:
                        return t1.getCategory().compareTo(t2.getCategory());
                    case STATUS:
                        return t1.getStatus().compareTo(t2.getStatus());
                    default:
                        return t1.getCreatedAt().compareTo(t2.getCreatedAt());
                }
            }
        })
                .forEach(System.out::println);
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
