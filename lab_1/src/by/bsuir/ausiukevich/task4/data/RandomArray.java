package by.bsuir.ausiukevich.task4.data;

public class RandomArray {
    private int size;
    private int[] array;

    public RandomArray(int n) {
        size = n;
        array = new int[size];
        installArray();
    }

    private void installArray() {
        for (int i = 0; i < size; i++) {
            int temp = (int) (Math.random() * 100) + 1;
            array[i] = temp;
        }
    }

    public void printElements() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    public void findSimpleNumbers() {
        System.out.print("Simple Numbers: ");
        for (int i = 0; i < size; i++) {
            if (array[i] == 0 || array[i] == 1) {
                continue;
            } else if (array[i] == 2) {
                System.out.print(array[i] + " ");
            } else {
                boolean isSimple = true;
                for (int j = 2; j < array[i] - 1; j++) {
                    if (array[i] % j == 0) {
                        isSimple = false;
                        break;
                    }
                }
                if (isSimple) {
                    System.out.print(array[i] + " ");
                }
            }
        }
    }
}
