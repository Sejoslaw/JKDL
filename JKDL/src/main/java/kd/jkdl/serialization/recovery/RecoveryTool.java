package main.java.kd.jkdl.serialization.recovery;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * TODO: Finish Recovery Tool
 * 
 * This tool will read serialized file and returned every piece of data possible to read from the File.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * 
 * @see {@link ObjectInputStream}
 * 
 * @see {@link <a href="http://www.javaworld.com/article/2072752/the-java-serialization-algorithm-revealed.html">Java Serialization Algorithm</a>}
 * @see {@link <a href="http://docs.oracle.com/javase/7/docs/platform/serialization/spec/input.html#3403">Object Input Class</a>}
 */
public class RecoveryTool 
{
	/**
	 * File to be recovered / readed.
	 */
	private final File _file;
	
	public RecoveryTool(File file)
	{
		this._file = file;
	}
	
	/**
	 * Main method used for reading selected file.
	 * 
	 * @throws FileNotFoundException Thrown if given File is NULL or not exists.
	 * @throws IOException Thrown if Object cannot be read from the File.
	 */
	public void read() 
			throws FileNotFoundException, IOException
	{
		if(this._file == null || !this._file.exists())
		{
			throw new FileNotFoundException("File: " + this._file.toString() + " , cannot be found");
		}
		//=========== File exists and is not null
		FileInputStream fis = new FileInputStream(this._file);
		
		// Reading Objects
		
		
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		try
//		{
//			Object read = ois.readObject();
//			while(read != null)
//			{
//				read = ois.readObject();
//			}
//		}
//		catch(ClassNotFoundException exception)
//		{
//		}
//		ois.close();
		fis.close();
	}
}