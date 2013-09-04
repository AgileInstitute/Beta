package main.java;

import java.util.ArrayList;
import java.util.Collection;

public class User {
	
	Collection<Book> purchases = new ArrayList<Book>();

	public User(String username) {
	}

	public void addPurchase(Book book) {
		purchases.add(book);
	}

	public boolean hasPurchasedBook(Book edition) {
		for (Book next : purchases) {
			if (next.isSameTitleAs(edition) && next.edition() == edition.edition())
				return true;
		}
		return false;
	}

}
