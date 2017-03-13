package main.java.kd.jkdl.exception;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;

/**
 * This Exception is thrown if {@link AudioSystem#isLineSupported(javax.sound.sampled.Line.Info)} return FALSE.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class LineNotSupportedException extends Exception 
{
	private static final long serialVersionUID = -6641314501482651389L;
	
	private final Info _info;
	
	public LineNotSupportedException(String message, Info info) 
	{
		super(message);
		this._info = info;
	}
	
	/**
	 * @return Returns DataLine.Info which was checked and is not supported.
	 */
	public Info getLine()
	{
		return this._info;
	}
}