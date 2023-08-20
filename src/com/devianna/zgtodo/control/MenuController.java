package com.devianna.zgtodo.control;

import com.devianna.zgtodo.consts.StringConstants;
import com.devianna.zgtodo.models.OrderBy;
import com.devianna.zgtodo.models.Priority;
import com.devianna.zgtodo.models.Status;
import com.devianna.zgtodo.models.Task;
import com.devianna.zgtodo.view.MenuView;
import com.devianna.zgtodo.view.TaskListView;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuController {
    private final Scanner scanner;
    private final TaskController taskController;
    private final MenuView menuView;
    private final TaskListView taskListView;

    public MenuController() {
        scanner = new Scanner(System.in);
        menuView = new MenuView();
        taskController = new TaskController();
        taskListView = new TaskListView(taskController);
    }

    public void startMainMenu() {
        int option = 0;
        while (option != 4) {
            menuView.drawMainMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    startAddTaskMenu();
                    break;
                case 2:
                    startOrderByMenu();
                    break;
                case 3:
                    startFilterMenu();
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println(StringConstants.INVALID_MENU_OPTION);
            }
        }
        scanner.close();
    }

    private void startAddTaskMenu() {
        System.out.println("Qual o nome da tarefa?");
        scanner.nextLine();
        String newTaskName = scanner.nextLine();
        System.out.println("Dê uma descrição simples:");
        String newTaskDescription = scanner.nextLine();

        int newTaskPriorityNumber = 0;
        while (newTaskPriorityNumber < 1 || newTaskPriorityNumber > 5) {
            System.out.println("De 1 a 5 qual é a prioridade da tarefa?");
            newTaskPriorityNumber = scanner.nextInt();
        }


        System.out.println("Qual é a categoria da tarefa?");
        scanner.nextLine();
        String newTaskCategory = scanner.nextLine();
        // TODO: data limite

        System.out.println("Criando tarefa...");
        Priority newTaskPriority = Priority.findByNumber(newTaskPriorityNumber);
        taskController.createTask(
                newTaskName, newTaskDescription, newTaskPriority, newTaskCategory, Status.TODO, null
        );
    }
    private void startOrderByMenu() {
        int orderOption = 0;
        while (orderOption != 4) {
            menuView.drawOrderByMenu();
            orderOption = scanner.nextInt();
            switch (orderOption) {
                case 0:
                    startAllTasksMenu(OrderBy.DEFAULT, null);
                    break;
                case 1:
                    startAllTasksMenu(OrderBy.PRIORITY, null);
                    break;
                case 2:
                    startAllTasksMenu(OrderBy.CATEGORY, null);
                    break;
                case 3:
                    startAllTasksMenu(OrderBy.STATUS, null);
                    break;
                case 4:
                    System.out.println("Voltando para o menu principal...");
                    break;
                default:
                    System.out.println(StringConstants.INVALID_MENU_OPTION);
            }
        }
    }
    private void startFilterMenu() {
        int filterOption = 0;
        while (filterOption != 4) {
            menuView.drawFilterByMenu();
            filterOption = scanner.nextInt();
            switch (filterOption) {
                case 1:
                    startFilterChoiceMenu(OrderBy.PRIORITY);
                    break;
                case 2:
                    startFilterChoiceMenu(OrderBy.CATEGORY);
                    break;
                case 3:
                    startFilterChoiceMenu(OrderBy.STATUS);
                    break;
                case 4:
                    System.out.println("Voltando para o menu principal...");
                    break;
                default:
                    System.out.println(StringConstants.INVALID_MENU_OPTION);
            }
        }
    }

    private void startFilterChoiceMenu(OrderBy orderBy) {
        menuView.drawFilterValueMenu(orderBy);
        scanner.nextLine();
        String valueFilterOption = scanner.nextLine();
        switch (orderBy) {
            case PRIORITY:
                int priorityNumber = Integer.parseInt(valueFilterOption);
                Priority priority = Priority.findByNumber(priorityNumber);
                startAllTasksMenu(orderBy, priority);
                break;
            case STATUS:
                int statusNumber = Integer.parseInt(valueFilterOption);
                Status status = Status.findByNumber(statusNumber);
                startAllTasksMenu(orderBy, status);
                break;
            case CATEGORY:
                startAllTasksMenu(orderBy, valueFilterOption);
                break;
            default:
                System.out.println(StringConstants.INVALID_MENU_OPTION);
        }

    }

    private <T> void startAllTasksMenu(OrderBy orderBy, T filterBy) {
        int menuOption = 0;
        int taskOption;
        taskListView.showAllTasks(orderBy, filterBy);
        while (menuOption != 4) {
            menuView.drawTaskListMenu();
            menuOption = scanner.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.println("Qual o número da tarefa que você deseja avançar?");
                    taskOption = scanner.nextInt();
                    try {
                        Status currentStatus = taskController.getTask(taskOption).getStatus();
                        if (currentStatus.equals(Status.TODO)) {
                            taskController.getTask(taskOption).setStatus(Status.DOING);
                            System.out.printf("Tarefa %d agora está em execução\n", taskOption);
                        } else if (currentStatus.equals(Status.DOING)) {
                            taskController.getTask(taskOption).setStatus(Status.DONE);
                            System.out.println("Tarefa finalizada!");
                        } else {
                            scanner.nextLine();
                            System.out.println("Esta tarefa já está finalizada! Deseja reverter? (S/N)");
                            String answer = scanner.nextLine().toUpperCase();
                            if (answer.equals("S")) {
                                taskController.getTask(taskOption).setStatus(Status.TODO);
                                System.out.println("Status revertido");
                            } else if (!answer.equals("N")) {
                                System.out.println(StringConstants.INVALID_MENU_OPTION);
                            }
                        }

                        taskListView.showAllTasks(orderBy, filterBy);
                    } catch (NullPointerException e) {
                        System.out.println("Esta tarefa não foi encontrada");
                    }
                    break;
                case 2:
                    System.out.println("Qual o número da tarefa que você deseja deletar?");
                    taskOption = scanner.nextInt();
                    try {
                        taskController.deleteTask(taskOption);
                        System.out.println("Tarefa deletada!");
                        taskListView.showAllTasks(orderBy, filterBy);
                    } catch (NullPointerException e) {
                        System.out.println("Esta tarefa não foi encontrada");
                    }
                    break;
                case 3:
                    System.out.println("Qual o número da tarefa que você deseja atualizar?");
                    taskOption = scanner.nextInt();
                    startUpdateTaskMenu(taskOption);
                    taskListView.showAllTasks(orderBy, filterBy);
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println(StringConstants.INVALID_MENU_OPTION);
            }
        }
    }

    public void startUpdateTaskMenu(int taskId) {
        int fieldOption = 0;
        String newValue;
        while (fieldOption != 6) {
            menuView.drawUpdateMenu();
            fieldOption = scanner.nextInt();
            scanner.nextLine();
            switch (fieldOption) {
                case 1:
                    System.out.println("Qual será o novo nome?");
                    newValue = scanner.nextLine();
                    taskController.updateTask(taskId, Task.TaskAttributes.NAME, newValue);
                    break;
                case 2:
                    System.out.println("Qual será a nova descrição?");
                    newValue = scanner.nextLine();
                    taskController.updateTask(taskId, Task.TaskAttributes.DESCRIPTION, newValue);
                    break;
                case 3:
                    System.out.println("Qual será a nova categoria?");
                    newValue = scanner.nextLine();
                    taskController.updateTask(taskId, Task.TaskAttributes.CATEGORY, newValue);
                    break;
                case 4:
                    System.out.println("De 1 a 5, qual será a nova prioridade?");
                    newValue = scanner.nextLine();
                    taskController.updateTask(taskId, Task.TaskAttributes.PRIORITY, newValue);
                    break;
                case 5:
                    System.out.println("No modelo YYYY-MM-DD, qual será a data limite?");
                    newValue = scanner.nextLine();
                    taskController.updateTask(taskId, Task.TaskAttributes.LIMIT_DATE, newValue);
                    break;
                case 6:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println(StringConstants.INVALID_MENU_OPTION);
            }
        }
    }
}
