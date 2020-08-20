package application;

import entities.Battle;
import entities.Ninja;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        UI.initScreen();
        int functionChoice = sc.nextInt();
        System.out.println();

        if (functionChoice == Battle.FUNCTION_NUMBER) {
            UI.loadBattleScreen(sc);
            Ninja[] ninjas = Ninja.createNinjas(sc);
            Battle.initBattle(ninjas[0], ninjas[1]);
        }

        sc.close();
    }

}
