/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.test.jasper.style;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperStyleTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.Color;
import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DefaultFontTest extends AbstractJasperStyleTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<String> column2;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        FontBuilder defaultFont = stl.font()
                                     .setFontSize(12);

        rb.setDefaultFont(defaultFont)
          .columns(column1 = col.column("Column1", "field1", type.stringType())
                                .setStyle(stl.style()
                                             .bold()), column2 = col.column("Column2", "field2", type.stringType()));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // column1
        columnDetailStyleTest(column1, 0, null, null, "Arial", 12f, true, null);
        columnDetailStyleTest(column1, 1, null, null, "Arial", 12f, true, null);
        columnDetailStyleTest(column1, 2, null, null, "Arial", 12f, true, null);

        // column2
        columnDetailStyleTest(column2, 0, Color.BLACK, null, "Arial", 12f, null, null);
        columnDetailStyleTest(column2, 1, Color.BLACK, null, "Arial", 12f, null, null);
        columnDetailStyleTest(column2, 2, Color.BLACK, null, "Arial", 12f, null, null);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        dataSource.add("1", "1", "1");
        dataSource.add("1", "1", "1");
        dataSource.add("1", "1", "1");
        return dataSource;
    }
}
