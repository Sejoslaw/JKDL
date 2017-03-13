package main.java.kd.jkdl.audio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 * This class contains various methods to operate on Java Audio API. <br>
 * This is basically a handler for most of Java build-in methods. <br>
 * Try to use {@link AudioSystem}, this class contains most of needed methods.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * 
 * @see AudioFileFormat
 * @see AudioFormat
 * @see AudioInputStream
 * @see AudioSystem
 * @see Clip
 * @see Mixer
 * @see SourceDataLine
 * @see TargetDataLine
 */
public class JKDLAudio 
{
	private JKDLAudio()
	{
	}
	
	/**
	 * Stop playing audio from given InputStream.
	 * 
	 * @see InputStream
	 */
	public static void stopAudio(InputStream inputStream)
	{
		AudioPlayer.player.stop(inputStream);
	}
	
	/**
	 * Stop playing audio from given File.
	 * 
	 * @see AudioInputStream
	 */
	public static void stopAudio(File file) 
			throws UnsupportedAudioFileException, IOException
	{
		AudioPlayer.player.stop(AudioSystem.getAudioInputStream(file));
	}
	
	/**
	 * Stop playing audio in loop from given ContinuousAudioDataStream.
	 * 
	 * @see ContinuousAudioDataStream
	 */
	public static void stopLoopAudio(ContinuousAudioDataStream cas)
	{
		AudioPlayer.player.stop(cas);
	}
	
	/**
	 * Play audio from given File. <br>
	 * It will play audio at new thread to make it cleaner.
	 * 
	 * @return thread which play audio.
	 */
	public static Thread playAudio(File file) 
			throws UnsupportedAudioFileException, IOException
	{
		Thread sound = new Thread()
		{
			public void run()
			{
				try 
				{
					AudioPlayer.player.start(newAudioStream(file));
				} 
				catch(IOException e) 
				{
					e.printStackTrace();
					return;
				}
			}
		};
		sound.start();
		return sound;
	}
	
	/**
	 * Play audio from given InputStream.
	 * 
	 * @return thread which play audio.
	 * 
	 * @see InputStream
	 */
	public static Thread playAudio(InputStream inputStream)
	{
		Thread sound = new Thread()
		{
			public void run()
			{
				AudioPlayer.player.start(inputStream);
			}
		};
		sound.start();
		return sound;
	}
	
	/**
	 * Play audio in a loop from given ContinuousAudioDataStream.
	 * 
	 * @return thread which play audio.
	 * 
	 * @see ContinuousAudioDataStream
	 */
	public static Thread loopAudio(ContinuousAudioDataStream cas)
	{
		Thread sound = new Thread()
		{
			public void run()
			{
				AudioPlayer.player.start(cas);
			}
		};
		sound.start();
		return sound;
	}
	
	/**
	 * @return thread which play audio.
	 */
	public static Thread loopAudio(File file)
	{
		Thread sound = new Thread()
		{
			public void run()
			{
				try 
				{
					AudioData audioData = getAudioData(newAudioStream(file));
					ContinuousAudioDataStream stream = newContinuousAudioDataStream(audioData);
					AudioPlayer.player.start(stream);
				} 
				catch(IOException e) 
				{
					e.printStackTrace();
					return;
				}
			}
		};
		sound.start();
		return sound;
	}
	
	/**
	 * @return new ContinuousAudioDataStream
	 * 
	 * @see ContinuousAudioDataStream
	 */
	public static ContinuousAudioDataStream newContinuousAudioDataStream(AudioData data)
	{
		return new ContinuousAudioDataStream(data);
	}
	
	/**
	 * @return AudioData from given AudioStream.
	 * 
	 * @see AudioData
	 */
	public static AudioData getAudioData(AudioStream stream) 
			throws IOException
	{
		return stream.getData();
	}
	
	/**
	 * @return new AudioStream.
	 * 
	 * @see AudioStream
	 */
	public static AudioStream newAudioStream(URL url) 
			throws IOException
	{
		return new AudioStream(url.openStream());
	}
	
	/**
	 * @return new AudioStream.
	 * 
	 * @see AudioStream
	 */
	public static AudioStream newAudioStream(File file) 
			throws FileNotFoundException, IOException
	{
		return new AudioStream(new FileInputStream(file));
	}
	
	/**
	 * Play WAV File.
	 */
	public static void playWAV(File wavFile) 
			throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(wavFile);
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	}
	
	/**
	 * @return new JKDLRecorder preconfigured on wave type and WAV audio format.
	 * 
	 * @see JKDLRecorder
	 */
	public static JKDLRecorder newRecorderWAV()
	{
		return newRecorder(Type.WAVE, newAudioFormatWAV());
	}
	
	/**
	 * @return new JKDLRecorder.
	 * 
	 * @see JKDLRecorder
	 */
	public static JKDLRecorder newRecorder(Type formatType, AudioFormat audioFormat)
	{
		return new JKDLRecorder(formatType, audioFormat);
	}
	
	/**
	 * Constructs an audio file format object.
	 * This public constructor may be used by applications to describe the
	 * properties of a requested audio file.
	 * 
	 * @param type the type of the audio file
	 * @param format the format of the audio data contained in the file
	 * @param frameLength the audio data length in sample frames, or <code>AudioSystem.NOT_SPECIFIED</code>
	 * 
	 * @return new AudioFileFormat.
	 * 
	 * @see AudioFileFormat
	 */
	public static AudioFileFormat newAudioFileFormat(Type type, AudioFormat format, int frameLength)
	{
		return new AudioFileFormat(type, format, frameLength);
	}
	
	/**
	 * @return preconfigured WAV audio format.
	 * 
	 * @see AudioFormat
	 * @see #newAudioFormat(float, int, int, boolean, boolean)
	 */
	public static AudioFormat newAudioFormatWAV()
	{
		return newAudioFormat(16000, 8, 2, true, true);
	}
	
	/**
	 * @return an <code>AudioFormat</code> with a linear PCM encoding and
	 * the given parameters.  The frame size is set to the number of bytes
	 * required to contain one sample from each channel, and the frame rate
	 * is set to the sample rate.
	 *
	 * @param sampleRate                the number of samples per second
	 * @param sampleSizeInBits  		the number of bits in each sample
	 * @param channels                  the number of channels (1 for mono, 2 for stereo, and so on)
	 * @param signed                    indicates whether the data is signed or unsigned
	 * @param bigEndian                 indicates whether the data for a single sample
	 *                                                  is stored in big-endian byte order (<code>false</code>
	 *                                                  means little-endian)
	 *      
	 * @see AudioFormat
	 */
	public static AudioFormat newAudioFormat(float sampleRate, int sampleSizeInBits, int channels, boolean signed, boolean bigEndian)
	{
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}
}