import java.util.Scanner;

public class Program {
    private static int putIllegalArgument() {
        System.err.println("Illegal Argument");
        return (-1);
    }

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= 1) {
            System.exit(putIllegalArgument());
        } else if (number == 2) {
            System.out.println(true + " " + 1);
        } else {
            int expSqrt = getExpectedSqrt(number);
            int i = 2;
            while (i <= expSqrt) {
                if (number % i == 0) {
                    System.out.println(false + " " + (i - 1));
                    System.exit(0);
                }
                i++;
            }
            System.out.println(true + " " + (i - 1));
        }
    }
}
