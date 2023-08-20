package com.devianna.zgtodo.models;

public enum Status {
    TODO("PENDENTE"),
    DOING("FAZENDO"),
    DONE("FEITA");

    private final String text;
    Status(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
