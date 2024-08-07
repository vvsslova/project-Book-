package com.github.vvsslova;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
/**
 * @author Victoria Shilova
 * Этот проект реализует создание книги (outer class Book), вёрстку её дизайна (inner class DesignBook).
 * и изменение прогресса чтения (inner class BookReadingState).
 */
/**
 * Данный класс создает экземпляр книги, выдает информацию о ней и вызывает подсчет числа прочитанных страниц.
 */
public class Book {
    private String author;
    private String publishingHouse;
    private int yearPublication;
    private Design designBook;
    private String title;
    /**
     * У каждого экземпляра книги своё состояние при чтении (объект класса BookReadingState).
     * При вызове метода callAdvanceProgress будет изменяться количество прочитанных страниц конкретно для этого экзмепляра.
     */
    private ReadingState stateReading;

    /**
     * Данный конструктор инициализует поля экземпляра книги.
     *
     * @param author          автор.
     * @param title           название.
     * @param publishingHouse издательский дом.
     * @param yearPublication год публикации.
     * @param design          дизайн книги (уже готовый объект класса DesignBook).
     */
    public Book(String author, String title, String publishingHouse, int yearPublication, Design design) {
        this.designBook = design;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.yearPublication = yearPublication;
        this.title = title;
        this.stateReading = new ReadingState();
    }

    /**
     * Метод отображает в консоли информацию о конкретном экземпляре книги.
     */
    public void getBookInfo() {
        System.out.println("Это книга " + title + "\n" + "Её автор: " + author + "\n" + "Выпущена издательским домом " + publishingHouse + " в " + yearPublication + " году");
    }

    /**
     * Метод вызывает метод вложенного класса для изменения прогресса чтения книги.
     *
     * @param numberReadPages количество прочитанных страниц.
     */
    public void updateProgress(int numberReadPages) {
        stateReading.updateProgress(numberReadPages);
    }

    /**
     * Этот внутренний класс отвечает за создание дизайна книги.
     */
    @Data
    public static class Design {
        private String color;
        private double width;
        private double length;
        private String font;
        private int fontSize;
        protected int pageCount;

        /**
         * Конструктор иницилизирует поля макета дизайна книги.
         *
         * @param color     цвет.
         * @param width     ширина страницы (в мм).
         * @param length    длина страницы (в мм).
         * @param font      шрифт.
         * @param fontSize  размер шрифта.
         * @param pageCount количество страниц.
         */
        public Design(String color, int width, int length, String font, int fontSize, int pageCount) {
            this.color = color;
            this.width = width;
            this.length = length;
            this.font = font;
            this.fontSize = fontSize;
            this.pageCount = pageCount;
        }

        /**
         * Метод отображает информацию о макете дизайна книги в консоли.
         * Также рассчитывает толщину корешка, исходя из полученных в конструкторе данных о количестве страниц.
         */
        public void getDesignInfo() {
            System.out.println("Вот информация о дизайне этой книги:" + "\n" + "Площадь обложки равна: " + ((width * length) / 1000) + " см²");
            double bookThickness;
            bookThickness = Math.round((pageCount * 0.1) + 3);
            System.out.println("Толщина корешка: " + bookThickness + " мм" + "\n" + "Цвет обложки: " + color + "\n" + "Типографические данные: " + "\n" + "Цвет: " + color + "\n" + "Шрифт: " + font + "\n" + "Размер шрифта: " + fontSize);
        }
    }

    /**
     * Этот внутренний класс отвечает за реализацию процесса подсчета прочитанных страниц.
     */
    @Data
    public class ReadingState {
        private int progress = 3;

        /**
         * Метод осуществляет подсчет прочитанных страниц у конкретного экземпляра книги (с учётом прочитанных).
         *
         * @param numberReadPages количество прочитанных страниц.
         */
        public void updateProgress(int numberReadPages) {
            int pageCount = designBook.getPageCount();
            if (progress == 3) {
                progress = progress + numberReadPages;
            } else {
                progress = progress + numberReadPages;
            }
            if (this.progress >= pageCount) {
                System.out.println("Невозможно прочитать больше, чем страниц в книге");
            } else {
                System.out.println("Количество прочитанных страниц: " + progress + " из " + pageCount);
            }
        }
    }
}
