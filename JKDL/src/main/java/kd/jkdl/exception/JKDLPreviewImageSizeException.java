package main.java.kd.jkdl.exception;

public class JKDLPreviewImageSizeException extends JKDLImageException
{
	private static final long serialVersionUID = -4329358672450876368L;
	
	private int _zoomLevel;
	
	public JKDLPreviewImageSizeException(String message) 
	{
		super(message);
		_zoomLevel = Integer.valueOf(message);
	}
	
	public int getZoomLevel()
	{
		return _zoomLevel;
	}
}