/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.Rectangle;

/**
 * A filter which replcaes each pixel by the maximum of itself and its eight neightbours.
 */
public class MaximumFilter extends WholeImageFilter 
{
	public MaximumFilter() 
	{
	}

	protected int[] filterPixels( int width, int height, int[] inPixels, Rectangle transformedSpace ) 
	{
		int index = 0;
		int[] outPixels = new int[width * height];

		for (int y = 0; y < height; y++) 
		{
			for (int x = 0; x < width; x++) 
			{
				int pixel = 0xff000000;
				for (int dy = -1; dy <= 1; dy++) 
				{
					int iy = y+dy;
					int ioffset;
					if (0 <= iy && iy < height) 
					{
						ioffset = iy*width;
						for (int dx = -1; dx <= 1; dx++) 
						{
							int ix = x+dx;
							if (0 <= ix && ix < width) 
							{
								pixel = PixelUtils.combinePixels(pixel, inPixels[ioffset+ix], PixelUtils.MAX);
							}
						}
					}
				}
				outPixels[index++] = pixel;
			}
		}
		return outPixels;
	}

	public String toString() 
	{
		return "Blur/Maximum";
	}
}