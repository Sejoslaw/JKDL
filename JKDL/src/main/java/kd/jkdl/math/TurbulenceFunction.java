/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.math;

public class TurbulenceFunction extends CompoundFunction2D 
{
	private float octaves;

	public TurbulenceFunction(IFunction2D basis, float octaves) 
	{
		super(basis);
		this.octaves = octaves;
	}
	
	public void setOctaves(float octaves) 
	{
		this.octaves = octaves;
	}

	public float getOctaves() 
	{
		return octaves;
	}

	public float evaluate(float x, float y) 
	{
		float t = 0.0f;
		for (float f = 1.0f; f <= octaves; f *= 2)
		{
			t += Math.abs(basis.evaluate(f * x, f * y)) / f;
		}
		return t;
	}
}