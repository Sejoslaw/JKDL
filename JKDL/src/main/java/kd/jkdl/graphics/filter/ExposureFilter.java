/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A filter which changes the exposure of an image.
 */
public class ExposureFilter extends TransferFilter 
{
	private float exposure = 1.0f;

	protected float transferFunction( float f ) 
	{
		return 1 - (float)Math.exp(-f * exposure);
	}

    /**
     * Set the exposure level.
     * @param exposure the exposure level
     * @min-value 0
     * @max-value 5+
     * @see #getExposure
     */
	public void setExposure(float exposure) 
	{
		this.exposure = exposure;
		initialized = false;
	}
	
    /**
     * Get the exposure level.
     * @return the exposure level
     * @see #setExposure
     */
	public float getExposure() 
	{
		return exposure;
	}

	public String toString() 
	{
		return "Colors/Exposure...";
	}
}