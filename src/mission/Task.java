package mission;

import application.Main;

import java.util.Random;
import java.util.Scanner;

public class Task {

    public static final Integer FUNCTION_NUMBER = 2;

    private String rank;
    private Integer xp;
    private Integer ap;

    public Task(String rank) {
        this.rank = rank;
        Random random = new Random();
        switch (rank.toUpperCase()) {
            case "D":
                xp = random.nextInt((30 - 18) + 1) + 18;
                ap = random.nextInt((20 - 10) + 1) + 10;
                break;
            case "C":
                xp = random.nextInt((80 - 30) + 1) + 30;
                ap = random.nextInt((55 - 35) + 1) + 35;
                break;
            case "B":
                xp = random.nextInt((250 - 100) + 1) + 100;
                ap = random.nextInt((125 - 95) + 1) + 95;
                break;
            case "A":
                xp = random.nextInt((600 - 300) + 1) + 300;
                ap = random.nextInt((250 - 200) + 1) + 200;
                break;
            case "S":
                xp = random.nextInt((1200 - 650) + 1) + 650;
                ap = random.nextInt((450 - 375) + 1) + 375;
                break;
        }
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getAp() {
        return ap;
    }

    public void setAp(Integer ap) {
        this.ap = ap;
    }

    public boolean showReward() {
        Scanner sc = new Scanner(System.in);
        System.out.println("A recompensa por esta Tarefa Rank " + rank + " foi de:");
        System.out.println("— " + xp + " Experience Points");
        System.out.println("— " + ap + " Attributes Points");
        System.out.println("Pressione 0 para executar o programa novamente ...");
        return sc.nextInt() == 0;
    }
}
