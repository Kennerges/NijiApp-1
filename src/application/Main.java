package application;

import battle.BattleService;
import entities.Ninja;
import entities.Patent;
import mission.ContractMission;
import mission.ContractMissionService;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        UI.startScreen();
        System.out.println();
        UI.clearScreen();
        if (UI.actuallyService == 1) {
            BattleService battleService = new BattleService();
            battleService.initBattle(sc);
            Ninja ninjaOne = battleService.getBattle().getNinjaOne();
            Ninja ninjaTwo = battleService.getBattle().getNinjaTwo();
            while (ninjaOne.getAttributes().getLife() > 0 && ninjaTwo.getAttributes().getLife() > 0
                    && ninjaOne.getAttributes().getStamina() > 0 && ninjaTwo.getAttributes().getStamina() > 0) {
                UI.battleScreen(ninjaOne, ninjaTwo);
                UI.actionScreen(ninjaOne, ninjaTwo, sc);
                UI.clearScreen();
            }
        } else if (UI.actuallyService == 2) {
            ContractMissionService contractMissionService = new ContractMissionService();
            contractMissionService.initMission(sc);
            ContractMission contractMission = contractMissionService.getContractMission();
            UI.ninjaInformationScreen(contractMission);
        } else if (UI.actuallyService == 0) {
            System.out.print("Programa encerrado.");
        }
        sc.close();
    }
}

