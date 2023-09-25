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

    public BookStore(Set<Book> books) {
        this.books = books;
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
    public  List<Book> getAllBooksOrderedByYear() {
        List<Book> allBooksOrderedByYear = new ArrayList<>();
        allBooksOrderedByYear.addAll(books);
        Collections.sort(allBooksOrderedByYear);
        return allBooksOrderedByYear;
    }
//////•	Va returna un set cu toate genurile existente în colecția de cărți
    public Set<String> getAllGenres() {
        Set <String> geners = new HashSet<>();
        //parcurg setul de carti si pentru fiecare carte salvez in set -ul geners fiecare gen si apoi returnez setul
        for (Book book: books) {
            geners.add(book.getGenre());
        }
        return geners;
    }
    public TreeSet<Book> getAllBooksOrderedByAuthor() {
        List<Book> allBooksOrderedByAuthor = new ArrayList<>();
        TreeSet<Book> booksOrderedByAuthor = new TreeSet<>();
        allBooksOrderedByAuthor.addAll(books);
        allBooksOrderedByAuthor.sort(new AuthorComparator());
        booksOrderedByAuthor.addAll(allBooksOrderedByAuthor);
        return booksOrderedByAuthor;
    }

    ///getAllBooksByGenre()
////•	Va construi o mapă, în care cheia este un gen, iar valoarea este set-ul de cărți care au acel gen
////•	Va returna această mapă (toate genurile, cu toate cărțile din fiecare gen) (HINT: mapă cu cheia gen,
// iar valoarea lista de cărți cu acel gen)
        //voi pune in cheia mapei setul returnat de metoda getAllGeners
        //voi parcurge lista e carti si pentru fiecare gen de carti salvat in lista voi pune intr o alta lista cartea respectiva
    public Map<String, List<Book>>  getAllBooksByGenre() {
        Map<String, List<Book>> allBooksByGenre = new HashMap<>();
        List<String> keyForMap = new ArrayList<>();
        List<Book> keyValue = new ArrayList<>();
        keyForMap.addAll(getAllGenres());
        for (int i = 0; i < keyForMap.size(); i++){
            String genre = keyForMap.get(i);
            for (Book book:books) {
                if (genre.equals(book.getGenere())) {
                    keyValue.add(book);
                }
            }
        }
        for (String s: keyForMap) {
            allBooksByGenre.put(s, keyValue);
        }
        return allBooksByGenre;
    }
    public List<Book> getBooksByGenre(Book genre) {
        List<Book> booksByGenre = new ArrayList<>();
        //daca genul dat ca parametru se gaseste la o cheie din mapa atunci se va returna valoarea
        // corespunzatoare acelei chei din mapa
        for (Book book:books) {
            if (genre.equals(getAllBooksByGenre().get(book.getGenre()))) {
                booksByGenre.add(book);
            }
        }
        return booksByGenre;
    }

}
