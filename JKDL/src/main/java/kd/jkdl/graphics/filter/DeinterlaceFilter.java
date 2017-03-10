/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.image.BufferedImage;

/**
 * A filter for de-interlacing video frames.
 */
public class DeinterlaceFilter extends AbstractBufferedImageOp 
{
    public final static int EVEN = 0;
    public final static int ODD = 1;
    public final static int AVERAGE = 2;

    private int mode = EVEN;

	public void setMode(int mode) 
	{
		this.mode = mode;
	}

	public int getMode() 
	{
		return mode;
	}

    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
        int width = src.getWidth();
        int height = src.getHeight();

        if ( dst == null )
        {
        	dst = createCompatibleDestImage( src, null );
        }

		int[] pixels = null;

        if ( mode == EVEN ) 
        {
            for ( int y = 0; y < height-1; y += 2 ) 
            {
                pixels = getRGB( src, 0, y, width, 1, pixels );
                if ( src != dst )
                {
                	setRGB( dst, 0, y, width, 1, pixels );
                }
                setRGB( dst, 0, y+1, width, 1, pixels );
            }
        } 
        else if ( mode == ODD ) 
        {
            for ( int y = 1; y < height; y += 2 ) 
            {
                pixels = getRGB( src, 0, y, width, 1, pixels );
                if ( src != dst )
                {
                	setRGB( dst, 0, y, width, 1, pixels );
                }
                setRGB( dst, 0, y-1, width, 1, pixels );
            }
        } 
        else if ( mode == AVERAGE ) 
        {
            int[] pixels2 = null;
            for ( int y = 0; y < height-1; y += 2 ) 
            {
                pixels = getRGB( src, 0, y, width, 1, pixels );
                pixels2 = getRGB( src, 0, y+1, width, 1, pixels2 );
                for ( int x = 0; x < width; x++ ) 
                {
                    int rgb1 = pixels[x];
                    int rgb2 = pixels2[x];
                    int a1 = (rgb1 >> 24) & 0xff;
                    int r1 = (rgb1 >> 16) & 0xff;
                    int g1 = (rgb1 >> 8) & 0xff;
                    int b1 = rgb1 & 0xff;
                    int a2 = (rgb2 >> 24) & 0xff;
                    int r2 = (rgb2 >> 16) & 0xff;
                    int g2 = (rgb2 >> 8) & 0xff;
                    int b2 = rgb2 & 0xff;
                    a1 = (a1+a2)/2;
                    r1 = (r1+r2)/2;
                    g1 = (g1+g2)/2;
                    b1 = (b1+b2)/2;
                    pixels[x] = (a1 << 24) | (r1 << 16) | (g1 << 8) | b1;
                }
                setRGB( dst, 0, y, width, 1, pixels );
                setRGB( dst, 0, y+1, width, 1, pixels );
            }
        }
        return dst;
    }

    public String toString() 
    {
        return "Video/De-Interlace";
    }
}