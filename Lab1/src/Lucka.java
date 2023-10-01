public class Lucka {
//Визначити, які числа серед перших N чисел Люка є простими

    /**
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {    //виявлення чи число є простим
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param n
     */
    public void findLucasPrimes(int n) { //виявлення чи число є простим у чисел Люка
        int l0 = 2, l1 = 1, l, count = 0;
        System.out.println("Прості числа Люка серед перших " + n + " чисел Люка:");
        if(n>=1){
            System.out.print("1 ");
        }
        while (count < n-1) {
            if (isPrime(l0)) {
                System.out.print(l0 + " ");
                count++;
            }
            int nextLucas = l0 + l1;
            l0 = l1;
            l1 = nextLucas;
        }
        System.out.println();
    }
}
