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

import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.report.DefaultAdhocReportCustomizer;
import net.sf.dynamicreports.adhoc.transformation.AdhocToXmlTransform;
import net.sf.dynamicreports.adhoc.transformation.XmlToAdhocTransform;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AdhocManagerTest {

    private AdhocManager adhocManager;
    private CustomReport customReport;

    @Before
    public void setUp() throws Exception {

        ReportCustomizer reportCustomizer = new ReportCustomizer();
        customReport = new SimpleCustomReport(reportCustomizer);
        adhocManager = AdhocManager.getInstance(new AdhocToXmlTransform(), new XmlToAdhocTransform());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createReport() throws Exception {

        ByteArrayOutputStream os1 = new ByteArrayOutputStream();
        ByteArrayOutputStream os2 = new ByteArrayOutputStream();
        ByteArrayOutputStream os3 = new ByteArrayOutputStream();
        ByteArrayOutputStream os4 = new ByteArrayOutputStream();
        ByteArrayOutputStream os6 = new ByteArrayOutputStream();

        customReport.createReport(new AdhocReport()).toCsv(os1);
        customReport.createReport(new AdhocReport()).toPdf(os2);
        customReport.createReport(new AdhocReport()).toPptx(os3);
        customReport.createReport(new AdhocReport()).toXml(os4);
        customReport.createReport(new AdhocReport()).toXlsx(os6);

        assertNotNull(os1);
        assertNotNull(os2);
        assertNotNull(os3);
        assertNotNull(os4);
        assertNotNull(os6);

        // TODO Import POI to test xlsx
        // TODO Import PDF-Box to test pdf files
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

    private class ReportCustomizer extends DefaultAdhocReportCustomizer {

        private List<ComponentBuilder<?, ?>> getComponents() {
            return new ArrayList<ComponentBuilder<?, ?>>(components.values());
        }
    }
}