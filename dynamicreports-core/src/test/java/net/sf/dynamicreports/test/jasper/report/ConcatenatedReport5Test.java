/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.test.jasper.report;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.concatenatedReport;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;

import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * @author Ricardo Mariaca
 */
public class ConcatenatedReport5Test {
    static JasperConcatenatedReportBuilder concatenatedReport;

    @BeforeAll
    public static void init() {
        final JasperReportBuilder report1 = report().title(cmp.text("text1")).setWhenNoDataType(WhenNoDataType.BLANK_PAGE).setDataSource(new DataSource());
        final JasperReportBuilder report2 = report().title(cmp.text("text2")).setWhenNoDataType(WhenNoDataType.BLANK_PAGE).setDataSource(new DataSource());
        final JasperReportBuilder report3 = report().title(cmp.text("text3")).setWhenNoDataType(WhenNoDataType.BLANK_PAGE).setDataSource(new DataSource());

        concatenatedReport = concatenatedReport();
        concatenatedReport.concatenate(report1, report2, report3);
    }

    @Test
    public void test() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            concatenatedReport.toCsv(bos);
            Assertions.assertEquals( "text1\ntext2\ntext3\n", new String(bos.toByteArray()), "concatenated report ");

            bos = new ByteArrayOutputStream();
            concatenatedReport.toCsv(bos);
            Assertions.assertEquals( "text1\ntext2\ntext3\n", new String(bos.toByteArray()), "concatenated report ");
        } catch (final DRException e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }
    }

    private static class DataSource implements JRDataSource {
        private boolean next = true;

        @Override
        public boolean next() throws JRException {
            if (next) {
                next = false;
                return true;
            }
            return next;
        }

        @Override
        public Object getFieldValue(JRField jrField) throws JRException {
            return null;
        }

    }
}
