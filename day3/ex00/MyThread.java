package ex00;

public class MyThread extends Thread{

    private final String name;
    private final Integer count;

    public MyThread(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < this.count; i++) {
            try {
                sleep((long)(Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
                System.exit(-1);
            }
            System.out.println(this.name);
        }
    }
}
