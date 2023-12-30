package Fight;

import Droids.Droids;
import Menu.Menu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Battle {
    protected int countRound;
    protected Scanner scanner;
    protected boolean write;
    protected String resetColor = "\u001B[0m";  // Скидаємо колір
    public Battle(){
        countRound = 0;
        scanner = new Scanner(System.in);
    }
   public boolean ReturnBeWrited(int numb){
       return numb == 1;
   }

    public boolean ReturnDamage(boolean beWrite,FileWriter mywriter,Droids target, Droids droid){    //отриання удару
        try {
            if(droid.setDmage(beWrite,target, mywriter))return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public void battle(List<Droids> droid) throws IOException {

        Droids droid0 = droid.get(0);
        Droids droid1 = droid.get(1);
        String filenameOneVSOne = "D:\\2Kurs\\ApplicationProgramming\\3Lab\\oneUSoneFight.txt";
        FileWriter mywrite = new FileWriter(filenameOneVSOne);
        System.out.println("Хочете записати цей бій у файл? (1 - так, 2 - ні)");
        int beWrite = scanner.nextInt();

        write = ReturnBeWrited(beWrite);
        Menu menu=new Menu();
        menu.WriteInFile(write, mywrite,"\nРозпочато бій між дроїдом "+droid0.SetColor()+ droid0.getName()+resetColor+" та дроїдом "+droid1.SetColor()+droid1.getName()+resetColor+"\n");
        menu.WriteInFile(write, mywrite,"-----------------------------------------------------------------------------\n");
        menu.WriteInFile(write, mywrite,"Характеристики дроїдів:\n");
        menu.WriteInFile(write, mywrite,droid0.toString());
        menu.WriteInFile(write, mywrite,droid1.toString());

        while (droid0.isAlive() && droid1.isAlive()){       //бляха можу ну тих дроїдів і краще поспати?
            countRound++;
            if (countRound>20)break;
            menu.WriteInFile(write, mywrite,"\n----\u001B[31mRound "+countRound+"\u001B[0m----\n");
            if(countRound %3 == 0){
                droid0.UltraChance(droid1);// диви фокус
                menu.WriteInFile(write, mywrite,"\nДроїд "+droid0.SetColor()+ droid0.getName()+resetColor+ " використала супер силу\n\n");
                if(!ReturnDamage(write,mywrite,droid1, droid0)){
                    break;
                }
            } else {
                if (droid0.isAlive()) {
                    if(!ReturnDamage(write,mywrite,droid1, droid0)){
                        break;
                    }
                    menu.WriteInFile(write, mywrite,"\n");
                }
            }
            if(countRound %3 ==0){
                droid1.UltraChance(droid0);
                menu.WriteInFile(write, mywrite,"\nДроїд "+droid1.SetColor()+ droid1.getName()+resetColor+ " використав супер силу\n\n");
                if(!ReturnDamage(write,mywrite,droid0, droid1)){
                    break;
                }
            } else {
                if (droid1.isAlive()) {
                    if(!ReturnDamage(write,mywrite,droid0, droid1)){
                       break;
                    }
                    menu.WriteInFile(write, mywrite,"\n");
                }
            }
            if (!droid1.isAlive()) {
                menu.WriteInFile(write, mywrite," Дроїд "+droid1.SetColor()+droid1.getName()+resetColor + " переміг  Дроїда "+droid0.SetColor()+droid0.getName()+resetColor);
            }
            else if (!droid0.isAlive()){
                menu.WriteInFile(write, mywrite," Дроїд "+droid0.SetColor()+droid0.getName()+resetColor + " переміг  Дроїда "+droid1.SetColor()+droid1.getName()+resetColor);
            }
        }
        mywrite.close();
    }

}
