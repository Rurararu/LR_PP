package Droids;

public class Lilith extends Droids{
    public Lilith(){
        this.name = "Lilith";
        this.clas = "Class Support";
        this.health = 100;
        this.damage = 10;
        this.critical_damage = 0.5;
        this.change_critical_damage = 0.15;
    }
    public Lilith(String name, String clas, int health, int damage, double critical_damage, double change_critical_damage) {
        super(name, clas, health, damage, critical_damage, change_critical_damage);
    }
    public void UltraChance (Droids droid){
        critical_damage *= 2;
        if (change_critical_damage != 1.0) {
            change_critical_damage *= 4;
        }
    }
}
