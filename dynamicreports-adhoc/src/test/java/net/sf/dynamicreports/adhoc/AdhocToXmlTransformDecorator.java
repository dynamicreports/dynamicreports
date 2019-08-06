package net.sf.dynamicreports.adhoc;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.exception.ConfigurationMarshallerException;
import net.sf.dynamicreports.adhoc.transformation.IAdhocToXmlTransform;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;

public class AdhocToXmlTransformDecorator implements IAdhocToXmlTransform {

    private IAdhocToXmlTransform adhocToXmlTransform;

    public AdhocToXmlTransformDecorator(IAdhocToXmlTransform adhocToXmlTransform) {
        this.adhocToXmlTransform = adhocToXmlTransform;
    }

    /**
     * <p>transform.</p>
     *
     * @param adhocConfiguration a {@link AdhocConfiguration} object.
     * @return a {@link XmlAdhocConfiguration} object.
     */
    @Override
    public XmlAdhocConfiguration transform(AdhocConfiguration adhocConfiguration) throws ConfigurationMarshallerException {
        if (adhocConfiguration == null || adhocConfiguration.getFilter() == null || adhocConfiguration.getReport() == null){
            throw new ConfigurationMarshallerException("The ad-hoc-configuration has not been configured");
        }
        return adhocToXmlTransform.transform(adhocConfiguration);
    }
}
