package test.java;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;
import main.java.Auction;
import main.java.NotifyBidders;

import org.junit.Test;

public class NotifyBiddersTest {

	public class MockNotifyBidders extends NotifyBidders {

		public String getWinningNotification() {
			return super.getWinningNotification();
		}
		public String getLosingNotification() {
			return super.getLosingNotification();
		}
		public Map<String, String> notifySent() {
			return super.notifySent();
		}
	}
	
	@Test
	public void testNotify() {
	
		MockNotifyBidders notify = notifyBidders();
		
		// Then: success == no exception thrown
		// set notify flag on bidder map
		Assert.assertTrue(notify.notifySent().containsKey("bidder1"));
		Assert.assertTrue(notify.notifySent().containsKey("bidder2"));		
		
	}

	@Test
	public void winnerNotifiedProperly() {
		
		MockNotifyBidders notify = notifyBidders();
		String winningNotificationActual = notify.notifySent().get("bidder2");
		String winningNotificationExpected = notify.getWinningNotification();
		String losingNotificationActual = notify.notifySent().get("bidder1");
		String losingNotificationExpected = notify.getLosingNotification();
		
		// Then: success == no exception thrown
		// set notify flag on bidder map
		Assert.assertEquals("Should be winning message.",
				winningNotificationExpected, winningNotificationActual);		
		Assert.assertEquals("Should be losing message.",
				losingNotificationExpected, losingNotificationActual);		
		
	}

	private MockNotifyBidders notifyBidders() {
		// Given: closed auction, and bidders
		Set<String> bidders = new HashSet<String>();
		bidders.add("bidder1");
		bidders.add("bidder2");
		
		Auction auction = mock(Auction.class);
		given(auction.getWinner()).willReturn("bidder2");
		given(auction.getBidders()).willReturn(bidders);
		
		MockNotifyBidders notify = new MockNotifyBidders();
		
		// When: notify is called
		notify.notifyUsers(auction);
		return notify;
	}
		
}
