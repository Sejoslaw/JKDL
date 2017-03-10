/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.math;

public abstract class CompoundFunction2D implements IFunction2D 
{
	protected IFunction2D basis;
	
	public CompoundFunction2D(IFunction2D basis) 
	{
		this.basis = basis;
	}
	
	public void setBasis(IFunction2D basis) 
	{
		this.basis = basis;
	}

	public IFunction2D getBasis() 
	{
		return basis;
	}
}