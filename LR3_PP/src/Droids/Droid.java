package Droids;

import java.util.Random;
public class Droid {
    public String name;
    protected double health;
    protected double damage;

    protected boolean reserved = false;



    public Droid(String name, double health, double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    public Droid() {
    }
    public void Attack(Droid enemy){
        int max = 30;
        int min = 10;
    Random rand = new Random();
    damage = rand.nextDouble(max-min)+min;
    enemy.getHit(damage);
    }
    public boolean IsAlive(){

        return health > 0;
    }
    public void getHit(double damage){
        health -= damage;
        if (health < 0){
            health = 0;
        }
    }
    public void reserve(Droid droid){
        reserved = true;
    }
    public boolean isReserved(){
        return reserved;
    }
    public double getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }


}
