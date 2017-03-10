package test.html;

import java.util.List;

import javax.swing.text.Element;
import javax.swing.text.html.HTMLDocument;

import main.java.kd.jkdl.html.JHTML;

/**
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestJHTML 
{
	public static void main(String[] args) 
	{
		try
		{
			HTMLDocument doc = JHTML.newDocument(null, "https://minecraft.curseforge.com/projects/vanilla-magic");
			Element e = doc.getDefaultRootElement();
			System.out.println(e.getName());
			
			List<Element> childs = JHTML.getAllChilds(e);
			for(Element el : childs)
			{
				System.out.println(el.getName());
			}
			
			System.out.print(doc.getBase());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}