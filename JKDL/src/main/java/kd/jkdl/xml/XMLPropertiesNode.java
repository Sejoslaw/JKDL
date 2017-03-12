package main.java.kd.jkdl.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Properties Node in XML File.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class XMLPropertiesNode extends XMLNode
{
	public XMLPropertiesNode()
	{
		this(null);
	}
	
	public XMLPropertiesNode(Map<String, String> attributes) 
	{
		super("xml", attributes, null);
	}
	
	public List<String> build(String indent)
	{
		List<String> list = new ArrayList<>();
		String builded = build();
		list.add(builded);
		return list;
	}
	
	public String build()
	{
		String builded = "<?xml";
		if(this.getAttributes() != null)
		{
			if(this.getAttributes().size() > 0)
			{
				for(Entry<String, String> attribute : this.getAttributes().entrySet())
				{
					builded += " " + attribute.getKey() + "=" + "\"" + attribute.getValue() + "\"";
				}
			}
		}
		builded += "?>";
		return builded;
	}
}