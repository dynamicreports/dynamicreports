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
package net.sf.dynamicreports.test.jasper.column;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class BooleanColumn3Test {

    @Test
    public void test() {
        try {
            JasperReportBuilder rb = createReport();
            JRDataSource dataSource = createDataSource();

            JasperReport report = rb.toJasperReport();
            Map<String, Object> params = new HashMap<String, Object>();
            params.putAll(rb.getJasperParameters());

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            JasperFillManager.fillReportToStream(report, bos, params, dataSource);

            JasperExportManager.exportReportToPdfStream(new ByteArrayInputStream(bos.toByteArray()), new ByteArrayOutputStream());

            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    private JasperReportBuilder createReport() {
        JasperReportBuilder rb = report();
        rb.columns(col.booleanColumn("Column1", "field1")
                      .setComponentType(BooleanComponentType.IMAGE_CHECKBOX_1)
                      .setStyle(stl.style()
                                   .setTextAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.TOP)));
        return rb;
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        dataSource.add(true);
        dataSource.add(false);
        dataSource.add();
        return dataSource;
    }

}
