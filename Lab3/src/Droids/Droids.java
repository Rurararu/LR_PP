package Droids;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import Menu.Menu;


public abstract class Droids {
    protected String name;
    protected String clas;
    protected int health;
    protected int damage;
    protected double critical_damage;
    protected double change_critical_damage;

    public Droids(String name, String
            clas, int health, int damage, double critical_damage, double change_critical_damage) {
        this.name = name;
        this.clas = clas;
        this.health = health;
        this.damage = damage;
        this.critical_damage = critical_damage;
        this.change_critical_damage = change_critical_damage;
    }
    public Droids(){}

    @Override
    public String toString() {
        String resetColor = "\u001B[0m";  // Скидаємо колір

        return
                "Name: '" + SetColor() + name + resetColor + "'\n" +
                " Class:'" + clas + "'\n" +
                " Health: " + health +"\n"+
                " Damage: " + damage +"\n"+
                " Critical damage: " + critical_damage +"\n"+
                " Change critical damage: " + change_critical_damage +"\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {

        this.health += health;

        if(this.health<0){
            this.health = 0;
        }

    }

    public int getDamage() {
        return damage;
    }


    public double getCritical_damage() {
        return critical_damage;
    }

    public void setCritical_damage(double critical_damage) {
        this.critical_damage = critical_damage;
    }

    public double getChange_critical_damage() {
        return change_critical_damage;
    }

    public void setChange_critical_damage(double change_critical_damage) {
        this.change_critical_damage = change_critical_damage;
    }

    public boolean isAlive (){
        //перевірка чи дроїд ще живий
        return this.health > 0;
    }

    public boolean isCritical(){    //крит шанс
        Random random = new Random();
        int critDamage =  random.nextInt(100);
        return critDamage < change_critical_damage*100;
    }
    public boolean setDmage(boolean beWrite,Droids droid, FileWriter mywriter) throws IOException {  //завдання удару
        //int health = 0;
        Menu menu=new Menu();
        String resetColor = "\u001B[0m";  // Скидаємо колір
        if (droid.isCritical()){
            int hit = (int) (this.damage+this.damage*this.getCritical_damage());
            droid.setHealth(-hit);
            menu.WriteInFile(beWrite, mywriter,"Дроїд "+this.SetColor()+this.name+resetColor+" завдав "+hit+" удару дроїду "+droid.SetColor()+droid.name+resetColor+"\n");
            menu.WriteInFile(beWrite, mywriter,"У Дроїда "+droid.SetColor()+droid.name+resetColor+" зосталося "+droid.getHealth()+" здоров'я \n");
        }else {
            droid.setHealth(-this.damage);
            menu.WriteInFile(beWrite, mywriter,"Дроїд "+this.SetColor() + this.name +resetColor+ " завдав " + this.damage + " удару дроїду " +droid.SetColor()+ droid.name+resetColor+"\n");
            menu.WriteInFile(beWrite, mywriter,"У Дроїда "+droid.SetColor() + droid.name +resetColor+ " зосталося " + droid.getHealth() + " здоров'я \n");
        }
        if (!droid.isAlive()){
//            droid.health=0;
            menu.WriteInFile(beWrite, mywriter,"Дроїд "+droid.SetColor()+droid.name+resetColor+" помер :(\n");
            return false;
        }
        return true;
    }
    //public void UltraChance (){}
    public void UltraChance (Droids droids){}

    public String SetColor(){

        String BlueColor = "\u001B[36m";  // Голубий колір
        String PurpleColor = "\u001B[35m";  // Фіолетовий колір
        String GreenColor = "\u001B[92m";  // Червоний колір
        String resetColor = "\u001B[0m";  // Скидаємо колір

        switch (getClas()) {
            case "Class Support":
                return BlueColor;
            case "Class Healer":
                return GreenColor;
            case "Class Super":
                return PurpleColor;
        }

        return resetColor;
    }
}
