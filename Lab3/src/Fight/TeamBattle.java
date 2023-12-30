package Fight;

import Droids.Droids;
import Menu.Menu;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamBattle extends Battle {

    public void battleteam(ArrayList<Droids> team1, ArrayList<Droids> team2, String name1, String name2) throws IOException {

        String filenameTeamVSTeam = "D:\\2Kurs\\ApplicationProgramming\\3Lab\\teamVSteamFight.txt";
        FileWriter mywrite = new FileWriter(filenameTeamVSTeam);
        System.out.println("Хочете записати цей бій у файл? (1 так, 2 ні)");
        int beWrite = scanner.nextInt();

        write = ReturnBeWrited(beWrite);
        Menu menu=new Menu();

        menu.WriteInFile(write, mywrite,"\n\nРозпочато бій між командою \u001B[45m"+ name1+"\u001B[0m та комадою \u001B[46m"+name2+"\u001B[0m\n");
        menu.WriteInFile(write, mywrite,"-----------------------------------------------------------------------------\n");
        menu.WriteInFile(write, mywrite,"\nХарактеристики дроїдів першої команди:\n");
        for (int i = 0; i<team1.size();i++){
            menu.WriteInFile(write, mywrite,team1.get(i).toString());
        }
        menu.WriteInFile(write, mywrite,"\nХарактеристики дроїдів другої команди:\n");
        for (int i = 0; i<team2.size();i++){
            menu.WriteInFile(write, mywrite,team2.get(i).toString());
        }

        while (!team1.isEmpty() && !team2.isEmpty()) {
            countRound++;
            menu.WriteInFile(write, mywrite,"\n----\u001B[31mRound " + countRound + "\u001B[0m----\n");
            if(countRound<50) {
                // Команда 1 б'є

                for (int i = 0; i < team1.size(); i++) {

                    Droids droid1 = team1.get(i);
                    Droids target = team2.get(0);

                    menu.WriteInFile(write, mywrite,"\nЗ команди \u001B[45m"+name1 + "\u001B[0m Дроїд "+droid1.SetColor() + droid1.getName() +resetColor+ " б'є з команди \u001B[46m" + name2 + "\u001B[0m Дроїда " + target.SetColor()+target.getName()+resetColor+"\n");

                    if (target.isAlive()) {
                        ReturnDamage(write,mywrite,target, droid1);
                    }

                    if (!target.isAlive()) {
                           // System.out.println(name2 + " " + target.getName() + " вилітає з команди " + name2);
                            team2.remove(0);
                    }
                }

                // Команда 2 б'є
                for (int i = 0; i < team2.size(); i++) {

                    Droids droid2 = team2.get(i);
                    Droids target = team1.get(0);

                    menu.WriteInFile(write, mywrite,"\nЗ команди \u001B[46m"+name2 + "\u001B[0m Дроїд " +droid2.SetColor()+ droid2.getName() +resetColor+ " б'є з команди \u001B[45m" + name1 + "\u001B[0m Дроїда " + target.SetColor()+target.getName()+resetColor+"\n");

                        ReturnDamage(write,mywrite,target, droid2);

                    if (!target.isAlive()) {
                        //System.out.println(name1 + " " + target.getName() + " вилітає з команди " + name1);
                        team1.remove(0);
                    }
                }
            }else {break;}

        }

        if (team1.isEmpty()) {
            menu.WriteInFile(write, mywrite,"\n\u001B[46mКоманда " + name2 + " перемогла!\u001B[0m\n");
        } else {
            menu.WriteInFile(write, mywrite,"\n\u001B[45mКоманда " + name1 + " перемогла!\u001B[0m\n");
        }
        mywrite.close();
    }
}
