package application;

import battle.Battle;
import entities.Ninja;
import mission.Contract;
import mission.Task;
import workout.GroupWorkout;
import workout.TechniqueWorkout;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("- - - - - - - - - -");
        System.out.println("Nijigakure APP # 1");
        System.out.println("- - - - - - - - - -");
        System.out.println("Versão: 1.0");
        System.out.println();
        System.out.println("Funções:\n");
        System.out.println("> 1. Sistema de Batalhas 1v1");
        System.out.println("> 2. Recompensa em Tarefas");
        System.out.println("> 3. Recompensa em Contratos");
        System.out.println("> 4. Pontuação por Treino em Grupo");
        System.out.println("> 5. Aprendizado de Técnicas");
        System.out.println("> 0. Encerrar o programa.\n");
        System.out.println("Escolha a funcionalidade a ser usada.\n");
        System.out.print("Resposta: ");
        int functionChosen = sc.nextInt();
        System.out.println();

        while (functionChosen != 1 && functionChosen != 2 && functionChosen != 3
                && functionChosen != 4 && functionChosen != 5 &&functionChosen != 0) {
            System.out.print("Opção inexistente. Selecione outra: ");
            functionChosen = sc.nextInt();
            System.out.println();
        }

        if (functionChosen == Battle.FUNCTION_NUMBER) {
            System.out.print(ANSI_YELLOW + "Sistema de Batalhas 1v1" + ANSI_RESET);
            System.out.println(" escolhido");
            sc.nextLine();
            System.out.println();
            Ninja[] ninjas = UIBattle.battleConfigureScreen(sc);
            Ninja ninjaOne = ninjas[0];
            Ninja ninjaTwo = ninjas[1];
            while (ninjaOne.getAttributes().getLife() > 0 && ninjaTwo.getAttributes().getLife() > 0
                    && ninjaOne.getAttributes().getStamina() > 0 && ninjaTwo.getAttributes().getStamina() > 0) {
                UIBattle.battleScreen(ninjaOne, ninjaTwo);
                UIBattle.actionScreen(ninjaOne, ninjaTwo, sc);
            }
        } else if (functionChosen == Contract.FUNCTION_NUMBER) {
            System.out.print(ANSI_YELLOW + "Recompensa de Contratos" + ANSI_RESET);
            System.out.println(" escolhido");
            sc.nextLine();
            System.out.println();
            Contract contract = UIContract.contractConfigureScreen(sc);
            contract.defineReward();
        } else if (functionChosen == GroupWorkout.FUNCTION_NUMBER) {
            System.out.print(ANSI_YELLOW + "Pontuação por Treino em Grupo" + ANSI_RESET);
            System.out.println(" escolhido");
            sc.nextLine();
            System.out.println();
            GroupWorkout groupWorkout = UIGrupalWorkout.grupalWorkoutConfigureScreen(sc);
            groupWorkout.defineReward();
        } else if (functionChosen == TechniqueWorkout.FUNCTION_NUMBER) {
            System.out.print(ANSI_YELLOW + "Aprendizado de Técnicas" + ANSI_RESET);
            System.out.println(" escolhido");
            sc.nextLine();
            System.out.println();
            TechniqueWorkout techniqueWorkout = UITechniqueWorkout.techniqueWorkoutConfigureScreen(sc);
            techniqueWorkout.defineApprentice();
        } else if (functionChosen == Task.FUNCTION_NUMBER) {
            System.out.print(ANSI_YELLOW + "Recompensa de Tarefas" + ANSI_RESET);
            System.out.println(" escolhido");
            sc.nextLine();
            System.out.println();
            Task task = UITask.taskConfigureScreen(sc);
            while (task.showReward()) {
                task = UITask.taskConfigureScreen(sc);
            }
        } else {
            System.out.print("Programa finalizado.");
        }
    }
}

