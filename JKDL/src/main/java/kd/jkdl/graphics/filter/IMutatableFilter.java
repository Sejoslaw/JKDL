/**
 * Copyright 2006 Jerry Huxtable
 * 
 * - ported by Krzysztof Dobrzyñski 2016
 */

package main.java.kd.jkdl.graphics.filter;

import java.awt.image.BufferedImageOp;

public interface IMutatableFilter 
{
	public void mutate(float mutationLevel, BufferedImageOp dst, boolean keepShape, boolean keepColors);
}
