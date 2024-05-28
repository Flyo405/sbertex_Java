import java.util.Collection;

public class CountPrimeNumbers {

    public static <T extends Number> int countPrimeNumbers(Collection<T> collection) {
        int count = 0;
        for (T element : collection) {
            if (isPrime(element.intValue()))  {
                count++;
            }
        }
        return count;
    }
    public static boolean isPrime(int countPrimeNumbers) {
        if (countPrimeNumbers < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(countPrimeNumbers); i++) {
            if (countPrimeNumbers % i == 0) {
                return false;
            }
        }

        return true;
    }
}