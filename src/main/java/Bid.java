package main.java;

public class Bid {
	private int amount;
	private String bidder;
	
	public Bid(String userName)
	{
		this.bidder = userName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
