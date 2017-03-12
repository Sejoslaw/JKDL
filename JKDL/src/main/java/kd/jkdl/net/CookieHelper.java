package main.java.kd.jkdl.net;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Register and store data about all cookies from given URL.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * 
 * @see {@link HttpCookie}
 * @see {@link CookieManager}
 * @see {@link CookieStore}
 */
public class CookieHelper 
{
	/**
	 * Given URL.
	 */
	private final URL _url;
	
	/**
	 * Registered CookieManager.
	 */
	private final CookieManager _cookieManager = new CookieManager();
	
	/**
	 * CookieStore contains all data about retrieved Cookies.
	 */
	private final CookieStore _cookieStore;
	
	public CookieHelper(String url) 
			throws IOException
	{
		this(new URL(url));
	}
	
	public CookieHelper(URL url) 
			throws IOException
	{
		this._url = url;
		
		CookieHandler.setDefault(this._cookieManager); // Sets CookieManager
		URLConnection conn = this._url.openConnection(); // Opens URLConnection
		conn.getContent(); // Retrieves content from connection
		this._cookieStore = this._cookieManager.getCookieStore(); // Returns CookieStore from the CookieManager
	}
	
	/**
	 * @return Returns URL connected with this CookieHelper.
	 */
	public URL getURL()
	{
		return this._url;
	}
	
	/**
	 * @param uri
	 * @param cookie
	 * 
	 * @see {@link CookieStore#add(URI, HttpCookie)}
	 */
	public void add(URI uri, HttpCookie cookie)
	{
		this._cookieStore.add(uri, cookie);
	}
	
	/**
	 * @return Returns List of all Cookies from the given URL.
	 */
	public List<HttpCookie> getCookies()
	{
		return this._cookieStore.getCookies();
	}
	
	/**
	 * @return Returns an immutable list of URIs;
	 * 
	 * @see {@link CookieStore#getURIs()}
	 */
	public List<URI> getURIs()
	{
		return this._cookieStore.getURIs();
	}
}