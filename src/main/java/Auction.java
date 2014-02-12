package main.java;

/**
 * A class that simulates an Auction
 *
 */
public class Auction {
    private String seller;
    private boolean open;
    private int currentBidAmount = 0;

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
        return this.isOpen();
    }
    public boolean makeBid(String bidder, int amount) {
        if (isValidBidder(bidder)) {
            return amount > currentBidAmount;
        }
        else {
            return false;
        }
    }

    public void setCurrentBidAmount(int amount) {
        currentBidAmount = amount;
    }

    public boolean isOpen() {
        return open;
    }

    public void open() {
        this.open = true;
    }

    /**
     * Closes the auction.
     *
     */
    public void close() {
        this.open = false;
    }

}
