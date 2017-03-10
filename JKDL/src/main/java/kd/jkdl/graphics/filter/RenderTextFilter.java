/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzy�ski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * A filter which renders text onto an image.
 */
public class RenderTextFilter extends AbstractBufferedImageOp 
{
	private String text;
	private Font font;
    private Paint paint;
	private Composite composite;
    private AffineTransform transform;
	
	/**
     * Construct a RenderTextFilter.
     */
    public RenderTextFilter() 
    {
	}
	
	/**
     * Construct a RenderTextFilter.
     * @param text the text
     * @param font the font to use (may be null)
     * @param paint the paint (may be null)
     * @param composite the composite (may be null)
     * @param transform the transform (may be null)
     */
	public RenderTextFilter( String text, Font font, Paint paint, Composite composite, AffineTransform transform ) 
	{
		this.text = text;
		this.font = font;
		this.composite = composite;
		this.paint = paint;
		this.transform = transform;
	}
	
	/**
     * Set the text to paint.
     * @param text the text
     * @see #getText
     */
	public void setText( String text ) 
	{
		this.text = text;
	}
    
	/**
     * Get the text to paint.
     * @return the text
     * @see #setText
     */
    public String getText() 
    {
        return text;
    }
	
	/**
     * Set the composite with which to paint the text.
     * @param composite the composite
     * @see #getComposite
     */
	public void setComposite( Composite composite ) 
	{
		this.composite = composite;
	}
    
	/**
     * Get the composite with which to paint the text.
     * @return the composite
     * @see #setComposite
     */
    public Composite getComposite() 
    {
        return composite;
    }
	
	/**
     * Set the paint with which to paint the text.
     * @param paint the paint
     * @see #getPaint
     */
	public void setPaint( Paint paint ) 
	{
		this.paint = paint;
	}
    
	/**
     * Get the paint with which to paint the text.
     * @return the paint
     * @see #setPaint
     */
    public Paint getPaint() 
    {
        return paint;
    }
	
	/**
     * Set the font with which to paint the text.
     * @param font the font
     * @see #getFont
     */
	public void setFont( Font font ) 
	{
		this.font = font;
	}
    
	/**
     * Get the font with which to paint the text.
     * @return the font
     * @see #setFont
     */
    public Font getFont() 
    {
        return font;
    }
	
	/**
     * Set the transform with which to paint the text.
     * @param transform the transform
     * @see #getTransform
     */
	public void setTransform( AffineTransform transform ) 
	{
		this.transform = transform;
	}
    
	/**
     * Get the transform with which to paint the text.
     * @return the transform
     * @see #setTransform
     */
    public AffineTransform getTransform() 
    {
        return transform;
    }
	
	public BufferedImage filter( BufferedImage src, BufferedImage dst ) 
	{
        if ( dst == null )
        {
        	dst = createCompatibleDestImage( src, null );
        }

		Graphics2D g = dst.createGraphics();
        g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        if ( font != null )
        {
        	g.setFont( font );
        }
        if ( transform != null )
        {
        	g.setTransform( transform );
        }
        if ( composite != null )
        {
        	g.setComposite( composite );
        }
        if ( paint != null )
        {
        	g.setPaint( paint );
        }
        if ( text != null )
        {
        	g.drawString( text, 10, 100 );
        }
        g.dispose();
		return dst;
	}
}