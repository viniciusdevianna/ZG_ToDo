package com.devianna.zgtodo.models;

import java.time.LocalDate;
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
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
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
