package main.java.kd.jkdl.xml;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * This is the base class used for reading XML from {@link File} or from String.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class XMLReader
{
	/**
	 * XML file.
	 */
	private final File _xmlFile;
	
	/**
	 * Document.
	 */
	private final Document _document;
	
	/**
	 * Root element in read document.
	 */
	private final Element _rootElement;
	
	/**
	 * Determines if the checking XML is taken from File.
	 */
	private final boolean _isFile;
	
	/**
	 * @param file
	 * @param isFile
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * 
	 * @see {@link JXML#newReader(String, boolean)}
	 */
	public XMLReader(String file, boolean isFile) 
			throws ParserConfigurationException, SAXException, IOException
	{
		this._isFile = isFile;
		
		if(this._isFile)
		{
			this._xmlFile = new File(file);
		}
		else
		{
			this._xmlFile = null;
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		if(this._isFile)
		{
			this._document = builder.parse(this._xmlFile); // Parse from File
		}
		else
		{
			this._document = builder.parse(new InputSource(new StringReader(file))); // Parse from String
		}
		
		this._document.getDocumentElement().normalize();
		this._rootElement = this._document.getDocumentElement();
	}
	
	/**
	 * @return Returns TRUE if the XML was read from file.
	 */
	public boolean getIsFile()
	{
		return this._isFile;
	}
	
	/**
	 * @return Returns XML file. NULL if XML was given as string, not from file.
	 */
	public File getFile()
	{
		return this._xmlFile;
	}
	
	/**
	 * @return Returns XML document.
	 */
	public Document getDocument()
	{
		return this._document;
	}
	
	/**
	 * @return Returns root element of this document.
	 */
	public Element getRootElement()
	{
		return this._rootElement;
	}
}