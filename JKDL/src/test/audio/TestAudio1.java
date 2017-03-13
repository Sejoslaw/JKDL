package test.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

import main.java.kd.jkdl.audio.JKDLAudio;
import main.java.kd.jkdl.audio.JKDLRecorder;
import main.java.kd.jkdl.datetime.TimePeriod;
import main.java.kd.jkdl.exception.LineNotSupportedException;

/**
 * Audio Recording test -> record for some time example
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestAudio1 
{
	public static void main(String[] args) 
			throws LineNotSupportedException, LineUnavailableException, IOException 
	{
		// Create new Recorder
		JKDLRecorder recorder = JKDLAudio.newRecorderWAV();
		// Record 5 seconds and save record to File
		recorder.record(TimePeriod.SECOND.toMilliseconds() * 5, new File("C:/Test/Record.wav"));
	}
}