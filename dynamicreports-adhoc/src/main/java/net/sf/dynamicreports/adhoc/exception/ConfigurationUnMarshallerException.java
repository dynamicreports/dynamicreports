package net.sf.dynamicreports.adhoc.exception;

import net.sf.dynamicreports.report.exception.DRException;

import java.io.InputStream;

/**
 * Exception thrown when reading configurations from a given InputStream
 */
public class ConfigurationUnMarshallerException extends DRException {


    /**
     * Constructs a ConfigurationUnMarshallerException using the inputStream from which we are
     * reading configurations when the exceptional event occurs. For instance it is used in the
     * adhocManager to capture exceptions when loading data from an xml file like so:
     * <pre>
     *     {@code
     *     try {
     * 			Unmarshaller unmarshaller = JAXBContext.newInstance(XmlAdhocConfiguration.class).createUnmarshaller();
     * 			JAXBElement<XmlAdhocConfiguration> element = unmarshaller.unmarshal(new StreamSource(is), XmlAdhocConfiguration.class);
     * 			XmlAdhocConfiguration xmlAdhocConfiguration = element.getValue();
     * 			AdhocConfiguration adhocConfiguration = xmlToAdhocTransform.transform(xmlAdhocConfiguration);
     * 			return adhocConfiguration;
     * 		} catch (JAXBException e) {
     * 	        // time to throw our exception
     * 			throw new ConfigurationUnMarshallerException(is);
     * 		}
     *     }
     * </pre>
     *
     * @param is The InputStream from which we are reading configuration data
     */
    public ConfigurationUnMarshallerException(final InputStream is) {

        super(String.format("Exception encountered when reading configuration from the source : %s", is));
    }
}
