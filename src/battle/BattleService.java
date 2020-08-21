package battle;

import entities.Ninja;

import java.util.Random;

public class BattleService {

    public static final Integer FUNCTION_NUMBER = 1;

    public static boolean singleAttackHandsCleanTest(Ninja attacker, Ninja defender, Integer response) {
        Random random = new Random();
        if (response == 1) {
            double attackerValue = (attacker.getAttributes().getMovement() +
                    attacker.getAttributes().getTaijutsu()) / 2;
            double defenderValue = defender.getAttributes().getTaijutsu() +
                    defender.getAttributes().getAgility() +
                    defender.getAttributes().getMovement();
            double totalValue = attackerValue + defenderValue;
            double result = random.nextDouble() * totalValue;
            if (result <= attackerValue) {
                System.out.println("A atacou B com perfeição.");
                return true;
            } else {
                System.out.println("B conseguiu se defender do ataque de A.");
                return false;
            }
        } else {
            double attackerValue = attacker.getAttributes().getMovement();
            double defenderValue = (defender.getAttributes().getMovement() +
                    defender.getAttributes().getAgility()) +
                    defender.getAttributes().getTaijutsu();
            double totalValue = attackerValue + defenderValue;
            double result = random.nextDouble() * totalValue;
            if (result <= attackerValue) {
                System.out.println("A atacou B com perfeição.");
                return true;
            } else {
                System.out.println("B conseguiu desviar do ataque de A.");
                return false;
            }
        }
    }

    public static boolean[] multipleAttackHandsCleanTest(Ninja attacker, Ninja defender, Integer response, int n) {
        boolean[] booleans = new boolean[n];
        Random random = new Random();

        if (response == 1) {
            for (int i = 0; i < n; i++) {
                double attackerValue = (attacker.getAttributes().getMovement() +
                        attacker.getAttributes().getTaijutsu()) / 2;
                double defenderValue = defender.getAttributes().getTaijutsu() +
                        defender.getAttributes().getAgility() +
                        defender.getAttributes().getMovement();
                double totalValue = attackerValue + defenderValue;
                double result = random.nextDouble() * totalValue;
                if (result <= attackerValue) {
                    System.out.println(i + 1 + "º: " + attacker.getName() + " conseguiu acertar "
                            + defender.getName() + ".");
                    booleans[i] = true;
                } else {
                    System.out.println(i + 1 + "º: " + defender.getName() + " conseguiu se defender do ataque de "
                            + attacker.getName() + ".");
                    booleans[i] = false;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                double attackerValue = attacker.getAttributes().getMovement();
                double defenderValue = (defender.getAttributes().getMovement() +
                        defender.getAttributes().getAgility()) +
                        defender.getAttributes().getTaijutsu();
                double totalValue = attackerValue + defenderValue;
                double result = random.nextDouble() * totalValue;
                if (result <= attackerValue) {
                    System.out.println("A atacou B com perfeição.");
                    booleans[i] = true;
                } else {
                    System.out.println("B conseguiu desviar do ataque de A.");
                    booleans[i] = false;
                }
            }
        }
        return booleans;
    }
}
