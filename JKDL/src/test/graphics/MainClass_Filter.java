package test.graphics;

import main.java.kd.jkdl.graphics.filter.JKDLFilterUtils;
import main.java.kd.jkdl.graphics.filter.PosterizeFilter;

public class MainClass_Filter 
{
	public static void main(String[] args) 
	{
		String testPicture = "C:/Test/pb.png";
		try
		{
			JKDLFilterUtils.previewImageBeforeAndAfterFiltr(testPicture, new PosterizeFilter(), 30);
		}
		catch(Exception e)
		{
		}
	}
}