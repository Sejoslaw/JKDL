package test.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import main.java.kd.jkdl.audio.JKDLAudio;

/**
 * Audio playing test
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestAudio3 
{
	public static void main(String[] args) 
			throws UnsupportedAudioFileException, IOException 
	{
		// Play audio from given File.
		JKDLAudio.playAudio(new File("C:/Test/Record.wav")); 
	}
}