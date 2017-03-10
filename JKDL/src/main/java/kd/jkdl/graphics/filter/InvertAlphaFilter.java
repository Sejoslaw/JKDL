/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzy�ski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A Filter to invert the alpha channel of an image. This is really only useful for inverting selections, where we only use the alpha channel.
 */
public class InvertAlphaFilter extends PointFilter 
{
	public InvertAlphaFilter() 
	{
		canFilterIndexColorModel = true;
	}

	public int filterRGB(int x, int y, int rgb) 
	{
		return rgb ^ 0xff000000;
	}

	public String toString() 
	{
		return "Alpha/Invert";
	}
}