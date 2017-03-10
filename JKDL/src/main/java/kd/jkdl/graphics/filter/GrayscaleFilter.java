/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A filter which converts an image to grayscale using the NTSC brightness calculation.
 */
public class GrayscaleFilter extends PointFilter 
{
	public GrayscaleFilter() 
	{
		canFilterIndexColorModel = true;
	}

	public int filterRGB(int x, int y, int rgb) 
	{
		int a = rgb & 0xff000000;
		int r = (rgb >> 16) & 0xff;
		int g = (rgb >> 8) & 0xff;
		int b = rgb & 0xff;
		rgb = (r * 77 + g * 151 + b * 28) >> 8;	// NTSC luma
		return a | (rgb << 16) | (rgb << 8) | rgb;
	}

	public String toString() 
	{
		return "Colors/Grayscale";
	}
}