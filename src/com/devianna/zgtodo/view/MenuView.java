package com.devianna.zgtodo.view;

import com.devianna.zgtodo.consts.StringConstants;

public class MenuView {
    public void drawMainMenu() {
        System.out.println(" ---------------------------------------------------------------------- ");
        System.out.println("|************************ Bem-vindo ao " + StringConstants.ZGTODO + " ***********************|");
        System.out.println(
                "|" + StringConstants.ITALIC + " O seu aplicativo simples, porém completo, de organização de tarefas. "
                        + StringConstants.RESET_FORMAT + "|");
        System.out.println(" ---------------------------------------------------------------------- \n");
        System.out.println("O que você deseja fazer?");

        System.out.println(" -------------------------------------------- ");
        System.out.println("| 1 - Adicionar uma nova tarefa             |");
        System.out.println("| 2 - Ver lista de tarefas completa         |");
        System.out.println("| 3 - Filtrar tarefas                       |");
        System.out.println("| 4 - Sair                                  |");
        System.out.println(" -------------------------------------------- ");

        System.out.print(":");
    }

    public void drawOrderByMenu() {
        System.out.println("Deseja ordenar a lista de tarefas?");
        System.out.println(" -------------------------------------------- ");
        System.out.println("| 1 - Por prioridade                        |");
        System.out.println("| 2 - Por categoria                         |");
        System.out.println("| 3 - Por status                            |");
        System.out.println("| 4 - Ordenação Padrão                      |");
        System.out.println("| 5 - Voltar para o menu principal          |");
        System.out.println(" -------------------------------------------- ");

        System.out.print(":");
    }

    public void drawTaskListMenu() {
        System.out.println("O que você deseja fazer?");
        System.out.println(" -------------------------------------------- ");
        System.out.println("| 1 - Completar tarefa                      |");
        System.out.println("| 2 - Deletar tarefa                        |");
        System.out.println("| 3 - Atualizar tarefa                      |");
        System.out.println("| 4 - Voltar                                |");
        System.out.println(" -------------------------------------------- ");

        System.out.print(":");
    }

}
