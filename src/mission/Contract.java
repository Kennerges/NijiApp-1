package mission;

import entities.Ninja;
import entities.Ranking;

public class Contract {

    public Ninja[] ninjas;
    public int payment;
    public Ranking ranking;
    public int players;

    public Contract(Ninja[] ninjas, int payment, Ranking ranking, int players) {
        this.ninjas = ninjas;
        this.payment = payment;
        this.ranking = ranking;
        this.players = players;
    }
}
