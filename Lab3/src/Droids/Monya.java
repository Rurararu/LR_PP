package Droids;

public class Monya extends Droids{

    public Monya(){
        this.name = "Monya";
        this.clas = "Class Super";
        this.health = 80;
        this.damage = 12;
        this.critical_damage = 1.52;
        this.change_critical_damage = 0.05;
    }

    public Monya(String name, String clas, int health, int damage, double critical_damage, double change_critical_damage) {
        super(name, clas, health, damage, critical_damage, change_critical_damage);
    }

    public void UltraChance (Droids droid){
        int hit=40;
        droid.health -=hit;
    }

}
