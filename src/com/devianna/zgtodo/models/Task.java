package com.devianna.zgtodo.models;

import com.devianna.zgtodo.consts.StringConstants;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Task {
    private final int id;
    private String name;
    private String description;
    private Priority priority;
    private String category;
    private Status status;
    private final LocalDate createdAt;
    private LocalDate limitDate;

    public Task(int id, String name, String description, Priority priority, String category, Status status, LocalDate limitDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.category = category;
        this.status = status;
        this.createdAt = LocalDate.now();
        this.limitDate = limitDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(LocalDate limitDate) {
        this.limitDate = limitDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String taskId = StringConstants.BOLD + StringConstants.UNDERLINE + id + StringConstants.RESET_FORMAT;
        String taskName = StringConstants.BOLD + name + StringConstants.RESET_FORMAT;
        String taskDescription = StringConstants.ITALIC + description + StringConstants.RESET_FORMAT;
        String taskCategory = "|" + category + "|";
        String taskPriority = priority.getColor() + " " + priority.getText() + " " + StringConstants.RESET_FORMAT;
        String taskLimit = "";

        if (limitDate != null) {
            taskLimit = "Data Limite: " + StringConstants.UNDERLINE + limitDate + StringConstants.RESET_FORMAT;
            if (limitDate.isEqual(LocalDate.now())) {
                taskLimit = StringConstants.RED_FONT + taskLimit;
            }
        }

        if (status.equals(Status.DONE)) {
            taskName = StringConstants.STROKE + taskName;
            taskDescription = StringConstants.STROKE + taskDescription;
            taskCategory = StringConstants.STROKE + taskCategory;
            taskPriority = StringConstants.STROKE + taskPriority;
            taskLimit = StringConstants.STROKE + taskLimit;
        }

        return String.format(
                "> %s - %s\t%s\tPrioridade: %s\t%s\n %s\nStatus: %s\n",
                taskId, taskName, taskCategory, taskPriority, taskLimit, taskDescription, status.getText());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getId() == task.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
