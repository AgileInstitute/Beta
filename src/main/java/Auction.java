package main.java;

/**
 * A class that simulates an Auction
 *
 */
public class Auction {

	private String seller;
	
	public Auction(String seller) {
		
		this.seller = seller;
		
	}
	
	public boolean isValidBidder(String bidder) {
		
		return !seller.equals(bidder);
		
	}
	
    /**
     * Return whether the given user can modify this instance of an Auction
     * @param userName
     * @return
     */
    public boolean canModify(String userName) {
        return userName.equals(seller);
    }

    public boolean canBid() {
        return true;
    }
    public boolean makeBid(String bidder, int amount) {
        return ! canModify(bidder);
    }
}
