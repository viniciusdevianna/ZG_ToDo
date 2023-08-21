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

    public static Status findByNumber(int number) {
        Status s;
        try {
            s = values()[number - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            s = null;
        }
        return s;
    }
}
