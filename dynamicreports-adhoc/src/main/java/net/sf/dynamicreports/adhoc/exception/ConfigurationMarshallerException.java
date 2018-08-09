package net.sf.dynamicreports.adhoc.exception;

import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;
import net.sf.dynamicreports.report.exception.DRException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;

/**
 * This exception is thrown when a JAXB Marshaller fails while marshalling {@link JAXBElement} containing
 * and {@link XmlAdhocConfiguration} into the output stream provided
 */
public class ConfigurationMarshallerException extends DRException {

    /**
     * Creates a DRException when the client encounters an exceptional event while marshalling an
     * element into an assigned outputStream
     * 
     * @param element The element being marshalled into XML when exception is encountered
     * @param outputStream The output stream into which we are marshalling the element
     */
    public ConfigurationMarshallerException(final JAXBElement<XmlAdhocConfiguration> element, final OutputStream outputStream) {

        super(String.format("Exception encountered while marshalling the JAXBElement : %s into the outputStream : %s", element, new StreamResult(outputStream)));
    }

}
