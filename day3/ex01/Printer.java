package ex01;

public class Printer {
    private boolean flag = true;

    public synchronized void printMessage(String message, Integer type) throws InterruptedException {
        if (type == 1) {
            while (!flag) {
                wait();
            }
            flag = false;
        } else {
            while (flag) {
                wait();
            }
            flag = true;
        }
        System.out.println(message);
        notify();
    }
}
