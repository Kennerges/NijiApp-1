package application;

import entities.Ninja;
import entities.Patent;
import workout.GroupWorkout;

import java.util.Scanner;

public class UIGrupalWorkout {

    public static GroupWorkout grupalWorkoutConfigureScreen(Scanner sc) {
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Configure o seu Treino");
        System.out.println("- - - - - - - - - - - - -");
        System.out.println();
        System.out.println("> 1ª: Diga a quantidade de jogadores presentes na Treino: ");
        System.out.print("— ");
        int players = sc.nextInt();
        System.out.println("> 2ª: Quantos personagens estavam presentes no Treino? ");
        System.out.print("— ");
        int characters = sc.nextInt();
        Ninja[] ninjas = ninjaInformationScreen(characters, sc);
        System.out.println();
        clearScreen();
        return new GroupWorkout(ninjas, players);
    }

    private static Ninja[] ninjaInformationScreen(int n, Scanner sc) {
        Ninja[] ninjas = new Ninja[n];
        for (int i = 0; i < ninjas.length; i++) {
            System.out.println("-> Cite o nome do ninja #" + (i + 1) + ": ");
            System.out.print("— ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("--> Qual a patente dele? " +
                    "\n1. Genin" +
                    "\n2. Chunin" +
                    "\n3. Jounin" +
                    "\n4. Tokubetsu Jounin" +
                    "\n5. Kage" +
                    "\n6. Saikounin" +
                    "\n— ");
            int chosenPatent = sc.nextInt();
            Patent patent = new Patent(chosenPatent);
            System.out.println("->: Quantas linhas ele escreveu? ");
            System.out.print("— ");
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
