package com.devianna.zgtodo.models;

public enum Priority {
    VERY_LOW(1, "Muito Baixa"),
    LOW(2, "Baixa"),
    NORMAL(3, "Normal"),
    HIGH(4, "Alta"),
    VERY_HIGH(5, "Muito Alta");

    private final int number;
    private final String text;

    Priority(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }
    public String getText() {
        return text;
    }
}
