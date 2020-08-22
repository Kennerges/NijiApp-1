package mission;

import entities.Ninja;
import entities.Ranking;

public class Contract {

    public static final Integer FUNCTION_NUMBER = 3;

    private Ninja[] ninjas;
    private int payment;
    private Ranking ranking;
    private int players;

    public Contract(Ninja[] ninjas, int payment, Ranking ranking, int players) {
        this.ninjas = ninjas;
        this.payment = payment;
        this.ranking = ranking;
        this.players = players;
    }

    public void defineReward() {
        int totalLines = 0;
        double totalPoints;
        double totalInfluence = 0;
        double avgInfluence;

        for (Ninja ninja : ninjas) {
            totalLines = totalLines + ninja.getLinesWritten();
            totalInfluence = totalInfluence + ninja.getPatent().influence;
        }

        avgInfluence = totalInfluence / ninjas.length;
        totalPoints = (avgInfluence *
                totalLines + (avgInfluence *
                totalLines * (players * 0.08))) / 4;

        for (Ninja ninja : ninjas) {
            System.out.println("Name: "
                    + ninja.getName()
                    + "\n"
                    + "Earned points: "
                    + String.format("%.2f",ninja.pointsGained(totalLines, totalPoints))
                    + " points\n"
                    + "Earned experience: "
                    + String.format("%.2f", ninja.xpGained(ranking))
                    + " xp\n"
                    + "Payment: ¥ "
                    + payment);
        }
    }
}
