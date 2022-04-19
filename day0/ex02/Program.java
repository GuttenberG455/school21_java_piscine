import java.util.Scanner;

public class Program {
    private static int getExpectedSqrt(int number) {
        int start = 1;
        int end = number;
        int res = 0;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (mid * mid == number) {
                return (mid);
            } else if (mid * mid < number) {
                start = mid + 1;
                res = mid;
            }
            else {
                end = mid - 1;
            }
        }
        return (res);
    }

    private static boolean isPrime(int number) {

		if (number <= 1) {
			return (false);
		}
        else if (number == 2) {
            return (true);
        }
        else {
            int expSqrt = getExpectedSqrt(number);
            int i = 2;
            while (i <= expSqrt) {
                if (number % i == 0) {
                    return (false);
                }
                i++;
            }
            return (true);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input;

        int reqCount = 0;
        while (true) {
            input = scanner.nextLong();
            if (input == 42) {
                System.out.println("Count of coffee - request - " + reqCount);
                break;
            }
            int sumDigits = 0;
            while (input > 0) {
                sumDigits += input % 10;
                input /= 10;
            }
            if (isPrime(sumDigits))
                reqCount++;
        }
		scanner.close();
    }
}
