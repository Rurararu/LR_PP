import java.util.Scanner;

public class Main {
    public static Phone[] ArrOfObj(int num){
        Scanner scanner = new Scanner(System.in);
        Phone[] arr;
        arr = new Phone[num];

        for(int i=0; i<num; i++)
        {
            int id, numb, timecity,timeLD;
            String lname, fname, sname;
            System.out.println("Введіть прізвище користувача: ");
            scanner.nextLine();
            lname = scanner.nextLine();
            System.out.println("Введіть ім\'я користувача: ");
            fname = scanner.nextLine();
            System.out.println("Введіть побатькові користувача: ");
            sname = scanner.nextLine();
            System.out.println("Введіть номер рахунку користувача: ");
            numb = scanner.nextInt();
            System.out.println("Введіть використаний час міських розмов користувача: ");
            timecity = scanner.nextInt();
            System.out.println("Введіть використаний час міжміських розмов користувача: ");
            timeLD = scanner.nextInt();

            arr[i] = new Phone(i+1,lname, fname, sname, numb,timecity,timeLD );
        }
        return arr;
    }

    public static void arrPrint(Phone[]arr, int num){
        for(int i = 0; i <num; i++){
            System.out.println("Телефоний користувач:\n "+arr[i].toString()+"\n");
        }
    }
    public static void TimeToTalk(Phone[]arr, int num)
    {
        System.out.println("Введіть ліміт часу міських розмов: ");
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        for(int i = 0; i< num; i++){
            if(time < arr[i].getTimeCity()){
                System.out.println("Телефоний користувач в якого час міських розмов перевищує заданий:\n"+arr[i]);
            }
        }
    }
    public static void UserUsed(Phone[]arr, int num)
    {
        for(int i = 0; i< num; i++){
            if(0 < arr[i].getTimeLongDistance()){
                System.out.println("Телефоні користувачі, які користувались міжміським зв'язком:\n"+arr[i]);
            }
        }
    }

    public static void NumbIn(Phone[]arr, int num)
    {
        System.out.println("Введіть початок діапазону: ");
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        System.out.println("Введіть кінець діапазону: ");
        int end = scanner.nextInt();
        for(int i = 0; i< num; i++){
            if(start < arr[i].getNumber() && end > arr[i].getNumber() ){
                System.out.println("Телефоні користувачі, чий номер рахунку знаходиться у вказаному діапазоні:\n"+arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Введіть кількість телефоних користувачів: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Phone[] arr =ArrOfObj(num);
        arrPrint(arr,num);
        TimeToTalk(arr,num);
        UserUsed(arr,num);
        NumbIn(arr,num);
    }
}