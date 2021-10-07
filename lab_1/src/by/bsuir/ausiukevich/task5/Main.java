package by.bsuir.ausiukevich.task5;

import by.bsuir.ausiukevich.input.InputInteger;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] randomArrayInt = InputInteger.getRandomArrayInt(10, 1, 20);
        System.out.println(Arrays.toString(randomArrayInt));
        int result = FinderHighestSequence.find(randomArrayInt);
        System.out.println(result);
    }
}
