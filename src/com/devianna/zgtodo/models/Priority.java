package com.devianna.zgtodo.models;

import com.devianna.zgtodo.consts.StringConstants;

public enum Priority {
    VERY_HIGH(5, "Muito Alta", StringConstants.VERY_HIGH_PRIORITY),
    HIGH(4, "Alta", StringConstants.HIGH_PRIORITY),
    NORMAL(3, "Normal", StringConstants.NORMAL_PRIORITY),
    LOW(2, "Baixa", StringConstants.LOW_PRIORITY),
    VERY_LOW(1, "Muito Baixa", StringConstants.VERY_LOW_PRIORITY);

    private final int number;
    private final String text;
    private final String color;

    Priority(int number, String text, String color) {
        this.number = number;
        this.text = text;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }
    public String getText() {
        return text;
    }
    public String getColor() { return color; }

    public static Priority findByNumber(int number) {
        for (Priority p : values()) {
            if (p.number == number) {
                return p;
            }
        }
        return null;
    }
}
