/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.image.BufferedImage;

/**
 * This filter diffuses an image by moving its pixels in random directions.
 */
public class DiffuseFilter extends TransformFilter 
{
	private float[] sinTable, cosTable;
	private float scale = 4;
	
	public DiffuseFilter() 
	{
		setEdgeAction(CLAMP);
	}
	
	/**
     * Specifies the scale of the texture.
     * @param scale the scale of the texture.
     * @min-value 1
     * @max-value 100+
     * @see #getScale
     */
	public void setScale(float scale) 
	{
		this.scale = scale;
	}

	/**
     * Returns the scale of the texture.
     * @return the scale of the texture.
     * @see #setScale
     */
	public float getScale() 
	{
		return scale;
	}

	protected void transformInverse(int x, int y, float[] out) 
	{
		int angle = (int)(Math.random() * 255);
		float distance = (float)Math.random();
		out[0] = x + distance * sinTable[angle];
		out[1] = y + distance * cosTable[angle];
	}

    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
		sinTable = new float[256];
		cosTable = new float[256];
		for (int i = 0; i < 256; i++) 
		{
			float angle = ImageMath.TWO_PI*i/256f;
			sinTable[i] = (float)(scale*Math.sin(angle));
			cosTable[i] = (float)(scale*Math.cos(angle));
		}
		return super.filter( src, dst );
	}

	public String toString() 
	{
		return "Distort/Diffuse...";
	}
}