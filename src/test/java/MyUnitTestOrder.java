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

		System.out.println(order.displayList());
		Assert.assertEquals("Title Price Life 9.95 ", order.displayList());
	}	
	@Test
	public void testaddDiscount(){
		Double	total = 73.85;
		Order  order = new Order ();
		order.addBook(new Book("Life", 28.95));
		order.addBook(new Book("Death", 24.95));
		order.addBook(new Book("Ying", 9.95));
		order.addBook(new Book("Yang", 19.95));
		order.addDiscount("4th free", 9.95);
		Assert.assertEquals(total, order.getSubTotal());

	}
	
	@Test
	public void testDisplayListWdiscount()
	{
	
		Order  order = new Order ();
		order.addBook(new Book("Life", 9.95));
		order.addBook(new Book("Death", 9.95));
		order.addBook(new Book("Ying", 9.95));
		order.addBook(new Book("Yang", 9.95));
		order.addDiscount("4th free", 9.95);
		Assert.assertEquals("Title Price Life 9.95 Death 9.95 Ying 9.95 Yang 9.95 4th free -9.95", order.displayList());
	}	
	
}
