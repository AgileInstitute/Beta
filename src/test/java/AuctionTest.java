package test.java;

import main.java.Auction;

import org.junit.Assert;
import org.junit.Test;

public class AuctionTest {

	@Test
	public void canSellerBidOnOwnAuction() {
		
		String seller = "sellerx";
		Auction auction = new Auction(seller);
		boolean canBid;
		
		canBid = auction.isValidBidder(seller);
		
		Assert.assertFalse(canBid);
		
	}
	
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
