package net.sf.dynamicreports.adhoc.transformation;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.exception.ConfigurationUnMarshallerException;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;

public interface IXmlToAdhocTransform {
    /**
     * <p>transform.</p>
     *
     * @param xmlAdhocConfiguration a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration} object.
     */
    AdhocConfiguration transform(XmlAdhocConfiguration xmlAdhocConfiguration) throws ConfigurationUnMarshallerException;
}
