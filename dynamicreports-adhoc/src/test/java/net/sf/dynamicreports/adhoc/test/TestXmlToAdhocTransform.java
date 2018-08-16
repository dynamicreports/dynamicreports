package net.sf.dynamicreports.adhoc.test;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.configuration.AdhocHorizontalAlignment;
import net.sf.dynamicreports.adhoc.exception.AdhocException;
import net.sf.dynamicreports.adhoc.transformation.DefaultXmlToAdhocTransform;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransformer;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocHorizontalAlignment;

/**
 * This class was only created to test the possibility of an exception happening during xml to adhoc transformation
 */
public class TestXmlToAdhocTransform extends DefaultXmlToAdhocTransform implements XmlToAdhocTransformer {

    /**
     * <p>transform.</p>
     *
     * @param xmlAdhocConfiguration a {@link XmlAdhocConfiguration} object.
     * @return a {@link AdhocConfiguration} object.
     */
    @Override
    public AdhocConfiguration transform(final XmlAdhocConfiguration xmlAdhocConfiguration) {
        return super.transform(xmlAdhocConfiguration);
    }

    /**
     * <p>horizontalAlignment.</p>
     *
     * @param xmlAdhocHorizontalAlignment a {@link XmlAdhocHorizontalAlignment} object.
     * @return a {@link AdhocHorizontalAlignment} object.
     */
    @Override
    protected AdhocHorizontalAlignment horizontalAlignment(final XmlAdhocHorizontalAlignment xmlAdhocHorizontalAlignment) {
        throw new AdhocException("Horizontal alignment " + xmlAdhocHorizontalAlignment.name() + " not supported");
    }
}
