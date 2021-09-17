package by.bsuir.ausiukevich.input;

import by.bsuir.ausiukevich.exception.InputExeption;

import java.sql.SQLException;
import java.util.Scanner;

public class InputDouble {

    private InputDouble() {
    }

    public static double getInputDouble(String str) {
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
        throw new InputExeption("Error when entering double number");
    }
}
