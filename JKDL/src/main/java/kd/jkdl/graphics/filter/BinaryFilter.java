/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import main.java.kd.jkdl.math.BlackFunction;

/**
 * The superclass for some of the filters which work on binary images.
 */
public abstract class BinaryFilter extends WholeImageFilter 
{
	protected int newColor = 0xff000000;
	protected BlackFunction blackFunction = new BlackFunction();
	protected int iterations = 1;
	protected IColormap colormap;

	/**
	 * Set the number of iterations the effect is performed.
	 * @param iterations the number of iterations
     * @min-value 0
     * @see #getIterations
	 */
	public void setIterations(int iterations) 
	{
		this.iterations = iterations;
	}

	/**
	 * Get the number of iterations the effect is performed.
	 * @return the number of iterations
     * @see #setIterations
	 */
	public int getIterations() 
	{
		return iterations;
	}

    /**
     * Set the colormap to be used for the filter.
     * @param colormap the colormap
     * @see #getColormap
     */
	public void setColormap(IColormap colormap) 
	{
		this.colormap = colormap;
	}

    /**
     * Get the colormap to be used for the filter.
     * @return the colormap
     * @see #setColormap
     */
	public IColormap getColormap() 
	{
		return colormap;
	}

	public void setNewColor(int newColor) 
	{
		this.newColor = newColor;
	}

	public int getNewColor() 
	{
		return newColor;
	}

	public void setBlackFunction(BlackFunction blackFunction) 
	{
		this.blackFunction = blackFunction;
	}

	public BlackFunction getBlackFunction() 
	{
		return blackFunction;
	}
}