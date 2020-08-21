package mission;

import application.UI;
import entities.Ninja;
import entities.Ranking;

import java.util.Scanner;

public class ContractMissionService {

    public static final Integer FUNCTION_NUMBER = 2;

    private ContractMission contractMission;

    public void initMission(Scanner sc) {
        String[] chars = UI.configureContractMissionScreen(sc);
        int peoples = Integer.parseInt(chars[0]);
        int payment = Integer.parseInt(chars[3]);
        Ninja[] ninjas = new Ninja[Integer.parseInt(chars[1])];
        Ranking ranking = new Ranking(chars[2].charAt(0));
        contractMission = new ContractMission(ninjas, payment, ranking, peoples);
    }

    public ContractMission getContractMission() {
        return contractMission;
    }
}
