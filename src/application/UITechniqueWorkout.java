package application;

import entities.Attributes;
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
        System.out.print("> 1ª: Diga o nome da técnica: ");
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
            int answer = sc.nextInt();
            System.out.println("-> Qual é o valor dele: ");
            int attributeValue = sc.nextInt();
            technique.addValue(answer, attributeValue);
        } Ninja ninja = ninjaInformationScreen(sc, technique.getValues());
        System.out.println();
        clearScreen();
        return new TechniqueWorkout(ninja, technique);
    }

    private static Ninja ninjaInformationScreen(Scanner sc, Map<String, Integer> map) {
        Ninja ninja = new Ninja();
        System.out.print("-> Cite o nome do ninja: ");
        sc.nextLine();
        String name = sc.nextLine();
        ninja.setName(name);
        Set<String> set = map.keySet();
        for (String attribute : set) {
            System.out.print("->: Qual o valor do atributo dele em ");
            switch (attribute) {
                case "ninjutsu":
                    System.out.print("Ninjutsu: ");
                    ninja.getAttributes().setNinjutsu(sc.nextDouble());
                    break;
                case "taijutsu":
                    System.out.print("Taijutsu: ");
                    ninja.getAttributes().setTaijutsu(sc.nextDouble());
                    break;
                case "genjutsu":
                    System.out.print("Genjutsu: ");
                    ninja.getAttributes().setGenjutsu(sc.nextDouble());
                    break;
                case "intelligence":
                    System.out.print("Inteligência: ");
                    ninja.getAttributes().setIntelligence(sc.nextDouble());
                    break;
                case "selling":
                    System.out.print("Selos: ");
                    ninja.getAttributes().setSelling(sc.nextDouble());
                    break;
                case "controlChakra":
                    System.out.print("Controle de Chakra: ");
                    ninja.getAttributes().setControlChakra(sc.nextDouble());
                    break;
                default:
                    System.out.print("Emissão de Chakra: ");
                    ninja.getAttributes().setEmissionChakra(sc.nextDouble());
                    break;
            }
        }
        System.out.print("->: Qual o valor do atributo dele em Inteligência: ");
        ninja.getAttributes().setIntelligence(sc.nextDouble());
        return ninja;
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
