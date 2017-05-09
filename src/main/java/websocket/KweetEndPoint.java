package main.java.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by Kevin.
 */
@ServerEndpoint(value = "/kweetEndPoint")
public class KweetEndPoint{

    private static final Logger LOG = Logger.getLogger(KweetEndPoint.class.getName());
    private static final Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

    static {
        LOG.setLevel(Level.ALL);
    }
    @OnOpen
    public void onOpen(Session client) {
        LOG.info("WebSocket Connection opened ...");
        clients.add(client);
    }

    @OnClose
    public void onClose(Session client) {
        LOG.info("WebSocket Connection closed ...");
        clients.remove(client);
    }

    @OnError
    public void onError(Throwable t) {
        LOG.log(Level.INFO, "WebSocket Error ...{0}", t.getMessage());
    }

    @OnMessage
    public void onMessage(final Session client, final String message) {
        if (message != null) {
            System.out.println("message");
            sendMessage(client, message);
            /*
                Als het in de toekomst wenselijk is, is hier een mogelijkheid om de kweet te persisten die gekregen is via de websockets.
             */
        }
    }

    private void sendMessage(Session client, String message) {
        try{
            if(client.isOpen()) {
                client.getBasicRemote().sendObject(message);
            }
            else {
                LOG.log(Level.INFO, "WebSocket message not send, no open connection");
            }
        } catch (EncodeException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToAllClients(String message){
        for(Session client : clients){
            sendMessage(client, message);
        }
    }
}
