package main.java.kd.jkdl.html;

import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.ViewFactory;
import javax.swing.text.html.CSS;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.text.html.HTMLWriter;
import javax.swing.text.html.MinimalHTMLWriter;
import javax.swing.text.html.StyleSheet;

/**
 * TODO: Add support for HTML > 3.2
 * 
 * This class contains various methods to operate on HTML.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * 
 * @see HTML
 */
public class JHTML 
{
	private JHTML()
	{
	}
	
	/**
	 * @return Return Parser for HTMLDocument.
	 * 
	 * @see Parser
	 */
	public static Parser getParser(HTMLDocument doc)
	{
		return doc.getParser();
	}
	
	/**
	 * @return Return List of all child elements of specified element.
	 * 
	 * @see Element
	 */
	public static List<Element> getAllChilds(Element e)
	{
		List<Element> list = new ArrayList<>();
		int index = 0;
		Element child = e.getElement(index);
		while(child != null)
		{
			list.add(child);
			index++;
			child = e.getElement(index);
		}
		return list;
	}
	
	/**
	 * @return Return ViewFactory.
	 * 
	 * @see ViewFactory
	 */
	public static ViewFactory getViewFactory(HTMLEditorKit kit)
	{
		return kit.getViewFactory();
	}
	
	/**
	 * @return Return root Element.
	 * 
	 * @see Element
	 */
	public static Element getRootElement(Document doc)
	{
		return doc.getDefaultRootElement();
	}
	
	/**
	 * @return Return new Document.
	 * 
	 * @see Document
	 */
	public static Document newDocument(HTMLEditorKit kit)
	{
		return kit.createDefaultDocument();
	}
	
	/**
	 * @return Return new HTMLEditorKit.
	 * 
	 * @see HTMLEditorKit
	 */
	public static HTMLEditorKit newEditorKit()
	{
		return new HTMLEditorKit();
	}
	
	/**
	 * @param styleSheet StyleSHeet which will be use for this Document. Can be NULL.
	 * @param url URL of this Document.
	 * 
	 * @return Return new HTMLDocument.
	 * 
	 * @throws MalformedURLException 
	 * 
	 * @see HTMLDocument
	 */
	public static HTMLDocument newDocument(StyleSheet styleSheet, String url) 
			throws MalformedURLException
	{
		HTMLDocument doc;
		if(styleSheet == null)
		{
			doc = new HTMLDocument();
		}
		else
		{
			doc = new HTMLDocument(styleSheet);
		}
		doc.setBase(new URL(url));
		return doc;
	}
	
	/**
	 * @return Return new StyleSheet.
	 * 
	 * @see StyleSheet
	 */
	public static StyleSheet newStyleSheet()
	{
		return new StyleSheet();
	}
	
	/**
	 * @return Return new CSS.
	 * 
	 * @see CSS
	 */
	public static CSS newCSS()
	{
		return new CSS();
	}
	
	/**
	 * @return Return new HTMLWriter.
	 * 
	 * @see HTMLWriter#HTMLWriter(Writer, HTMLDocument, int, int)
	 */
	public static HTMLWriter newWriter(Writer writer, HTMLDocument doc, int pos, int len)
	{
		if(pos < 0)
		{
			pos = 0;
		}
		if(len <= 0)
		{
			len = doc.getLength();
		}
		return new HTMLWriter(writer, doc, pos, len);
	}
	
	/**
	 * @return Return new MinimalHTMLWriter.
	 * 
	 * @see MinimalHTMLWriter#MinimalHTMLWriter(Writer, javax.swing.text.StyledDocument, int, int)
	 */
	public static MinimalHTMLWriter newMinimalWriter(Writer writer, HTMLDocument doc, int pos, int len)
	{
		if(pos < 0)
		{
			pos = 0;
		}
		if(len <= 0)
		{
			len = doc.getLength();
		}
		return new MinimalHTMLWriter(writer, doc, pos ,len);
	}
}