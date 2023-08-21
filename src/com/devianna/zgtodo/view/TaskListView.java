package com.devianna.zgtodo.view;

import com.devianna.zgtodo.control.TaskController;
import com.devianna.zgtodo.models.OrderBy;
import com.devianna.zgtodo.models.Priority;
import com.devianna.zgtodo.models.Status;
import com.devianna.zgtodo.models.Task;

import java.util.Comparator;
import java.util.function.Predicate;

public class TaskListView {
    private final TaskController taskController;

    public TaskListView(TaskController tc) {
        taskController = tc;
    }

    public <T> void showAllTasks(OrderBy orderBy, T filterBy) {
        taskController.allTasks()
                .stream()
                .filter(getFilter(filterBy))
                .sorted(new Comparator<Task>() {
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

    private <T> Predicate<Task> getFilter(T filterBy) {
        Predicate<Task> filter;
        if (filterBy instanceof Priority) {
            filter = (t) -> t.getPriority().equals(filterBy);
        } else if (filterBy instanceof Status) {
            filter = (t) -> t.getStatus().equals(filterBy);
        } else if (filterBy instanceof String) {
            filter = (t) -> t.getCategory().equals(filterBy);
        } else {
            filter = (t) -> true;
        }
        return filter;
    }
}
