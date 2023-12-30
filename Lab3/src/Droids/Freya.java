package Droids;

public class Freya extends Droids{

    public Freya(){
        this.name = "Freya";
        this.clas = "Class Healer";
        this.health = 100;
        this.damage = 12;
        this.critical_damage = 0.15;
        this.change_critical_damage = 0.05;
    }

    public Freya(String name, String clas, int health, int damage, double critical_damage, double change_critical_damage) {
        super(name, clas, health, damage, critical_damage, change_critical_damage);
    }

    //public void
    @Override
    public void UltraChance (Droids droid){
        System.out.println("Кількість життя було: "+health);
        if (health<100){
            health *= 1.5;
            if (health>100) {
                health = 100;
            }
        }
        System.out.println("Кількість життя стало: "+health);
    }


}
