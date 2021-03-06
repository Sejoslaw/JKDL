package main.java.kd.jkdl.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Some useful Java Socket API methods.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyński</a> -> https://github.com/Sejoslaw
 * 
 * @see {@link <a href="http://cs.lmu.edu/~ray/notes/javanetexamples/">Java Socket Programming Examples</a>}
 */
public class JSocket 
{
	/**
	 * @return Returns new ServerSocket.
	 * 
	 * @throws IOException
	 * 
	 * @see ServerSocket
	 */
	public static ServerSocket newServerSocket(int port) 
			throws IOException
	{
		return new ServerSocket(port);
	}
	
	/**
	 * @return Returns new InetAddress.
	 * 
	 * @throws UnknownHostException
	 * 
	 * @see {@link InetAddress#getByName(String)}
	 * @see InetAddress
	 */
	public static InetAddress newInetAddress(String host) 
			throws UnknownHostException
	{
		return InetAddress.getByName(host);
	}
	
	/**
	 * @return Returns new Socket.
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 * 
	 * @see Socket
	 */
	public static Socket newSocket(String host, int port) 
			throws UnknownHostException, IOException
	{
		return new Socket(host, port);
	}
}