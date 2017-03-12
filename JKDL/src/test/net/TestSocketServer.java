package test.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import main.java.kd.jkdl.net.JSocket;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class TestSocketServer
{
	/**
     * Runs the server.
     */
    public static void main(String[] args) 
    		throws IOException 
    {
        ServerSocket listener = JSocket.newServerSocket(9090);
        try 
        {
            while(true) 
            {
                Socket socket = listener.accept();
                try 
                {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } 
                finally 
                {
                    socket.close();
                }
            }
        }
        finally 
        {
            listener.close();
        }
    }
}