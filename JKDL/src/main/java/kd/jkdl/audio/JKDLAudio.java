package main.java.kd.jkdl.audio;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

/**
 * TODO: Add support for Java build-in Audio API.
 * 
 * This class contains various methods to operate on Java Audio API. <br>
 * This is basically a handler for most of Java build-in methods.
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
	 * @return Return new JKDLRecorder preconfigured on wave type and WAV audio format.
	 * 
	 * @see JKDLRecorder
	 */
	public static JKDLRecorder newRecorderWAV()
	{
		return newRecorder(Type.WAVE, newAudioFormatWAV());
	}
	
	/**
	 * @return Return new JKDLRecorder.
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
	 * @return Return new AudioFileFormat.
	 * 
	 * @see AudioFileFormat
	 */
	public static AudioFileFormat newAudioFileFormat(Type type, AudioFormat format, int frameLength)
	{
		return new AudioFileFormat(type, format, frameLength);
	}
	
	/**
	 * @return Return preconfigured WAV audio format.
	 * 
	 * @see AudioFormat
	 * @see #newAudioFormat(float, int, int, boolean, boolean)
	 */
	public static AudioFormat newAudioFormatWAV()
	{
		return newAudioFormat(16000, 8, 2, true, true);
	}
	
	/**
	 * @return Return an <code>AudioFormat</code> with a linear PCM encoding and
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