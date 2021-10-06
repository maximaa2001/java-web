package by.bsuir.ausiukevich.task12;

import java.util.ArrayList;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int price;
    private static int edition;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode(){
        int hashTitle = (title != null) ? title.hashCode() : 0;
        int hashAuthor = (author != null) ? author.hashCode() : 0;
        return hashTitle + hashAuthor + 31 * price;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        if(this == o){
            return true;
        }
        Book book = (Book) o;
        return title.equals(book.getTitle()) && author.equals(book.getAuthor()) && price == book.getPrice();
    }

    @Override
    public String toString(){
        return "title = " + getTitle() + ", author = " + getAuthor() + ", price = " + getPrice();
    }
}
