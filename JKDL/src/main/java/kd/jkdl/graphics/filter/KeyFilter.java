/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzy�ski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * An experimental filter which can be used for keying against a clean shot. Given a source image, a clean image and a destination image, 
 * the filter replaces all pixels in the source which nearly equal the equivalent clean pixel by destination pixels.
 */
public class KeyFilter extends AbstractBufferedImageOp 
{
	private float hTolerance = 0;
	private float sTolerance = 0;
	private float bTolerance = 0;
	private BufferedImage destination;
	private BufferedImage cleanImage;

	public KeyFilter() 
	{
	}

	/**
	 * Set the hue tolerance of the image in the range 0..1.
	 * @param hTolerance the tolerance
     * @see #getHTolerance
	 */
	public void setHTolerance( float hTolerance ) 
	{
		this.hTolerance = hTolerance;
	}
	
	/**
	 * Get the hue tolerance.
	 * @return the tolerance
     * @see #setHTolerance
	 */
	public float getHTolerance() 
	{
		return hTolerance;
	}
	
	/**
	 * Set the saturation tolerance of the image in the range 0..1.
	 * @param sTolerance the tolerance
     * @see #getSTolerance
	 */
	public void setSTolerance( float sTolerance ) 
	{
		this.sTolerance = sTolerance;
	}
	
	/**
	 * Get the saturation tolerance.
	 * @return the tolerance
     * @see #setSTolerance
	 */
	public float getSTolerance() 
	{
		return sTolerance;
	}
	
	/**
	 * Set the brightness tolerance of the image in the range 0..1.
	 * @param bTolerance the tolerance
     * @see #getBTolerance
	 */
	public void setBTolerance( float bTolerance ) 
	{
		this.bTolerance = bTolerance;
	}
	
	/**
	 * Get the brightness tolerance.
	 * @return the tolerance
     * @see #setBTolerance
	 */
	public float getBTolerance() 
	{
		return bTolerance;
	}
	
    /**
     * Set the destination image.
     * @param destination the destination image
     * @see #getDestination
     */
	public void setDestination( BufferedImage destination ) 
	{
		this.destination = destination;
	}
	
    /**
     * Get the destination image.
     * @return the destination image
     * @see #setDestination
     */
	public BufferedImage getDestination() 
	{
		return destination;
	}
	
    /**
     * Get the clean image.
     * @param cleanImage the clean image
     * @see #getCleanImage
     */
	public void setCleanImage( BufferedImage cleanImage ) 
	{
		this.cleanImage = cleanImage;
	}
	
    /**
     * Get the clean image.
     * @return the clean image
     * @see #setCleanImage
     */
	public BufferedImage getCleanImage() 
	{
		return cleanImage;
	}
		
    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
        int width = src.getWidth();
        int height = src.getHeight();

        if ( dst == null )
        {
        	dst = createCompatibleDestImage( src, null );
        }

        if ( destination != null && cleanImage != null ) 
        {
            float[] hsb1 = null;
            float[] hsb2 = null;
            int[] inPixels = null;
            int[] outPixels = null;
            int[] cleanPixels = null;
            for ( int y = 0; y < height; y++ ) 
            {
                inPixels = getRGB( src, 0, y, width, 1, inPixels );
                outPixels = getRGB( destination, 0, y, width, 1, outPixels );
                cleanPixels = getRGB( cleanImage, 0, y, width, 1, cleanPixels );
                for ( int x = 0; x < width; x++ ) 
                {
                    int rgb1 = inPixels[x];
                    int out = outPixels[x];
                    int rgb2 = cleanPixels[x];

                    int r1 = (rgb1 >> 16) & 0xff;
                    int g1 = (rgb1 >> 8) & 0xff;
                    int b1 = rgb1 & 0xff;
                    int r2 = (rgb2 >> 16) & 0xff;
                    int g2 = (rgb2 >> 8) & 0xff;
                    int b2 = rgb2 & 0xff;
                    hsb1 = Color.RGBtoHSB( r1, b1, g1, hsb1 );
                    hsb2 = Color.RGBtoHSB( r2, b2, g2, hsb2 );
                    
                    if ( Math.abs( hsb1[0] - hsb2[0] ) < hTolerance && Math.abs( hsb1[1] - hsb2[1] ) < sTolerance && Math.abs( hsb1[2] - hsb2[2] ) < bTolerance )
                    {
                    	inPixels[x] = out;
                    }
                    else
                    {
                    	inPixels[x] = rgb1;
                    }
                }
                setRGB( dst, 0, y, width, 1, inPixels );
            }
        }
        return dst;
    }

	public String toString() 
	{
		return "Keying/Key...";
	}
}