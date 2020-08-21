package mission;

import entities.Ninja;

public class ContractService {

    public static final Integer FUNCTION_NUMBER = 2;

    public static void defineReward(Contract contract) {
        int totalLines = 0;
        double totalPoints;
        double totalInfluence = 0;
        double avgInfluence;

        Ninja[] ninjas = contract.ninjas;

        for (Ninja ninja : ninjas) {
            totalLines = totalLines + ninja.getLinesWritten();
            totalInfluence = totalInfluence + ninja.getPatent().influence;
        }

        avgInfluence = totalInfluence / contract.ninjas.length;
        totalPoints = (avgInfluence *
                totalLines + (avgInfluence *
                totalLines * (contract.players * 0.08))) / 4;

        for (Ninja ninja : ninjas) {
            System.out.println("Name: "
                    + ninja.getName()
                    + "\n"
                    + "Earned points: "
                    + String.format("%.2f",ninja.pointsGained(totalLines, totalPoints))
                    + " points\n"
                    + "Earned experience: "
                    + String.format("%.2f", ninja.xpGained(contract))
                    + " xp\n"
                    + "Payment: ¥ "
                    + contract.payment
                    + "\n");
        }
    }
}
