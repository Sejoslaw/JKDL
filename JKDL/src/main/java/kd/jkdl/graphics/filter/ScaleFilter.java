/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

/**
 * Scales an image using the area-averaging algorithm, which can't be done with AffineTransformOp.
 */
public class ScaleFilter extends AbstractBufferedImageOp 
{
	private int width;
	private int height;

    /**
     * Construct a ScaleFilter.
     */
	public ScaleFilter() 
	{
		this(32, 32);
	}

    /**
     * Construct a ScaleFilter.
     * @param width the width to scale to
     * @param height the height to scale to
     */
	public ScaleFilter( int width, int height ) 
	{
		this.width = width;
		this.height = height;
	}

    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
		if ( dst == null ) 
		{
			ColorModel dstCM = src.getColorModel();
			dst = new BufferedImage(dstCM, dstCM.createCompatibleWritableRaster( width, height ), dstCM.isAlphaPremultiplied(), null);
		}
		
		Image scaleImage = src.getScaledInstance( width, height, Image.SCALE_AREA_AVERAGING );
		Graphics2D g = dst.createGraphics();
		g.drawImage( scaleImage, 0, 0, width, height, null );
		g.dispose();
		
        return dst;
    }

	public String toString() 
	{
		return "Distort/Scale";
	}
}