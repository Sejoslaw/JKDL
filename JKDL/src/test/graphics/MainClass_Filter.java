package test.graphics;

import main.java.kd.jkdl.graphics.filter.PosterizeFilter;
import main.java.kd.jkdl.graphics.filter.RFFilterUtils;

public class MainClass_Filter 
{
	public static void main(String[] args) 
	{
		String testPicture = "C:/Test/pb.png";
		try
		{
			RFFilterUtils.previewImageBeforeAndAfterFiltr(testPicture, new PosterizeFilter(), 30);
		}
		catch(Exception e)
		{
		}
	}
}