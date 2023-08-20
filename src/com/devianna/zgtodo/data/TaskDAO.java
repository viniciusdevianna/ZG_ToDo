package com.devianna.zgtodo.data;

import com.devianna.zgtodo.models.Priority;
import com.devianna.zgtodo.models.Status;
import com.devianna.zgtodo.models.Task;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskDAO {
    private final File database;

    public TaskDAO() {
        database = new File("./src/com/devianna/zgtodo/data/tasksDB.csv");
        if (!database.exists()) {
            try {
                if (database.createNewFile()) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(database));
                    writer.write("id;name;description;priority;category;status;limitDate;createdAt\n");
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Não foi possível acessar o arquivo de database.\nSuas alterações não serão salvas.");
            }
        }
    }

    public ArrayList<Task> read() throws FileNotFoundException {
        Scanner scanner = new Scanner(database);
        scanner.nextLine();
        ArrayList<Task> tasks = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] attributes = scanner.nextLine().split(";");
            Task t = new Task(
                    Integer.parseInt(attributes[0]),
                    attributes[1],
                    attributes[2],
                    Priority.findByNumber(Integer.parseInt(attributes[3])),
                    attributes[4],
                    Status.valueOf(attributes[5]),
                    attributes[6].isEmpty() ? null : LocalDate.parse(attributes[6]),
                    LocalDate.parse(attributes[7])
            );
            tasks.add(t);
        }

        scanner.close();
        return tasks;
    }

    public void save(Task task) throws IOException {
        String[] attributes = new String[8];
        attributes[0] = String.valueOf(task.getId());
        attributes[1] = task.getName();
        attributes[2] = task.getDescription();
        attributes[3] = String.valueOf(task.getPriority().getNumber());
        attributes[4] = task.getCategory();
        attributes[5] = task.getStatus().toString();
        attributes[6] = task.getLimitDate() != null ? task.getLimitDate().toString() : "";
        attributes[7] = task.getCreatedAt().toString();

        String newTask = String.join(";", attributes);

        BufferedWriter writer = new BufferedWriter(new FileWriter(database, true));
        writer.append(newTask).append("\n");
        writer.close();
    }
}
