package main.java.kd.jkdl.graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.kd.jkdl.exception.JKDLPreviewImageSizeException;

/**
 * Class which contains static methods to modify the JKDLImage.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class JKDLImageUtils
{
	private JKDLImageUtils()
	{
	}
	
	public static boolean isPointInsideImage(int minX, int maxX, int minY, int maxY, Point point)
	{
		if((minX <= point.getX()) && (point.getX() <= maxX))
		{
			if((minY <= point.getY()) && (point.getY() <= maxY))
			{
				return true;
			}
		}
		return false;
	}
	
	public static JKDLImage[][] getSprites(String path, int countX, int countY) throws IOException
	{
		JKDLImage img = new JKDLImage(path);
		int width = img.getPictureWidth();
		int height = img.getPictureHeight();
		int sizeX = width / countX; // width of one sprite
		int sizeY = height / countY; // height of one sprite
		JKDLImage[][] images = new JKDLImage[countX][countY];
		for(int x = 0; x < countX; x++)
		{
			for(int y = 0; y < countY; y++)
			{
				JKDLImage bi = new JKDLImage(new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB));
				images[x][y] = bi;
			}
		}
		return images;
	}
	
	/**
	 * 
	 * @param imageToRotate
	 * @param angle - will be converted to radians
	 * @return graphics of rotated picture
	 * @throws PreviewImageSizeException zoomLevel must be bigger or equal 1
	 */
	public static Graphics2D rotateImage(JKDLImage JKDLImage, double angle, boolean preview, int zoomLevel) 
			throws JKDLPreviewImageSizeException
	{
		BufferedImage imageToRotate = JKDLImage.getImage();
		
		double radians = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        
        int newWidth = (int)Math.round(imageToRotate.getWidth() * cos + imageToRotate.getHeight() * sin);
        int newHeight = (int)Math.round(imageToRotate.getWidth() * sin + imageToRotate.getHeight() * cos);
        
        BufferedImage rotate = null;
        if(!preview)
        {
        	rotate = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        }
        else
        {
        	rotate = new BufferedImage(newWidth * zoomLevel, newHeight * zoomLevel, BufferedImage.TYPE_INT_ARGB);
        }
        
        Graphics2D g2d = rotate.createGraphics();
        
        int x = (newWidth - imageToRotate.getWidth()) / 2;
        int y = (newHeight - imageToRotate.getHeight()) / 2;
        
        AffineTransform at = new AffineTransform();
        at.setToRotation(radians, x + (rotate.getWidth() / 2), y + (rotate.getHeight() / 2));
        at.translate(x, y);
        g2d.setTransform(at);
        
        if(preview)
        {
        	if(zoomLevel <= 0)
    		{
        		throw new JKDLPreviewImageSizeException(String.valueOf(zoomLevel));
    		}
        	
        	JLabel label = new JLabel(new ImageIcon(rotate));
        	JPanel panel = new JPanel();
        	g2d.drawImage(imageToRotate, 0, 0, newWidth * zoomLevel, newHeight * zoomLevel, panel);
        	g2d.dispose();
        	panel.add(label);
        	
        	JFrame frame = new JFrame("Preview of: " + JKDLImage.getPath());
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(newWidth * zoomLevel, newHeight * zoomLevel);
    		frame.add(panel);
    		frame.pack();
    		frame.setVisible(true);
        }
        return g2d;
	}
	
	public static JKDLImage flipVertically(JKDLImage JKDLImage) 
	{
		BufferedImage imageToFlip = JKDLImage.getImage();
		AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
		tx.translate(0, -imageToFlip.getHeight(null));
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		imageToFlip = op.filter(imageToFlip, null);
		JKDLImage.setImage(imageToFlip, JKDLImage.getPath());
		return JKDLImage;
	}
	
	public static JKDLImage flipHorizontally(JKDLImage JKDLImage)
	{
		BufferedImage image = JKDLImage.getImage();
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		JKDLImage.setImage(image, JKDLImage.getPath());
		return JKDLImage;
	}
	
	public static JKDLImage flip180Degree(JKDLImage JKDLImage)
	{
		BufferedImage image = JKDLImage.getImage();
		AffineTransform tx = AffineTransform.getScaleInstance(-1, -1);
		tx.translate(-image.getWidth(null), -image.getHeight(null));
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		JKDLImage.setImage(image, JKDLImage.getPath());
		return JKDLImage;
	}
	
	public static JFrame preview(JKDLImage image, int imageType, String frameName) 
			throws JKDLPreviewImageSizeException
	{
		return preview(image, imageType, frameName, 1);
	}
	
	public static JFrame preview(JKDLImage JKDLImage, int imageType, String frameName, int zoomLevel) 
			throws JKDLPreviewImageSizeException
	{
		if(zoomLevel <= 0)
		{
			throw new JKDLPreviewImageSizeException(String.valueOf(zoomLevel));
		}
		
		BufferedImage image = JKDLImage.getImage();

		int newImageWidth = image.getWidth() * zoomLevel;
		int newImageHeight = image.getHeight() * zoomLevel;
		BufferedImage resizedImage = new BufferedImage(newImageWidth , 
				newImageHeight, 
				imageType);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(image, 0, 0, newImageWidth , newImageHeight , null);
		g.dispose();
		
		JLabel picLabel = new JLabel(new ImageIcon(resizedImage));
		
		JFrame frame = new JFrame(frameName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(image.getWidth(), image.getHeight());
		frame.add(picLabel);
		frame.pack();
		frame.setVisible(true);
		return frame;
	}
	
	public static JFrame createNewFrame(String frameName, int width, int height, boolean visible)
	{
		JFrame frame = new JFrame(frameName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		
		if(visible == true)
		{
			frame.pack();
		}
		
		frame.setVisible(visible);
		return frame;
	}
}