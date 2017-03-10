/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A filter which averages the 3x3 neighbourhood of each pixel, providing a simple blur.
 */
public class AverageFilter extends ConvolveFilter 
{
    /**
     * The convolution kernal for the averaging.
     */
	protected static float[] theMatrix = { 0.1f, 0.1f, 0.1f, 0.1f, 0.2f, 0.1f, 0.1f, 0.1f, 0.1f };

	public AverageFilter() 
	{
		super( theMatrix );
	}

	public String toString() 
	{
		return "Blur/Average Blur";
	}
}