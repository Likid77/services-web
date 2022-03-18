package tn.nids.remadi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "to", "text", "from" })
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Message {
	// Attributes
	private String from;
	private String to;
	private String text;
	private boolean isNew;

	// Properties
	@XmlElement(name = "emetteur", required = true)
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@XmlElement(name = "destinataire")
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	@XmlAttribute
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@XmlTransient
	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	// Constructors
	public Message() {
		super();
	}

	public Message(String from, String to, String text, boolean isNew) {
		super();
		this.from = from;
		this.to = to;
		this.text = text;
		this.isNew = isNew;
	}

}
