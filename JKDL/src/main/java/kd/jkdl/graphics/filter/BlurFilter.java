/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A simple blur filter. You should probably use BoxBlurFilter instead.
 */
public class BlurFilter extends ConvolveFilter 
{ 	
 	/**
     * A 3x3 convolution kernel for a simple blur.
     */
    protected static float[] blurMatrix = {
		1/14f, 2/14f, 1/14f,
		2/14f, 2/14f, 2/14f,
		1/14f, 2/14f, 1/14f
	};

	public BlurFilter() 
	{
		super( blurMatrix );
	}

	public String toString() 
	{
		return "Blur/Simple Blur";
	}
}