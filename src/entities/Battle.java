package entities;

import java.util.Random;

public class Battle {

    public static final Integer FUNCTION_NUMBER = 1;

    private Ninja ninjaOne;
    private Ninja ninjaTwo;

    public void createBattle(Ninja[] ninjas) {
        this.ninjaOne = ninjas[0];
        this.ninjaTwo = ninjas[1];
    }

    public Ninja getNinjaOne() {
        return ninjaOne;
    }

    public void setNinjaOne(Ninja ninjaOne) {
        this.ninjaOne = ninjaOne;
    }

    public Ninja getNinjaTwo() {
        return ninjaTwo;
    }

    public void setNinjaTwo(Ninja ninjaTwo) {
        this.ninjaTwo = ninjaTwo;
    }

    public static boolean singleAttackHandsCleanTest(Ninja ninjaOne, Ninja ninjaTwo, Integer response) {
        Random random = new Random();

        if (response == 1) {
            double ninjaOneValue = (ninjaOne.getAttributes().getMovement() +
                    ninjaOne.getAttributes().getTaijutsu()) / 2;
            double ninjaTwoValue = ninjaTwo.getAttributes().getTaijutsu() +
                    ninjaTwo.getAttributes().getAgility() +
                    ninjaTwo.getAttributes().getMovement();

            double totalValue = ninjaOneValue + ninjaTwoValue;
            double result = random.nextDouble() * totalValue;
            boolean success = result <= ninjaOneValue;

            if (success) {
                System.out.println("A atacou B com perfeição.");
                return true;
            } else {
                System.out.println("B conseguiu se defender do ataque de A.");
                return false;
            }

        } else {
            double ninjaOneValue = ninjaOne.getAttributes().getMovement();
            double ninjaTwoValue = (ninjaTwo.getAttributes().getMovement() +
                    ninjaTwo.getAttributes().getAgility()) +
                    ninjaTwo.getAttributes().getTaijutsu();

            double totalValue = ninjaOneValue + ninjaTwoValue;
            double result = random.nextDouble() * totalValue;

            boolean success = result <= ninjaOneValue;

            if (success) {
                System.out.println("A atacou B com perfeição.");
                return true;
            } else {
                System.out.println("B conseguiu desviar do ataque de A.");
                return false;
            }
        }
    }

    public static boolean[] multipleAttackHandsCleanTest(Ninja ninjaOne, Ninja ninjaTwo, Integer response, int n) {

        boolean[] booleans = new boolean[n];
        Random random = new Random();

        if (response == 1) {
            for (int i = 0; i < n; i++) {
                double ninjaOneValue = (ninjaOne.getAttributes().getMovement() +
                        ninjaOne.getAttributes().getTaijutsu()) / 2;
                double ninjaTwoValue = ninjaTwo.getAttributes().getTaijutsu() +
                        ninjaTwo.getAttributes().getAgility() +
                        ninjaTwo.getAttributes().getMovement();

                double totalValue = ninjaOneValue + ninjaTwoValue;
                double result = random.nextDouble() * totalValue;
                booleans[i] = result <= ninjaOneValue;
            }
        } else {
            for (int i = 0; i < n; i++) {
                double ninjaOneValue = ninjaOne.getAttributes().getMovement();
                double ninjaTwoValue = (ninjaTwo.getAttributes().getMovement() +
                        ninjaTwo.getAttributes().getAgility()) +
                        ninjaTwo.getAttributes().getTaijutsu();

                double totalValue = ninjaOneValue + ninjaTwoValue;
                double result = random.nextDouble() * totalValue;
                booleans[i] = result <= ninjaOneValue;
            }
        }
        return booleans;
    }
}
