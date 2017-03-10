/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.math;

public class CompositeFunction1D implements IFunction1D 
{
	private IFunction1D f1, f2;
	
	public CompositeFunction1D(IFunction1D f1, IFunction1D f2) 
	{
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public float evaluate(float v) 
	{
		return f1.evaluate(f2.evaluate(v));
	}
}