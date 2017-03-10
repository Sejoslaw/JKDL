/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

/**
 * A filter for changing the gamma of an image.
 */
public class GammaFilter extends TransferFilter 
{
	private float rGamma, gGamma, bGamma;

    /**
     * Construct a GammaFilter.
     */
	public GammaFilter() 
	{
		this(1.0f);
	}

    /**
     * Construct a GammaFilter.
     * @param gamma the gamma level for all RGB channels
     */
	public GammaFilter(float gamma) 
	{
		this(gamma, gamma, gamma);
	}

    /**
     * Construct a GammaFilter.
     * @param rGamma the gamma level for the red channel
     * @param gGamma the gamma level for the blue channel
     * @param bGamma the gamma level for the green channel
     */
	public GammaFilter(float rGamma, float gGamma, float bGamma) 
	{
		setGamma(rGamma, gGamma, bGamma);
	}

    /**
     * Set the gamma levels.
     * @param rGamma the gamma level for the red channel
     * @param gGamma the gamma level for the blue channel
     * @param bGamma the gamma level for the green channel
     * @see #getGamma
     */
	public void setGamma(float rGamma, float gGamma, float bGamma) 
	{
		this.rGamma = rGamma;
		this.gGamma = gGamma;
		this.bGamma = bGamma;
		initialized = false;
	}

    /**
     * Set the gamma level.
     * @param gamma the gamma level for all RGB channels
     * @see #getGamma
     */
	public void setGamma(float gamma) 
	{
		setGamma(gamma, gamma, gamma);
	}
	
    /**
     * Get the gamma level.
     * @return the gamma level for all RGB channels
     * @see #setGamma
     */
	public float getGamma() 
	{
		return rGamma;
	}
	
    protected void initialize() 
    {
		rTable = makeTable(rGamma);

		if (gGamma == rGamma)
		{
			gTable = rTable;
		}
		else
		{
			gTable = makeTable(gGamma);
		}

		if (bGamma == rGamma)
		{
			bTable = rTable;
		}
		else if (bGamma == gGamma)
		{
			bTable = gTable;
		}
		else
		{
			bTable = makeTable(bGamma);
		}
	}

	private int[] makeTable(float gamma) 
	{
		int[] table = new int[256];
		for (int i = 0; i < 256; i++) 
		{
			int v = (int) ((255.0 * Math.pow(i/255.0, 1.0 / gamma)) + 0.5);
			if (v > 255)
			{
				v = 255;
			}
			table[i] = v;
		}
		return table;
	}

	public String toString() 
	{
		return "Colors/Gamma...";
	}
}