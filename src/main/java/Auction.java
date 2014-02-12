package main.java;

/**
 * A class that simulates an Auction
 *
 */
public class Auction {
    private String seller;
    private String description = "";
    private String condition;
    private boolean open;
    private int currentBidAmount = 0;
    private int quantity = 0;
    private int minBid;

    public Auction(String seller) {this.seller = seller;}

    public boolean isValidBidder(String bidder) {return !seller.equals(bidder);}

    /**
     * Return whether the given user can modify this instance of an Auction
     * @param userName
     * @return
     */
    public boolean canModify(String userName) {return userName.equals(seller);}

    public boolean canBid() {return this.isOpen();}

    public boolean makeBid(String bidder, int amount) {
        if (isValidBidder(bidder)) {
            return amount > currentBidAmount;
        }
        else {
            return false;
        }
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
    public void close() {this.open = false;}

    public String getCondition() {return condition;}
    public void setCondition(String condition) throws AuctionInProgressException {
        if (isOpen()) throw new AuctionInProgressException("Cannot set condition.  Auction is started.");
        this.condition = condition;
    }

    public String getDescription() {return description;}
    public void setDescription(String description) throws AuctionInProgressException {
        if (isOpen()) throw new AuctionInProgressException("Cannot set description.  Auction is started.");
        this.description = description;
    }

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) throws AuctionInProgressException {
        if (isOpen()) throw new AuctionInProgressException("Cannot set quantity.  Auction is started.");
        this.quantity = quantity;
    }

    public int getMinBid() {return minBid;}
    public void setMinBid(int minBid) throws AuctionInProgressException {
        if (isOpen()) throw new AuctionInProgressException("Cannot set bid.  Auction is started.");
        this.minBid = minBid;
    }
}
