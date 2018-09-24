/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.dynamicreports.adhoc;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.exception.ConfigurationMarshallerException;
import net.sf.dynamicreports.adhoc.exception.ConfigurationUnMarshallerException;
import net.sf.dynamicreports.adhoc.report.AdhocReportCustomizer;
import net.sf.dynamicreports.adhoc.report.DefaultAdhocReportCustomizer;
import net.sf.dynamicreports.adhoc.transformation.AdhocToXmlTransform;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransform;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.exception.DRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>AdhocManager class.</p>
 * Provides methods for creating {@link JasperReportBuilder} given an {@link AdhocReportCustomizer} and the {@link AdhocReport} itself.
 * <pre>
 *     {@code
 *      JasperReportBuilder reportBuilder = AdhocManager.createReport(configuration.getReport(), new ReportCustomizer());
 *     }
 * </pre>
 * The {@link JasperReportBuilder} may also be created using the {@link #createReport(AdhocReport)} without providing an an implementation for {@link AdhocReportCustomizer} relying on the {@link
 * DefaultAdhocReportCustomizer} object instead.
 * <br>
 * The {@link AdhocManager} also provides {@link #saveConfiguration(AdhocConfiguration, OutputStream)} and the {@link #loadConfiguration(InputStream)} methods for marshalling configuration and
 * unmarshalling configuration to and from the outputStream and inputStream respectively.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class AdhocManager {

    private static final Logger log = LoggerFactory.getLogger(AdhocManager.class);
    private static volatile AdhocManager INSTANCE = null;
    private final AdhocToXmlTransform adhocToXmlTransform;
    private final XmlToAdhocTransform xmlToAdhocTransform;

    private AdhocManager(AdhocToXmlTransform adhocToXmlTransform, XmlToAdhocTransform xmlToAdhocTransform) {
        this.adhocToXmlTransform = adhocToXmlTransform;
        this.xmlToAdhocTransform = xmlToAdhocTransform;
    }

    public static AdhocManager getInstance(AdhocToXmlTransform adhocToXmlTransform, XmlToAdhocTransform xmlToAdhocTransform) {
        if (INSTANCE == null) {
            synchronized (AdhocManager.class) {
                INSTANCE = new AdhocManager(adhocToXmlTransform, xmlToAdhocTransform);
            }
        }
        return INSTANCE;
    }


    // todo add singleton here
    // todo use non-static methods and run tests
    // todo stop configuring transformers in class and initialize in constructor

    /**
     * <p>createReport.</p>
     * Creates a JasperReportBuilder which is subsequently set up with the {@code JRDataSource} and finaly used to create a report like shown here:
     * <pre>
     *     {@link
     *     AdhocConfiguration configuration = new AdhocConfiguration();
     * 		AdhocReport report = new AdhocReport();
     * 		configuration.setReport(report);
     * 		// configure report...
     *     JasperReportBuilder reportBuilder = AdhocManager.createReport(configuration.getReport());
     * 	   reportBuilder.setDataSource(createDataSource());
     * 	   reportBuilder.show();
     *     }
     * </pre>
     * The {@link AdhocReportCustomizer} is internally provided by invocation of the {@link DefaultAdhocReportCustomizer}
     *
     * @param adhocReport a {@link net.sf.dynamicreports.adhoc.configuration.AdhocReport} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.JasperReportBuilder} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public JasperReportBuilder createReport(AdhocReport adhocReport) throws DRException {
        log.debug("Creating JasperReportBuilder from adhocReport: {} using defaultAdhocReportCustomizer", adhocReport.getProperties().getProperties());
        return createReport(adhocReport, new DefaultAdhocReportCustomizer());
    }

    /**
     * <p>createReport.</p>
     * Creates a JasperReportBuilder which is subsequently set up with the {@code JRDataSource} and finaly used to create a report like shown here:
     * <pre>
     *     {@link
     *     AdhocConfiguration configuration = new AdhocConfiguration();
     * 		AdhocReport report = new AdhocReport();
     * 		configuration.setReport(report);
     * 		// configure report...
     *     JasperReportBuilder reportBuilder = AdhocManager.createReport(configuration.getReport(), new ReportCustomizer());
     * 	   reportBuilder.setDataSource(createDataSource());
     * 	   reportBuilder.show();
     *     }
     * </pre>
     *
     * @param adhocReport           a {@link net.sf.dynamicreports.adhoc.configuration.AdhocReport} object.
     * @param adhocReportCustomizer a {@link net.sf.dynamicreports.adhoc.report.AdhocReportCustomizer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.JasperReportBuilder} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public JasperReportBuilder createReport(AdhocReport adhocReport, AdhocReportCustomizer adhocReportCustomizer) throws DRException {
        log.debug("Creating JasperReportBuilder from adhocReport: {} and adhocReportCustomizer : {}", adhocReport.getProperties().getProperties(), adhocReportCustomizer);
        JasperReportBuilder report = DynamicReports.report();
        adhocReportCustomizer.customize(report, adhocReport);
        return report;
    }

    /**
     * <p>saveConfiguration.</p>
     * This method enables a client to save configuration to an XML file. Consider the folowing example
     * <pre>
     *     AdhocReport report = new AdhocReport();
     *     AdhocColumn column = new AdhocColumn();
     * 		column.setName("item");
     * 		report.addColumn(column);
     *
     * 		column = new AdhocColumn();
     * 		column.setName("quantity");
     * 		report.addColumn(column);
     * 	AdhocConfiguration configuration = new AdhocConfiguration();
     * 	configuration.setReport(report);
     *
     * 	// Now saving to an XML file in the system
     * 	AdhocManager.saveConfiguration(configuration, new FileOutputStream("c:/temp/configuration.xml"));
     * </pre>
     *
     * @param adhocConfiguration a {@link net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration} object.
     * @param os                 a {@link java.io.OutputStream} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public void saveConfiguration(AdhocConfiguration adhocConfiguration, OutputStream os) throws DRException {
        log.info("Saving the AdhocConfiguration : {} to the outputStream {} in XML format using JAXB Api", adhocConfiguration.getReport().getProperties().getProperties(), os.toString());
        XmlAdhocConfiguration xmlAdhocConfiguration = adhocToXmlTransform.transform(adhocConfiguration);
        JAXBElement<XmlAdhocConfiguration> element = null;
        try {
            Marshaller marshaller = JAXBContext.newInstance(XmlAdhocConfiguration.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            element = new net.sf.dynamicreports.adhoc.xmlconfiguration.ObjectFactory().createConfiguration(xmlAdhocConfiguration);
            marshaller.marshal(element, new StreamResult(os));
        } catch (JAXBException e) {
            throw new ConfigurationMarshallerException(element, os);
        }
    }

    /**
     * <p>loadConfiguration.</p>
     * This method enables a client to read {@link AdhocConfiguration} from an {@link InputStream} The method may be applied as shown:
     * <pre>
     *     {@link
     * 			AdhocConfiguration loadedConfiguration = AdhocManager.loadConfiguration(new FileInputStream("c:/temp/configuration.xml"));
     *     }
     * </pre>
     *
     * @param is a {@link java.io.InputStream} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public AdhocConfiguration loadConfiguration(InputStream is) throws DRException {
        try {
            Unmarshaller unmarshaller = JAXBContext.newInstance(XmlAdhocConfiguration.class).createUnmarshaller();
            JAXBElement<XmlAdhocConfiguration> element = unmarshaller.unmarshal(new StreamSource(is), XmlAdhocConfiguration.class);
            XmlAdhocConfiguration xmlAdhocConfiguration = element.getValue();
            return xmlToAdhocTransform.transform(xmlAdhocConfiguration);
        } catch (JAXBException e) {
            throw new ConfigurationUnMarshallerException(is);
        }
    }

}
