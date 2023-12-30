package Droids;

public class Ambrosia extends Droids{

    public Ambrosia(){
        this.name = "Ambrosia";
        this.clas = "Class Super";
        this.health = 100;
        this.damage = 20;
        this.critical_damage = 0.5;
        this.change_critical_damage = 0.5;
    }

    public Ambrosia(String name, String clas, int health, int damage, double critical_damage, double change_critical_damage) {
        super(name, clas, health, damage, critical_damage, change_critical_damage);
    }
}
