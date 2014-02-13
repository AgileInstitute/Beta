package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A class that simulates an Auction
 *
 */
public class Auction {
    private String seller;
    private Item item;
    private String bidder;
    private String winner;
    private boolean open;
    private int currentBidAmount = 0;
    private int reservePrice;
    private int minBid = 0;
    private int buyItNowAmount = 0;
    private Set<String> bidders = new HashSet<String>();
    private NotifyBidders notifyBidders = new NotifyBidders();

    public Auction(String seller) {
        this.seller = seller;
        this.item = new Item("", "", 0);
    }

    public Auction(String seller, Item item, int minBid, int reserve, int buyItNow) {
        this.seller = seller;
        this.item = item;
        this.minBid = minBid;
        this.reservePrice = reserve;
        this.buyItNowAmount = buyItNow;
    }

    public boolean isValidBidder(String bidder) {return !seller.equals(bidder);}

    /**
     * Return whether the given user can modify this instance of an Auction
     * @param userName
     * @return
     */
    public boolean canModify(String userName) {return userName.equals(seller);}

    public boolean canBid() {return this.isOpen();}

    public boolean makeBid(String bidder, int amount) {
        if (isValidBidder(bidder) && isOpen() && isValidBidAmount(amount)) {
            this.bidder = bidder;
            this.currentBidAmount = amount;
            this.bidders.add(bidder);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isValidBidAmount(int bidAmount) {
        return (bidAmount > currentBidAmount && bidAmount >= minBid);
    }

    public int getCurrentBidAmount() {return currentBidAmount;}
    public void setCurrentBidAmount(int amount) {currentBidAmount = amount;}

    public boolean isOpen() {return open;}
    public void open() throws AuctionNotReadyException {
        if (getDescription().isEmpty() || getQuantity() == 0) {
            throw new AuctionNotReadyException("Missing fields");
        }
        else {
            this.open = true;
        }
    }

    /**
     * Closes the auction.
     *
     */
    public void close() {
        this.open = false;

        if (this.currentBidAmount >= this.reservePrice) {
            this.winner = this.bidder;
            this.notifyBidders();
        }
    }

    public void buyItNow(String buyer) {
        makeBid(buyer, getBuyItNowAmount());
        close();
    }

    public String getCondition() {return item.getCondition();}
    public void setCondition(String condition, String userName) throws AuctionInProgressException {
        if (isOpen()) throw new AuctionInProgressException("Cannot set condition.  Auction is started.");
        if (!userName.equals(seller)) { return; }
        try {
            item.setCondition(condition);
        } catch (FrozenException e) {
            throw new AuctionInProgressException("Cannot set condition.  Item is frozen.");
        }
    }

    public String getDescription() {return item.getDescription();}
    public void setDescription(String description, String userName) throws AuctionInProgressException {
        if (isOpen()) throw new AuctionInProgressException("Cannot set description.  Auction is started.");
        if (!userName.equals(seller)) { return; }
        try {
            item.setDescription(description);
        } catch (FrozenException e) {
            throw new AuctionInProgressException("Cannot set condition.  Item is frozen.");
        }
    }

    public int getQuantity() {return item.getQuantity();}
    public void setQuantity(int quantity, String userName) throws AuctionInProgressException {
        if (isOpen()) throw new AuctionInProgressException("Cannot set quantity.  Auction is started.");
        if (!userName.equals(seller)) { return; }
        try {
            item.setQuantity(quantity);
        } catch (FrozenException e) {
            throw new AuctionInProgressException("Cannot set condition.  Item is frozen.");
        }
    }

    public int getMinBid() {return minBid;}
    public void setMinBid(int minBid, String userName) throws AuctionInProgressException {
        if (isOpen()) throw new AuctionInProgressException("Cannot set bid.  Auction is started.");
        if (!userName.equals(seller)) { return; }
        this.minBid = minBid;
    }

    public void setBuyItNowAmount(int amount, String userName) throws AuctionInProgressException {
        if (isOpen()) throw new AuctionInProgressException("Cannot set Buy It Now.  Auction is started.");
        if (!userName.equals(seller)) { return; }
        buyItNowAmount = amount;
    }
    public int getBuyItNowAmount() { return buyItNowAmount; }

    public int getReservePrice() { return reservePrice; }
    public void setReservePrice(int reservePrice, String userName) throws AuctionInProgressException {
        if (!userName.equals(seller)) { return; }
        if (open) {
            throw new AuctionInProgressException(
                                                 "Reserve price cannot be set once auction is open.");
        } else {
            this.reservePrice = reservePrice;
        }
    }

    public String getWinner() { return winner; }
    private void setWinner(String winner) { this.winner = winner; }

	public void notifyBidders() {
		getNotifyBidders().notifyUsers(this);		
	}

	public Set<String> getBidders() {
		return bidders;
	}

	public NotifyBidders getNotifyBidders() {
		return notifyBidders;
	}

	public void setNotifyBidders(NotifyBidders notifyBidders) {
		this.notifyBidders = notifyBidders;
	}
}
