package main.java.kd.jkdl.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.XMLFormatter;

import javax.xml.XMLConstants;
import javax.xml.bind.Binder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.util.JAXBResult;
import javax.xml.bind.util.JAXBSource;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.util.XMLEventAllocator;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.validation.SchemaFactory;
import javax.xml.ws.spi.Provider;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderAdapter;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * This class contains various methods to operate on Java XML API and files.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * 
 * @see XMLStreamConstants
 * @see XMLConstants
 * @see DatatypeConstants
 * @see XPathConstants
 */
public class JXML
{
	private JXML()
	{
	}
	
	/**
	 * @return Returns DOMImplementation.
	 * 
	 * @see DOMImplementation
	 */
	public static DOMImplementation getDOMImplementation(DOMImplementationRegistry registry, String features)
	{
		return registry.getDOMImplementation(features);
	}
	
	/**
	 * @return Returns attribute node as Attr.
	 * 
	 * @see Attr
	 */
	public static Attr getAttributeNode(Element e, String attributeNodename)
	{
		return e.getAttributeNode(attributeNodename);
	}
	
	/**
	 * @return Returns Node attributes as NamedNodeMap.
	 * 
	 * @see NamedNodeMap
	 */
	public static NamedNodeMap getNodeAttributes(Node node)
	{
		return node.getAttributes();
	}
	
	/**
	 * @return Returns Document from XML String.
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * 
	 * @see Document
	 */
	public static Document readDocument(String xmlString) 
			throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = newDocumentBuilderFactory();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(new InputSource(new StringReader(xmlString)));
	}
	
	/**
	 * @return Returns Document from File.
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * 
	 * @see Document
	 * @see File
	 */
	public static Document readDocument(File xmlFile) 
			throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = newDocumentBuilderFactory();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(xmlFile);
	}
	
	/**
	 * @return Returns NodeList with all child Nodes.
	 * 
	 * @see NodeList
	 */
	public static NodeList getChilds(Node node)
	{
		return node.getChildNodes();
	}
	
	/**
	 * @return Returns new XPath.
	 * 
	 * @see XPath
	 */
	public static XPath newXPath(XPathFactory factory)
	{
		return factory.newXPath();
	}
	
	/**
	 * @return Returns new instance of DOMImplementationRegistry.
	 * 
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassCastException
	 * 
	 * @see DOMImplementationRegistry
	 */
	public static DOMImplementationRegistry newDOMImplementationRegistry() 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassCastException
	{
		return DOMImplementationRegistry.newInstance();
	}
	
	/**
	 * @return Returns new XPathFactory.
	 * 
	 * @see XPathFactory
	 */
	public static XPathFactory newXPathFactory()
	{
		return XPathFactory.newInstance();
	}
	
	/**
	 * @return Returns a Provider.
	 * 
	 * @see Provider
	 */
	public static Provider getProvider()
	{
		return Provider.provider();
	}
	
	/**
	 * @return Returns new SchemaFactory.
	 * 
	 * @see SchemaFactory
	 */
	public static SchemaFactory newSchemaFactory(String schemaLanguage)
	{
		return SchemaFactory.newInstance(schemaLanguage);
	}
	
	/**
	 * @return Returns new SAXTransformerFactory.
	 * 
	 * @see SAXTransformerFactory
	 */
	public static SAXTransformerFactory newSAXTransformerFactory()
	{
		return (SAXTransformerFactory) SAXTransformerFactory.newInstance();
	}
	
	/**
	 * @return Returns a SOAPConnection.
	 * 
	 * @throws SOAPException 
	 * 
	 * @see SOAPConnection
	 */
	public static SOAPConnection newSOAPConnection(SOAPConnectionFactory factory) 
			throws SOAPException
	{
		return factory.createConnection();
	}
	
	/**
	 * @return Returns new SOAPConnectionFactory.
	 * 
	 * @throws SOAPException 
	 * @throws UnsupportedOperationException 
	 * 
	 * @see SOAPConnectionFactory
	 */
	public static SOAPConnectionFactory newSOAPConnectionFactory() 
			throws UnsupportedOperationException, SOAPException
	{
		return SOAPConnectionFactory.newInstance();
	}
	
	/**
	 * @return Returns a SOAPElement.
	 * 
	 * @throws SOAPException
	 * 
	 * @see SOAPElement
	 */
	public static SOAPElement newSOAPElement(SOAPFactory factory, String name) 
			throws SOAPException
	{
		return factory.createElement(name);
	}
	
	/**
	 * @return Returns new SOAPFactory.
	 * 
	 * @throws SOAPException
	 * 
	 * @see SOAPFactory
	 */
	public static SOAPFactory newSOAPFactory() 
			throws SOAPException
	{
		return SOAPFactory.newInstance();
	}
	
	/**
	 * @return Returns a SOAPHeader.
	 * 
	 * @throws SOAPException 
	 * 
	 * @see SOAPHeader
	 */
	public static SOAPHeader getSOAPHeader(SOAPMessage message) throws SOAPException
	{
		return message.getSOAPHeader();
	}
	
	/**
	 * @return Returns a SOAPBody.
	 * 
	 * @throws SOAPException 
	 * 
	 * @see SOAPBody
	 */
	public static SOAPBody getSOAPBody(SOAPMessage message) 
			throws SOAPException
	{
		return message.getSOAPBody();
	}
	
	/**
	 * @return Returns a SOAPPart.
	 * 
	 * @see SOAPPart
	 */
	public static SOAPPart getSOAPPart(SOAPMessage message)
	{
		return message.getSOAPPart();
	}
	
	/**
	 * @return Returns new SOAPMessage.
	 * 
	 * @throws SOAPException
	 * 
	 * @see SOAPMessage
	 */
	public static SOAPMessage newSOAPMessage(MessageFactory factory) 
			throws SOAPException
	{
		return factory.createMessage();
	}
	
	/**
	 * @return Returns new MessageFactory.
	 * 
	 * @throws SOAPException 
	 * 
	 * @see MessageFactory
	 */
	public static MessageFactory newMessageFactory() 
			throws SOAPException
	{
		return MessageFactory.newInstance();
	}
	
	/**
	 * @return Returns a XMLReader.
	 * 
	 * @throws SAXException
	 * 
	 * @see XMLReader
	 */
	public static XMLReader getXMLReader(SAXParser parser) 
			throws SAXException
	{
		return parser.getXMLReader();
	}
	
	/**
	 * @return Returns new SAXParser.
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * 
	 * @see SAXParser
	 */
	public static SAXParser newSAXParser(SAXParserFactory factory) 
			throws ParserConfigurationException, SAXException
	{
		return factory.newSAXParser();
	}
	
	/**
	 * @return Returns new SAXParserFactory.
	 * 
	 * @see SAXParserFactory
	 */
	public static SAXParserFactory newSAXParserFactory()
	{
		return SAXParserFactory.newInstance();
	}
	
	/**
	 * @return Returns new DatatypeFactory.
	 * 
	 * @throws DatatypeConfigurationException 
	 * 
	 * @see DatatypeFactory
	 */
	public static DatatypeFactory newDatatypeFactory() 
			throws DatatypeConfigurationException
	{
		return DatatypeFactory.newInstance();
	}
	
	/**
	 * @return Returns new Transformer.
	 * 
	 * @throws TransformerConfigurationException
	 * 
	 * @see Transformer
	 */
	public static Transformer newTransformer(TransformerFactory factory) 
			throws TransformerConfigurationException
	{
		return factory.newTransformer();
	}
	
	/**
	 * @return Returns new instance of TransformerFactory.
	 * 
	 * @see TransformerFactory
	 */
	public static TransformerFactory newTransformerFactory()
	{
		return TransformerFactory.newInstance();
	}
	
	/**
	 * @return Returns new JAXBSource
	 * 
	 * @throws JAXBException
	 * 
	 * @see JAXBSource
	 */
	public static JAXBSource newJAXBSource(JAXBContext context, Object object) 
			throws JAXBException
	{
		return new JAXBSource(context, object);
	}
	
	/**
	 * @return Returns new JAXBResult.
	 * 
	 * @throws JAXBException
	 * 
	 * @see JAXBContext
	 * @see JAXBResult
	 */
	public static JAXBResult newJAXBResult(JAXBContext context) 
			throws JAXBException
	{
		return new JAXBResult(context);
	}
	
	/**
	 * @return Returns value from JAXBElement.
	 * 
	 * @see JAXBElement
	 * @see JAXBIntrospector
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getJAXBElementValue(JAXBElement<T> element)
	{
		return (T) JAXBIntrospector.getValue(element);
	}
	
	/**
	 * @return Returns new instance of JAXBContext of the given Class.
	 * 
	 * @throws JAXBException
	 * 
	 * @see JAXBContext
	 */
	public static JAXBContext newJAXBContext(Class<?> classesToBeBound) 
			throws JAXBException
	{
		return JAXBContext.newInstance(classesToBeBound);
	}
	
	/**
	 * @return Returns an JAXBIntrospector.
	 * 
	 * @see JAXBIntrospector
	 */
	public static JAXBIntrospector newJAXBIntrospector(JAXBContext context)
	{
		return context.createJAXBIntrospector();
	}
	
	/**
	 * @return Returns an Marshaller.
	 * 
	 * @throws JAXBException 
	 * 
	 * @see Marshaller
	 */
	public static Marshaller getMarshaller(JAXBContext context) 
			throws JAXBException
	{
		return context.createMarshaller();
	}
	
	/**
	 * @return Returns an Unmarshaller.
	 * 
	 * @throws JAXBException 
	 * 
	 * @see Unmarshaller
	 */
	public static Unmarshaller getUnmarshaller(JAXBContext context) 
			throws JAXBException
	{
		return context.createUnmarshaller();
	}
	
	/**
	 * @return Returns new Binder for Node class.
	 * 
	 * @see Binder
	 * @see Node
	 */
	public static Binder<Node> newBinder(JAXBContext context)
	{
		return context.createBinder();
	}
	
	/**
	 * @return Returns new instance of XMLEventFactory.
	 * 
	 * @see XMLEventFactory#newFactory
	 */
	public static XMLEventFactory newEventFactory()
	{
		return XMLEventFactory.newFactory();
	}
	
	/**
	 * @return Returns new instance of XMLInputFactory.
	 * 
	 * @see XMLInputFactory#newFactory
	 */
	public static XMLInputFactory newInputFactory()
	{
		return XMLInputFactory.newFactory();
	}
	
	/**
	 * @return Returns an XMLOutputFactory.
	 * 
	 * @see XMLOutputFactory
	 */
	public static XMLOutputFactory newOutputFactory()
	{
		return XMLOutputFactory.newFactory();
	}
	
	/**
	 * @return Returns instance of XMLSignatureFactory.
	 * 
	 * @see XMLSignatureFactory#getInstance
	 */
	public static XMLSignatureFactory newSignatureFactory()
	{
		return XMLSignatureFactory.getInstance();
	}
	
	/**
	 * @return Returns instance of DocumentBuilderFactory
	 * 
	 * @see DocumentBuilderFactory
	 */
	public static DocumentBuilderFactory newDocumentBuilderFactory()
	{
		return DocumentBuilderFactory.newInstance();
	}
	
	/**
	 * @return Returns new instance of XMLFormatter.
	 * 
	 * @see XMLFormatter
	 */
	public static XMLFormatter newFormatter()
	{
		return new XMLFormatter();
	}
	
	/**
	 * @param file File from which reader should read data.
	 * @param isFile Indicates if XML should be read from File.
	 * 
	 * @return Returns new XMLReader.
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * 
	 * @see XMLReader
	 */
	public static main.java.kd.jkdl.xml.XMLReader newReader(String file, boolean isFile) 
			throws ParserConfigurationException, SAXException, IOException
	{
		return new main.java.kd.jkdl.xml.XMLReader(file, isFile);
	}
	
	/**
	 * @param out Stream into which XML should be write.
	 * 
	 * @return Returns new XMLEncoder.
	 * 
	 * @see XMLEncoder
	 */
	public static XMLEncoder newEncoder(OutputStream out)
	{
		return new XMLEncoder(out);
	}
	
	/**
	 * @param in Stream from which XML should be read.
	 * 
	 * @return Returns new XMLDecoder.
	 * 
	 * @see XMLDecoder
	 */
	public static XMLDecoder newDecoder(InputStream in)
	{
		return new XMLDecoder(in);
	}
	
	/**
	 * @param in Source from which XML should be read.
	 * 
	 * @return Returns new XMLDecoder.
	 * 
	 * @see XMLDecoder
	 */
	public static XMLDecoder newDecoder(InputSource is)
	{
		return new XMLDecoder(is);
	}
	
	/**
	 * @return Returns an XMLGregorianCalendar.
	 * 
	 * @throws DatatypeConfigurationException
	 * 
	 * @see XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar newGregorianCalendar(DatatypeFactory factory) 
			throws DatatypeConfigurationException
	{
		return factory.newXMLGregorianCalendar();
	}
	
	/**
	 * @return Returns an XMLObject.
	 * 
	 * @see XMLSignatureFactory#newXMLObject(List, String, String, String)
	 */
	@SuppressWarnings("rawtypes")
	public static XMLObject newObject(XMLSignatureFactory factory, 
			List content, String id, String mimeType, String encoding)
	{
		return factory.newXMLObject(content, id, mimeType, encoding);
	}
	
	/**
	 * @return Returns an XMLSignature.
	 * 
	 * @see XMLSignatureFactory#newXMLSignature(SignedInfo, KeyInfo, List, String, String)
	 */
	@SuppressWarnings("rawtypes")
	public static XMLSignature newSignature(XMLSignatureFactory factory, 
			SignedInfo si, KeyInfo ki, List objects, String id, String signatureValueId)
	{
		return factory.newXMLSignature(si, ki, objects, id, signatureValueId);
	}
	
	/**
	 * @return Returns an XMLStreamReader.
	 * 
	 * @throws XMLStreamException
	 * 
	 * @see XMLStreamReader
	 */
	public static XMLStreamReader newStreamReader(XMLInputFactory factory, InputStream stream) 
			throws XMLStreamException
	{
		return factory.createXMLStreamReader(stream);
	}
	
	/**
	 * @return Returns an XMLStreamWriter
	 * 
	 * @throws XMLStreamException
	 * 
	 * @see XMLStreamWriter
	 */
	public static XMLStreamWriter newStreamWriter(XMLOutputFactory factory, OutputStream stream) 
			throws XMLStreamException
	{
		return factory.createXMLStreamWriter(stream);
	}
	
	/**
	 * @return Returns an XMLEventReader
	 * 
	 * @throws XMLStreamException
	 * 
	 * @see XMLEventReader
	 */
	public static XMLEventReader newEventReader(XMLInputFactory factory, XMLStreamReader reader) 
			throws XMLStreamException
	{
		return factory.createXMLEventReader(reader);
	}
	
	/**
	 * @return Returns an XMLEventWriter
	 * 
	 * @throws XMLStreamException
	 * 
	 * @see XMLEventWriter
	 */
	public static XMLEventWriter newEventWriter(XMLOutputFactory factory, OutputStream stream) 
			throws XMLStreamException
	{
		return factory.createXMLEventWriter(stream);
	}
	
	/**
	 * @return Returns an XMLResolver.
	 * 
	 * @see XMLResolver
	 */
	public static XMLResolver getResolver(XMLInputFactory factory)
	{
		return factory.getXMLResolver();
	}
	
	/**
	 * @return Returns an XMLReporter.
	 * 
	 * @see XMLReporter
	 */
	public static XMLReporter getReporter(XMLInputFactory factory)
	{
		return factory.getXMLReporter();
	}
	
	/**
	 * @return Returns an XMLEventAllocator
	 * 
	 * @see XMLEventAllocator
	 */
	public static XMLEventAllocator getEventAllocator(XMLInputFactory factory)
	{
		return factory.getEventAllocator();
	}
	
	/**
	 * @return Returns new {@link org.xml.sax.XMLReader}
	 * 
	 * @throws SAXException 
	 * 
	 * @see XMLReaderFactory
	 * @see org.xml.sax.XMLReader
	 */
	public static org.xml.sax.XMLReader newReader() 
			throws SAXException
	{
		return XMLReaderFactory.createXMLReader();
	}
	
	/**
	 * @return Returns new XMLReaderAdapter.
	 * 
	 * @throws SAXException
	 * 
	 * @see XMLReaderAdapter
	 */
	public static XMLReaderAdapter newReaderAdapter() 
			throws SAXException
	{
		return new XMLReaderAdapter();
	}
	
	/**
	 * @param parent The parent reader.
	 * 
	 * @return Returns new XMLFilter.
	 * 
	 * @see XMLFilter
	 */
	public static XMLFilter newFilter(XMLReader parent)
	{
		return new XMLFilterImpl(parent);
	}
	
	/**
	 * @param file Path to file.
	 * 
	 * @return Returns XMLReader which already read the XML file.
	 * 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * 
	 * @see Document
	 * @see Element
	 */
	public static main.java.kd.jkdl.xml.XMLReader readXML(String file, boolean isFile) 
			throws ParserConfigurationException, SAXException, IOException
	{
		return new main.java.kd.jkdl.xml.XMLReader(file, isFile);
	}
	
	/**
	 * @param file Path to file.
	 * @param clazz Class that extends {@link DefaultHandler}.
	 * 
	 * @return Returns SAXParser which has already read given XML file.
	 * 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static SAXParser readXML(String file, Class<? extends DefaultHandler> clazz) 
			throws InstantiationException, IllegalAccessException, 
			ParserConfigurationException, SAXException, IOException
	{
		return readXML(new File(file), clazz);
	}
	
	/**
	 * @param file Path to file.
	 * @param clazz Class that extends {@link DefaultHandler}.
	 * 
	 * @return Returns SAXParser which has already read given XML file.
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static SAXParser readXML(File file, Class<? extends DefaultHandler> clazz) 
			throws InstantiationException, IllegalAccessException, 
			ParserConfigurationException, SAXException, IOException
	{
		DefaultHandler handler = clazz.newInstance();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		saxParser.parse(file, handler);
		return saxParser;
	}
	
	/**
	 * Shows the window with XML text.
	 * 
	 * @param file Path to file.
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static XMLPreviewWindow previewXML(String file, boolean isFile)
			throws ParserConfigurationException, SAXException, IOException
	{
		return previewXML(new main.java.kd.jkdl.xml.XMLReader(file, isFile));
	}
	
	/**
	 * Shows the window with XML text.
	 * 
	 * @param reader XMLReader to display.
	 */
	public static XMLPreviewWindow previewXML(main.java.kd.jkdl.xml.XMLReader reader)
	{
		return new XMLPreviewWindow(reader);
	}
	
	/**
	 * @param file File into which objects will be written.
	 * @param objectToWrite Object to write.
	 * 
	 * @return Returns TRUE if object was written correctly, else returns FALSE.
	 * 
	 * @throws IOException This Exception is thrown if something went wrong with File.
	 * 
	 * @see {@link XmlRootElement} - Class of the given Object must have this annotation.
	 * @see {@link XmlElement} - Optional annotation for setter.
	 * @see {@link XmlAttribute} - Optional annotation for setter.
	 * 
	 * @see {@link #readObjectFromXML(File)}
	 */
	public static boolean writeObjectToXML(File file, Object objectToWrite) 
			throws IOException
	{
		if(file == null || objectToWrite == null)
		{
			return false;
		}
		if(!file.exists())
		{
			file.createNewFile();
		}
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
		encoder.writeObject(objectToWrite);
		encoder.close();
		return true;
	}
	
	/**
	 * @param file File into which objects will be written.
	 * @param objectsToWrite Object array to write.
	 * 
	 * @return Returns TRUE if object was written correctly, else returns FALSE.
	 * 
	 * @throws IOException This Exception is thrown if something went wrong with File.
	 * 
	 * @see {@link XmlRootElement} - Class of the given Object must have this annotation.
	 * @see {@link XmlElement} - Optional annotation for setter.
	 * @see {@link XmlAttribute} - Optional annotation for setter.
	 * 
	 * @see {@link #readObjectFromXML(File)}
	 */
	public static boolean writeObjectToXML(File file, Object[] objectsToWrite) 
			throws IOException
	{
		if(file == null || objectsToWrite == null)
		{
			return false;
		}
		if(!file.exists())
		{
			file.createNewFile();
		}
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
		encoder.writeObject(objectsToWrite);
		encoder.close();
		return true;
	}
	
	/**
	 * @param file File from which objects should be read.
	 * 
	 * @return Returns all read objects from given File.
	 * 
	 * @throws FileNotFoundException This Exception is thrown if something went wrong with File.
	 * 
	 * @see {@link #writeObjectToXML(File, Object)}
	 */
	public static List<Object> readObjectFromXML(File file) 
			throws FileNotFoundException
	{
		if(file == null)
		{
			return null;
		}
		if(!file.exists())
		{
			return null;
		}
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
		List<Object> objects = new ArrayList<>();
		try
		{
			Object nextObject = decoder.readObject();
			while(nextObject != null)
			{
				objects.add(nextObject);
				try
				{
					nextObject = decoder.readObject();
				}
				catch(Exception e)
				{
					nextObject = null;
				}
			}
		}
		catch(Exception e)
		{
		}
		decoder.close();
		return objects;
	}
	
	/**
	 * @return Returns new XMLWriter.
	 * 
	 * @see XMLWriter
	 */
	public static XMLWriter newWriter()
	{
		return new XMLWriter();
	}
}