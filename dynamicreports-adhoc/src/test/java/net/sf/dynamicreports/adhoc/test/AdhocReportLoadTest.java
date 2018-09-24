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
package net.sf.dynamicreports.adhoc.test;

import junit.framework.Assert;
import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.base.JRBoxPen;
import org.junit.Test;

import java.awt.Color;
import java.io.InputStream;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class AdhocReportLoadTest extends AbstractJasperTest {

    private AdhocConfiguration adhocConfiguration;
    private String groupName;

    @Override
    public void init() {
        try {
            InputStream is = AdhocConfigurationLoadTest.class.getResourceAsStream("adhocconfiguration2.xml");
            this.adhocConfiguration = adhocManager.loadConfiguration(is);
        } catch (DRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

        super.init();
    }

    @Override
    protected JasperReportBuilder createReport() throws DRException {
        JasperReportBuilder report = adhocManager.createReport(adhocConfiguration.getReport());
        report.setLocale(Locale.ENGLISH);

        groupName = report.getReport().getGroups().get(0).getName();

        return report;
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4");
        dataSource.add("test", 1, toDate(2011, 1, 1), "test");
        return dataSource;
    }

    @Override
    @Test
    public void test() {
        numberOfPagesTest(1);

        elementValueTest("columnHeader.column_field1.title1", 0, "Column1 && C<a>aa</a> \"a\" 'c'");
        elementValueTest("columnHeader.column_field2.title1", 0, "Column2");

        elementValueTest("detail.column_field11", 0, "test");
        elementValueTest("detail.column_field21", 0, "1");
        elementValueTest("detail.column_field31", 0, new SimpleDateFormat("M/d/yy h:mm a", new DateFormatSymbols(Locale.ENGLISH)).format(toDate(2011, 1, 1)));

        elementValueTest("groupHeaderTitleAndValue.group_" + groupName + "1", "test");

        JRStyle style = getElementAt("columnHeader.column_field1.title1", 0).getStyle();
        JRBoxPen pen = style.getLineBox().getLeftPen();
        Assert.assertEquals(2f, pen.getLineWidth());
        style = getElementAt("detail.column_field11", 0).getStyle();
        Assert.assertEquals("foreColor", Color.BLUE, style.getForecolor());
    }
}
