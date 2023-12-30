package Menu;
import Droids.Droids;

import Droids.Freya;
import Droids.Aurora;
import Droids.Cora;
import Droids.Teresa;
import Droids.Luna;
import Droids.Lilith;
import Droids.Jude;
import Droids.Monya;
import Droids.Ambrosia;
import Fight.Battle;
import Fight.TeamBattle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Menu {
    protected Scanner scanner;

    public Menu(){
        scanner = new Scanner(System.in);
    }

    public void WriteInFile(boolean beWrite,FileWriter mywriter, String name) throws IOException {
        System.out.print(name);
        if(beWrite) {
            mywriter.write(name);
        }
    }

    public void start() throws FileNotFoundException {
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Бій 1 на 1");
            System.out.println("2. Командний бій (3 на 3)");
            System.out.println("3. Показати характеристики всіх дроїдів");
            System.out.println("4. Відтворити бій");
            System.out.println("5. Вихід");
            System.out.print("Оберіть опцію: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    performoneVSone();
                    break;
                case 2:
                    performteamVSteam();
                    break;
                case 3:
                    AllDroidsInfo();
                    break;
                case 4:
                    RiderFromFile();   //ТА
                    break;
                case 5:
                    System.out.println("Гра завершена.");   //ТА
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    break;
            }
        } while (choice != 5);
    }

    protected void  AllDroidsInfo(){
        ArrayList<Droids> availableDroids = new ArrayList<>();
        availableDroids.add(new Freya());   //клас лікарів
        availableDroids.add(new Aurora());
        availableDroids.add(new Cora());

        availableDroids.add(new Teresa());  //клас помічників
        availableDroids.add(new Luna());
        availableDroids.add(new Lilith());

        availableDroids.add(new Jude());     //клас супер-дроїдів
        availableDroids.add(new Monya());
        availableDroids.add(new Ambrosia());

        System.out.println("\n Характеристики всіх дроїдів: \n");
        for (int i = 0; i < 9; i++) {
            Droids droid = availableDroids.get(i);
            System.out.println(droid.toString());
        }
    }
    protected void  RiderFromFile() throws FileNotFoundException {
        int numb;
        String filenameTeamVSTeam = "D:\\2Kurs\\ApplicationProgramming\\3Lab\\teamVSteamFight.txt";
        String filenameOneVSOne = "D:\\2Kurs\\ApplicationProgramming\\3Lab\\oneUSoneFight.txt";
        System.out.println("Який бій ви би хотіли вібтворити? " +
                "\n(1 - один на один, 2 - команда на команду)");
        numb = scanner.nextInt();

        if (numb==1) {
            FileReader ridefrom = new FileReader(filenameOneVSOne);
            Scanner output = new Scanner(ridefrom);
            while (output.hasNextLine()){
                System.out.println(output.nextLine());
            }
            output.close();
        }if (numb==2) {
            FileReader ridefrom = new FileReader(filenameTeamVSTeam);
            Scanner output = new Scanner(ridefrom);
            while (output.hasNextLine()){
                System.out.println(output.nextLine());
            }
            output.close();
        }
    }
    protected void performoneVSone(){
        System.out.println("Виберіть першого дроїда:");
        List<Droids> droids = selectDroids(1);
        if (droids.size() != 2) {
            System.out.println("Помилка у виборі дроїдів. Потрібно точно два дроїда.");
            return;
        }
        Battle battle1v1 = new Battle();
        try {
            battle1v1.battle(droids);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    protected void performteamVSteam(){
        String name1, name2;
        System.out.println("Введіть назву для команди 1:");
        name1 = scanner.nextLine();
        System.out.println("Введіть назву для команди 2:");
        name2 = scanner.nextLine();
        System.out.println("\nВиберіть дроїдів для команди 1:");
        ArrayList<Droids> team1 = selectDroids(2); // Виберіть 3 дроїди для команди 1
        if (team1.size() != 3) {
            System.out.println("Помилка у виборі дроїдів для команди 1. Потрібно точно 3 дроїди.");
            return;
        }

        System.out.println("\nВиберіть дроїдів для команди 2:");
        ArrayList<Droids> team2 = selectDroids(3); // Виберіть 3 дроїди для команди 2
        if (team2.size() != 3) {
            System.out.println("Помилка у виборі дроїдів для команди 2. Потрібно точно 3 дроїди.");
            return;
        }

        TeamBattle battle3v3 = new TeamBattle();
        try {
            battle3v3.battleteam(team1,team2,name1,name2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private ArrayList<Droids> selectDroids(int numb) {
        // Отримуємо список дроїдів з якими користувач може провести бій
        ArrayList<Droids> availableDroids = new ArrayList<>();
        availableDroids.add(new Freya());   //клас лікарів
        availableDroids.add(new Aurora());
        availableDroids.add(new Cora());

        availableDroids.add(new Teresa());  //клас помічників
        availableDroids.add(new Luna());
        availableDroids.add(new Lilith());

        availableDroids.add(new Jude());     //клас супер-дроїдів
        availableDroids.add(new Monya());
        availableDroids.add(new Ambrosia());

        System.out.println("Доступні Дроїди для вибору:");
        String resetColor = "\u001B[0m";  // Скидаємо колір
        for (int i = 0; i < availableDroids.size(); i++) {
            Droids droid = availableDroids.get(i);
            System.out.println((i + 1) + ". " +droid.SetColor()+ droid.getName()+resetColor);
        }
        if(numb==1) {
            System.out.print("Виберіть першого Дроїда (введіть номер): ");
            int droid0Index = scanner.nextInt() - 1;

            System.out.print("Виберіть другого Дроїда (введіть номер): ");
            int droid1Index = scanner.nextInt() - 1;

            if (droid0Index < 0 || droid0Index >= availableDroids.size() ||
                    droid1Index < 0 || droid1Index >= availableDroids.size()) {
                System.out.println("Помилка у виборі Дроїда.");
                return new ArrayList<>();
            }
            Droids droid0 = availableDroids.get(droid0Index);
            Droids droid1 = availableDroids.get(droid1Index);

            ArrayList<Droids> oneVSone = new ArrayList<>();
            oneVSone.add(droid0);
            oneVSone.add(droid1);

            return oneVSone;
        }else if (numb==2){
            System.out.print("Виберіть першого Дроїда для першої команди (введіть номер): ");
            int droid0Index = scanner.nextInt() - 1;
            System.out.print("Виберіть другого Дроїда для першої команди (введіть номер): ");
            int droid1Index = scanner.nextInt() - 1;
            System.out.print("Виберіть третього Дроїда для першої команди (введіть номер): ");
            int droid2Index = scanner.nextInt() - 1;

            if (droid0Index < 0 || droid0Index >= availableDroids.size() ||
                    droid1Index < 0 || droid1Index >= availableDroids.size() ||
            droid2Index < 0 || droid2Index >= availableDroids.size()){
                System.out.println("Помилка у виборі Дроїда.");
                return new ArrayList<>();
            }
            Droids droid0 = availableDroids.get(droid0Index);
            Droids droid1 = availableDroids.get(droid1Index);
            Droids droid2 = availableDroids.get(droid2Index);

            ArrayList<Droids> TeamOne = new ArrayList<>();
            TeamOne.add(droid0);
            TeamOne.add(droid1);
            TeamOne.add(droid2);

            return TeamOne;
        }else {
            System.out.print("Виберіть першого Дроїда для другої команди (введіть номер): ");
            int droid0Index = scanner.nextInt() - 1;
            System.out.print("Виберіть другого Дроїда для другої команди (введіть номер): ");
            int droid1Index = scanner.nextInt() - 1;
            System.out.print("Виберіть третього Дроїда для дрогої команди (введіть номер): ");
            int droid2Index = scanner.nextInt() - 1;

            if (droid0Index < 0 || droid0Index >= availableDroids.size() ||
                    droid1Index < 0 || droid1Index >= availableDroids.size() ||
                    droid2Index < 0 || droid2Index >= availableDroids.size()) {
                System.out.println("Помилка у виборі Дроїда.");
                return new ArrayList<>();
            }
            Droids droid0 = availableDroids.get(droid0Index);
            Droids droid1 = availableDroids.get(droid1Index);
            Droids droid2 = availableDroids.get(droid2Index);

            ArrayList<Droids> TeamTwo = new ArrayList<>();
            TeamTwo.add(droid0);
            TeamTwo.add(droid1);
            TeamTwo.add(droid2);

            return TeamTwo;
        }
        }
    }
