/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import main.java.kd.jkdl.math.IFunction2D;
import main.java.kd.jkdl.math.Noise;

public class TextureFilter extends PointFilter 
{
	private float scale = 32;
	private float stretch = 1.0f;
	private float angle = 0.0f;
	public float amount = 1.0f;
	public float turbulence = 1.0f;
	public float gain = 0.5f;
	public float bias = 0.5f;
	public int operation;
	private float m00 = 1.0f;
	private float m01 = 0.0f;
	private float m10 = 0.0f;
	private float m11 = 1.0f;
	private IColormap colormap = new Gradient();
	private IFunction2D function = new Noise();

	public TextureFilter() 
	{
	}

	/**
	 * Set the amount of texture.
	 * @param amount the amount
     * @min-value 0
     * @max-value 1
     * @see #getAmount
	 */
	public void setAmount(float amount) 
	{
		this.amount = amount;
	}

	/**
	 * Get the amount of texture.
	 * @return the amount
     * @see #setAmount
	 */
	public float getAmount() 
	{
		return amount;
	}

	public void setFunction(IFunction2D function) 
	{
		this.function = function;
	}

	public IFunction2D getFunction() 
	{
		return function;
	}

	public void setOperation(int operation) 
	{
		this.operation = operation;
	}
	
	public int getOperation() 
	{
		return operation;
	}
	
	/**
     * Specifies the scale of the texture.
     * @param scale the scale of the texture.
     * @min-value 1
     * @max-value 300+
     * @see #getScale
     */
	public void setScale(float scale) 
	{
		this.scale = scale;
	}

	/**
     * Returns the scale of the texture.
     * @return the scale of the texture.
     * @see #setScale
     */
	public float getScale() 
	{
		return scale;
	}

	/**
     * Specifies the stretch factor of the texture.
     * @param stretch the stretch factor of the texture.
     * @min-value 1
     * @max-value 50+
     * @see #getStretch
     */
	public void setStretch(float stretch) 
	{
		this.stretch = stretch;
	}

	/**
     * Returns the stretch factor of the texture.
     * @return the stretch factor of the texture.
     * @see #setStretch
     */
	public float getStretch() 
	{
		return stretch;
	}

	/**
     * Specifies the angle of the texture.
     * @param angle the angle of the texture.
     * @angle
     * @see #getAngle
     */
	public void setAngle(float angle) 
	{
		this.angle = angle;
		float cos = (float)Math.cos(angle);
		float sin = (float)Math.sin(angle);
		m00 = cos;
		m01 = sin;
		m10 = -sin;
		m11 = cos;
	}

	/**
     * Returns the angle of the texture.
     * @return the angle of the texture.
     * @see #setAngle
     */
	public float getAngle() 
	{
		return angle;
	}

	/**
     * Specifies the turbulence of the texture.
     * @param turbulence the turbulence of the texture.
     * @min-value 0
     * @max-value 1
     * @see #getTurbulence
     */
	public void setTurbulence(float turbulence) 
	{
		this.turbulence = turbulence;
	}

	/**
     * Returns the turbulence of the texture.
     * @return the turbulence of the texture.
     * @see #setTurbulence
     */
	public float getTurbulence() 
	{
		return turbulence;
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
		float nx = m00*x + m01*y;
		float ny = m10*x + m11*y;
		nx /= scale;
		ny /= scale * stretch;
		float f = turbulence == 1.0 ? Noise.noise2(nx, ny) : Noise.turbulence2(nx, ny, turbulence);
		f = (f * 0.5f) + 0.5f;
		f = ImageMath.gain(f, gain);
		f = ImageMath.bias(f, bias);
		f *= amount;
		int a = rgb & 0xff000000;
		int v;
		if (colormap != null)
		{
			v = colormap.getColor(f);
		}
		else 
		{
			v = PixelUtils.clamp((int)(f*255));
			int r = v << 16;
			int g = v << 8;
			int b = v;
			v = a|r|g|b;
		}
		
		if (operation != PixelUtils.REPLACE)
		{
			v = PixelUtils.combinePixels(rgb, v, operation);
		}
		return v;
	}

	public String toString() 
	{
		return "Texture/Noise...";
	}
}