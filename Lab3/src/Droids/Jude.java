package Droids;

public class Jude extends Droids{
    public Jude(){
        this.name = "Jude";
        this.clas = "Class Super";
        this.health = 90;
        this.damage = 10;
        this.critical_damage = 5.0;
        this.change_critical_damage = 0.25;
    }
    public Jude(String name, String clas, int health, int damage, double critical_damage, double change_critical_damage) {
        super(name, clas, health, damage, critical_damage, change_critical_damage);
    }
}
