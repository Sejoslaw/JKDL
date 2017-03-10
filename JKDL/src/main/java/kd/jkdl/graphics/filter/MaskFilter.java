/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * Applies a bit mask to each ARGB pixel of an image. You can use this for, say, masking out the red channel.
 */
public class MaskFilter extends PointFilter 
{
	private int mask;

	public MaskFilter() 
	{
		this(0xff00ffff);
	}

	public MaskFilter(int mask) 
	{
		canFilterIndexColorModel = true;
		setMask(mask);
	}

	public void setMask(int mask) 
	{
		this.mask = mask;
	}

	public int getMask() 
	{
		return mask;
	}

	public int filterRGB(int x, int y, int rgb) 
	{
		return rgb & mask;
	}

	public String toString() 
	{
		return "Mask";
	}
}