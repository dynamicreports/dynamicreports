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
package net.sf.dynamicreports.test.jasper.column;

import net.sf.dynamicreports.design.transformation.CustomBatikRenderer;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintImage;
import org.junit.Assert;

import java.io.Serializable;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;

/**
 * @author Ricardo Mariaca
 */
public class BooleanColumn1Test extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setLocale(Locale.ENGLISH)
          .columns(col.booleanColumn("field1").setComponentType(BooleanComponentType.TEXT_TRUE_FALSE), col.booleanColumn("field1").setComponentType(BooleanComponentType.TEXT_YES_NO),
                   col.booleanColumn("field1").setComponentType(BooleanComponentType.TEXT_TRUE_FALSE).setEmptyWhenNullValue(true),
                   col.booleanColumn("field1").setComponentType(BooleanComponentType.IMAGE_STYLE_1), col.booleanColumn("field1").setComponentType(BooleanComponentType.IMAGE_STYLE_2),
                   col.booleanColumn("field1").setComponentType(BooleanComponentType.IMAGE_STYLE_3), col.booleanColumn("field1").setComponentType(BooleanComponentType.IMAGE_STYLE_4),
                   col.booleanColumn("field1").setComponentType(BooleanComponentType.IMAGE_CHECKBOX_1), col.booleanColumn("field1").setComponentType(BooleanComponentType.IMAGE_CHECKBOX_2),
                   col.booleanColumn("field1").setComponentType(BooleanComponentType.IMAGE_BALL),
                   col.booleanColumn("field1").setComponentType(BooleanComponentType.IMAGE_STYLE_1).setEmptyWhenNullValue(true));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementCountTest("detail.column_field11", 3);
        elementValueTest("detail.column_field11", "True", "False", "False");

        elementCountTest("detail.column_field12", 3);
        elementValueTest("detail.column_field12", "Yes", "No", "No");

        elementCountTest("detail.column_field13", 3);
        elementValueTest("detail.column_field13", "True", "False", "");

        testImage("detail.column_field14", 0);
        testImage("detail.column_field14", 1);
        testImage("detail.column_field14", 2);

        testImage("detail.column_field15", 0);
        testImage("detail.column_field15", 1);
        testImage("detail.column_field15", 2);

        testImage("detail.column_field16", 0);
        testImage("detail.column_field16", 1);
        testImage("detail.column_field16", 2);

        testImage("detail.column_field17", 0);
        testImage("detail.column_field17", 1);
        testImage("detail.column_field17", 2);

        testImage("detail.column_field18", 0);
        testImage("detail.column_field18", 1);
        testImage("detail.column_field18", 2);

        testImage("detail.column_field19", 0);
        testImage("detail.column_field19", 1);
        testImage("detail.column_field19", 2);

        testImage("detail.column_field110", 0);
        testImage("detail.column_field110", 1);
        testImage("detail.column_field110", 2);

        testImage("detail.column_field111", 0);
        testImage("detail.column_field111", 1);
        Assert.assertNull((((JRPrintImage) getElementAt("detail.column_field111", 2)).getRenderer()));

    }

    private void testImage(String name, int index) {
        CustomBatikRenderer batikRenderer = ((CustomBatikRenderer) ((JRPrintImage) getElementAt(name, index)).getRenderer());
        try {
            byte[] data = batikRenderer.getData(DefaultJasperReportsContext.getInstance());
            Assert.assertNotNull(data);
        } catch (JRException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        dataSource.add(true);
        dataSource.add(false);
        dataSource.add();
        return dataSource;
    }
}
