/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

/**
 * Scales an image using bi-cubic interpolation, which can't be done with AffineTransformOp.
 */
public class BicubicScaleFilter extends AbstractBufferedImageOp 
{
	private int width;
	private int height;

	/**
     * Construct a BicubicScaleFilter which resizes to 32x32 pixels.
     */
    public BicubicScaleFilter() 
    {
		this(32, 32);
	}

	/**
	 * Constructor for a filter which scales the input image to the given width and height using bicubic interpolation.
	 * Unfortunately, it appears that bicubic actually looks worse than bilinear interpolation on most Java implementations,
	 * but you can be the judge.
     * @param width the width of the output image
     * @param height the height of the output image
	 */
	public BicubicScaleFilter( int width, int height ) 
	{
		this.width = width;
		this.height = height;
	}

    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
    	if ( dst == null ) 
    	{
			ColorModel dstCM = src.getColorModel();
			dst = new BufferedImage(dstCM, dstCM.createCompatibleWritableRaster(width, height), dstCM.isAlphaPremultiplied(), null);
		}
		Graphics2D g = dst.createGraphics();
		g.setRenderingHint( RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC );
		g.drawImage( src, 0, 0, width, height, null );
		g.dispose();
        return dst;
    }

	public String toString() 
	{
		return "Distort/Bicubic Scale";
	}
}