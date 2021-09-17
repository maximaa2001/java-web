package by.bsuir.ausiukevich.task1.data;

import java.util.Scanner;

public class Input {
    private Double numberX;
    private Double numberY;

    public Input() {
        numberX = installNumber();
        numberY = installNumber();
    }

    public static Double installNumber() {
        Scanner scanner = new Scanner(System.in);
        double temp;
        System.out.println("Input number ...");
        do {
            if (scanner.hasNextLong()) {
                temp = scanner.nextLong();
                return temp;
            } else if (scanner.hasNextDouble()) {
                temp = scanner.nextDouble();
                return temp;
            } else {
                System.out.println("INCORRECT NUMBER");
                scanner.next();
            }
            System.out.println("Input number ...");
        } while (scanner.hasNext());
        return null;
    }

    public Double getNumberX() {
        return numberX;
    }

    public void setNumberX(Double numberX) {
        this.numberX = numberX;
    }

    public Double getNumberY() {
        return numberY;
    }

    public void setNumberY(Double numberY) {
        this.numberY = numberY;
    }
}
