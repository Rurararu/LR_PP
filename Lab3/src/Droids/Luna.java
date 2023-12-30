package Droids;

public class Luna extends Droids{
    public Luna(){
        this.name = "Luna";
        this.clas = "Class Support";
        this.health = 50;
        this.damage = 10;
        this.critical_damage = 4.0;
        this.change_critical_damage = 0.05;
    }
    public Luna(String name, String clas, int health, int damage, double critical_damage, double change_critical_damage) {
        super(name, clas, health, damage, critical_damage, change_critical_damage);
    }
}
