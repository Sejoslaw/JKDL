/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A filter which uses the brightness of each pixel to lookup a color from a colormap. 
 */
public class LookupFilter extends PointFilter 
{
	private IColormap colormap = new Gradient();
	
	/**
     * Construct a LookupFilter.
     */
    public LookupFilter() 
    {
		canFilterIndexColorModel = true;
	}

	/**
     * Construct a LookupFilter.
     * @param colormap the color map
     */
	public LookupFilter(IColormap colormap) 
	{
		canFilterIndexColorModel = true;
		this.colormap = colormap;
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

	public int filterRGB(int x, int y, int rgb) 
	{
		int r = (rgb >> 16) & 0xff;
		int g = (rgb >> 8) & 0xff;
		int b = rgb & 0xff;
		rgb = (r + g + b) / 3;
		return colormap.getColor(rgb/255.0f);
	}

	public String toString() 
	{
		return "Colors/Lookup...";
	}
}