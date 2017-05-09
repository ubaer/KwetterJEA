package main.java.websocket;

import java.io.Serializable;

/**
 * Simple POJO used for communicating through websockets.
 * @author jgeenen
 */
public class Message implements Serializable{
    
    private String text;
    
    public Message(){}

    public Message(String text) {
        this.text=text;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
