package entities;

public class Attributes {

    private Double taijutsu;
    private Double strength;
    private Double agility;
    private Double movement;
    private Double resistance;
    private Double life;
    private Double stamina;
    private Double chakra;

    public Attributes(Double taijutsu, Double strength, Double agility, Double movement, Double resistance, Double life, Double stamina, Double chakra) {
        this.taijutsu = taijutsu;
        this.strength = strength;
        this.agility = agility;
        this.movement = movement;
        this.resistance = resistance;
        this.life = life;
        this.stamina = stamina;
        this.chakra = chakra;
    }

    public Double getTaijutsu() {
        return taijutsu;
    }

    public void setTaijutsu(Double taijutsu) {
        this.taijutsu = taijutsu;
    }

    public Double getStrength() {
        return strength;
    }

    public void setStrength(Double strength) {
        this.strength = strength;
    }

    public Double getAgility() {
        return agility;
    }

    public void setAgility(Double agility) {
        this.agility = agility;
    }

    public Double getMovement() {
        return movement;
    }

    public void setMovement(Double movement) {
        this.movement = movement;
    }

    public Double getResistance() {
        return resistance;
    }

    public void setResistance(Double resistance) {
        this.resistance = resistance;
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

    public void setChakra(Double chakra) {
        this.chakra = chakra;
    }
}