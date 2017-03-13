package test.graphics;

import java.io.IOException;

import main.java.kd.jkdl.exception.JKDLPreviewImageSizeException;
import main.java.kd.jkdl.graphics.JKDLImage;
import main.java.kd.jkdl.graphics.JKDLImageHelper;
import main.java.kd.jkdl.graphics.JKDLImageUtils;

public class MainClass 
{
	public static void main(String[] args) 
	{
		String testPicture = "C:/Test/pb.png";
		try 
		{
			JKDLImage image = new JKDLImage(testPicture);
			JKDLImageHelper rfih = new JKDLImageHelper(image);
			System.out.println(rfih.getR(7, 1));
			System.out.println(rfih.getG(7, 1));
			System.out.println(rfih.getB(7, 1));
			System.out.println(rfih.getA(7, 1));
			System.out.println();
			//rfih.setRGBA(7, 1, 0, 120, 0, 120);
			System.out.println(rfih.getR(7, 1));
			System.out.println(rfih.getG(7, 1));
			System.out.println(rfih.getB(7, 1));
			System.out.println(rfih.getA(7, 1));
			//rfih.saveImage("png", "C:/Test/pb1.png");
			//rfih.preview(30);
			//image.preview(30);
			//RFImageUtils.rotateImage(image.getImage(), 120, true, 30);
			image.preview(30);
			JKDLImageUtils.flip180Degree(image);
			image.preview(30);
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		} 
		catch(JKDLPreviewImageSizeException e) 
		{
			e.printStackTrace();
		}
	}
}