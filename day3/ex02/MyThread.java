package ex02;

public class MyThread extends Thread {
    private Integer ord;
    private Integer[] arrayInt;
    private Integer[] sumArr;
    private Integer startPos;
    private Integer endPos;

    public MyThread(Integer ord, Integer[] array, Integer threadAmount, Integer sizeArray, Integer[] sumArr) {
        this.ord = ord;
        this.arrayInt = array;
        this.sumArr = sumArr;
        this.startPos = ord > 0 ? (sizeArray / threadAmount) * ord: 0;
        if (ord == threadAmount - 1) {
            this.endPos = sizeArray - 1;
        } else {
            this.endPos = (sizeArray / threadAmount) * (ord + 1) - 1;
        }
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    @Override
    public void run() {
        Integer sum = 0;
        for (int i = this.startPos; i <= endPos; i++) {
            sum += this.arrayInt[i];
        }
        this.sumArr[this.ord] = sum;
        System.out.printf("Thread %s : from %s to %s sum is %s%n", this.ord, this.startPos, this.endPos, sum);
    }
}
