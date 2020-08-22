package application;

import entities.Ninja;
import entities.Patent;
import workout.GroupWorkout;

import java.util.Scanner;

public class UIGrupalWorkout {

    public static GroupWorkout grupalWorkoutConfigureScreen(Scanner sc) {
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Configure o seu Contrato");
        System.out.println("- - - - - - - - - - - - -");
        System.out.println();
        System.out.print("> 1ª: Diga a quantidade de jogadores presentes na Missão: ");
        int players = sc.nextInt();
        System.out.print("> 2ª: Quantos personagens estavam presentes na Missão? ");
        Ninja[] ninjas = ninjaInformationScreen(sc.nextInt(), sc);
        System.out.println();
        clearScreen();
        return new GroupWorkout(ninjas, players);
    }

    private static Ninja[] ninjaInformationScreen(int n, Scanner sc) {
        Ninja[] ninjas = new Ninja[n];
        for (int i = 0; i < ninjas.length; i++) {
            System.out.print("-> Cite o nome do ninja #" + (i + 1) + ": ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("--> Qual a patente dele? " +
                    "\n1. Genin" +
                    "\n2. Chunin" +
                    "\n3. Jounin" +
                    "\n4. Tokubetsu Jounin" +
                    "\n5. Kage" +
                    "\n6. Saikounin" +
                    "\nResposta: ");
            int chosenPatent = sc.nextInt();
            Patent patent = new Patent(chosenPatent);
            System.out.print("->: Quantas linhas ele escreveu? ");
            int lines = sc.nextInt();
            System.out.println();
            ninjas[i] = new Ninja(name, lines, patent);
        }
        clearScreen();
        return ninjas;
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
