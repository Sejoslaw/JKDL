package test.net;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;

import main.java.kd.jkdl.net.CookieHelper;

/**
 * Basic example of how CookieManager works.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestCookieHelper 
{
	public static void main(String[] args) 
			throws IOException 
	{
		CookieHelper ch = new CookieHelper("https://github.com/Sejoslaw");
		List<HttpCookie> cookies = ch.getCookies();
		
		// iterate HttpCookie object
		for(HttpCookie cookie : cookies)
		{
			// gets domain set for the cookie
			System.out.println("Domain: " + cookie.getDomain());
			// gets max age of the cookie
			System.out.println("max age: " + cookie.getMaxAge());
			// gets name cookie
			System.out.println("name of cookie: " + cookie.getName());
			// gets path of the server
			System.out.println("server path: " + cookie.getPath());
			// gets boolean if cookie is being sent with secure protocol
			System.out.println("is cookie secure: " + cookie.getSecure());
			// gets the value of the cookie
			System.out.println("value of cookie: " + cookie.getValue());
			// gets the version of the protocol with which the given cookie is related.
			System.out.println("value of cookie: " + cookie.getVersion());
		}
	}
}