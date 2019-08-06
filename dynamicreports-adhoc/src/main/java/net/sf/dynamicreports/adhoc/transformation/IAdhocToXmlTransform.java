package net.sf.dynamicreports.adhoc.transformation;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.exception.ConfigurationMarshallerException;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;

public interface IAdhocToXmlTransform {
    /**
     * <p>transform.</p>
     *
     * @param adhocConfiguration a {@link net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration} object.
     * @return a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration} object.
     */
    XmlAdhocConfiguration transform(AdhocConfiguration adhocConfiguration) throws ConfigurationMarshallerException;
}
