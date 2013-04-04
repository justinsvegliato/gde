package gde;

import gde.util.SocketUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listener {
    
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

    private static int localPort = 8746;
    
    private Listener() {
    }
    
//    static {
//        InputStream inputStream = Listener.class.getClassLoader().getResourceAsStream("resources/listener.properties");
//        Properties listenerProperties = new Properties();
//        try {
//            listenerProperties.load(inputStream);
//            localPort = Integer.parseInt(listenerProperties.getProperty("localPort"));            
//        } catch (IOException e) {
//            System.exit(1);
//        } finally {
//            SocketUtils.close(inputStream);
//        }
//    }

    public static void main(String[] args) {
        listen();
    }

    private static void listen() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(localPort);
            logger.debug("Opened ServerSocket on port [" + localPort + "]");
        } catch (IOException ioe) {
            logger.error("Failed to open ServerSocket on port [" + localPort + "]", ioe);
            return;
        }
        
        Socket clientSocket = null;
        BufferedReader bufferedReader = null;
        RequestHandler requestHandler = new RequestHandler();
        try {
            logger.debug("Initialized and ready to receive messages from game client");
            String clientRequest;
            while (true) {
                clientSocket = serverSocket.accept();
                logger.debug("Established connection with game client");
                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                while ((clientRequest = bufferedReader.readLine()) != null) {
                    logger.debug("Received request from game client");
                    requestHandler.handleRequest(clientRequest);
                }
            }
        } catch (IOException e) {
            logger.error("IOException encountered while working with the ServerSocket or ClientSocket", e);
        } catch (Throwable t) {
            logger.error("Throwable caught for logging purposes", t);
        } finally {
            SocketUtils.close(bufferedReader);
            SocketUtils.close(clientSocket);
            SocketUtils.close(serverSocket);
        }
    }
}