/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A filter which replaces one color by another in an image. This is frankly, not often useful, but has its occasional
 * uses when dealing with GIF transparency and the like.
 */
public class MapColorsFilter extends PointFilter 
{
	private int oldColor;
	private int newColor;
	
	/**
     * Construct a MapColorsFilter.
     */
    public MapColorsFilter() 
    {
		this( 0xffffffff, 0xff000000 );
	}
	
	/**
     * Construct a MapColorsFilter.
     * @param oldColor the color to replace
     * @param newColor the color to replace it with
     */
	public MapColorsFilter(int oldColor, int newColor) 
	{
		canFilterIndexColorModel = true;
		this.oldColor = oldColor;
		this.newColor = newColor;
	}

	public int filterRGB(int x, int y, int rgb) 
	{
		if (rgb == oldColor)
		{
			return newColor;
		}
		return rgb;
	}
}