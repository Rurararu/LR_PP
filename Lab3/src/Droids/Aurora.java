package Droids;

public class Aurora extends Droids{

    public Aurora(){
        this.name = "Aurora";
        this.clas = "Class Healer";
        this.health = 100;
        this.damage = 10;
        this.critical_damage = 0.15;
        this.change_critical_damage = 0.05;
    }
    public Aurora(String name, String clas, int health, int damage, double critical_damage, double change_critical_damage) {
        super(name, clas, health, damage, critical_damage, change_critical_damage);
    }
    public void UltraChance (Droids droid){
        health += (int) (1.5 * droid.getDamage());
    }
}
