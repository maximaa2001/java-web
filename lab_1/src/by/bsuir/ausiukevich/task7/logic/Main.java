package by.bsuir.ausiukevich.task7.logic;

import by.bsuir.ausiukevich.input.InputDouble;
import by.bsuir.ausiukevich.input.InputInteger;
import by.bsuir.ausiukevich.task7.data.SortShell;

public class Main {
    public static void main(String[] args) {
        double[] inputArray = InputDouble.getArrayDouble(getSizeArray());
        SortShell sortShell = new SortShell(inputArray);
        sortShell.sort();
        sortShell.printArray();
    }

    private static int getSizeArray() {
        return InputInteger.getInputInteger();
    }
}
