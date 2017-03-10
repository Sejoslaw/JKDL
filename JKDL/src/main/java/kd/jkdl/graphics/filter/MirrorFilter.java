/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzy�ski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;

public class MirrorFilter extends AbstractBufferedImageOp 
{
    private float opacity = 1.0f;
	private float centreY = 0.5f;
    private float distance;
    private float angle;
    private float rotation;
    private float gap;

    public MirrorFilter() 
    {
	}
	
	/**
     * Specifies the angle of the mirror.
     * @param angle the angle of the mirror.
     * @angle
     * @see #getAngle
     */
	public void setAngle( float angle ) 
	{
		this.angle = angle;
	}

	/**
     * Returns the angle of the mirror.
     * @return the angle of the mirror.
     * @see #setAngle
     */
	public float getAngle() 
	{
		return angle;
	}
	
	public void setDistance( float distance ) 
	{
		this.distance = distance;
	}

	public float getDistance() 
	{
		return distance;
	}
	
	public void setRotation( float rotation )
	{
		this.rotation = rotation;
	}

	public float getRotation() 
	{
		return rotation;
	}
	
	public void setGap( float gap )
	{
		this.gap = gap;
	}

	public float getGap()
	{
		return gap;
	}
	
	/**
     * Set the opacity of the reflection.
     * @param opacity the opacity.
     * @see #getOpacity
     */
	public void setOpacity( float opacity ) 
	{
		this.opacity = opacity;
	}

	/**
     * Get the opacity of the reflection.
     * @return the opacity.
     * @see #setOpacity
     */
	public float getOpacity() 
	{
		return opacity;
	}
	
	public void setCentreY( float centreY ) 
	{
		this.centreY = centreY;
	}

	public float getCentreY() 
	{
		return centreY;
	}
	
    public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
    {
        if ( dst == null )
        {
        	dst = createCompatibleDestImage( src, null );
        }
		Shape clip;
		int width = src.getWidth();
		int height = src.getHeight();
		int h = (int)(centreY * height);
		int d = (int)(gap * height);

		Graphics2D g = dst.createGraphics();
		clip = g.getClip();
		g.clipRect( 0, 0, width, h );
		g.drawRenderedImage( src, null );
		g.setClip( clip );
		g.clipRect( 0, h+d, width, height-h-d );
		g.translate( 0, 2*h+d );
		g.scale( 1, -1 );
		g.drawRenderedImage( src, null );
		g.setPaint( new GradientPaint( 0, 0, new Color( 1.0f, 0.0f, 0.0f, 0.0f ), 0, h, new Color( 0.0f, 1.0f, 0.0f, opacity ) ) );
		g.setComposite( AlphaComposite.getInstance( AlphaComposite.DST_IN ) );
		g.fillRect( 0, 0, width, h );
		g.setClip( clip );
		g.dispose();
        
        return dst;
    }
    
	public String toString() 
	{
		return "Effects/Mirror...";
	}
}