package com.devianna.zgtodo;

import com.devianna.zgtodo.control.MenuController;

public class Application {
    public static void main(String[] args) {
        MenuController myController = new MenuController();
        myController.startMainMenu();
    }
}
