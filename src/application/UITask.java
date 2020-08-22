package application;

import mission.Task;

import java.util.Scanner;

public class UITask {

    public static Task taskConfigureScreen(Scanner sc) {
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Configure a sua Tarefa");
        System.out.println("- - - - - - - - - - - - -");
        System.out.println();
        System.out.print("> 1ª: Qual o Rank da Missão: ");
        String rank = sc.nextLine();
        System.out.println();
        clearScreen();
        return new Task(rank);
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

