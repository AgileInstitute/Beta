package main.java;

import java.util.ArrayList;
import java.util.List;

public class Order {
	List<Book> booklist = new ArrayList<Book>();
    String reason = "";
	Double discount_val=(double) 0;
	public Order() {
		

		}

	
	public boolean addBook(Book newBook) {
		// TODO Auto-generated method stub
		booklist.add(newBook);
		return true;
	}


	public String displayList() {
		String display = "Title Price "; 
		Double price;

		for(int size = 0; size < booklist.size(); size = size +1){
		display = display.concat(booklist.get(size).getTitle());
		display = display.concat(" ");
		price = booklist.get(size).getPrice();
		display = display.concat(price.toString());		
		display = display.concat(" ");	
		}
		if (discount_val != 0){
		display = display.concat(reason);	
		display = display.concat(" -");	
		display = display.concat(discount_val.toString());
		}
		
		return display;
	}


	public void addDiscount(String discription, double discount) {
		
		discount_val = discount;
		reason= discription;
		return;
	}


	public Double getSubTotal() {
		Double priceTotal = 0.0 ;

		for(int size = 0; size < booklist.size(); size = size +1){	
			priceTotal += booklist.get(size).getPrice();
		}
		priceTotal -= discount_val;
		return priceTotal;
	}

}
