package main.java.kd.jkdl.graphics.filter;

import java.io.IOException;

import main.java.kd.jkdl.exception.JKDLPreviewImageSizeException;
import main.java.kd.jkdl.graphics.JKDLImage;

/**
 * This class contains various methods to operate on Java Filters.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class JKDLFilterUtils 
{
	private JKDLFilterUtils()
	{
	}
	
	public static JKDLImage previewImageBeforeAndAfterFiltr(String pathToImage, AbstractBufferedImageOp abiop) 
			throws IOException, JKDLPreviewImageSizeException
	{
		return previewImageBeforeAndAfterFiltr(pathToImage, abiop, 1);
	}

	public static JKDLImage previewImageBeforeAndAfterFiltr(String pathToImage, AbstractBufferedImageOp filtr, int zoomLevel) 
			throws IOException, JKDLPreviewImageSizeException
	{
		if(zoomLevel <= 0)
		{
			throw new JKDLPreviewImageSizeException(String.valueOf(zoomLevel));
		}
		JKDLImage imageBefore = new JKDLImage(pathToImage);
		imageBefore.preview("Preview Before", zoomLevel);
		JKDLImage imageAfter = new JKDLImage(filtr.filter(imageBefore.getImage(), imageBefore.getImage()));
		imageAfter.preview("Preview After", zoomLevel);
		return imageAfter;
	}
}