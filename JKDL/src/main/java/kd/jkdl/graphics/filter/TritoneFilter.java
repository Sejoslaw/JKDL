/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.image.BufferedImage;

/**
 * A filter which performs a tritone conversion on an image. Given three colors for shadows, midtones and highlights,
 * it converts the image to grayscale and then applies a color mapping based on the colors.
 */
public class TritoneFilter extends PointFilter 
{
	private int shadowColor = 0xff000000;
	private int midColor = 0xff888888;
	private int highColor = 0xffffffff;
    private int[] lut;
	
    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
        lut = new int[256];
        for ( int i = 0; i < 128; i++ ) 
        {
            float t = i / 127.0f;
            lut[i] = ImageMath.mixColors( t, shadowColor, midColor );
        }
        for ( int i = 128; i < 256; i++ ) 
        {
            float t = (i-127) / 128.0f;
            lut[i] = ImageMath.mixColors( t, midColor, highColor );
        }
        dst = super.filter( src, dst );
        lut = null;
        return dst;
    }
    
	public int filterRGB( int x, int y, int rgb ) 
	{
        return lut[ PixelUtils.brightness( rgb ) ];
	}

    /**
     * Set the shadow color.
     * @param shadowColor the shadow color
     * @see #getShadowColor
     */
	public void setShadowColor( int shadowColor )
	{
		this.shadowColor = shadowColor;
	}
	
    /**
     * Get the shadow color.
     * @return the shadow color
     * @see #setShadowColor
     */
	public int getShadowColor() 
	{
		return shadowColor;
	}

    /**
     * Set the mid color.
     * @param midColor the mid color
     * @see #getmidColor
     */
	public void setMidColor( int midColor )
	{
		this.midColor = midColor;
	}
	
    /**
     * Get the mid color.
     * @return the mid color
     * @see #setmidColor
     */
	public int getMidColor() 
	{
		return midColor;
	}

    /**
     * Set the high color.
     * @param highColor the high color
     * @see #gethighColor
     */
	public void setHighColor( int highColor ) 
	{
		this.highColor = highColor;
	}
	
    /**
     * Get the high color.
     * @return the high color
     * @see #sethighColor
     */
	public int getHighColor() 
	{
		return highColor;
	}


	public String toString() 
	{
		return "Colors/Tritone...";
	}
}