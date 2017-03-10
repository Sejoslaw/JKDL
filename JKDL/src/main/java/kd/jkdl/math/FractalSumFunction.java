/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.math;

public class FractalSumFunction extends CompoundFunction2D 
{
	private float octaves = 1.0f;
	
	public FractalSumFunction(IFunction2D basis) 
	{
		super(basis);
	}
	
	public float evaluate(float x, float y) 
	{
		float t = 0.0f;

		for (float f = 1.0f; f <= octaves; f *= 2)
		{
			t += basis.evaluate(f * x, f * y) / f;
		}
		return t;
	}
}