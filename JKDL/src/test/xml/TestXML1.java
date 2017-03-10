package test.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import main.java.kd.jkdl.xml.JXML;
import main.java.kd.jkdl.xml.XMLReader;

/**
 * This test shows a basic Reader for XML and also prints XML in window.
 * First XML is taken from File.
 * Second is taken from String.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestXML1 
{
	static final String testXML = 
					"<?xml version=\"1.0\"?>\n" +
					"<simplepaint version=\"1.0\">\n" +
					"   <background red='255' green='153' blue='51'/>\n" +
					"   <curve>\n" +
					"      <color red='0' green='0' blue='255'/>\n" +
					"      <symmetric>false</symmetric>\n" +
					"      <point x='83' y='96'/>\n" +
					"      <point x='116' y='149'/>\n" +
					"      <point x='159' y='215'/>\n" +
					"      <point x='216' y='294'/>\n" +
					"      <point x='264' y='359'/>\n" +
					"      <point x='309' y='418'/>\n" +
					"      <point x='371' y='499'/>\n" +
					"      <point x='400' y='543'/>\n" +
					"   </curve>\n" +
					"   <curve>\n" +
					"      <color red='255' green='255' blue='255'/>\n" +
					"      <symmetric>true</symmetric>\n" +
					"      <point x='54' y='305'/>\n" +
					"      <point x='79' y='289'/>\n" +
					"      <point x='128' y='262'/>\n" +
					"      <point x='190' y='236'/>\n" +
					"      <point x='253' y='209'/>\n" +
					"      <point x='341' y='158'/>\n" +
					"   </curve>\n" +
					"</simplepaint>\n";
	
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException
	{
		// Read XML
		XMLReader reader = JXML.readXML("C:/Test/cd.xml", true); // True, because this XML is taken from File (this XML is a file).
		JXML.previewXML(reader).show(); // Convert readed XML into XMLPreviewWindow and show that Window.
		JXML.previewXML(testXML, false).show(); // Convert XML from String into XMLPreviewWindow and show that Window.
	}
}