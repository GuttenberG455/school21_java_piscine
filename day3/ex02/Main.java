package ex02;

import java.util.Scanner;

public class Main {
    private static Integer getCount(String line, String key) {
        Integer count = 1;
        Scanner scanner = new Scanner(line).useDelimiter("=");

        if (scanner.next().equals(key)) {
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Terminating");
                System.exit(-1);
            }
        }
        if (count < 0) {
            System.out.println("Invalid input! Terminating");
            System.exit(-1);
        }
        scanner.close();
        return count;
    }

    public static Integer[] createArray(Integer size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int)(Math.random() * 2001) - 1000;
        }
        return array;
    }

    private static void printSum(Integer[] array, String line) {
        Integer mainSum = 0;
        for (int i : array) {
            mainSum += i;
        }
        System.out.println(line + mainSum);
    }

    public static void main(String[] args) throws InterruptedException {
        Integer sizeArray = getCount(args[0], "--arraySize");
        Integer threadsCount = getCount(args[1], "--threadsCount");


        Integer[] arrayInt = createArray(sizeArray);
        printSum(arrayInt, "Sum: ");

        Integer[] arraySums = new Integer[threadsCount];
        MyThread[] threads = new MyThread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new MyThread(i, arrayInt, threadsCount, sizeArray, arraySums);
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            threads[i].join();
        }

        printSum(arraySums, "Sum by threads: ");
    }
}

//