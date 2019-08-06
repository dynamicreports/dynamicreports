package net.sf.dynamicreports.adhoc;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.exception.ConfigurationUnMarshallerException;
import net.sf.dynamicreports.adhoc.transformation.IXmlToAdhocTransform;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransform;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;

public class XmlToAdhocTransformDecorator implements IXmlToAdhocTransform {

    private final XmlToAdhocTransform xmlToAdhocTransform;

    public XmlToAdhocTransformDecorator(XmlToAdhocTransform xmlToAdhocTransform) {
        this.xmlToAdhocTransform = xmlToAdhocTransform;
    }

    /**
     * <p>transform.</p>
     *
     * @param xmlAdhocConfiguration a {@link XmlAdhocConfiguration} object.
     * @return a {@link AdhocConfiguration} object.
     */
    @Override
    public AdhocConfiguration transform(XmlAdhocConfiguration xmlAdhocConfiguration) throws ConfigurationUnMarshallerException {

        if (xmlAdhocConfiguration == null || xmlAdhocConfiguration.getFilter() == null || xmlAdhocConfiguration.getReport() == null) {
            throw new ConfigurationUnMarshallerException("The ad-hoc-configuration has not been configured");
        }

        return xmlToAdhocTransform.transform(xmlAdhocConfiguration);
    }
}
