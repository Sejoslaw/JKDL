package main.java.kd.jkdl.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import main.java.kd.jkdl.datetime.TimePeriod;
import main.java.kd.jkdl.exception.LineNotSupportedException;

/**
 * Base recorder for recording audio from computer audio input.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class JKDLRecorder
{
	/**
	 * The line from which audio data is captured.
	 */
	private TargetDataLine _dataLine;
	/**
	 * Format of audio file
	 */
	private Type _formatType;
	/**
	 * Audio format used in this recorder.
	 */
	private AudioFormat _audioFormat;
	
	public JKDLRecorder(Type formatType, AudioFormat audioFormat)
	{
		this._formatType = formatType;
		this._audioFormat = audioFormat;
	}
	
	/**
	 * Record audio for the given duration (period of time) and into given file
	 * 
	 * @param duration Number of milliseconds for which the recorder should record audio.
	 * @param file File into which audio should be saved.
	 * 
	 * @throws IOException 
	 * @throws LineUnavailableException 
	 * @throws LineNotSupportedException 
	 * 
	 * @see TimePeriod
	 * @see #start(File)
	 * @see #stop()
	 */
	public void record(int duration, File file) 
			throws LineNotSupportedException, LineUnavailableException, IOException
	{
		// Creates a new thread that waits for a specified of time before stopping
		Thread stopper = new Thread(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Thread.sleep(duration);
				} 
				catch(InterruptedException ex) 
				{
					ex.printStackTrace();
				}
				// Stop recording
				stop();
			}
		});
		stopper.start();
		// Start recording to given File
		start(file);
	}
	
	/**
	 * Start recording. <br>
	 * Similar to: {@link #record(int, File)}. <br>
	 * Don't forget to {@link #stop()} the recorder.
	 * 
	 * @throws LineNotSupportedException Thrown if checking DataLine.Info is not supported.
	 * @throws LineUnavailableException If a matching line is not available due to resource restrictions
	 * @throws IOException If an I/O exception occurs
	 */
	public void start(File file)
			throws LineNotSupportedException, LineUnavailableException, IOException
	{
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, this._audioFormat);
		// Checks if system supports the data line
		if(!AudioSystem.isLineSupported(info)) 
		{
			throw new LineNotSupportedException("Line not supported", info);
		}
		this._dataLine = (TargetDataLine) AudioSystem.getLine(info);
		this._dataLine.open(this._audioFormat);
		// Start capturing
		this._dataLine.start();
		AudioInputStream audioInputStream = new AudioInputStream(this._dataLine);
		// Start recording
		AudioSystem.write(audioInputStream, this._formatType, file);
	}
	
	/**
	 * Stop recording. <br>
	 * This method has no effect on {@link #record(int, File)}.
	 * 
	 * @see #start(File)
	 */
	public void stop()
	{
		this._dataLine.stop();
		this._dataLine.close();
	}
}