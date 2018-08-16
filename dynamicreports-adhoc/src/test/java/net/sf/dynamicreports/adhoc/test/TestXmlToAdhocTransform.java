package net.sf.dynamicreports.adhoc.test;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransformer;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;

/**
 * This class was only created to test the possibility of an exception happening during xml to
 * adhoc transformation
 */
public class TestXmlToAdhocTransform implements XmlToAdhocTransformer {

    /**
     * <p>transform.</p>
     *
     * @param xmlAdhocConfiguration a {@link XmlAdhocConfiguration} object.
     * @return a {@link AdhocConfiguration} object.
     */
    @Override
    public AdhocConfiguration transform(final XmlAdhocConfiguration xmlAdhocConfiguration) {
        return null;
    }
}
