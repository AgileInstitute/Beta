package main.java;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class NotifyBidders {

	String winnerMessage = "You Won!";
	String loserMessage = "You Lost!";
	Map<String, String> notifications = new HashMap<String, String>();

	protected Map<String, String> notifySent() {
		return notifications;
	}

	public void notifyUsers(Auction auction) {
		
		Set<String> bidders = auction.getBidders();
		for (String bidder : bidders) {
			if (bidder.equals(auction.getWinner())) {
				notifications.put(bidder, getWinningNotification());
			} else {
				notifications.put(bidder, getLosingNotification());
			}
		}
		
	}

	protected String getWinningNotification() {
		return winnerMessage;
	}

	protected String getLosingNotification() {
		return loserMessage;
	}

}
