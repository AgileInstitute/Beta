package main.java;

public class FrozenException extends Exception {
    public FrozenException(){ super(); }

    public FrozenException(String message){
        super(message);
    }
}
