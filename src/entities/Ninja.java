package entities;

import java.util.Scanner;

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

    public static Ninja[] createNinjas(Scanner sc) {
        int n = 0;
        Ninja[] ninjas = new Ninja[2];

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
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        return ninjas;
    }

    public void applyingImpactAttack(Ninja ninja) {
        if (attributes.getStrength() >= ninja.getAttributes().getResistance()) {
            double myForce = attributes.getStrength();
            double enemyResistance = ninja.attributes.getResistance();
            double surplus = myForce - enemyResistance;
            ninja.takingImpactDamageOnLife(surplus);
            double rest = myForce - surplus;
            ninja.takingImpactDamageOnStamina(rest);
        } else {
            double strongAttr = ninja.getAttributes().getResistance();
            double smallAttr = attributes.getStrength();
            double result = 100 * smallAttr / strongAttr;
            double diff = (100 - result) / 100;
            double newDamage = attributes.getStrength() * diff;
            ninja.takingImpactDamageOnStamina(newDamage);
        }
    }

    public void takingImpactDamageOnLife(double damage) {
        double previousLife = getAttributes().getLife();
        double nextLife = previousLife - damage / 2 / 6;
        getAttributes().setLife(nextLife);
    }

    public void takingImpactDamageOnStamina(double damage) {
        double previousStamina = getAttributes().getStamina();
        double nextStamina = previousStamina - damage / 2;
        getAttributes().setStamina(nextStamina);
        updateResistance();
    }

    public void updateResistance() {
        double newStamina = Math.round(getAttributes().getStamina() / 10);
        getAttributes().setResistance(newStamina);
    }

}
