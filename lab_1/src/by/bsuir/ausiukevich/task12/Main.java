package by.bsuir.ausiukevich.task12;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book1 = new Book("Название","Автор",100);
        Book book2 = new Book();
        book2.setTitle("Название");
        book2.setAuthor("Автор");
        Book book3 = new Book("Название","Автор",100);
        System.out.println(book1.hashCode() == book2.hashCode());
        System.out.println(book1.hashCode() == book3.hashCode());
        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book3));
        Book x = (Book) book1.clone();
        x.setTitle("Другое название");
        System.out.println(book1);
        System.out.println(x);
    }
}
