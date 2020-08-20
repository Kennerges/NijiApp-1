package battle;

import application.UI;
import entities.Ninja;

import java.util.Scanner;

public class BattleService {

    public Battle battle;

    public void initBattle(Scanner sc) {
        Ninja[] ninjas = UI.configureBattleScreen(sc);
        battle = new Battle(ninjas);
    }

}
