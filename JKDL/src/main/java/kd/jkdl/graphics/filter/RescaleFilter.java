/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A filter which simply multiplies pixel values by a given scale factor.
 */
public class RescaleFilter extends TransferFilter 
{
	private float scale = 1.0f;
	
	public RescaleFilter() 
	{
    }
    
	public RescaleFilter(float scale) 
	{
		this.scale = scale;
    }
    
    protected float transferFunction( float v ) 
    {
		return v * scale;
	}

	/**
     * Specifies the scale factor.
     * @param scale the scale factor.
     * @min-value 1
     * @max-value 5+
     * @see #getScale
     */
	public void setScale(float scale) 
	{
		this.scale = scale;
		initialized = false;
	}
	
	/**
     * Returns the scale factor.
     * @return the scale factor.
     * @see #setScale
     */
	public float getScale() 
	{
		return scale;
	}

	public String toString() 
	{
		return "Colors/Rescale...";
	}
}