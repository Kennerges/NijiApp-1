package application;

import battle.BattleService;
import entities.Ninja;
import mission.Contract;
import mission.ContractService;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("- - - - - - - - - -");
        System.out.println("Nijigakure APP # 1");
        System.out.println("- - - - - - - - - -");
        System.out.println("Versão: 1.0");
        System.out.println();
        System.out.println("Funções:\n");
        System.out.println("> 1. Sistema de Batalhas 1v1");
        System.out.println("> 2. Recompensa em Contratos");
        System.out.println("> 3. Pontuação por Treino Individual");
        System.out.println("> 4. Pontuação por Treino em Grupo");
        System.out.println("> 5. Aprendizado de Técnicas");
        System.out.println("> 0. Encerrar o programa.\n");
        System.out.println("Escolha a funcionalidade a ser usada.\n");
        System.out.print("Resposta: ");
        int functionChosen = sc.nextInt();
        System.out.println();

        while (functionChosen != 1 && functionChosen != 2 && functionChosen != 0) {
            System.out.print("Opção inexistente. Selecione outra: ");
            functionChosen = sc.nextInt();
            System.out.println();
        }

        if (functionChosen == BattleService.FUNCTION_NUMBER) {
            System.out.print(ANSI_YELLOW + "Sistema de Batalhas 1v1" + ANSI_RESET);
            System.out.println(" escolhido");
            sc.nextLine();
            System.out.println();
            Ninja[] ninjas = UIBattles.battleConfigureScreen(sc);
            Ninja ninjaOne = ninjas[0];
            Ninja ninjaTwo = ninjas[1];
            while (ninjaOne.getAttributes().getLife() > 0 && ninjaTwo.getAttributes().getLife() > 0
                    && ninjaOne.getAttributes().getStamina() > 0 && ninjaTwo.getAttributes().getStamina() > 0) {
                UIBattles.battleScreen(ninjaOne, ninjaTwo);
                UIBattles.actionScreen(ninjaOne, ninjaTwo, sc);
                UIBattles.clearScreen();
            }
        } else if (functionChosen == ContractService.FUNCTION_NUMBER) {
            System.out.print(ANSI_YELLOW + "Recompensa de Contratos" + ANSI_RESET);
            System.out.println(" escolhido");
            sc.nextLine();
            System.out.println();
            Contract contract = UIContract.contractConfigureScreen(sc);
            ContractService.defineReward(contract);
        } else if (functionChosen == 0) {
            System.out.print("Programa finalizado.");
        }
    }
}

