/**
*
*/
package main.java;


/**
* @author empkv0
*
*/
public class Book implements Comparable<Book>{

private String title;
private double price;
private Edition edition;


public Book() {
// TODO Auto-generated constructor stub
}




public Book(String title, double price) {
// TODO Auto-generated method stub
this.title = title;
this.price = price;


}

public String getTitle() {
// TODO Auto-generated method stub
return title;

}

public double getPrice() {
// TODO Auto-generated method stub
return price;

}


@Override
public int compareTo(Book o) {
// TODO Auto-generated method stub

return Double.compare(price, o.price);
}


	public Book(String title, Edition edition) {
		this.title = title;
		this.edition = edition;
	}

	public int getDiscount(User loggedInUser) {
		if (loggedInUser != null){
		
			if (loggedInUser.hasPurchasedBook(this)){
//				if (loggedInUser.getPurchasedBook(this).isSameEdition(Edition.KINDLE))
					return 10;
			}

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
