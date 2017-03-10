/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A filter to posterize an image.
 */
public class PosterizeFilter extends PointFilter 
{
	private int numLevels;
	private int[] levels;
    private boolean initialized = false;

	public PosterizeFilter() 
	{
		setNumLevels(6);
	}
	
	/**
     * Set the number of levels in the output image.
     * @param numLevels the number of levels
     * @see #getNumLevels
     */
    public void setNumLevels(int numLevels) 
    {
		this.numLevels = numLevels;
		initialized = false;
	}

	/**
     * Get the number of levels in the output image.
     * @return the number of levels
     * @see #setNumLevels
     */
	public int getNumLevels() 
	{
		return numLevels;
	}

	/**
     * Initialize the filter.
     */
    protected void initialize() 
    {
		levels = new int[256];
		if (numLevels != 1)
		{
			for (int i = 0; i < 256; i++)
			{
				levels[i] = 255 * (numLevels*i / 256) / (numLevels-1);
			}
		}
	}
	
	public int filterRGB(int x, int y, int rgb) 
	{
		if (!initialized) 
		{
			initialized = true;
			initialize();
		}
		int a = rgb & 0xff000000;
		int r = (rgb >> 16) & 0xff;
		int g = (rgb >> 8) & 0xff;
		int b = rgb & 0xff;
		r = levels[r];
		g = levels[g];
		b = levels[b];
		return a | (r << 16) | (g << 8) | b;
	}

	public String toString() 
	{
		return "Colors/Posterize...";
	}
}