package Droids;

import java.util.Random;

public class FuriousDroid extends Droid {
    protected double damageMultiplCoeff;
    public FuriousDroid(String name, double health, double damage, double damageMultiplCoeff) {
        super(name, health, damage);
        this.damageMultiplCoeff = damageMultiplCoeff;
        this.damage *= damageMultiplCoeff;
    }

    public FuriousDroid() {

    }
    public void getHit(double damage){
        health -= damage;
        if (health < 0){
            health = 0;
        }
    }
    public void Attack(Droid enemy) {
        double max = 30;
        double min = 10;

        Random rand = new Random();
        damage = rand.nextDouble(max-min)+min;
        damage *= damageMultiplCoeff;
        enemy.getHit(damage);

    }

    public double getDamageMultiplCoeff() {
        return damageMultiplCoeff;
    }

    public void setDamageMultiplCoeff(double damageMultiplCoeff) {
        this.damageMultiplCoeff = damageMultiplCoeff;
    }
}
