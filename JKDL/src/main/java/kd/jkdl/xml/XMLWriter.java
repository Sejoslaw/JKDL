package main.java.kd.jkdl.xml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the base class used for writing XML to {@link File}. <br>
 * <br>
 * NOTE !!! <br>
 * This may not be compatible with {@link XMLReader}. <br>
 * This XMLWriter is used if User want to write it's own XML File. Keep that in mind.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * 
 * @see XMLNode
 * @see XMLReader
 */
public class XMLWriter
{
	/**
	 * List of all root Nodes in this Writer.
	 */
	private List<XMLNode> _rootNodes = new ArrayList<>();
	
	/**
	 * XML String.
	 */
	private String _xmlString = "";
	
	/**
	 * XML List.
	 */
	private List<String> _xmlList = new ArrayList<>();
	
	/**
	 * XML Properties Node.
	 * If it exists it is a first Node in file.
	 */
	private XMLPropertiesNode _propertiesNode = null;
	
	/**
	 * @return Return the Properties Node.
	 */
	public XMLPropertiesNode getPropertiesNode()
	{
		return this._propertiesNode;
	}
	
	/**
	 * Set Properties Node.
	 */
	public void setPropertiesNode(XMLPropertiesNode newPropertiesNode)
	{
		this._propertiesNode = newPropertiesNode;
	}
	
	/**
	 * Add Nodes to writer.
	 * 
	 * @param nodes
	 */
	public void addNodes(XMLNode... nodes) 
	{
		for(XMLNode node : nodes)
		{
			this._rootNodes.add(node);
		}
	}
	
	/**
	 * @return Return all root Nodes.
	 */
	public List<XMLNode> getRootNodes()
	{
		return this._rootNodes;
	}
	
	/**
	 * Remove root Node.
	 */
	public void removeRootNode(int index)
	{
		this._rootNodes.remove(index);
	}
	
	/**
	 * Remove root Node.
	 */
	public void removeRootNode(XMLNode node)
	{
		this._rootNodes.remove(node);
	}
	
	/**
	 * @return Return the number of root Nodes.
	 */
	public int getRootNodesNumber()
	{
		return getRootNodes().size();
	}
	
	/**
	 * Build the XML inside writer. Run this method before writing to {@link File} or String. <br>
	 * After each time this will firstly clear previously saved data.
	 */
	public void buildXML()
	{
		// Build XML String
		this._xmlString = "";
		if(this._propertiesNode != null)
		{
			this._xmlString += this._propertiesNode.build();
		}
		for(XMLNode rootNode : this._rootNodes)
		{
			this._xmlString += rootNode.build();
		}
		// Build XML List
		this._xmlList.clear();
		if(this._propertiesNode != null)
		{
			this._xmlList.add(this._propertiesNode.build());
		}
		for(XMLNode rootNode : this._rootNodes)
		{
			this._xmlList.addAll(rootNode.build(""));
		}
	}
	
	/**
	 * @return Return XML in a form of String.
	 */
	public String writeToString()
	{
		return this._xmlString;
	}
	
	/**
	 * @param file Path to File.
	 * 
	 * @return Return {@link File} with XML.
	 * 
	 * @throws IOException 
	 */
	public File writeToFile(String pathToFile) 
			throws IOException
	{
		// Check if File exists
		File file = new File(pathToFile);
		if(!file.exists())
		{
			file.createNewFile();
		}
		else
		{
			file.delete();
			file.createNewFile();
		}
		// Save XML to File
		PrintWriter writer = new PrintWriter(file);
		for(String xmlLine : this._xmlList)
		{
			writer.println(xmlLine);
		}
		writer.flush();
		writer.close();
		return file;
	}
}