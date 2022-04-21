package ex01;

public class MyThread extends Thread{

    private final static Printer printer = new Printer();
    private final String name;
    private final Integer count;
    private final Integer type;

    public MyThread(String name, Integer count, Integer type) {
        this.name = name;
        this.count = count;
        this.type = type;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++) {
            try {
                printer.printMessage(this.name, this.type);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
                System.exit(-1);
            }
        }
    }
}