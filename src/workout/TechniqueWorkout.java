package workout;

import entities.Ninja;
import entities.Technique;

import java.util.Set;

public class TechniqueWorkout {

    public static final Integer FUNCTION_NUMBER = 5;

    private final Ninja ninja;
    private final Technique technique;

    public TechniqueWorkout(Ninja ninja, Technique technique) {
        this.ninja = ninja;
        this.technique = technique;
    }
    public void defineApprentice() {
        Set<String> nameAttributes = technique.getValues().keySet();
        double hours = 0;
        double accumulatedPoints = 0;
        for (String key : nameAttributes) {
            if (key.equals("ninjutsu")) {
                double valueTechnique = technique.getValues().get(key);
                double valueCharacter = ninja.attributes.getNinjutsu();
                hours = hours + valueTechnique / valueCharacter * valueTechnique / 50;
                accumulatedPoints = accumulatedPoints + valueTechnique;
            } if (key.equals("taijutsu")) {
                double valueTechnique = technique.getValues().get(key);
                double valueCharacter = ninja.attributes.getTaijutsu();
                hours = hours + valueTechnique / valueCharacter * valueTechnique / 50;
            } if (key.equals("genjutsu")) {
                double valueTechnique = technique.getValues().get(key);
                double valueCharacter = ninja.attributes.getGenjutsu();
                hours = hours + valueTechnique / valueCharacter * valueTechnique / 50;
                accumulatedPoints = accumulatedPoints + valueTechnique;
            } if (key.equals("selling")) {
                double valueTechnique = technique.getValues().get(key);
                double valueCharacter = ninja.attributes.getSelling();
                hours = hours + valueTechnique / valueCharacter * valueTechnique / 50;
                accumulatedPoints = accumulatedPoints + valueTechnique;
            } if (key.equals("controlChakra")) {
                double valueTechnique = technique.getValues().get(key);
                double valueCharacter = ninja.attributes.getControlChakra();
                hours = hours + valueTechnique / valueCharacter * valueTechnique / 50;
                accumulatedPoints = accumulatedPoints + valueTechnique;
            } if (key.equals("emissionChakra")) {
                double valueTechnique = technique.getValues().get(key);
                double valueCharacter = ninja.attributes.getEmissionChakra();
                hours = hours + valueTechnique / valueCharacter * valueTechnique / 50;
                accumulatedPoints = accumulatedPoints + valueTechnique;
            } } double scenes = accumulatedPoints / ninja.getAttributes().getIntelligence() * accumulatedPoints / 50;
        System.out.println("Quantity hours: " + String.format("%.2f", hours));
        System.out.println("Quantity scenes: " + String.format("%.0f", Math.ceil(scenes)));
    }
}
