package test.java;

import main.java.Auction;
import main.java.AuctionInProgressException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the functionality of the Auction class.
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
        boolean result = auction.isValidBidder(seller);

        Assert.assertFalse(result);
    }

    /**
     * Tests that a user can bid on an auction.
     */
    @Test
    public void canUserBidOnAuction() {
        String seller = "sellerx";
        String bidder = "bidderx";
        Auction auction = new Auction(seller);
        boolean result = auction.isValidBidder(bidder);

        Assert.assertTrue(result);
    }

    @Test
    public void checkAuctionUpdateRestriction() {
        Auction auction = new Auction("sellerDude");

        Assert.assertFalse(auction.canModify("otherDude"));
    }

    @Test
    public void checkAuctionUpdatePermission() {
        Auction auction = new Auction("sellerDude");

        Assert.assertTrue(auction.canModify("sellerDude"));
    }

    @Test
    public void noBidUntilAuctionOpens() {
    	Auction auction = new Auction("sellerx");
    	Assert.assertFalse(auction.canBid());
    }

    @Test
    public void canBidWhenOpen() {
        Auction auction = new Auction("seller");
        auction.open();

        Assert.assertTrue(auction.canBid());
    }

    @Test
    public void noBidOnClosedAuction() {
    	Auction auction = new Auction("sellerx");
    	auction.close();

    	Assert.assertFalse(auction.canBid());
    }

    @Test
    public void AllowBidder() {
        //Given
        Auction auction = new Auction("seller");
        String bidder = "Moneybags";
        int amount = 10;

        //When
        boolean result = auction.makeBid(bidder, amount);

        Assert.assertTrue(result);
    }

    @Test
    public void PreventBidder() {
        //Given
        String bidder = "seller";
        Auction auction = new Auction(bidder);
        int amount = 10;

        //When
        boolean result = auction.makeBid(bidder, amount);

        Assert.assertFalse("Bidding on my own Auction", result);
    }

    @Test
    public void disallowInsufficientBidder() {
        //Given
        Auction auction = new Auction("seller");
        int amount = 10;
        auction.setCurrentBidAmount(amount);
        String new_bidder = "new bidder";

        //When
        boolean result = auction.makeBid(new_bidder, amount);

        Assert.assertFalse("Bid was not greater than current", result);
    }

    @Test
    public void allowLargerBidder() {
        //Given
        Auction auction = new Auction("seller");
        int amount = 10;
        auction.setCurrentBidAmount(amount);
        String new_bidder = "new bidder";

        //When
        boolean result = auction.makeBid(new_bidder, amount + 1);

        Assert.assertTrue("Bid should have been acceptable",
                          result);
    }
    
    @Test
    public void conditionSetOnOpenAuction() {
    	String bidder = "seller";
    	String condition = "Awesome!";
    	Auction auction = new Auction(bidder);
    	auction.open();
    	boolean exceptionCaught = false;
    	try {
    		auction.setCondition(condition);
		}
    	catch (AuctionInProgressException e) {
    		exceptionCaught = true;
		}
    	
    	Assert.assertTrue(exceptionCaught);
    }
    
    @Test
    public void conditionSetOnNotOpenAuction() {
    	String bidder = "seller";
    	String condition = "Awesome!";
    	Auction auction = new Auction(bidder);
    	boolean exceptionCaught = false;
    	try {
    		auction.setCondition(condition);
		}
    	catch (AuctionInProgressException e) {
    		exceptionCaught = true;
		}
    	
    	Assert.assertFalse(exceptionCaught);
    	Assert.assertEquals(condition, auction.getCondition());
    }

    @Test
    public void minBidSetOnOpenAuction() {
    	String bidder = "seller";
    	Auction auction = new Auction(bidder);
    	auction.open();
    	boolean exceptionCaught = false;
    	try {
    		auction.setMinBid(100);
		}
    	catch (AuctionInProgressException e) {
    		exceptionCaught = true;
		}
    	
    	Assert.assertTrue(exceptionCaught);
    }
    
    @Test
    public void minBidSetOnNotOpenAuction() {
    	String bidder = "seller";
    	int bid = 100;
    	Auction auction = new Auction(bidder);
    	boolean exceptionCaught = false;
    	try {
    		auction.setMinBid(bid);
		}
    	catch (AuctionInProgressException e) {
    		exceptionCaught = true;
		}
    	
    	Assert.assertFalse(exceptionCaught);
    	Assert.assertEquals(bid, auction.getMinBid());
    }
    
    @Test
    public void descriptionSetOnOpenAuction() {
    	String bidder = "seller";
    	Auction auction = new Auction(bidder);
    	auction.open();
    	boolean exceptionCaught = false;
    	try {
    		auction.setDescription("My description");
		}
    	catch (AuctionInProgressException e) {
    		exceptionCaught = true;
		}
    	
    	Assert.assertTrue(exceptionCaught);
    }
    
    @Test
    public void descriptionSetOnNotOpenAuction() {
    	String bidder = "seller";
    	String descr = "My description";
    	Auction auction = new Auction(bidder);
    	boolean exceptionCaught = false;
    	try {
    		auction.setDescription(descr);
		}
    	catch (AuctionInProgressException e) {
    		exceptionCaught = true;
		}
    	
    	Assert.assertFalse(exceptionCaught);
    	Assert.assertEquals(descr, auction.getDescription());
    }
    
    @Test
    public void quantitySetOnOpenAuction() {
    	String bidder = "seller";
    	Auction auction = new Auction(bidder);
    	auction.open();
    	boolean exceptionCaught = false;
    	try {
    		auction.setQuantity(100);
		}
    	catch (AuctionInProgressException e) {
    		exceptionCaught = true;
		}
    	
    	Assert.assertTrue(exceptionCaught);
    }
    
    @Test
    public void quantitySetOnNotOpenAuction() {
    	String bidder = "seller";
    	Auction auction = new Auction(bidder);
    	boolean exceptionCaught = false;
    	try {
    		auction.setQuantity(100);
		}
    	catch (AuctionInProgressException e) {
    		exceptionCaught = true;
		}
    	
    	Assert.assertFalse(exceptionCaught);
    	Assert.assertEquals(100, auction.getQuantity());
    }
}
