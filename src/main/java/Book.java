public class Book {

   private  String year;
   private String title;
   private String genre;
   private String author;

   public Book(String year, String title, String genre, String author) {
      this.year = year;
      this.title = title;
      this.genre = genre;
      this.author = author;
   }

   public String getYear() {
      return year;
   }

   public void setYear(String year) {
      this.year = year;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getGenre() {
      return genre;
   }

   public void setGenre(String genre) {
      this.genre = genre;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

}
////Librăria va trebui să conțină o colecție de cărți. Fiecare carte are atributele: year, title, genre (gen) și author.
////Librăria va trebui să implementeze următoarele funcționalități:
////•	Afișarea cărților ordonate după year
////•	Afișarea cărților ordonate după autor
////•	Gruparea cărților după genre
////•	Afișarea tuturor cărților dintr-un anumit gen
////•	Afișarea tuturor genurilor împreună cu toate cărțile din fiecare gen
////•	Afișarea tuturor genurilor
////•	Adăugarea unei cărți
////•	Ștergerea unei cărți
////Creează clasa Book
////Atribute:
////•	Year
////•	Title
////•	Genre
////•	Author
////Metode:
////compareTo
////(suprascrisă din interfața Comparable)
////•	Va compara cărțile după year
////Creează clasa AuthorComparator
////•	Va implementa interfața Comparator
////•	Va suprascrie metoda compare() pentru a compara două cărți după autor (se va apela metoda compareTo() pentru String-uri)