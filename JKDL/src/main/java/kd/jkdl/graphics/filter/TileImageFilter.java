/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

/**
 * A filter which tiles an image into a lerger one.
 */
public class TileImageFilter extends AbstractBufferedImageOp 
{
	private int width;
	private int height;
	protected int tileWidth;
	protected int tileHeight;

	/**
     * Construct a TileImageFilter.
     */
    public TileImageFilter() 
    {
		this(32, 32);
	}

	/**
     * Construct a TileImageFilter.
     * @param width the output image width
     * @param height the output image height
     */
	public TileImageFilter(int width, int height) 
	{
		this.width = width;
		this.height = height;
	}

	/**
     * Set the output image width.
     * @param width the width
     * @see #getWidth
     */
	public void setWidth(int width) 
	{
		this.width = width;
	}

	/**
     * Get the output image width.
     * @return the width
     * @see #setWidth
     */
	public int getWidth() 
	{
		return width;
	}

	/**
     * Set the output image height.
     * @param height the height
     * @see #getHeight
     */
	public void setHeight(int height) 
	{
		this.height = height;
	}

	/**
     * Get the output image height.
     * @return the height
     * @see #setHeight
     */
	public int getHeight() 
	{
		return height;
	}

    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
        int tileWidth = src.getWidth();
        int tileHeight = src.getHeight();

        if ( dst == null ) 
        {
            ColorModel dstCM = src.getColorModel();
			dst = new BufferedImage(dstCM, dstCM.createCompatibleWritableRaster(width, height), dstCM.isAlphaPremultiplied(), null);
		}

		Graphics2D g = dst.createGraphics();
		for ( int y = 0; y < height; y += tileHeight) 
		{
			for ( int x = 0; x < width; x += tileWidth ) 
			{
				g.drawImage( src, null, x, y );
			}
		}
		g.dispose();

        return dst;
    }

	public String toString() 
	{
		return "Tile";
	}
}