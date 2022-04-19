import java.util.Scanner;

public class Program {
    private static int putIllegalArgument() {
        System.err.println("Illegal Argument");
        return -1;
    }

    private static int getMinGrade(Scanner scanner) {
        int min = scanner.nextInt();
        for (int i = 0; i < 4; i++) {
            int current = scanner.nextInt();
            min = (current < min) ? current : min;
        }
        scanner.nextLine();
        return (min);
    }

    private static String concatOutput(String output, String input, int grade) {
        output = output + input + ' ';
        for (int i = 0; i < grade; i++) {
            output += "=";
        }
        output += ">";
        return (output);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input, output = "";

        input = scanner.nextLine();
        int weekCount = 1;
        while (weekCount <= 18 && !input.equals("42")) {

            if (!input.equals("Week " + weekCount)) {
				scanner.close();
                System.exit(putIllegalArgument());
            }
            int min = getMinGrade(scanner);
            output = concatOutput(output, input, min);
			if (!input.equals("42")) {
				output += "\n";
			}
			if (weekCount == 18) {
				break ;
			}
            input = scanner.nextLine();
            weekCount++;
        }
		if (!output.equals("")) {
			System.out.print(output);
		}
		scanner.close();
    }
}
