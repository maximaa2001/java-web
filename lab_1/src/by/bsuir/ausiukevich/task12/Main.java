package by.bsuir.ausiukevich.task12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book1 = new Book("В мире животных", "Автор", 100, 10);
        Book book2 = new Book("Познай мир", "Другой автор", 200, 3);
        Book book3 = new ProgrammerBook("Java From EPAM", "Кто-то очень умный", 500, 1, "Java", 9);
        Book book4 = new ProgrammerBook("С#", "Еще один автор", 180, 2, "С#", 8);
        Book book5 = new ProgrammerBook("Все о C++", "Автор2", 200, 8, "C++", 7);
        List<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);
        list.add(book5);
        printList(list);
        Collections.sort(list);
        System.out.println();
        printList(list);
    }

    private static <T extends Book> void printList(List<T> list) {
        for (T el : list) {
            System.out.println(el);
        }
    }

}
