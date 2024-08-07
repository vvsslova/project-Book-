package com.github.vvsslova;

public class App {
    public static void main(String[] args) {
        Book.Design designFirstBook = new Book.Design("yellow", 190, 150, "Arial", 12, 579);
        Book firstBook = new Book("Erich Maria Remarque", "Three comrades", "exmo", 2015, designFirstBook);
        firstBook.getBookInfo();
        System.out.println(" ");
        designFirstBook.getDesignInfo();
        System.out.println(" ");
        firstBook.updateProgress(6);
        firstBook.updateProgress(179);

        System.out.println(" ");

        Book.Design designSecondBook = new Book.Design("white", 200, 140, "Times New Roman", 14, 430);
        Book secondBook = new Book("Jane Osten", "Pride and Prejudice", "AST", 2018, designSecondBook);
        secondBook.getBookInfo();
        System.out.println(" ");
        designSecondBook.getDesignInfo();
        System.out.println(" ");
        secondBook.updateProgress(38);
        secondBook.updateProgress(172);

    }
}
