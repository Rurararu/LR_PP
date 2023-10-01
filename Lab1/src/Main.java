import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть перших n чисел Люка які хочете перевірити:");
        int n = scanner.nextInt();
        Lucka numbers = new Lucka();//обєкт класу
        numbers.findLucasPrimes(n);
    }
}
