package com.devianna.zgtodo.data;

import com.devianna.zgtodo.models.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<String, String> attributes = new HashMap<>();
        ArrayList<Task> tasks = new ArrayList<>();

        // Pulando a linha com os nomes dos campos
        scanner.nextLine();

        while (scanner.hasNext()) {
            String[] values = scanner.nextLine().split(";");
            attributes.put("id", values[0]);
            attributes.put("name", values[1]);
            attributes.put("description", values[2]);
            attributes.put("priority", values[3]);
            attributes.put("category", values[4]);
            attributes.put("status", values[5]);
            attributes.put("limitDate", values[6]);
            attributes.put("createdAt", values[7]);

            Task t = new Task(attributes);
            tasks.add(t);
        }

        scanner.close();
        return tasks;
    }

    public void save(Task task) throws IOException {
        String newTask = task.toCSV();
        BufferedWriter writer = new BufferedWriter(new FileWriter(database, true));
        writer.append(newTask).append("\n");
        writer.close();
    }
}
