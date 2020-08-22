package workout;

import entities.Ninja;

public class GroupWorkout {

    public static final Integer FUNCTION_NUMBER = 4;

    private final Ninja[] ninjas;
    private final int players;

    public GroupWorkout(Ninja[] ninjas, int players) {
        this.ninjas = ninjas;
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
                totalLines * (players * 0.08)));

        for (Ninja ninja : ninjas) {
            System.out.println("Name: "
                    + ninja.getName()
                    + "\n"
                    + "Earned points: "
                    + String.format("%.2f",ninja.pointsGained(totalLines, totalPoints))
                    + " points\n");
        }
    }
}
