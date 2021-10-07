package by.bsuir.ausiukevich.input;

import by.bsuir.ausiukevich.exception.InputExeption;

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
        throw new InputExeption("Error when entering int number");
    }

    public static int[] getRandomArrayInt(int size, int from, int to) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * to) + from;
        }
        return array;
    }
}
