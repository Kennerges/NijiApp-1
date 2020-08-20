package application;

import entities.Battle;
import entities.Ninja;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Battle battle = new Battle();

        UI.startScreen();
        UI.functionChosenScreen(sc.nextInt());
        System.out.println();
        UI.clearScreen();
        Ninja[] ninjas = UI.configureBattleScreen(sc);
        battle.createBattle(ninjas);
        Ninja ninjaOne = battle.getNinjaOne();
        Ninja ninjaTwo = battle.getNinjaTwo();

        while (ninjaOne.getAttributes().getLife() > 0 || ninjaTwo.getAttributes().getLife() > 0
        || ninjaOne.getAttributes().getStamina() > 0 || ninjaTwo.getAttributes().getStamina() > 0) {
            UI.battleScreen(ninjaOne, ninjaTwo);
            UI.actionScreen(ninjaOne, ninjaTwo, sc);
            UI.clearScreen();
        }

        sc.close();
    }

}
