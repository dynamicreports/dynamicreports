package net.sf.dynamicreports.adhoc.test;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.transformation.AdhocToXmlTransformer;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;


/**
 * This class was only created to test the possibility of an exception happening during adhoc to
 * xml transformation
 */
public class TestAdhocToXmlTransform implements AdhocToXmlTransformer {

    /**
     * <p>transform.</p>
     *
     * @param adhocConfiguration a {@link AdhocConfiguration} object.
     * @return a {@link XmlAdhocConfiguration} object.
     */
    @Override
    public XmlAdhocConfiguration transform(final AdhocConfiguration adhocConfiguration) {
        return null;
    }
}
