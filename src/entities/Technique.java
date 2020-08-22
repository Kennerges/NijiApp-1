package entities;

import java.util.HashMap;
import java.util.Map;

public class Technique {

    private String name;
    private Map<String, Integer> values = new HashMap<>();

    public Technique(String name) {
        this.name = name;
    }

    public Map<String, Integer> getValues() {
        return values;
    }

    public void addValue(Integer answer, Integer value) {
        String attributeName = "";
        switch (answer) {
            case 1:
                attributeName = "ninjutsu";
                break;
            case 2:
                attributeName = "taijutsu";
                break;
            case 3:
                attributeName = "genjutsu";
                break;
            case 4:
                attributeName = "intelligence";
                break;
            case 5:
                attributeName = "selling";
                break;
            case 6:
                attributeName = "controlChakra";
                break;
            case 7:
                attributeName = "emissionChakra";
                break;
        }
        values.put(attributeName, value);
    }
}
