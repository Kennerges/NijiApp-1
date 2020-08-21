package application;

import battle.BattleService;
import entities.Attributes;
import battle.Battle;
import entities.Ninja;
import entities.Patent;
import mission.ContractMission;
import mission.ContractMissionService;

import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static Integer actuallyService = 0;

    public static void startScreen() {
        System.out.println("- - - - - - - - - -");
        System.out.println("Nijigakure APP # 1");
        System.out.println("- - - - - - - - - -\n");
        showFunctionsScreen();
    }

    private static void showFunctionsScreen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Funções:\n");
        System.out.print("> 1. Sistema de Batalhas 1v1\n");
        System.out.print("> 2. Recompensa em Contratos\n");
        System.out.print("> 3. Pontuação por Treino Individual\n");
        System.out.print("> 4. Pontuação por Treino em Grupo\n");
        System.out.print("> 5. Aprendizado de Técnicas\n");
        System.out.print("> 0. Encerrar o programa.\n");
        System.out.println("Escolha a funcionalidade a ser usada.");
        System.out.print("Resposta: ");
        functionChosenScreen(sc.nextInt());
        sc.nextLine();
    }

    public static void functionChosenScreen(int functionChosen) {
        System.out.println();
        if (functionChosen == BattleService.FUNCTION_NUMBER) {
            System.out.print(ANSI_YELLOW + "Sistema de Batalhas 1v1" + ANSI_RESET);
            System.out.println(" escolhido");
            System.out.print("Aperte Enter para continuar ...");
            actuallyService = 1;
        } else if (functionChosen == ContractMissionService.FUNCTION_NUMBER) {
            System.out.print(ANSI_YELLOW + "Recompensa de Contratos" + ANSI_RESET);
            System.out.println(" escolhido");
            System.out.print("Aperte Enter para continuar ...");
            actuallyService = 2;
        }  else if (functionChosen == 0){
            actuallyService = 0;
        }
    }
    public static String[] configureContractMissionScreen(Scanner sc) {
        String[] chars = new String[4];
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Configure o seu Contrato");
        System.out.println("- - - - - - - - - - - - -");
        System.out.println();
        System.out.print("> 1ª: Diga a quantidade de jogadores presentes na Missão: ");
        chars[0] = sc.nextLine();
        System.out.print("> 2ª: Quantos personagens estavam presentes na Missão? ");
        chars[1] = sc.nextLine();
        System.out.print("> 3ª: Qual o Ranking da Missão? ");
        chars[2] = sc.nextLine();
        System.out.print("> 4ª: Qual o Pagamento em ¥ da Missão: ");
        chars[3] = sc.nextLine();
        return chars;
    }

    public static void ninjaInformationScreen(ContractMission contractMission) {
        Scanner sc = new Scanner(System.in);
        Ninja[] ninjas = contractMission.ninjas;
        for (int i = 0; i < ninjas.length; i++) {
            System.out.print("-> Cite o nome do ninja #" + (i + 1) + ": ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("--> Qual a patente dele? " +
                    "\n1. Genin" +
                    "\n2. Chunin" +
                    "\n3. Jounin" +
                    "\n4. Tokubetsu Jounin" +
                    "\n5. Kage" +
                    "\n6. Saikounin" +
                    "\nResposta: ");
            int chosenPatent = sc.nextInt();
            Patent patent = new Patent(chosenPatent);
            System.out.print("->: Quantas linhas ele escreveu? ");
            int lines = sc.nextInt();
            System.out.println();
            contractMission.ninjas[i] = new Ninja(name, lines, patent);
        }
        showRewards(contractMission);
    }

    private static void showRewards(ContractMission contractMission) {
        int totalLines = 0;
        double totalPoints;
        double totalInfluence = 0;
        double avgInfluence;

        Ninja[] ninjas = contractMission.ninjas;

        for (Ninja ninja : ninjas) {
            totalLines = totalLines + ninja.getLinesWritten();
            totalInfluence = totalInfluence + ninja.getPatent().influence;
        }

        avgInfluence = totalInfluence / contractMission.players;
        totalPoints = (avgInfluence * totalLines + (avgInfluence *
                totalLines * (ninjas.length * 0.08))) / 4;

        for (Ninja ninja : ninjas) {
            System.out.println("Name: "
                    + ninja.getName()
                    + "\n"
                    + "Earned points: "
                    + String.format("%.2f",ninja.pointsGained(totalLines, totalPoints))
                    + " points\n"
                    + "Earned experience: "
                    + String.format("%.2f", ninja.xpGained(contractMission))
                    + " xp\n"
                    + "Payment: ¥ "
                    + contractMission.payment
                    + "\n");
        }
    }

    public static Ninja[] configureBattleScreen(Scanner sc) {
        int n = 0;
        Ninja[] ninjas = new Ninja[2];
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Configure a sua Batalha");
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
        System.out.println();
        if (characterChosen == 1) {
            System.out.println(ninjaOne.getName() + " escolhido.");
        } else {
            System.out.println(ninjaTwo.getName() + " escolhido.");
        }
        System.out.println();
        System.out.println("Qual será a sua ação? ");
        System.out.println("1. Ataque de mãos vazias");
        System.out.println();
        System.out.print("Resposta: ");
        int actionChosed = sc.nextInt();
        System.out.println();
        System.out.println("1. Único ataque");
        System.out.println("2. Múltiplos ataques");
        System.out.println();
        System.out.print("Resposta: ");
        int typeChosed = sc.nextInt();
        System.out.println();
        System.out.println("O que o outro ninja decidiu fazer? ");
        if (actionChosed == 1) {
            System.out.println("1. Defender");
            System.out.println("2. Desviar");
        }
        System.out.println();
        System.out.print("Resposta: ");
        int responseChosed = sc.nextInt();
        System.out.println();

        if (characterChosen == 1 && actionChosed == 1 && typeChosed == 1) {
            boolean success = Battle.singleAttackHandsCleanTest(ninjaOne, ninjaOne, responseChosed);
            if (success) {
                System.out.println("O ataque deu certo.");
                String damage = ninjaOne.applyingImpactAttack(ninjaTwo, responseChosed, false);
                System.out.println(damage);
            } else {
                System.out.println("O ataque foi defendido");
                String damage = ninjaOne.applyingImpactAttack(ninjaTwo, responseChosed, true);
                System.out.println(damage);
            }
        } else if (characterChosen == 1 && actionChosed == 1 && typeChosed == 2) {
            System.out.print("Quantas vezes: ");
            int n = sc.nextInt();
            boolean[] attempts = Battle.multipleAttackHandsCleanTest(ninjaOne, ninjaTwo, responseChosed, n);
            int m = 1;
            for (boolean attempt : attempts) {
                if (attempt) {
                    System.out.println("O ataque #" + m + " deu certo.");
                    String damage = ninjaOne.applyingImpactAttack(ninjaTwo, responseChosed, false);
                    System.out.println(damage);
                } else {
                    System.out.println("O ataque #" + m + " deu errado.");
                }
                m ++;
            }
        } else if (characterChosen == 2 && actionChosed == 1 && typeChosed == 1) {
            boolean success = Battle.singleAttackHandsCleanTest(ninjaOne, ninjaOne, responseChosed);
            if (success) {
                System.out.println("O ataque deu certo.");
                String damage = ninjaTwo.applyingImpactAttack(ninjaOne, responseChosed, false);
                System.out.println(damage);
            } else {
                System.out.println("O ataque foi defendido");
                String damage = ninjaTwo.applyingImpactAttack(ninjaOne, responseChosed, true);
                System.out.println(damage);
            }
        } else if (characterChosen == 2 && actionChosed == 1 && typeChosed == 2) {
            System.out.println("Quantas vezes: ");
            int n = sc.nextInt();
            boolean[] attempts = Battle.multipleAttackHandsCleanTest(ninjaOne, ninjaTwo, responseChosed, n);
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
