package application;

import entities.Ninja;
import entities.Technique;
import workout.TechniqueWorkout;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UITechniqueWorkout {

    public static TechniqueWorkout techniqueWorkoutConfigureScreen(Scanner sc) {
        System.out.println("- - - - - - - - - - - - - -");
        System.out.println("Configure o seu Aprendizado");
        System.out.println("- - - - - - - - - - - - - -");
        System.out.println();
        System.out.println("> 1ª: Diga o nome da técnica: ");
        System.out.print("— ");
        String name = sc.nextLine();
        Technique technique = new Technique(name);
        System.out.print("> 2ª: Quantos valores diferentes esta técnica possui? ");
        int n = sc.nextInt();
        System.out.println("1. Ninjutsu");
        System.out.println("2. Taijutsu");
        System.out.println("3. Genjutsu");
        System.out.println("4. Inteligência");
        System.out.println("5. Selos");
        System.out.println("6. Controle de Chakra");
        System.out.println("7. Emissão de Chakra");
        for (int i = 1; i <= n; i ++) {
            System.out.println("-> Qual é o número do " + i + "º atributo: ");
            System.out.print("— ");
            int answer = sc.nextInt();
            System.out.println("-> Qual é o valor dele: ");
            System.out.print("— ");
            int attributeValue = sc.nextInt();
            technique.addValue(answer, attributeValue);
        } Ninja ninja = ninjaInformationScreen(sc, technique.getValues());
        System.out.println();
        clearScreen();
        return new TechniqueWorkout(ninja, technique);
    }

    private static Ninja ninjaInformationScreen(Scanner sc, Map<String, Integer> map) {
        Ninja ninja = new Ninja();
        System.out.println("-> Cite o nome do ninja: ");
        System.out.print("— ");
        sc.nextLine();
        String name = sc.nextLine();
        ninja.setName(name);
        Set<String> set = map.keySet();
        for (String attribute : set) {
            System.out.print("->: Qual o valor do atributo dele em ");
            switch (attribute) {
                case "ninjutsu":
                    System.out.print("Ninjutsu: ");
                    System.out.print("— ");
                    ninja.getAttributes().setNinjutsu(sc.nextDouble());
                    break;
                case "taijutsu":
                    System.out.print("Taijutsu: ");
                    System.out.print("— ");
                    ninja.getAttributes().setTaijutsu(sc.nextDouble());
                    break;
                case "genjutsu":
                    System.out.print("Genjutsu: ");
                    System.out.print("— ");
                    ninja.getAttributes().setGenjutsu(sc.nextDouble());
                    break;
                case "intelligence":
                    System.out.print("Inteligência: ");
                    System.out.print("— ");
                    ninja.getAttributes().setIntelligence(sc.nextDouble());
                    break;
                case "selling":
                    System.out.print("Selos: ");
                    System.out.print("— ");
                    ninja.getAttributes().setSelling(sc.nextDouble());
                    break;
                case "controlChakra":
                    System.out.print("Controle de Chakra: ");
                    System.out.print("— ");
                    ninja.getAttributes().setControlChakra(sc.nextDouble());
                    break;
                default:
                    System.out.print("Emissão de Chakra: ");
                    System.out.print("— ");
                    ninja.getAttributes().setEmissionChakra(sc.nextDouble());
                    break;
            }
        }
        System.out.print("->: Qual o valor do atributo dele em Inteligência: ");
        System.out.print("— ");
        double intelligence = sc.nextDouble();
        ninja.getAttributes().setIntelligence(intelligence);
        return ninja;
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
