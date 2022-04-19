import java.util.Scanner;

public class Program {
    private static int[] getCharCount(String input) {
        int[] charCount = new int[65535];
        char[] inputAsArray = input.toCharArray();

        for (char c : inputAsArray) {
            charCount[c]++;
        }
        return (charCount);
    }

    private static char[] getTopList(int[] charCount) {
        char[] charTopList = new char[10];
        for (int j = 0; j < 10; j ++) {
            int maxVal = 0, maxInd = 0;
            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i] > maxVal) {
                    maxVal = charCount[i];
                    maxInd = i;
                }
            }
            charTopList[j] = (char)maxInd;
            charCount[maxInd] = 0;
        }
        return (charTopList);
    }
    private static void printNumber(char[] charTopList, int[] charCount, int ind) {
        if (charCount[charTopList[ind]] >= 10) {
            System.out.print(charCount[charTopList[ind]] + " ");
        } else {
            System.out.print(" " + charCount[charTopList[ind]] + " ");
        }
    }

    private static int[] getRatioList(char[] charTopList, int[] charCount) {
        int i = 0;
        while (i < 10) {
            if (charCount[charTopList[i]] == 0) {
                break;
            }
            i++;
        }
        int[] ratioList = new int[i];
        for (i = 0; i < ratioList.length; i++) {
            ratioList[i] = (int)((charCount[charTopList[i]] * 10 / charCount[charTopList[0]]));
        }
        return (ratioList);
    }

    private static void printTopList(char[] charTopList, int[] charCount, int[] ratioList) {
        int curInd = 0;

        for (int i = 10; i >= 0; i--) {
            while (curInd < ratioList.length) {
                if (ratioList[curInd] >= i) {
                    printNumber(charTopList, charCount, curInd);
                    curInd++;
                } else {
                    break;
                }
            }
            if (i == 0) {
                break;
            }
            System.out.println();
            for (int j = 0; j < curInd; j++) {
                if (ratioList[j] >= i) {
                    System.out.print(" # ");
                } else {
                    System.out.println();
                    break;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            if (charCount[charTopList[i]] == 0) {
                break;
            }
            System.out.print(" " + charTopList[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charTopList;
        int[] charCount;
        int[] ratioList;

        String input = scanner.nextLine();
        if (Objects.equals(input, "") || input.length() > 999) {
			scanner.close();
            System.exit(0);
        }
        charCount = getCharCount(input);
        charTopList = getTopList(charCount);
        charCount = getCharCount(input);
        ratioList = getRatioList(charTopList, charCount);
        printTopList(charTopList, charCount, ratioList);
		scanner.close();
    }
}
