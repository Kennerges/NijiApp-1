package entities;

public class Attributes {

    private Double ninjutsu = 0.0;
    private Double taijutsu = 0.0;
    private Double genjutsu = 0.0;
    private Double intelligence = 0.0;
    private Double strength = 0.0;
    private Double agility = 0.0;
    private Double movement = 0.0;
    private Double resistance = 0.0;
    private Double selling = 0.0;
    private Double life = 0.0;
    private Double stamina = 0.0;
    private Double chakra = 0.0;
    private Double controlChakra = 0.0;
    private Double emissionChakra = 0.0;

    public Attributes() {
    }

    public Attributes(Double taijutsu, Double strength, Double agility, Double movement, Double resistance,
                      Double life, Double stamina, Double chakra) {
        this.taijutsu = taijutsu;
        this.strength = strength;
        this.agility = agility;
        this.movement = movement;
        this.resistance = resistance;
        this.life = life;
        this.stamina = stamina;
        this.chakra = chakra;
    }

    public Double getNinjutsu() {
        return ninjutsu;
    }

    public void setNinjutsu(Double ninjutsu) {
        this.ninjutsu = ninjutsu;
    }

    public Double getTaijutsu() {
        return taijutsu;
    }

    public void setTaijutsu(Double taijutsu) {
        this.taijutsu = taijutsu;
    }

    public Double getGenjutsu() {
        return genjutsu;
    }

    public void setGenjutsu(Double genjutsu) {
        this.genjutsu = genjutsu;
    }

    public Double getStrength() {
        return strength;
    }

    public Double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Double intelligence) {
        this.intelligence = intelligence;
    }

    public Double getAgility() {
        return agility;
    }

    public Double getMovement() {
        return movement;
    }

    public Double getResistance() {
        return resistance;
    }

    public void setResistance(Double resistance) {
        this.resistance = resistance;
    }

    public Double getSelling() {
        return selling;
    }

    public void setSelling(Double selling) {
        this.selling = selling;
    }

    public Double getLife() {
        return life;
    }

    public void setLife(Double life) {
        this.life = life;
    }

    public Double getStamina() {
        return stamina;
    }

    public void setStamina(Double stamina) {
        this.stamina = stamina;
    }

    public Double getChakra() {
        return chakra;
    }

    public Double getControlChakra() {
        return controlChakra;
    }

    public void setControlChakra(Double controlChakra) {
        this.controlChakra = controlChakra;
    }

    public Double getEmissionChakra() {
        return emissionChakra;
    }

    public void setEmissionChakra(Double emissionChakra) {
        this.emissionChakra = emissionChakra;
    }
}