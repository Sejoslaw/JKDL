/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.image.BufferedImage;

/**
 * A filter which can be used to produce wipes by transferring the luma of a mask image into the alpha channel of the source.
 */
public class GradientWipeFilter extends AbstractBufferedImageOp 
{
	private float density = 0;
	private float softness = 0;
	private boolean invert;
	private BufferedImage mask;

	public GradientWipeFilter() 
	{
	}

	/**
	 * Set the density of the image in the range 0..1.
	 * *arg density The density
	 */
	public void setDensity( float density ) 
	{
		this.density = density;
	}
	
	public float getDensity() 
	{
		return density;
	}
	
	/**
	 * Set the softness of the dissolve in the range 0..1.
	 * @param softness the softness
     * @min-value 0
     * @max-value 1
     * @see #getSoftness
	 */
	public void setSoftness( float softness ) 
	{
		this.softness = softness;
	}
	
	/**
	 * Get the softness of the dissolve.
	 * @return the softness
     * @see #setSoftness
	 */
	public float getSoftness() 
	{
		return softness;
	}
	
	public void setMask( BufferedImage mask ) 
	{
		this.mask = mask;
	}
	
	public BufferedImage getMask() 
	{
		return mask;
	}
	
	public void setInvert( boolean invert ) 
	{
		this.invert = invert;
	}
	
	public boolean getInvert() 
	{
		return invert;
	}
	
    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
        int width = src.getWidth();
        int height = src.getHeight();

        if ( dst == null )
        {
        	dst = createCompatibleDestImage( src, null );
        }
		if ( mask == null )
		{
			return dst;
		}

        int maskWidth = mask.getWidth();
        int maskHeight = mask.getHeight();

		float d = density * (1+softness);
		float lower = 255 * (d-softness);
		float upper = 255 * d;

		int[] inPixels = new int[width];
		int[] maskPixels = new int[maskWidth];

        for ( int y = 0; y < height; y++ ) 
        {
			getRGB( src, 0, y, width, 1, inPixels );
			getRGB( mask, 0, y % maskHeight, maskWidth, 1, maskPixels );
			
			for ( int x = 0; x < width; x++ ) 
			{
				int maskRGB = maskPixels[x % maskWidth];
				int inRGB = inPixels[x];
				int v = PixelUtils.brightness( maskRGB );
				float f = ImageMath.smoothStep( lower, upper, v );
				int a = (int)(255 * f);

				if ( invert )
				{
					a = 255-a;
				}
				inPixels[x] = (a << 24) | (inRGB & 0x00ffffff);
			}
			setRGB( dst, 0, y, width, 1, inPixels );
        }
        return dst;
    }

	public String toString() 
	{
		return "Transitions/Gradient Wipe...";
	}
}