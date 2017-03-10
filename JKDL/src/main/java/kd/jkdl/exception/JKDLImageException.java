package main.java.kd.jkdl.exception;

import main.java.kd.jkdl.graphics.JKDLImage;

/**
 * This Exception is thrown if something went wrong with JKDLImage itself.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class JKDLImageException extends Exception
{
	private static final long serialVersionUID = 658136570275908329L;
	
	private JKDLImage _image;
	
	public JKDLImageException(String message)
	{
		super(message);
		_image = null;
	}
	
	public JKDLImageException(JKDLImage image)
	{
		this._image = image;
	}
	
	public JKDLImage getImage()
	{
		if(_image != null)
		{
			return _image;
		}
		return null;
	}
}