/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A colormap with the colors of the spectrum.
 */
public class SpectrumColormap implements IColormap 
{
	/**
	 * Construct a spcetrum color map.
	 */
	public SpectrumColormap() 
	{
	}

	/**
	 * Convert a value in the range 0..1 to an RGB color.
	 * @param v a value in the range 0..1
	 * @return an RGB color
	 */
	public int getColor(float v) 
	{
		return Spectrum.wavelengthToRGB(380+400*ImageMath.clamp(v, 0, 1.0f));
	}
}