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
package net.sf.dynamicreports.googlecharts.test;

import net.sf.dynamicreports.googlecharts.report.GoogleCharts;
import net.sf.dynamicreports.googlecharts.report.geomap.GeoMapDataMode;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.jasperreports.engine.JRDataSource;
import org.junit.Test;

import java.awt.Color;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GeoMapTest extends AbstractJasperTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.summary(GoogleCharts.geoMap()
                               .setDataMode(GeoMapDataMode.REGIONS)
                               .setShowLegend(false)
                               .setRegion("world")
                               .colors(Color.decode("#FF8747"), Color.decode("#FFB581"), Color.decode("#C06000"))
                               .setLocation("location", String.class)
                               .setValue("quantity", Integer.class)
                               .setLabel("label", String.class)
                               .setValueLabel("Quantity")
                               .setFixedHeight(300));
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("location", "quantity", "label");
        dataSource.add("GB", 170, "United Kingdom");
        dataSource.add("DE", 90, "Germany");
        dataSource.add("FR", 120, null);
        return dataSource;
    }

    @Override
    @Test
    public void test() {

        numberOfPagesTest(1);

        containsHtml("data rows", "data.addRows(3);");
        containsHtml("value label", "data.addColumn('number', 'Quantity');");

        containsHtml("values", "data.setValue(0, 0, 'GB');");
        containsHtml("values", "data.setValue(0, 1, 170);");
        containsHtml("values", "data.setValue(0, 2, 'United Kingdom');");
        containsHtml("values", "data.setValue(1, 0, 'DE');");
        containsHtml("values", "data.setValue(1, 1, 90);");
        containsHtml("values", "data.setValue(1, 2, 'Germany');");
        containsHtml("values", "data.setValue(2, 0, 'FR');");
        containsHtml("values", "data.setValue(2, 1, 120);");
        containsHtml("values", "data.setValue(2, 2, 'FR');");

        containsHtml("width", "options['width'] = '575px';");
        containsHtml("height", "options['height'] = '300px';");
        containsHtml("dataMode", "options['dataMode'] = 'regions';");
        containsHtml("showLegend", "options['showLegend'] = false;");
        containsHtml("region", "options['region'] = 'world';");
        containsHtml("colors", "options['colors'] = [0xFF8747,0xFFB581,0xC06000];");
    }
}
