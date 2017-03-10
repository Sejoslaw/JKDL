/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.math;

public class VLNoise implements IFunction2D 
{
	private float distortion = 10.0f;

	public void setDistortion(float distortion) 
	{
		this.distortion = distortion;
	}

	public float getDistortion() 
	{
		return distortion;
	}

	public float evaluate(float x, float y) 
	{
		float ox = Noise.noise2(x+0.5f, y) * distortion;
		float oy = Noise.noise2(x, y+0.5f) * distortion;
		return Noise.noise2(x+ox, y+oy);
	}
}