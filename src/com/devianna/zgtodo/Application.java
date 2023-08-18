package com.devianna.zgtodo;

import com.devianna.zgtodo.control.TaskController;
import com.devianna.zgtodo.models.Priority;
import com.devianna.zgtodo.models.Status;
import com.devianna.zgtodo.view.TaskListView;

public class Application {
    public static void main(String[] args) {
        TaskController controller = new TaskController();
        controller.createTask(
                "Tarefa Modelo",
                "Esta é apenas uma tarefa modelo",
                Priority.NORMAL,
                "Geral",
                Status.TODO,
                null
        );

        controller.createTask(
                "Tarefa Modelo 2",
                "Esta é apenas outra tarefa modelo",
                Priority.HIGH,
                "Doideira",
                Status.DOING,
                null
        );

        controller.deleteTask(2);

        controller.createTask(
                "Tarefa Modelo 3",
                "Esta é apenas outra tarefa modelo",
                Priority.HIGH,
                "Doideira",
                Status.DOING,
                null
        );

        TaskListView listView = new TaskListView(controller);
        listView.showAllTasks();
    }
}
