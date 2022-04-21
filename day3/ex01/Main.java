package ex01;

import java.util.Scanner;

public class Main {

    static final String EGG = "Egg";
    static final String HEN = "Hen";

    private static Integer getCount(String line) {
        Integer count = 5;
        Scanner scanner = new Scanner(line).useDelimiter("=");

        if (scanner.next().equals("--count")) {
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
            } else {
                System.out.println("Invalid argument, setting count to default (5)");
            }
        }
        if (count < 0) {
            count = 5;
            System.out.println("Invalid argument (count < 0) , setting count to default (5)");
        }
        scanner.close();
        return count;
    }

    public static void main(String[] args) {
        Integer count;

        if (args.length > 0 && args[0] != null && !args[0].isEmpty()) {
            count = getCount(args[0]);
        } else {
            count = 5;
        }

        MyThread threadEgg = new MyThread(EGG, count, 1);
        MyThread threadHen = new MyThread(HEN, count, -1);

        threadEgg.start();
        threadHen.start();

        try {
            threadEgg.join();
            threadHen.join();
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            System.exit(-1);
        }
    }
}
