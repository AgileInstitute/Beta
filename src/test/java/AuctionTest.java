package test.java;

import main.java.Auction;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the functionality of the Auction class.
 * 
 *
 */
public class AuctionTest {

	/**
	 * Tests that the user (seller) that created the auction
	 * cannot bid on that auction.
	 */
	@Test
	public void canSellerBidOnOwnAuction() {
		
		String seller = "sellerx";
		Auction auction = new Auction(seller);
		boolean canBid;
		
		canBid = auction.isValidBidder(seller);
		
		Assert.assertFalse(canBid);
		
	}
	
	/**
	 * Tests that a user can bid on an auction.
	 * 
	 */
	@Test
	public void canBidOnAuction() {
		
		String seller = "sellerx";
		String bidder = "bidderx";
		Auction auction = new Auction(seller);
		boolean canBid;
		
		canBid = auction.isValidBidder(bidder);
		
		Assert.assertTrue(canBid);
		
	}
	
    @Test
    public void checkAuctionUpdatePermissions() {
        Auction auction = new Auction("sellerDude");
        Assert.assertFalse(auction.canModify("otherDude"));
    }
    
    @Test
    public void checkAuctionUpdatePermissionsFails() {
        Auction auction = new Auction("sellerDude");
        Assert.assertTrue(auction.canModify("sellerDude"));
       
    }
		
}
