package test.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

import main.java.kd.jkdl.audio.JKDLAudio;
import main.java.kd.jkdl.audio.JKDLRecorder;
import main.java.kd.jkdl.datetime.TimePeriod;
import main.java.kd.jkdl.exception.LineNotSupportedException;

/**
 * Audio Recording test -> start, stop example
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestAudio2 
{
	public static void main(String[] args) 
			throws LineNotSupportedException, LineUnavailableException, IOException 
	{
		// Create new Recorder
		JKDLRecorder recorder = JKDLAudio.newRecorderWAV();
		// Creates a new thread that waits for a specified of time before stopping
		Thread stopper = new Thread(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Thread.sleep(TimePeriod.SECOND.toMilliseconds() * 5);
				} 
				catch(InterruptedException ex) 
				{
					ex.printStackTrace();
				}
				// Stop recording
				recorder.stop();
			}
		});
		stopper.start();
		// Start recording to given File
		recorder.start(new File("C:/Test/Record.wav"));
	}
}