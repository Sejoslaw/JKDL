/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyński 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.image.BufferedImage;

/**
 * A filter which adds Gaussian blur to an image, producing a glowing effect.
 */
public class HighPassFilter extends GaussianFilter 
{
	public HighPassFilter() 
	{
		radius = 10;
	}
	
    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
        int width = src.getWidth();
        int height = src.getHeight();

        if ( dst == null )
        {
        	dst = createCompatibleDestImage( src, null );
        }

        int[] inPixels = new int[width*height];
        int[] outPixels = new int[width*height];
        src.getRGB( 0, 0, width, height, inPixels, 0, width );

		if ( radius > 0 ) 
		{
			convolveAndTranspose(kernel, inPixels, outPixels, width, height, alpha, alpha && premultiplyAlpha, false, CLAMP_EDGES);
			convolveAndTranspose(kernel, outPixels, inPixels, height, width, alpha, false, alpha && premultiplyAlpha, CLAMP_EDGES);
		}

        src.getRGB( 0, 0, width, height, outPixels, 0, width );

		int index = 0;
		for ( int y = 0; y < height; y++ ) 
		{
			for ( int x = 0; x < width; x++ ) 
			{
				int rgb1 = outPixels[index];
				int r1 = (rgb1 >> 16) & 0xff;
				int g1 = (rgb1 >> 8) & 0xff;
				int b1 = rgb1 & 0xff;

				int rgb2 = inPixels[index];
				int r2 = (rgb2 >> 16) & 0xff;
				int g2 = (rgb2 >> 8) & 0xff;
				int b2 = rgb2 & 0xff;

				r1 = (r1 + 255-r2) / 2;
				g1 = (g1 + 255-g2) / 2;
				b1 = (b1 + 255-b2) / 2;

				inPixels[index] = (rgb1 & 0xff000000) | (r1 << 16) | (g1 << 8) | b1;
				index++;
			}
		}
        dst.setRGB( 0, 0, width, height, inPixels, 0, width );
        return dst;
    }

	public String toString() 
	{
		return "Blur/High Pass...";
	}
}