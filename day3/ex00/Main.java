package ex00;

import java.util.Scanner;

public class Main {

    static final String EGG = "Egg";
    static final String HEN = "Hen";
    static final String HUMAN = "Human";

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
        Integer count = 5;

        if (args.length > 0 && args[0] != null && !args[0].isEmpty()) {
            count = getCount(args[0]);
        }

        MyThread threadEgg = new MyThread(EGG, count);
        MyThread threadHen = new MyThread(HEN, count);

        threadEgg.start();
        threadHen.start();
        try {
            threadEgg.join();
            threadHen.join();
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            System.exit(-1);
        }
        for (int i = 0; i < count; i++) {
            System.out.println(HUMAN);
        }
    }
}
