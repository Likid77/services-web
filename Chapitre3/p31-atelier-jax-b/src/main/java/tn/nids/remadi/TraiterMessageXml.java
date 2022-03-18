package tn.nids.remadi;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TraiterMessageXml {

	public static void main(String[] args) throws JAXBException {
		// Création d'un contexte JAX-B sur la classe Message
		JAXBContext context = JAXBContext.newInstance(Message.class);

		// Création d'un Unmarshaller
		Unmarshaller unmarshaller = context.createUnmarshaller();

		Message message = (Message) unmarshaller.unmarshal(new File("message.xml"));

		System.out.println("From = " + message.getFrom());
		System.out.println("To = " + message.getTo());
		System.out.println("Text = " + message.getText());
	}

}
