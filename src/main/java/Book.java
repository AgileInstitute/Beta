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
		if (loggedInUser != null){
		
			if (loggedInUser.hasPurchasedBook(this)){
				System.out.println(this.edition);
				if (loggedInUser.getPurchasedBook(this).isSameEdition(Edition.KINDLE))
					return 10;
			}
			System.out.println(this.title);
			System.out.println(loggedInUser.getPurchasedBook(this));
			return 10;
		}
			
		return 0;
	}

	public boolean isSameTitleAs(Book bookToCheck) {
		return this.title.equals(bookToCheck.title);
	}

	public Edition edition() {
		return edition;
	}

	public boolean isSameEdition(Edition edition) {
        if (this.edition.equals(edition))
        	return true;
        
		return false;
	}

}


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
