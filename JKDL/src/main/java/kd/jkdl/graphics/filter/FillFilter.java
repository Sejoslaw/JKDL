/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A filter which fills an image with a given color. Normally you would just call Graphics.fillRect but it can sometimes be useful
 * to go via a filter to fit in with an existing API.
 */
public class FillFilter extends PointFilter 
{
	private int fillColor;

    /**
     * Construct a FillFilter.
     */
	public FillFilter() 
	{
		this(0xff000000);
	}

    /**
     * Construct a FillFilter.
     * @param color the fill color
     */
	public FillFilter(int color) 
	{
		this.fillColor = color;
	}

    /**
     * Set the fill color.
     * @param fillColor the fill color
     * @see #getFillColor
     */
	public void setFillColor(int fillColor) 
	{
		this.fillColor = fillColor;
	}

    /**
     * Get the fill color.
     * @return the fill color
     * @see #setFillColor
     */
	public int getFillColor() 
	{
		return fillColor;
	}

	public int filterRGB(int x, int y, int rgb) 
	{
		return fillColor;
	}
}