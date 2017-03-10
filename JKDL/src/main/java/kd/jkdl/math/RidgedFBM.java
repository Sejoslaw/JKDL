/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.math;

public class RidgedFBM implements IFunction2D 
{
	public float evaluate(float x, float y) 
	{
		return 1 - Math.abs(Noise.noise2(x, y));
	}
}