package tn.nids.remadi;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class GenererMessageXml {

	public static void main(String[] args) throws JAXBException {
		Message message = new Message();
		message.setFrom("Mehdi");
		message.setNew(true);
		message.setText("Hello!");
		message.setTo("Tahar");

		// Création d'un contexte JAX-B sur la classe Message
		JAXBContext context = JAXBContext.newInstance(Message.class);

		// Création d'un Marshaller à partir de ce contexte
		Marshaller marshaller = context.createMarshaller();

		// Choix d'UTF-8 pour encoder le fichier
		marshaller.setProperty("jaxb.encoding", "UTF-8");

		// On demande à JAX-B do formatter ce fichier pour pouvoir le lire à l'œil nu
		marshaller.setProperty("jaxb.formatted.output", true);

		// Écriture finale du document XML dans un fichier message.xml
		marshaller.marshal(message, new File("message.xml"));

	}

}
