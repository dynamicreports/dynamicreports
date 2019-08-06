package net.sf.dynamicreports.adhoc.test;

import net.sf.dynamicreports.adhoc.AdhocManager;
import net.sf.dynamicreports.adhoc.AdhocToXmlTransformDecorator;
import net.sf.dynamicreports.adhoc.XmlToAdhocTransformDecorator;
import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.exception.ConfigurationMarshallerException;
import net.sf.dynamicreports.adhoc.exception.ConfigurationUnMarshallerException;
import net.sf.dynamicreports.adhoc.transformation.AdhocToXmlTransform;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransform;
import net.sf.dynamicreports.report.exception.DRException;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class AdhocExceptionsTests {

    private AdhocManager adhocMan =
            AdhocManager.getInstance(
                    new AdhocToXmlTransformDecorator(new AdhocToXmlTransform()),
                    new XmlToAdhocTransformDecorator(new XmlToAdhocTransform()));
    // TODO IXmlToAdhocTransform interface
    // TODO XmlToAdhocTransformDecorator
    // TODO call ConfigurationMarshallerException from XmlToAdhocTransformDecorator for null pointers

    @Test(expected = ConfigurationMarshallerException.class)
    public void libraryCannotTransformNull() throws DRException {

        AdhocConfiguration configuration = new AdhocConfiguration();
        AdhocReport adhocReport = new AdhocReport();
        adhocReport.setProperty("Test_Property", "Test_Property_01");
        configuration.setReport(adhocReport);
        configuration.setFilter(null); // The catch is that java makes this possible, we don't want this possible

        adhocMan.saveConfiguration(configuration, new ByteArrayOutputStream());
    }

    @Test(expected = ConfigurationUnMarshallerException.class)
    public void libraryCannotUnMarshallNull() throws DRException {

        adhocMan.loadConfiguration(null);
    }
}
