package application;

import battle.BattleService;
import entities.Attributes;
import entities.Ninja;

import java.util.Scanner;

public class UIBattles {

    public static Ninja[] battleConfigureScreen(Scanner sc) {
        int n = 0;
        Ninja[] ninjas = new Ninja[2];
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Configure os personagens");
        System.out.println("- - - - - - - - - - - - -");
        System.out.println();
        while (n < 2) {
            System.out.println("-> " + (n + 1) + "º Ninja");
            System.out.print("Nome: ");
            String name = sc.next();
            System.out.print("Taijutsu: ");
            double taijutsu = sc.nextInt();
            System.out.print("Força: ");
            double strength = sc.nextInt();
            System.out.print("Agilidade: ");
            double agility = sc.nextInt();
            System.out.print("Movimentação: ");
            double movement = sc.nextInt();
            System.out.print("Resistência: ");
            double resistance = sc.nextDouble();
            System.out.print("Vida: ");
            double life = sc.nextDouble();
            double stamina = resistance * 10;
            double chakra = stamina * 2;
            Attributes attributesNinja = new Attributes(taijutsu, strength, agility, movement, resistance,
                    life, stamina, chakra);
            ninjas[n] = new Ninja(name, attributesNinja);
            System.out.println();
            n++;
        }
        clearScreen();
        return ninjas;
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

    public static void actionScreen(Ninja ninjaOne, Ninja ninjaTwo, Scanner sc) {
        System.out.println("Escolha o seu personagem: ");
        System.out.println("1. " + ninjaOne.getName());
        System.out.println("2. " + ninjaTwo.getName());
        System.out.println();
        System.out.print("Resposta: ");
        int characterChosen = sc.nextInt();
        while (characterChosen != 1 && characterChosen != 2) {
            System.out.println("Não existe este personagem.\nPor favor, digite um número válido: ");
            characterChosen = sc.nextInt();
        } if (characterChosen == 1) {
            System.out.println(ninjaOne.getName() + " escolhido.");
        } else {
            System.out.println(ninjaTwo.getName() + " escolhido.");
        } System.out.println();
        System.out.println("Qual será a sua ação? ");
        System.out.println("1. Ataque de mãos vazias");
        System.out.print("Resposta: ");
        int actionChosen = sc.nextInt();
        while (actionChosen != 1) {
            System.out.println("Não existe esta ação.\nPor favor, digite um número válido: ");
            actionChosen = sc.nextInt();
        } System.out.println();
        System.out.println("1. Único ataque");
        System.out.println("2. Múltiplos ataques");
        System.out.print("Resposta: ");
        int typeChosed = sc.nextInt();
        System.out.println();
        System.out.println("O que o outro ninja decidiu fazer? ");
        if (actionChosen == 1) {
            System.out.println("1. Defender");
            System.out.println("2. Desviar");
        } System.out.print("Resposta: ");
        int responseChosed = sc.nextInt();
        System.out.println();

        if (characterChosen == 1 && actionChosen == 1 && typeChosed == 1) {
            boolean success = BattleService.singleAttackHandsCleanTest(ninjaOne, ninjaTwo, responseChosed);
            String damage;
            if (success) {
                damage = ninjaOne.applyingImpactAttack(ninjaTwo, responseChosed, false);
            } else {
                damage = ninjaOne.applyingImpactAttack(ninjaTwo, responseChosed, true);
            }
            System.out.println(damage);
        } else if (characterChosen == 1 && actionChosen == 1 && typeChosed == 2) {
            System.out.print("Quantas vezes: ");
            int n = sc.nextInt();
            boolean[] attempts = BattleService.multipleAttackHandsCleanTest(ninjaOne, ninjaTwo, responseChosed, n);
            int m = 1;
            for (boolean attempt : attempts) {
                if (attempt) {
                    String damage = ninjaOne.applyingImpactAttack(ninjaTwo, responseChosed, false);
                    System.out.println(damage);
                }
                m ++;
            }
        } if (characterChosen == 2 && actionChosen == 1 && typeChosed == 1) {
            boolean success = BattleService.singleAttackHandsCleanTest(ninjaTwo, ninjaOne, responseChosed);
            if (success) {
                System.out.println("O ataque deu certo.");
                String damage = ninjaTwo.applyingImpactAttack(ninjaOne, responseChosed, false);
                System.out.println(damage);
            } else {
                System.out.println("O ataque deu errado");
                String damage = ninjaTwo.applyingImpactAttack(ninjaOne, responseChosed, true);
                System.out.println(damage);
            }
        } else if (characterChosen == 2 && actionChosen == 1 && typeChosed == 2) {
            System.out.print("Quantas vezes: ");
            int n = sc.nextInt();
            boolean[] attempts = BattleService.multipleAttackHandsCleanTest(ninjaTwo, ninjaOne, responseChosed, n);
            int m = 1;
            for (boolean attempt : attempts) {
                if (attempt) {
                    System.out.println("O ataque #" + m + " deu certo.");
                    String damage = ninjaTwo.applyingImpactAttack(ninjaOne, responseChosed, false);
                    System.out.println(damage);
                } else {
                    System.out.println("O ataque #" + m + " deu errado.");
                }
                m ++;
            }
        }
        System.out.println();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
