/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.Rectangle;

public class ShearFilter extends TransformFilter 
{
	private float xangle = 0.0f;
	private float yangle = 0.0f;
	private float shx = 0.0f;
	private float shy = 0.0f;
	private float xoffset = 0.0f;
	private float yoffset = 0.0f;
	private boolean resize = true;

	public ShearFilter() 
	{
	}

	public void setResize(boolean resize) 
	{
		this.resize = resize;
	}

	public boolean isResize() 
	{
		return resize;
	}

	public void setXAngle(float xangle) 
	{
		this.xangle = xangle;
		initialize();
	}

	public float getXAngle() 
	{
		return xangle;
	}

	public void setYAngle(float yangle) 
	{
		this.yangle = yangle;
		initialize();
	}

	public float getYAngle() 
	{
		return yangle;
	}

	private void initialize() 
	{
		shx = (float)Math.sin(xangle);
		shy = (float)Math.sin(yangle);
	}
	
	protected void transformSpace(Rectangle r) 
	{
		float tangent = (float)Math.tan(xangle);
		xoffset = -r.height * tangent;
		if (tangent < 0.0)
		{
			tangent = -tangent;
		}
		r.width = (int)(r.height * tangent + r.width + 0.999999f);
		tangent = (float)Math.tan(yangle);
		yoffset = -r.width * tangent;
		if (tangent < 0.0)
		{
			tangent = -tangent;
		}
		r.height = (int)(r.width * tangent + r.height + 0.999999f);
	}

	protected void transformInverse(int x, int y, float[] out) 
	{
		out[0] = x + xoffset + (y * shx);
		out[1] = y + yoffset + (x * shy);
	}

	public String toString() 
	{
		return "Distort/Shear...";
	}
}