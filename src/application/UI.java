package application;

import entities.Battle;
import entities.Ninja;

import java.util.Random;
import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void initScreen() {
        System.out.println("- - - - - - - - - -");
        System.out.println("Nijigakure APP # 1");
        System.out.println("- - - - - - - - - -\n");
        System.out.println("Funções:\n");
        System.out.println("> 1. Batalhas 1v1\n");
        System.out.println("Escolha a funcionalidade a ser usada.");
        System.out.print("Resposta: ");
    }

    public static void loadBattleScreen(Scanner sc) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print(ANSI_YELLOW + "Batalha 1v1" + ANSI_RESET);
        System.out.println(" escolhido");
        System.out.println("Aperte Enter para proceder");
        sc.nextLine();
        sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        configureBattleScreen();
    }

    public static void configureBattleScreen() {
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Configure a sua Batalha");
        System.out.println("- - - - - - - - - - - - -");
        System.out.println();
    }

    public static void battleScreen(Ninja ninjaOne, Ninja ninjaTwo) {
        System.out.println(ninjaOne.getName().toUpperCase());
        System.out.println("Vida: " + ninjaOne.getAttributes().getLife());
        System.out.println("Stamina: " + ninjaOne.getAttributes().getStamina());
        System.out.println("Chakra: " + ninjaOne.getAttributes().getChakra());
        System.out.println("- - - - - - - - -");
        System.out.println(ninjaTwo.getName().toUpperCase());
        System.out.println("Vida: " + ninjaTwo.getAttributes().getLife());
        System.out.println("Stamina: " + ninjaTwo.getAttributes().getStamina());
        System.out.println("Chakra: " + ninjaTwo.getAttributes().getChakra());
        System.out.println();
    }

    public static void selectionAndActionScreen(Ninja ninjaOne, Ninja ninjaTwo) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha o seu personagem: ");
        System.out.println("1. " + ninjaOne.getName());
        System.out.println("2. " + ninjaTwo.getName());
        int characterChosen = sc.nextInt();
        System.out.println();
        if (characterChosen == 1) {
            System.out.println(ninjaOne.getName() + " escolhido.");
        } else {
            System.out.println(ninjaTwo.getName() + " escolhido.");
        }
        System.out.println();
        System.out.println("Qual será a sua ação? ");
        System.out.println("1. Ataque de mãos vazias");
        System.out.println();
        System.out.print("Resposta: ");
        int actionChosed = sc.nextInt();
        System.out.println("1. Único ataque");
        System.out.println("2. Múltiplos ataques");
        int typeChosed = sc.nextInt();
        System.out.println();
        System.out.print("Resposta: ");
        if (actionChosed == 1) {
            System.out.println("O que o outro ninja decidiu fazer? ");
            System.out.println("1. Defender");
            System.out.println("2. Desviar");
            System.out.println();
            System.out.print("Resposta: ");
        }
        int responseChosed = sc.nextInt();

        if (characterChosen == 1) {
            if (actionChosed == 1) {
                if (typeChosed == 1) {
                    boolean success = Battle.singleAttackHandsCleanTest(ninjaOne, ninjaOne, responseChosed);
                    if (success) {
                        ninjaOne.applyingImpactAttack(ninjaTwo);
                    }
                } else if (typeChosed == 2) {
                    System.out.println("Quantos ataques foram: ");
                    int n = sc.nextInt();
                    for (boolean response : Battle.multipleAttackHandsCleanTest(ninjaOne, ninjaTwo, actionChosed, n)) {
                        if (response) {
                            ninjaOne.applyingImpactAttack(ninjaTwo);
                        }
                    }
                }
            }
        } else {
            if (actionChosed == 1) {
                ninjaTwo.applyingImpactAttack(ninjaOne);
            }
        }
        System.out.println();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
