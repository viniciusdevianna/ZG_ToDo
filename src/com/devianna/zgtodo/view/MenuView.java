package com.devianna.zgtodo.view;

import com.devianna.zgtodo.consts.StringConstants;
import com.devianna.zgtodo.models.OrderBy;

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
        System.out.println("| 0 - Ordenação Padrão                      |");
        System.out.println("| 1 - Por prioridade                        |");
        System.out.println("| 2 - Por categoria                         |");
        System.out.println("| 3 - Por status                            |");
        System.out.println("| 4 - Voltar para o menu principal          |");
        System.out.println(" -------------------------------------------- ");

        System.out.print(":");
    }

    public void drawFilterByMenu() {
        System.out.println("Filtrar a lista de tarefas por...");
        System.out.println(" -------------------------------------------- ");
        System.out.println("| 1 - Prioridade                            |");
        System.out.println("| 2 - Categoria                             |");
        System.out.println("| 3 - Status                                |");
        System.out.println("| 4 - Voltar para o menu principal          |");
        System.out.println(" -------------------------------------------- ");

        System.out.print(":");
    }

    public void drawFilterValueMenu(OrderBy orderby) {
        switch (orderby) {
            case PRIORITY:
                System.out.println("Qual a prioridade?");
                System.out.println(" -------------------------------------------- ");
                System.out.println("| 1 - Muito baixa                           |");
                System.out.println("| 2 - Baixa                                 |");
                System.out.println("| 3 - Normal                                |");
                System.out.println("| 4 - Alta                                  |");
                System.out.println("| 5 - Muito alta                            |");
                System.out.println(" -------------------------------------------- ");
                System.out.print(":");
                break;
            case CATEGORY:
                System.out.println("Qual categoria?");
                System.out.println(":");
                break;
            case STATUS:
                System.out.println("Qual o status?");
                System.out.println(" -------------------------------------------- ");
                System.out.println("| 1 - Pendente                              |");
                System.out.println("| 2 - Fazendo                               |");
                System.out.println("| 3 - Feita                                 |");
                System.out.println(" -------------------------------------------- ");
                System.out.println(":");
                break;
            default:
                System.out.println(StringConstants.INVALID_MENU_OPTION);
        }
    }

    public void drawTaskListMenu() {
        System.out.println("O que você deseja fazer?");
        System.out.println(" -------------------------------------------- ");
        System.out.println("| 1 - Avançar status                        |");
        System.out.println("| 2 - Deletar tarefa                        |");
        System.out.println("| 3 - Atualizar tarefa                      |");
        System.out.println("| 4 - Voltar                                |");
        System.out.println(" -------------------------------------------- ");

        System.out.print(":");
    }

    public void drawUpdateMenu() {
        System.out.println("O que você deseja atualizar?");
        System.out.println(" -------------------------------------------- ");
        System.out.println("| 1 - Nome                                  |");
        System.out.println("| 2 - Descrição                             |");
        System.out.println("| 3 - Categoria                             |");
        System.out.println("| 4 - Prioridade                            |");
        System.out.println("| 5 - Data Limite                           |");
        System.out.println("| 6 - Voltar                                |");
        System.out.println(" -------------------------------------------- ");

        System.out.print(":");
    }

}
