package by.bsuir.ausiukevich.input;

import by.bsuir.ausiukevich.exception.InputExeption;

import java.util.ArrayList;
import java.util.List;
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

    public static double[] getArrayDouble(int count) {
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = getInputDouble("of array");
        }
        return numbers;
    }

    public static List<Double> getHighestList(int count) {
        List<Double> list = new ArrayList<>();
        int i = 0;
        while (i < count) {
            double temp = getInputDouble("of list");
            if (list.isEmpty() || list.get(list.size() - 1) < temp) {
                list.add(temp);
                i++;
            } else {
                System.out.println("Every next number must be more than previous");
            }
        }
        return list;
    }
}
