public class Primes {
    public static void main(String[] args){
        printPrimes(Integer.parseInt(args[0]));
    }

    private static void printPrimes(int limit){
        for (int i = 2; i <= limit; i++){
            if (isPrime(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int x){
        for (int i = 2; i*i <= x; i++){
            if (x%i == 0) return false;
        }
        return true;
    }

}
