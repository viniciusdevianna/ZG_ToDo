package com.devianna.zgtodo;

import com.devianna.zgtodo.models.Priority;
import com.devianna.zgtodo.models.Status;
import com.devianna.zgtodo.models.Task;

public class Application {
    public static void main(String[] args) {
        Task t = new Task(
                1,
                "Tarefa Modelo",
                "Esta é apenas uma tarefa modelo",
                Priority.NORMAL,
                "Geral",
                Status.TODO,
                null
        );

        System.out.println(t);
        System.out.println("Descrição da tarefa: " + t.getDescription());
        System.out.println("Status: " + t.getStatus().getText());
        System.out.println("Prioridade: " + t.getPriority().getText());
    }
}
