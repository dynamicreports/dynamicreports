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
package net.sf.dynamicreports.test.jasper.report;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperExpressionTest extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<Integer> column1;
    private TextColumnBuilder<Integer> column2;
    private TextColumnBuilder<Integer> column3;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.columns(column1 = col.column("field1", Integer.class).setTitle(exp.jasperSyntaxText("Column1\n\"Column1\"")),
                   column2 = col.column("field2", Integer.class).setTitle(exp.jasperSyntax("\"Column2\"", String.class)),
                   column3 = col.column(exp.jasperSyntax("$F{field1} - $F{field2}", Integer.class)));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        columnTitleCountTest(column1, 1);
        columnTitleValueTest(column1, "Column1\n\"Column1\"");

        columnTitleCountTest(column2, 1);
        columnTitleValueTest(column2, "Column2");

        columnDetailValueTest(column3, "0", "8", "3");

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            getReportBuilder().toJrXml(bos);
            String jrxml = new String(bos.toByteArray());
            Assert.assertFalse("jrxml contains dependency to dynamicreports", StringUtils.contains(jrxml, "net.sf.dynamicreports"));
        } catch (DRException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        dataSource.add(1, 1);
        dataSource.add(10, 2);
        dataSource.add(5, 2);
        return dataSource;
    }
}
