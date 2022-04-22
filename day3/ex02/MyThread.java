package ex02;

public class MyThread extends Thread {
    private final Integer ord;
    private final Integer[] arrayInt;
    private final Integer[] sumArr;
    private final Integer startPos;
    private final Integer endPos;

    public MyThread(Integer ord, Integer[] array, Integer threadAmount, Integer sizeArray, Integer[] sumArr) {
        this.ord = ord;
        this.arrayInt = array;
        this.sumArr = sumArr;
        this.startPos = ord > 0 ? (sizeArray / threadAmount) * ord: 0;
        this.endPos = (ord == threadAmount - 1) ? sizeArray - 1 : (sizeArray / threadAmount) * (ord + 1) - 1;
    }

    @Override
    public void run() {
        Integer sum = 0;
        for (int i = this.startPos; i <= endPos; i++) {
            sum += this.arrayInt[i];
        }
        this.sumArr[this.ord] = sum;
        System.out.printf("Thread %s: from %s to %s sum is %s%n", this.ord + 1, this.startPos, this.endPos, sum);
    }
}
