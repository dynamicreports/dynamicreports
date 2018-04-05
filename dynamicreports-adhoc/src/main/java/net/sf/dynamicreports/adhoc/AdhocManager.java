/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.report.AdhocReportCustomizer;
import net.sf.dynamicreports.adhoc.report.DefaultAdhocReportCustomizer;
import net.sf.dynamicreports.adhoc.transformation.AdhocToXmlTransform;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransform;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class AdhocManager {
	private static AdhocToXmlTransform adhocToXmlTransform = new AdhocToXmlTransform();
	private static XmlToAdhocTransform xmlToAdhocTransform = new XmlToAdhocTransform();

	public static JasperReportBuilder createReport(AdhocReport adhocReport) throws DRException {
		return createReport(adhocReport, new DefaultAdhocReportCustomizer());
	}

	public static JasperReportBuilder createReport(AdhocReport adhocReport, AdhocReportCustomizer adhocReportCustomizer) throws DRException {
		JasperReportBuilder report = DynamicReports.report();
		adhocReportCustomizer.customize(report, adhocReport);
		return report;
	}

	public static void saveConfiguration(AdhocConfiguration adhocConfiguration, OutputStream os) throws DRException {
		XmlAdhocConfiguration xmlAdhocConfiguration = adhocToXmlTransform.transform(adhocConfiguration);
		try {
			Marshaller marshaller = JAXBContext.newInstance(XmlAdhocConfiguration.class).createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			JAXBElement<XmlAdhocConfiguration> element = new net.sf.dynamicreports.adhoc.xmlconfiguration.ObjectFactory().createConfiguration(xmlAdhocConfiguration);
			marshaller.marshal(element, new StreamResult(os));
		} catch (JAXBException e) {
			throw new DRException(e);
		}
	}

	public static AdhocConfiguration loadConfiguration(InputStream is) throws DRException {
		try {
			Unmarshaller unmarshaller = JAXBContext.newInstance(XmlAdhocConfiguration.class).createUnmarshaller();
			JAXBElement<XmlAdhocConfiguration> element = unmarshaller.unmarshal(new StreamSource(is), XmlAdhocConfiguration.class);
			XmlAdhocConfiguration xmlAdhocConfiguration = element.getValue();
			AdhocConfiguration adhocConfiguration = xmlToAdhocTransform.transform(xmlAdhocConfiguration);
			return adhocConfiguration;
		} catch (JAXBException e) {
			throw new DRException(e);
		}
	}

}
