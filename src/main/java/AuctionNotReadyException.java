package main.java;

public class AuctionNotReadyException extends Exception {
    public AuctionNotReadyException(String message){
        super(message);
    }
}
