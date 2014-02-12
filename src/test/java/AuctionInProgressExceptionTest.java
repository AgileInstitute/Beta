package test.java;


import main.java.AuctionInProgressException;

import org.junit.Assert;
import org.junit.Test;

public class AuctionInProgressExceptionTest {

    @Test
    public void testConstructs() {
        AuctionInProgressException aipe = new AuctionInProgressException("foo bar");
        Assert.assertEquals("foo bar", aipe.getMessage());
    }

}
