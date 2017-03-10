package main.java.kd.jkdl.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import main.java.kd.jkdl.exception.JKDLPreviewImageSizeException;

/**
 * Class which is use to modify the object of {@link JKDLImage} class.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class JKDLImageHelper
{
	private JKDLImage _image;
	private int imageType = BufferedImage.TYPE_INT_ARGB;
	
	public JKDLImageHelper(JKDLImage image)
	{
		this._image = image;
	}
	
	public JKDLImage getImage()
	{
		return _image;
	}
	
	public int getImageType()
	{
		return imageType;
	}
	
	public void setRGBA(int xCoord, int yCoord, int r, int g, int b, int a)
	{
		this._image.getImage().setRGB(xCoord, yCoord, JKDLColor.getRGBA(r, g, b, a));
	}
	
	public int getR(int xCoord, int yCoord)
	{
		return JKDLColor.getColor(_image.getImage().getRGB(xCoord, yCoord)).getRed();
	}
	
	public int getG(int xCoord, int yCoord)
	{
		return JKDLColor.getColor(_image.getImage().getRGB(xCoord, yCoord)).getGreen();
	}
	
	public int getB(int xCoord, int yCoord)
	{
		return JKDLColor.getColor(_image.getImage().getRGB(xCoord, yCoord)).getBlue();
	}
	
	public int getA(int xCoord, int yCoord)
	{
		return JKDLColor.getColor(_image.getImage().getRGB(xCoord, yCoord)).getAlpha();
	}
	
	public void saveImage(String formatName) throws IOException
	{
		saveImage(formatName, _image.getPath());
	}
	
	public void saveImage(String formatName, String newPath) throws IOException
	{
		BufferedImage bi = _image.getImage(); //compile();
		ImageIO.write(bi, formatName, new File(newPath));
	}
	
	public int getRGB(int xCoord, int yCoord)
	{
		return _image.getImage().getRGB(xCoord, yCoord);
	}

	public JFrame preview() throws JKDLPreviewImageSizeException
	{
		return preview(1);
	}
	
	public JFrame preview(int zoomLevel) throws JKDLPreviewImageSizeException
	{
		return JKDLImageUtils.preview(_image, imageType, "Preview of modified: " + _image.getPath(), zoomLevel);
	}
}