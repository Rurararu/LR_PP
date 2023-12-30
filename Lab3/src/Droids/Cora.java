package Droids;

public class Cora extends Droids{

    public Cora(){
        this.name = "Cora";
        this.clas = "Class Healer";
        this.health = 90;
        this.damage = 5;
        this.critical_damage = 2.0;
        this.change_critical_damage = 0.25;
    }
    public Cora(String name, String clas, int health, int damage, double critical_damage, double change_critical_damage) {
        super(name, clas, health, damage, critical_damage, change_critical_damage);
    }

    public void UltraChance (Droids droid){
        //System.out.println("Кількість життя було: "+health);
        if (health<20){
            health += 30;

        }
    }

}
