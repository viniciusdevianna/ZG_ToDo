package com.devianna.zgtodo.control;

import com.devianna.zgtodo.models.Priority;
import com.devianna.zgtodo.models.Status;
import com.devianna.zgtodo.models.Task;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskController {

    private final ArrayList<Task> listOfTasks;
    private int lastId;

    public TaskController() {
        listOfTasks = new ArrayList<Task>();
        // Enquanto não temos persistência, esta condição é sempre verdadeira, mas depois isso vai mudar
        lastId = listOfTasks.isEmpty() ? 1 : listOfTasks.get(listOfTasks.size() - 1).getId() + 1;
    }


    public void createTask(String name, String description, Priority priority, String category, Status status, LocalDate limitDate) {
        int id = lastId++;
        Task newTask = new Task(id, name, description, priority, category, status, limitDate);
        listOfTasks.add(newTask);
    }

    public void deleteTask(int taskId) {
        for (Task t : listOfTasks) {
            if (t.getId() == taskId) {
                listOfTasks.remove(t);
                break;
            }
        }
    }

    public Task getTask(int taskId) {
        for (Task t : listOfTasks) {
            if (t.getId() == taskId) return t;
        }
        return null;
    }

    public ArrayList<Task> allTasks() {
        return listOfTasks;
    }
}
