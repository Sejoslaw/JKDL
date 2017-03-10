/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.math;

public class BlackFunction implements IBinaryFunction 
{
	public boolean isBlack(int rgb) 
	{
		return rgb == 0xff000000;
	}
}