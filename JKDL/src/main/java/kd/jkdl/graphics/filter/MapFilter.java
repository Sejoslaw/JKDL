/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import main.java.kd.jkdl.math.IFunction2D;

public class MapFilter extends TransformFilter 
{
	private IFunction2D xMapFunction;
	private IFunction2D yMapFunction;

	public MapFilter() 
	{
	}
	
	public void setXMapFunction(IFunction2D xMapFunction) 
	{
		this.xMapFunction = xMapFunction;
	}

	public IFunction2D getXMapFunction() 
	{
		return xMapFunction;
	}

	public void setYMapFunction(IFunction2D yMapFunction) 
	{
		this.yMapFunction = yMapFunction;
	}

	public IFunction2D getYMapFunction() 
	{
		return yMapFunction;
	}
	
	protected void transformInverse(int x, int y, float[] out) 
	{
		float xMap, yMap;
		xMap = xMapFunction.evaluate(x, y);
		yMap = yMapFunction.evaluate(x, y);
		out[0] = xMap * transformedSpace.width;
		out[1] = yMap * transformedSpace.height;
	}

	public String toString() 
	{
		return "Distort/Map Coordinates...";
	}
}