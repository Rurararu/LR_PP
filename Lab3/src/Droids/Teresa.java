package Droids;

public class Teresa extends Droids{
    public Teresa(){
        this.name = "Teresa";
        this.clas = "Class Support";
        this.health = 90;
        this.damage = 10;
        this.critical_damage = 0.5;
        this.change_critical_damage = 0.25;
    }
    public Teresa(String name, String clas, int health, int damage, double critical_damage, double change_critical_damage) {
        super(name, clas, health, damage, critical_damage, change_critical_damage);
    }
    @Override
    public void UltraChance (Droids droid){
        int hit;
        hit = this.damage;
        hit *=3;
        droid.health -=hit;
    }
}
