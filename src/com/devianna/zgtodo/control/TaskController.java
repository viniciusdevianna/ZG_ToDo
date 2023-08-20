package com.devianna.zgtodo.control;

import com.devianna.zgtodo.data.TaskDAO;
import com.devianna.zgtodo.models.Priority;
import com.devianna.zgtodo.models.Status;
import com.devianna.zgtodo.models.Task;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TaskController {

    private ArrayList<Task> listOfTasks;
    private final TaskDAO taskDao;
    private int lastId;

    public TaskController() {
        taskDao = new TaskDAO();
        listOfTasks = new ArrayList<Task>();
        try {
            listOfTasks = taskDao.read();
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível acessar o banco de dados");
        }

        lastId = listOfTasks.isEmpty() ? 1 : listOfTasks.get(listOfTasks.size() - 1).getId() + 1;
    }


    public void createTask(String name, String description, Priority priority, String category, Status status, LocalDate limitDate) {
        int id = lastId++;
        Task newTask = new Task(id, name, description, priority, category, status, limitDate, LocalDate.now());

        try {
            taskDao.save(newTask);
        } catch (IOException e) {
            System.out.println("Não foi possível acessar o banco de dados.\nSuas alterações não serão salvas.");
        }

        listOfTasks.add(newTask);
    }

    public void deleteTask(int taskId) {
        Task t = getTask(taskId);
        try {
            taskDao.delete(t);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Suas alterações não foram salvas");
        }
        listOfTasks.remove(t);
    }

    public Task getTask(int taskId) {
        for (Task t : listOfTasks) {
            if (t.getId() == taskId) return t;
        }
        return null;
    }

    public void updateTask(int taskId, Task.TaskAttributes attribute, String newValue) {
        Task t = getTask(taskId);
        switch (attribute) {
            case NAME:
                t.setName(newValue);
                break;
            case DESCRIPTION:
                t.setDescription(newValue);
                break;
            case PRIORITY:
                t.setPriority(Priority.findByNumber(Integer.parseInt(newValue)));
                break;
            case CATEGORY:
                t.setCategory(newValue);
                break;
            case LIMIT_DATE:
                t.setLimitDate(LocalDate.parse(newValue));
                break;
            default:
                System.out.println("Atributo inválido");
        }

        try {
            taskDao.update(t);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Suas alterações não foram salvas");
        }
    }

    public ArrayList<Task> allTasks() {
        return listOfTasks;
    }
    
}
