package entities;

public class Ninja {

    private String name;

    private Attributes attributes;

    public Ninja(String name, Attributes attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String applyingImpactAttack(Ninja ninja, Integer response, boolean defense) {

        if (attributes.getStrength() > ninja.getAttributes().getResistance()) {
            double myForce = attributes.getStrength();
            double enemyResistance = ninja.attributes.getResistance();
            double surplus = myForce - enemyResistance;
            double rest;
            String toReturn = "";
            if (response == 1 && defense) {
                double damageToLife = ninja.takingImpactDamageOnLife(surplus / 2);
                rest = myForce - surplus;
                double damageToStamina = ninja.takingImpactDamageOnStamina(rest / 2);
                toReturn = "Dano causado a Stamina: "
                        + damageToStamina
                        + "\nDano causado a Vida: "
                        + damageToLife;
            } else if (response == 2) {
                double damageToLife = ninja.takingImpactDamageOnLife(surplus);
                rest = myForce - surplus;
                double damageToStamina = ninja.takingImpactDamageOnStamina(rest);
                toReturn = "Dano causado a Stamina: "
                        + damageToStamina
                        + "\nDano causado a Vida: "
                        + damageToLife;
            } else if (response == 1) {
                double damageToLife = ninja.takingImpactDamageOnLife(surplus);
                rest = myForce - surplus;
                double damageToStamina = ninja.takingImpactDamageOnStamina(rest);
                toReturn = "Dano causado a Stamina: "
                        + damageToStamina
                        + "\nDano causado a Vida: "
                        + damageToLife;
            }
            return toReturn;
        } else {
            double strongAttr = ninja.getAttributes().getResistance();
            double smallAttr = attributes.getStrength();
            double diff  = 100 * smallAttr / strongAttr;
            double result = diff / 100;
            double newDamage = attributes.getStrength() * result;
            double toReturn = 0;
            if (response == 1 && defense) {
                toReturn = ninja.takingImpactDamageOnStamina(newDamage / 2);
            } else if (response == 1) {
                toReturn = ninja.takingImpactDamageOnStamina(newDamage);
            } else if (response == 2) {
                toReturn = ninja.takingImpactDamageOnStamina(newDamage);
            }
            return "Dano causado a Stamina: " + toReturn;
        }
    }

    public Double takingImpactDamageOnLife(double damage) {
        double previousLife = getAttributes().getLife();
        double nextLife = previousLife - damage / 2;
        getAttributes().setLife(nextLife);
        return damage / 2 ;
    }

    public Double takingImpactDamageOnStamina(double damage) {
        double previousStamina = getAttributes().getStamina();
        double nextStamina = previousStamina - damage / 2;
        getAttributes().setStamina(nextStamina);
        updateResistance();
        return damage / 2;
    }

    public void updateResistance() {
        double resistanceUpdated = getAttributes().getStamina() / 10;
        getAttributes().setResistance(resistanceUpdated);
    }

}
