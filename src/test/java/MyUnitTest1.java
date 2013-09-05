package test.java;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import main.java.Book;


import org.junit.*;

public class MyUnitTest1 {

@Test
public void addBooks() {
// Book book = new Book();
List<Book> booklist = new ArrayList<Book>();
booklist.add(new Book("Angels & Demons", 19.95));
booklist.add(new Book("World Peace", 29.95));
booklist.add(new Book("Love of God", 39.95));
booklist.add(new Book("Life", 9.95));

Collections.sort(booklist);
System.out.println(booklist.size());

System.out.println(booklist.get(0).getTitle());
System.out.println(booklist.get(0).getPrice());

// Assert.assertTrue(booklist.iterator().isExists("Angels & Demons"));
// Assert.assertTrue(book.isExists("Angels"));

/* Assert.assertTrue(book.addBook("Angels & Demons", 19.95));
Assert.assertTrue(book.addBook("Divergent", 29.95));
Assert.assertTrue(book.addBook("Psychology", 39.95));
Assert.assertTrue(book.addBook("Design Patterns", 10.95));
*/
}

@Test
public void checkDiscount() {
BookClub bookclub = new BookClub();
List<Book> booklist = new ArrayList<Book>();
double minPrice = 0.0;

Assert.assertTrue(bookclub.isMemberBC("User1"));

booklist.add(new Book("Angels & Demons", 19.95));
booklist.add(new Book("World Peace", 29.95));
booklist.add(new Book("Love of God", 39.95));
booklist.add(new Book("Life", 9.95));

if (bookclub.isDiscountEligible(booklist)) {
Collections.sort(booklist);
minPrice = booklist.get(0).getPrice();

}



} 


}
 
