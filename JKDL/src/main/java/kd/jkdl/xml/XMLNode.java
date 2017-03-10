package main.java.kd.jkdl.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Single Node in XML File.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class XMLNode 
{
	/**
	 * Value of one tabulation from left.
	 */
	public static final String ONE_INDENT = "    ";
	
	/**
	 * Name of this Node.
	 */
	private final String _nodeName;
	
	/**
	 * Node attributes.
	 */
	private Map<String, String> _attributes;
	
	/**
	 * Text which this node contains.
	 */
	private String _text;
	
	/**
	 * Child Nodes of this Node.
	 */
	private List<XMLNode> _childs = new ArrayList<>();
	
	public XMLNode(String nodeName)
	{
		this(nodeName, null);
	}
	
	public XMLNode(String nodeName, String text)
	{
		this(nodeName, null, text);
	}
	
	public XMLNode(String nodeName, Map<String, String> attributes, String text)
	{
		this._nodeName = nodeName;
		this._attributes = attributes;
		this._text = text;
	}
	
	/**
	 * @return Return name of this Node.
	 */
	public String getNodeName()
	{
		return this._nodeName;
	}
	
	/**
	 * @return Return Map with all attributes of this Node.
	 */
	public Map<String, String> getAttributes()
	{
		return this._attributes;
	}
	
	/**
	 * Add new attribute to this Node.
	 * 
	 * @param name Name of the attribute
	 * @param value Value of the attribute
	 * 
	 * @return Return this Node.
	 */
	public XMLNode addAttribute(String name, String value)
	{
		if(this._attributes == null)
		{
			this._attributes = new HashMap<>();
		}
		this._attributes.put(name, value);
		return this;
	}
	
	/**
	 * @return Return the number of attributes of this Node.
	 */
	public int getAttributesNumber()
	{
		return getAttributes().size();
	}
	
	/**
	 * @return Return text which this node contains.
	 */
	public String getText()
	{
		return this._text;
	}
	
	/**
	 * @return Return all child Nodes.
	 */
	public List<XMLNode> getChildNodes()
	{
		return this._childs;
	}
	
	/**
	 * Add new child Node to this Node.
	 * 
	 * @param node Child to be add.
	 * 
	 * @return Return this Node.
	 */
	public XMLNode addChildNode(XMLNode node)
	{
		this._childs.add(node);
		return this;
	}
	
	/**
	 * Add multiple child Nodes.
	 * 
	 * @param nodes Child Nodes to be add.
	 * 
	 * @return Return this Node.
	 */
	public XMLNode addChildNodes(XMLNode... nodes)
	{
		for(XMLNode node : nodes)
		{
			addChildNode(node);
		}
		return this;
	}
	
	/**
	 * Remove child Node.
	 */
	public void removeChildNode(int index)
	{
		this._childs.remove(index);
	}
	
	/**
	 * Remove child Node.
	 */
	public void removeChildNode(XMLNode node)
	{
		this._childs.remove(node);
	}
	
	/**
	 * @return Return the number of child Nodes.
	 */
	public int getChildNodesNumber()
	{
		return getChildNodes().size();
	}
	
	/**
	 * @return Build Node in form of List.
	 */
	public List<String> build(String indent)
	{
		List<String> list = new ArrayList<>();
		// Constructing head ->  <...>
		String head = indent + "<" + this._nodeName;
		if(this._attributes != null)
		{
			for(Entry<String, String> attribute : this._attributes.entrySet())
			{
				head += " " + attribute.getKey() + "=" + "\"" + attribute.getValue() + "\"";
			}
		}
		head += ">";
		// Construct ending
		String end = "</" + this._nodeName + ">";
		// Add child Nodes or text Node
		String childIndent = indent + ONE_INDENT;
		if(!this._childs.isEmpty()) // If childs exists
		{
			list.add(head);
			for(XMLNode child : this._childs)
			{
				list.addAll(child.build(childIndent));
			}
			list.add(indent + end);
		}
		else if(this._text != null && !this._text.equals(""))// add text Node
		{
			list.add(head + this._text + end);
		}
		else
		{
			list.add(head + end);
		}
		return list;
	}
	
	/**
	 * @return Return this Node and all child Nodes in a String format.
	 */
	public String build()
	{
		// Constructing head ->  <...>
		String builded = "<" + this._nodeName;
		if(this._attributes != null)
		{
			for(Entry<String, String> attribute : this._attributes.entrySet())
			{
				builded += " " + attribute.getKey() + "=" + "\"" + attribute.getValue() + "\"";
			}
		}
		builded += ">";
		// Construct ending
		String end = "</" + this._nodeName + ">";
		// Add child Nodes or text Node
		if(!this._childs.isEmpty()) // If childs exists
		{
			for(XMLNode child : this._childs)
			{
				builded += child.build();
			}
			builded += end;
		}
		else if(this._text != null && !this._text.equals(""))// add text Node
		{
			builded += this._text + end;
		}
		else
		{
			builded += end;
		}
		return builded;
	}
}