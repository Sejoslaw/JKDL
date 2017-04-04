package main.java.kd.jkdl.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * TODO: Add more Colors. <br>
 * <br>
 * Basic Color operations.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class JKDLColor 
{
	public static Color getColor(int rgb)
	{
		return new Color(rgb);
	}
	
	public static Color getColor(int r, int g, int b, int a)
	{
		return new Color(r, g, b, a);
	}
	
	public static int getRGBA(int r, int g, int b, int a)
	{
		return new Color(r, g, b, a).getRGB();
	}
	
	public static Color getColorOfPixelAt(BufferedImage image, int xCoord, int yCoord)
	{
		int argb = image.getRGB(xCoord, yCoord);
		Color c = new Color(argb);
		return c;
	}
	
	//====================...::: Static Colors :::...=============================
	
	//Oranges
	public final static Color TOMATO = new Color(255,99,71);
	public final static Color ORANGERED = new Color(255,69,0);
	public final static Color CORAL = new Color(255,127,80);
	public final static Color LIGHTSALMON = new Color(255,160,122);
	public final static Color DARKORANGE = new Color(255,140,0);
	public final static Color ORANGE= new Color(255,165,0);
	
	//Grays
	public final static Color DIMGRAY = new Color(105,105,105);
	public final static Color DARKGRAY = new Color(128,128,128);
	public final static Color GRAY = new Color(169,169,169);
	public final static Color SILVER = new Color(192,192,192);
	public final static Color LIGHTGRAY = new Color(211,211,211);
	public final static Color GAINSBORO = new Color(220,220,220);
	public final static Color DARKSLATEGRAY = new Color(47,79,79);
	public final static Color SLATEGRAY = new Color(112,128,144);
	public final static Color LIGHTSLATEGRAY = new Color(119,136,153);
	
	//Whites
	public final static Color WHITESMOKE = new Color(245,245,245);
	public final static Color WHITE = new Color(255,255,255);
	public final static Color SNOW = new Color(255,250,250);
	public final static Color MISTYROSE = new Color(255,228,225);
	public final static Color SEASHELL = new Color(255,245,238);
	public final static Color LINEN = new Color(250,240,230);
	public final static Color ANTIQUEWHITE = new Color(250,235,215);
	public final static Color OLDLACE = new Color(253,245,230);
	public final static Color FLORALWHITE = new Color(255,250,240);
	public final static Color BEIGE = new Color(255,245,220);
	public final static Color IVORY = new Color(255,255,240);
	public final static Color HONEYDEW = new Color(240,255,240);
	public final static Color MINTCREAM = new Color(245,255,250);
	public final static Color AZURE = new Color(240,255,255);
	public final static Color ALICEBLUE = new Color(240,248,255);
	public final static Color GHOSTWHITE = new Color(248,248,255);
	public final static Color LAVENDERBLUSH = new Color(255,240,245);
	
	//Browns
	public final static Color MAROON = new Color(128,0,0);
	public final static Color BROWN = new Color(165,42,42);
	public final static Color ROSYBROWN = new Color(188,143,143);
	public final static Color SIENNA = new Color(160,82,45);
	public final static Color SADDLEBROWN = new Color(139,69,19); // 2139 ???
	public final static Color CHOCOLATE = new Color(210,105,30);
	public final static Color SANDYBROWN = new Color(244,164,96);
	public final static Color PERU = new Color(205,133,63);
	public final static Color BISQUE = new Color(255,225,196);
	public final static Color BURLYWOOD = new Color(222,184,135);
	public final static Color TAN = new Color(210,180,140);
	public final static Color NAVAJOWHITE = new Color(255,222,173);
	public final static Color BLANCHEDALMOND = new Color(255,235,205);
	public final static Color WHEAT = new Color(245,222,179);
	public final static Color DARKGOLDENROD = new Color(184,134,11);
	public final static Color GOLDENROD = new Color(218,165,32);
	public final static Color CORNSILK = new Color(255,248,220);
	
	//Reds
	public final static Color DARKRED = new Color(139,0,0);
	public final static Color FIREBRICK = new Color(178,34,34);
	public final static Color RED = new Color(255,0,0);
	public final static Color INDIANRED = new Color(205,92,92);
	public final static Color LIGHTCORAL = new Color(240,128,128);
	public final static Color SALMON= new Color(250,128,114);
	public final static Color DARKSALMON = new Color(233,150,122);
	public final static Color CRIMSON = new Color(220,20,60);
	
	//Greens
	public final static Color DARKCYAN = new Color(0,139,139);
	public final static Color OLIVE = new Color(128,128,0);
	public final static Color OLIVEDRAB = new Color(107,142,35);
	public final static Color YELLOWGREEN = new Color(154,205,50);
	public final static Color DARKOLIVEGREEN = new Color(85,107,47);
	public final static Color GREENYELLOW = new Color(173,255,47);
	public final static Color CHARTREUSE = new Color(127,255,0);
	public final static Color LAWNGREEN = new Color(124,252,0);
	public final static Color DARKGREEN = new Color(0,100,0);
	public final static Color GREEN = new Color(0,128,0);
	public final static Color FORESTGREEN = new Color(34,139,34);
	public final static Color LIME = new Color(0,255,0);
	public final static Color LIMEGREEN = new Color(50,205,50);
	public final static Color LIGHTGREEN = new Color(144,238,144);
	public final static Color PALEGREEN = new Color(152,251,152);
	public final static Color DARKSEAGREEN = new Color(143,188,143);
	public final static Color SEAGREEN = new Color(46,139,87);
	public final static Color MEDIUMSEAGREEN = new Color(60,179,113);
	public final static Color SPRINGGREEN = new Color(0,255,127);
	public final static Color MEDIUMSPRINGGREEN = new Color(0,250,154);
	public final static Color MEDIUMAQUAMARINE = new Color(102,205,170);
	public final static Color LIGHTSEAGREEN = new Color(32,178,170);
	public final static Color TEAL = new Color(0,128,128);
}