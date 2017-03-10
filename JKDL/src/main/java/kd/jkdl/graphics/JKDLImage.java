package main.java.kd.jkdl.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import main.java.kd.jkdl.exception.JKDLPreviewImageSizeException;

/**
 * Basic class that contains the Image.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class JKDLImage implements Cloneable, Serializable
{
	private static final long serialVersionUID = -4498537092586651760L;
	
	public static final String UNKNOWN_PATH = "unknown";
	
	private String _path;
	private BufferedImage _bufferedImage;
	private int _imageType = BufferedImage.TYPE_INT_ARGB;
	
	public JKDLImage(String path) throws IOException
	{
		this._path = path;
		_bufferedImage = ImageIO.read(new File(path));
	}
	
	public JKDLImage(BufferedImage image)
	{
		this._path = UNKNOWN_PATH;
		this._bufferedImage = image;
	}
	
	public int getImageType()
	{
		return _imageType;
	}
	
	public String getPath()
	{
		return _path;
	}
	
	public BufferedImage getImage()
	{
		return _bufferedImage;
	}
	
	public JKDLImage setImage(BufferedImage image, String path)
	{
		this._bufferedImage = image;
		this._path = path;
		return this;
	}
	
	public boolean writeImage(String formatName) throws IOException
	{
		return writeImage(formatName, _path);
	}
	
	public boolean writeImage(String formatName, String newPath) throws IOException
	{
		return writeImage(_bufferedImage, formatName, newPath);
	}
	
	public boolean writeImage(BufferedImage image, String formatName, String newPath) throws IOException
	{
		return ImageIO.write(image, formatName, new File(newPath));
	}
	
	public int getPictureWidth()
	{
		return _bufferedImage.getWidth();
	}
	
	public int getPictureHeight()
	{
		return _bufferedImage.getHeight();
	}
	
	public JFrame preview() throws JKDLPreviewImageSizeException
	{
		return preview(1);
	}
	
	public JFrame preview(int zoomLevel) throws JKDLPreviewImageSizeException
	{
		return preview("Preview of: " + getPath(), zoomLevel);
	}
	
	public JFrame preview(String frameName, int zoomLevel) throws JKDLPreviewImageSizeException
	{
		return JKDLImageUtils.preview(this, _imageType, frameName, zoomLevel);
	}
	
	@Override
	public JKDLImage clone()
	{
		try 
		{
			if(!getPath().equals(UNKNOWN_PATH))
			{
				return new JKDLImage(getPath());
			}
			else
			{
				return new JKDLImage(getImage());
			}
		} 
		catch (IOException e) 
		{
			return null;
		}
	}
}