import java.util.Random;
import java.util.Random;
public class HeavyDroid extends Droid{
    Random rand = new Random();
    protected double shieldHealth = 200;
    public HeavyDroid() {

    }
    public HeavyDroid( String name,int health,int damage, int shieldHealth) {
        super(name,health,damage);
        this.shieldHealth = shieldHealth;
    }

    /**
     * If whereToHit is more than 7 enemy droid hits heavy droid in body, not in shield
     * @param damage
     */
    public void getHit(double damage){
        int whereToHit = rand.nextInt(10);
        if(whereToHit>7) {
            health -= damage;
        }
        else{
            if (shieldHealth <= 0) {
                health -= damage;
            } else if (shieldHealth > 0) {
                shieldHealth -= damage;
                System.out.println("No damage! Exactly into"+name+"'s the shield! Shield health: "+shieldHealth);
            }
        }

        if (health < 0){
            health = 0;
        }
    }
    public void Attack(Droid enemy){
        double max = 15;
        double min = 10;
        Random rand = new Random();
        damage = rand.nextDouble((max-min))+min;
        enemy.getHit(damage);
    }

}
