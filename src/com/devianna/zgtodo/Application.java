package com.devianna.zgtodo;

import com.devianna.zgtodo.control.TaskController;
import com.devianna.zgtodo.models.OrderBy;
import com.devianna.zgtodo.models.Priority;
import com.devianna.zgtodo.models.Status;
import com.devianna.zgtodo.view.TaskListView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        TaskController controller = new TaskController();
        controller.createTask(
                "Tarefa Modelo",
                "Esta é apenas uma tarefa modelo",
                Priority.HIGH,
                "Geral",
                Status.TODO,
                LocalDate.now()
        );

        controller.createTask(
                "Tarefa Modelo 2",
                "Esta é apenas outra tarefa modelo",
                Priority.NORMAL,
                "Doideira",
                Status.DONE,
                null
        );

        //controller.deleteTask(2);

        controller.createTask(
                "Tarefa Modelo 3",
                "Esta é apenas outra tarefa modelo",
                Priority.VERY_HIGH,
                "Doideira",
                Status.DOING,
                null
        );

        TaskListView listView = new TaskListView(controller);
        listView.showAllTasks(OrderBy.PRIORITY);
        System.out.println();
        listView.showAllTasksFiltered(Priority.HIGH);

    }
}
