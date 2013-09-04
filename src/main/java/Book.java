/**
 * 
 */
package main.java;


/**
 * @author emp197
 *
 */
public class Book {

	private String title;
	private Edition edition;

	public Book(String title, Edition edition) {
		this.title = title;
		this.edition = edition;
	}

	public int getDiscount(User loggedInUser) {
		if (loggedInUser != null)
			return 10;
		
		return 0;
	}

	public boolean isSameTitleAs(Book bookToCheck) {
		return this.title.equals(bookToCheck.title);
	}

	public Edition edition() {
		return edition;
	}

}
