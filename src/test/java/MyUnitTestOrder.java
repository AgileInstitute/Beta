package test.java;

import main.java.Book;
import main.java.Order;
import org.junit.*;

public class MyUnitTestOrder {
	@Test
	public void testAddBook()
	{
	
		Order  order = new Order ();
		Assert.assertTrue(order.addBook(new Book("Life", 9.95)));
	}
	
	@Test
	public void testDisplayList()
	{
	
		Order  order = new Order ();
		order.addBook(new Book("Life", 9.95));

		
		Assert.assertEquals("Title Price Life 9.95", order.displayList());
	}	
}
