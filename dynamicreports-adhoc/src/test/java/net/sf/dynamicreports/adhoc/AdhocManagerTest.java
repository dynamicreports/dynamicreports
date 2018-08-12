package net.sf.dynamicreports.adhoc;

import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.transformation.AdhocToXmlTransform;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransform;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdhocManagerTest {

    private AdhocManager adhocManager;

    @Before
    public void setUp() throws Exception {

        adhocManager = AdhocManager.getInstance(new AdhocToXmlTransform(), new XmlToAdhocTransform());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createReport() throws Exception {

        //assertSame(new JasperReportBuilder(), adhocManager.createReport(new AdhocReport()));
    }

    @Test
    public void createReport1() {
    }

    @Test
    public void saveConfiguration() {
    }

    @Test
    public void loadConfiguration() {
    }
}