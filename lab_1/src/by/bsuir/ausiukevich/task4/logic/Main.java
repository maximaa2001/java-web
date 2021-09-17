package by.bsuir.ausiukevich.task4.logic;

import by.bsuir.ausiukevich.input.InputInteger;
import by.bsuir.ausiukevich.task4.data.RandomArray;

public class Main {
    public static void main(String[] args) {
        int n = InputInteger.getInputInteger();
        RandomArray randomArray = new RandomArray(n);
        randomArray.printElements();
        randomArray.findSimpleNumbers();
    }
}
