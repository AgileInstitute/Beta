package main.java;

import java.util.ArrayList;
import java.util.List;

public class Order {
	List<Book> booklist = new ArrayList<Book>();
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
		System.out.println(booklist.size());

		System.out.println(booklist.get(0).getTitle());
		System.out.println(booklist.get(0).getPrice());
		display = display.concat(booklist.get(0).getTitle());
		display = display.concat(" ");
		price = booklist.get(0).getPrice();
		display = display.concat(price.toString());		
		
		return display;
	}

}
