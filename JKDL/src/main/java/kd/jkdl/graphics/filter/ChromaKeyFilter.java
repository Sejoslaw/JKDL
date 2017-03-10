/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyński 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * A filter which can be used to produce wipes by transferring the luma of a Destination image into the alpha channel of the source.
 */
public class ChromaKeyFilter extends AbstractBufferedImageOp 
{
	private float hTolerance = 0;
	private float sTolerance = 0;
	private float bTolerance = 0;
	private int color;

	public ChromaKeyFilter() 
	{
	}

	/**
	 * Set the tolerance of the image in the range 0..1.
	 * *arg tolerance The tolerance
	 */
	public void setHTolerance( float hTolerance ) 
	{
		this.hTolerance = hTolerance;
	}
	
	public float getHTolerance() 
	{
		return hTolerance;
	}
	
	public void setSTolerance( float sTolerance ) 
	{
		this.sTolerance = sTolerance;
	}
	
	public float getSTolerance() 
	{
		return sTolerance;
	}
	
	public void setBTolerance( float bTolerance ) 
	{
		this.bTolerance = bTolerance;
	}
	
	public float getBTolerance() 
	{
		return bTolerance;
	}
	
	public void setColor( int color ) 
	{
		this.color = color;
	}
	
	public int getColor() 
	{
		return color;
	}
		
    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
        int width = src.getWidth();
        int height = src.getHeight();
        if ( dst == null )
        {
        	dst = createCompatibleDestImage( src, null );
        }
		float[] hsb1 = null;
		float[] hsb2 = null;
		int rgb2 = color;
		int r2 = (rgb2 >> 16) & 0xff;
		int g2 = (rgb2 >> 8) & 0xff;
		int b2 = rgb2 & 0xff;
		hsb2 = Color.RGBtoHSB( r2, b2, g2, hsb2 );
		int[] inPixels = null;
		for ( int y = 0; y < height; y++ ) 
		{
			inPixels = getRGB( src, 0, y, width, 1, inPixels );
			for ( int x = 0; x < width; x++ ) 
			{
				int rgb1 = inPixels[x];

				int r1 = (rgb1 >> 16) & 0xff;
				int g1 = (rgb1 >> 8) & 0xff;
				int b1 = rgb1 & 0xff;
				hsb1 = Color.RGBtoHSB( r1, b1, g1, hsb1 );
				if ( Math.abs( hsb1[0] - hsb2[0] ) < hTolerance && Math.abs( hsb1[1] - hsb2[1] ) < sTolerance && Math.abs( hsb1[2] - hsb2[2] ) < bTolerance )
				{
					inPixels[x] = rgb1 & 0xffffff;
				}
				else
				{
					inPixels[x] = rgb1;
				}
			}
			setRGB( dst, 0, y, width, 1, inPixels );
		}
        return dst;
    }

	public String toString() 
	{
		return "Keying/Chroma Key...";
	}
}