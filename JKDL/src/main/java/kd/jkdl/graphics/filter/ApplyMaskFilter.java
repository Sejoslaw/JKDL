/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

import main.java.kd.jkdl.graphics.JKDLImage;

/**
 * A filter which uses the alpha channel of a "mask" image to interpolate between a source and destination image.
 */
public class ApplyMaskFilter extends AbstractBufferedImageOp 
{
	private JKDLImage destination;
	private JKDLImage maskImage;

    /**
     * Construct an ApplyMaskFIlter.
     */
	public ApplyMaskFilter() 
	{
	}

    /**
     * Construct an ApplyMaskFIlter.
     * @param maskImage the mask image
     * @param destination the destination image
     */
	public ApplyMaskFilter( JKDLImage maskImage, JKDLImage destination ) 
	{
		this.maskImage = maskImage;
		this.destination = destination;
	}

    /**
     * Set the destination image.
     * @param destination the destination image
     * @see #getDestination
     */
	public void setDestination( JKDLImage destination ) 
	{
		this.destination = destination;
	}
	
    /**
     * Get the destination image.
     * @return the destination image
     * @see #setDestination
     */
	public JKDLImage getDestination() 
	{
		return destination;
	}
	
    /**
     * Set the mask image.
     * @param maskImage the mask image
     * @see #getMaskImage
     */
	public void setMaskImage( JKDLImage maskImage ) 
	{
		this.maskImage = maskImage;
	}
	
    /**
     * Get the mask image.
     * @return the mask image
     * @see #setMaskImage
     */
	public JKDLImage getMaskImage() 
	{
		return maskImage;
	}
		
    /**
     * Interpolates between two rasters according to the alpha level of a mask raster.
     * @param src the source raster
     * @param dst the destination raster
     * @param sel the mask raster
     */
	public static void composeThroughMask(Raster src, WritableRaster dst, Raster sel) 
	{
		int x = src.getMinX();
		int y = src.getMinY();
		int w = src.getWidth();
		int h = src.getHeight();

		int srcRGB[] = null;
		int selRGB[] = null;
		int dstRGB[] = null;

		for ( int i = 0; i < h; i++ ) 
		{
			srcRGB = src.getPixels(x, y, w, 1, srcRGB);
			selRGB = sel.getPixels(x, y, w, 1, selRGB);
			dstRGB = dst.getPixels(x, y, w, 1, dstRGB);

			int k = x;
			for ( int j = 0; j < w; j++ ) 
			{
				int sr = srcRGB[k];
				int dir = dstRGB[k];
				int sg = srcRGB[k+1];
				int dig = dstRGB[k+1];
				int sb = srcRGB[k+2];
				int dib = dstRGB[k+2];
				int sa = srcRGB[k+3];
				int dia = dstRGB[k+3];

				float a = selRGB[k+3]/255f;
				float ac = 1-a;

				dstRGB[k] = (int)(a*sr + ac*dir); 
				dstRGB[k+1] = (int)(a*sg + ac*dig); 
				dstRGB[k+2] = (int)(a*sb + ac*dib); 
				dstRGB[k+3] = (int)(a*sa + ac*dia);
				k += 4;
			}
			dst.setPixels(x, y, w, 1, dstRGB);
			y++;
		}
	}

    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
        if ( dst == null )
        {
        	dst = createCompatibleDestImage( src, null );
        }

        if ( destination != null && maskImage != null )
        {
        	composeThroughMask( src.getRaster(), dst.getRaster(), maskImage.getImage().getRaster() );
        }
        return dst;
    }

	public String toString() 
	{
		return "Keying/Key...";
	}
}