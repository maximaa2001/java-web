package by.bsuir.ausiukevich.task7.logic;

import by.bsuir.ausiukevich.input.InputInteger;
import by.bsuir.ausiukevich.task7.data.InputArrayNumbers;
import by.bsuir.ausiukevich.task7.data.SortShell;

public class Main {
    public static void main(String[] args) {
        InputArrayNumbers inputArrayNumbers = new InputArrayNumbers(getSizeArray());
        inputArrayNumbers.inputArray();
        SortShell sortShell = new SortShell(inputArrayNumbers.getInputArray());
        sortShell.sort();
        sortShell.printArray();
    }

    private static int getSizeArray() {
        return InputInteger.getInputInteger();
    }
}
