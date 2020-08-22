package application;

import entities.Ninja;
import entities.Patent;
import entities.Ranking;
import mission.Contract;

import java.util.Scanner;

public class UIContract {

    public static Contract contractConfigureScreen(Scanner sc) {
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Configure o seu Contrato");
        System.out.println("- - - - - - - - - - - - -");
        System.out.println();
        System.out.println("> 1ª: Diga a quantidade de jogadores presentes na Missão: ");
        System.out.print("— ");
        int players = sc.nextInt();
        System.out.println("> 2ª: Quantos personagens estavam presentes na Missão? ");
        System.out.print("— ");
        int characters = sc.nextInt();
        Ninja[] ninjas = ninjaInformationScreen(characters, sc);
        System.out.println("> 3ª: Qual o Ranking da Missão? ");
        System.out.print("— ");
        char rank = sc.next().toUpperCase().charAt(0);
        Ranking ranking = new Ranking(rank);
        System.out.println("> 4ª: Qual o Pagamento em ¥ da Missão: ");
        System.out.print("— ");
        int payment = sc.nextInt();
        System.out.println();
        clearScreen();
        return new Contract(ninjas, payment, ranking, players);
    }

    public static Ninja[] ninjaInformationScreen(int n, Scanner sc) {
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
