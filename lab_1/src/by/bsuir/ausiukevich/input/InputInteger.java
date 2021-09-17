package by.bsuir.ausiukevich.input;

import java.util.Scanner;

public class InputInteger {

    private InputInteger() {
    }
    public static int getInputInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number ...");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("INCORRECT NUMBER");
                scanner.next();
            }
            System.out.println("Input number ...");
        }
       return 0;
    }

}
