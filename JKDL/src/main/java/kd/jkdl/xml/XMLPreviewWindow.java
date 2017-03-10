package main.java.kd.jkdl.xml;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Window with XML text.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class XMLPreviewWindow extends JPanel
{
	private static final long serialVersionUID = 4603540545549114772L;
	
	/**
	 * XMLReader connected with this window.
	 */
	private final XMLReader _reader;
	
	private final JFrame _window;
	private final JTextArea _input;
	private final JTextArea _output;
	
	public XMLPreviewWindow(XMLReader reader)
	{
		this._reader = reader;
		
		// Window creation
		this._window = new JFrame(this._reader.getDocument().getBaseURI());
		
		// Panel creation
		setLayout(new BorderLayout(3, 3));
		setPreferredSize(new Dimension(550, 550));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		
		JPanel buttonBar = new JPanel();
		add(buttonBar, BorderLayout.SOUTH);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.GRAY);
		mainPanel.setLayout(new GridLayout(2, 1, 3, 3));
		add(mainPanel, BorderLayout.CENTER);
		
		this._input = new JTextArea("");
		this._input.setLineWrap(false);
		this._input.setMargin(new Insets(3, 3, 3, 3));
		mainPanel.add(new JScrollPane(this._input));
		
		this._output = new JTextArea();
		this._output.setLineWrap(true);
		this._output.setWrapStyleWord(true);
		this._output.setMargin(new Insets(3,3,3,3));
		this._output.setEditable(false);
		mainPanel.add(new JScrollPane(this._output));
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				_input.setText("");
				_output.setText("");
				_input.requestFocus();
			}
		});
		buttonBar.add(clearButton);
		
		JButton parseButton = new JButton("Show XML");
		parseButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				parse();
			}
		});
		buttonBar.add(parseButton);
		
		// End Window initialization
		this._window.setContentPane(this);
		this._window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this._window.pack();
		this._window.setLocation(100, 70);
	}
	
	private void parse()
	{
		this._output.setText("");
		listNodes(this._reader.getRootElement(), "", 1);
	}
	
	private void listNodes(Element node, String indent, int level)
	{
		this._input.append(indent + "<" + node.getTagName());
		this._output.append(indent + level + ". Element:  " + node.getTagName() + '\n');
		NamedNodeMap attributes = node.getAttributes();
		for(int i = 0; i < attributes.getLength(); ++i) 
		{
			Attr attribute = (Attr)attributes.item(i);
			this._input.append(" " + attribute.getName() + "=\'" + attribute.getValue() + "\'");
			this._output.append(indent + "         Attribute: " + attribute.getName() + ",  value:  " + attribute.getValue() + '\n');
		}
		this._input.append(">");
		String indentCopy = indent;
		indent += "   ";
		level++;
		String prefix = indent + level + ". ";
		NodeList children = node.getChildNodes();
		for(int i = 0; i < children.getLength(); ++i) 
		{
			Node child = children.item(i);
			int nodeType = child.getNodeType();
			if(nodeType == Node.ELEMENT_NODE)
			{
				this._input.append("" + '\n');
				listNodes((Element)child, indent, level);
			}
			else if(nodeType == Node.TEXT_NODE) 
			{
				String text = child.getTextContent();
				text = text.trim();
				if(text.length() > 0)
				{
					this._input.append(text);
					this._output.append(prefix + "Text:  " + text + '\n');
				}
			}
			else 
			{
				this._output.append(prefix + "(Some other type of node.)\n");
			}
		}
		this._input.append('\n' + indentCopy + "</" + node.getTagName() + ">");
	}
	
	/**
	 * @return Returns XMLReader connected with this window.
	 */
	public XMLReader getReader()
	{
		return this._reader;
	}
	
	/**
	 * @return Returns Window containing this panel.
	 */
	public JFrame getFrame()
	{
		return this._window;
	}
	
	/**
	 * Main method to show the Window.
	 */
	public void show()
	{
		this._window.setVisible(true);
	}
}