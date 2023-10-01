package org.example;
///Creează clasa BookStore
////Atribute:
////•	Books: va fi un set
////Metode:
////addBook()
////•	Adaugă o carte primită ca parametru în set-ul books

////deleteBook()
////•	Șterge cartea primită ca parametru din set-ul books

////getAllBooksOrderedByYear()
////•	Va returna valoarea atributului books

////getAllGenres()
////•	Va returna un set cu toate genurile existente în colecția de cărți

////getAllBooksOrderedByAuthor()
////•	Va returna un TreeSet care va folosi AuthorComparator pentru a sorta cărțile după autor
//getAllBooksByGenre()
//•	Va construi o mapă, în care cheia este un gen, iar valoarea este set-ul de cărți care au acel gen
//•	Va returna această mapă (toate genurile, cu toate cărțile din fiecare gen) (HINT: mapă cu cheia gen, iar valoarea lista de cărți cu acel gen)
//getBooksByGenre()
//•	Va primi ca parametru un gen
//•	Va returna toate cărțile care au acel gen (HINT: valoarea de la o anumită cheie din mapă)

import java.awt.print.Book;
import java.util.*;

////getAllBooksByGenre()
////•	Va construi o mapă, în care cheia este un gen, iar valoarea este set-ul de cărți care au acel gen
////•	Va returna această mapă (toate genurile, cu toate cărțile din fiecare gen) (HINT: mapă cu cheia gen, iar valoarea lista de cărți cu acel gen)
////getBooksByGenre()
////•	Va primi ca parametru un gen
////•	Va returna toate cărțile care au acel gen (HINT: valoarea de la o anumită cheie din mapă)
public class BookStore {
    private Set<Book> books;
    private Map<String, Set<Book>> booksByGenre;

    public BookStore() {
        books = new HashSet<>();
        booksByGenre = new HashMap<>();
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void deleteBook(Book book) {
        books.remove(book);
    }
////•	Va returna valoarea atributului books
    public  Set<Book> getAllBooksOrderedByYear() {
        return books;
    }
//////•	Va returna un set cu toate genurile existente în colecția de cărți / aici nu pot apela metodat getGenre() pe o carte book
    public Set<String> getAllGenres() {
        Set <String> geners = new HashSet<>();
        //parcurg setul de carti si pentru fiecare carte salvez in set -ul geners fiecare gen si apoi returnez setul de genuri
        for (Book book: books) {
            geners.add(book.getGenre());
        }
        return geners;
    }
    //tree setul va tine cartile ordonate dupa autor
    public TreeSet<Book> getAllBooksOrderedByAuthor() {
        TreeSet<Book> booksOrderedByAuthor = new TreeSet<>();
        booksOrderedByAuthor.addAll(books);
        return booksOrderedByAuthor;
    }

    ///getAllBooksByGenre()
////•	Va construi o mapă, în care cheia este un gen, iar valoarea este set-ul de cărți care au acel gen
////•	Va returna această mapă (toate genurile, cu toate cărțile din fiecare gen) (HINT: mapă cu cheia gen,
// iar valoarea lista de cărți cu acel gen)
        //voi pune in cheia mapei setul returnat de metoda getAllGeners
        //voi parcurge lista e carti si pentru fiecare gen de carti salvat in lista voi pune intr o alta lista cartea respectiva
    public Map<String, Set<Book>>  getAllBooksByGenre() {
        return booksByGenre;

    }
    public Set<Book> getBooksByGenre(String genre) {
        List<Book> booksByGenre = new ArrayList<>();
        //daca genul dat ca parametru se gaseste la o cheie din mapa atunci se va returna valoarea
        // corespunzatoare acelei chei din mapa
       if (!(booksByGenre.contains(genre))) {
           return null;
       } else {
           return booksByGenre.get(genre);
       }
    }

}
