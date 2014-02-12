package main.java;

/**
 * A class that simulates an Auction
 *
 */
public class Auction {
    private String seller;
    private String bidder;
    private String description = "";
    private String condition;
    private String winner;
    private boolean open;
    private int currentBidAmount = 0;
    private int quantity = 0;
    private int reservePrice;
    private int minBid;
    private int buyItNowAmount = 0;

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
        if (isValidBidder(bidder) && canBid() && amount > currentBidAmount && amount >= minBid) {
            this.bidder = bidder;
            this.currentBidAmount = amount;
            return true;
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
    public void close() {  	
        this.open = false;

        if (this.currentBidAmount > this.reservePrice) {
	        this.winner = this.bidder;
    	}
    }

    public void buyItNow(String buyer) {
        makeBid(buyer, getBuyItNowAmount());
        close();
    }
    public String winner() { return bidder; }

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

    public void setBuyItNowAmount(int amount) throws AuctionInProgressException {
        if (isOpen()) throw new AuctionInProgressException("Cannot set Buy It Now.  Auction is started.");
        buyItNowAmount = amount;
    }
    public int getBuyItNowAmount() { return buyItNowAmount; }

	public int getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(int reservePrice) {
		this.reservePrice = reservePrice;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
}
