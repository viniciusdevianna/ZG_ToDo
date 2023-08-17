package com.devianna.zgtodo.models;

public enum Status {
    TODO("Pendente"),
    DOING("Fazendo"),
    DONE("Feita");

    private final String text;
    Status(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
