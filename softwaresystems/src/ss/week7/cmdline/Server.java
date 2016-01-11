
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(0);
        }
    	
    	String name = args[0];
    	int port = 0;
    	Socket sock = null;
    	ServerSocket serversock = null;
    	
    	// port part
    	try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[1]
            		           + " is not an integer");
            System.exit(0);
        }
    	
    	// create server socket AND socket
    	try {
			serversock = new ServerSocket(port);
			System.out.println("Waiting for client...");
			sock = serversock.accept();
			System.out.println("Client connected!");
		} catch (IOException e) {
			System.out.println("Could not create ServerSocket on port: " + port);
			System.exit(0);
		}
    	
    	// peer part
    	try {
            Peer server = new Peer(name, sock);
            Thread streamInputHandler = new Thread(server);
            streamInputHandler.start();
            server.handleTerminalInput();
            server.shutDown();
        } catch (IOException e) {
            System.out.println("Connection lost :/");
        }
    }

} // end of class Server
