package test.xml;

import java.io.File;
import java.util.HashMap;

import main.java.kd.jkdl.xml.XMLNode;
import main.java.kd.jkdl.xml.XMLWriter;

/**
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestXML3 
{
	public static void main(String[] args) 
	{
		// Create new Writer
		XMLWriter writer = new XMLWriter();
		// Add Nodes to Writer
		writer.addNodes(
				new XMLNode("node1", "Text1"),
				new XMLNode("node2", "Text2 is better than Text1"),
				new XMLNode("node3", new HashMap<>(), "Text3 is something even more")
					.addAttribute("att31", "att31Value")
					.addAttribute("att32", "att32Value"),
				new XMLNode("node4", "node4 has no text")
					.addChildNodes(
							new XMLNode("child41", "child41 text is just a text"),
							new XMLNode("child42", "child42 has the simplest text")
							.addChildNode(new XMLNode("childchild41"))
					),
				new XMLNode("node5", "node5 text is too short")
					.addAttribute("att51", "att51Value")
					.addAttribute("att52", "att52Value")
					.addChildNodes(
							new XMLNode("child51", "child51 has it's own unique text"),
							new XMLNode("child52")
							.addChildNode(new XMLNode("childchild51"))
					)
		);
		// Build XML inside Writer (NOTE: XML is not saved yet).
		writer.buildXML();
		// Print and before printing, return constructed XML in form of String.
		System.out.print(writer.writeToString());
		try
		{
			// Try to save XML into File.
			File file = writer.writeToFile("C:/Test/writer.xml");
			if(file != null)
			{
				System.out.print("File saved.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}