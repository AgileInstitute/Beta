package test.java;

import main.java.Auction;

import org.junit.Assert;
import org.junit.Test;

public class AuctionTest {

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
