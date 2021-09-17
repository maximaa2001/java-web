package by.bsuir.ausiukevich.input;

import java.util.Scanner;

public class InputDouble {

    private InputDouble() {
    }

    public static Double getNumber(String str) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number " + str + " ...");
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else if (scanner.hasNextLong()) {
                long x = scanner.nextLong();
                return (double) x;
            } else {
                System.out.println("INCORRECT NUMBER");
                scanner.next();
            }
            System.out.println("Input number " + str + " ...");
        }
        return null;
    }
}
