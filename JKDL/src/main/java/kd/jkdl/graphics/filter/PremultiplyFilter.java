/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A filter which premultiplies an image's alpha. 
 * Note: this does not change the image type of the BufferedImage
 */
public class PremultiplyFilter extends PointFilter 
{
	public PremultiplyFilter() 
	{
	}

	public int filterRGB(int x, int y, int rgb) 
	{
		int a = (rgb >> 24) & 0xff;
		int r = (rgb >> 16) & 0xff;
		int g = (rgb >> 8) & 0xff;
		int b = rgb & 0xff;
		float f = a * (1.0f / 255.0f);
		r *= f;
		g *= f;
		b *= f;
		return (a << 24) | (r << 16) | (g << 8) | b;
	}

	public String toString() 
	{
		return "Alpha/Premultiply";
	}
}