package test.java;
import main.java.Bid;
import main.java.Auction;
import org.junit.Assert;
import org.junit.Test;

public class BidTest {
	@Test
	public void BidIsValid()
	{
		Auction auction = new Auction("seller");
		auction.open();
		Bid bid = new Bid("bidder");
		int currentBid = auction.getCurrentBid();
		bid.setAmount(currentBid += 1);
		Assert.assertTrue("", auction.PlaceBid(bid));
	}
}
