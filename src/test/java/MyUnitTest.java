package test.java;

import main.java.Book;
import main.java.Edition;
import main.java.User;

import org.junit.*;

public class MyUnitTest {
	@Test
	public void hasPurchasedBookByEdition() {
		User bart = new User("Bart");
		Book kindleEdition = new Book("War & Peace", Edition.KINDLE );
		Book kindleEditionAgain = new Book("War & Peace", Edition.KINDLE );
		
		bart.addPurchase(kindleEdition);
		
		Assert.assertTrue(bart.hasPurchasedBook(kindleEditionAgain));
		
	}
	@Test
	public void testWhenDiscount() {
		String title = "War & Peace";
		Book kindleEdition = new Book(title, Edition.KINDLE );
		Book paperbackEdition = new Book(title, Edition.PAPERBACK );
		
		User bart = new User("Bart");
		
		bart.addPurchase(kindleEdition);
		int discount = paperbackEdition.getDiscount(bart);
		Assert.assertEquals(10, discount);
	}
	
	@Test
	public void testNoDiscount() {
		Book book = new Book(anyBookTitle(), anyEdition());
		Assert.assertEquals(0, book.getDiscount(null));
	}
	private Edition anyEdition() {
		return Edition.KINDLE;
	}

	private String anyBookTitle() {
		return "My Life by Douglas Adams";
	}

	@Test	
	public void testBookNameMatch()
	{
		Book book = new Book("War & Peace", Edition.KINDLE );
		Book bookToCheck = new Book("War & Peace", Edition.PAPERBACK );
		Assert.assertTrue(book.isSameTitleAs(bookToCheck));
	}
	@Test	
	public void testBookNameDoesntMatch()
	{
		Book book = new Book("War", Edition.KINDLE );
		Book bookToCheck = new Book("War & Peace", Edition.KINDLE );
		
		Assert.assertFalse(book.isSameTitleAs(bookToCheck));
	}
}
