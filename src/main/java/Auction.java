package main.java;

/**
 * A class that simulates an Auction
 * 
 * @author dcroley
 *
 */
public class Auction {

    /**
     * The Auction owner name
     */
    private String owner = "";
    
    public Auction(String userName) {
        owner = userName;
    }
    
    /**
     * Return whether the given user can modify this instance of an Auction
     * @param userName
     * @return
     */
    public boolean canModify(String userName) {
        return userName.equals(owner);
    }
    
    public boolean canBid() {
        return true;
    }
    
}
