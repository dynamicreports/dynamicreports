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
package net.sf.dynamicreports.test.jasper.component;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.group.CustomGroupBuilder;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.StretchType;
import net.sf.dynamicreports.test.jasper.AbstractJasperTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRElement;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.type.PositionTypeEnum;
import net.sf.jasperreports.engine.type.StretchTypeEnum;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Component3Test extends AbstractJasperTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        CustomGroupBuilder group = grp.group("group1", exp.text(""));

        TextFieldBuilder<String> textField = cmp.text("")
                                                .setPositionType(ComponentPositionType.FIX_RELATIVE_TO_TOP)
                                                .setStretchType(StretchType.NO_STRETCH)
                                                .setPrintInFirstWholeBand(true)
                                                .setPrintWhenDetailOverflows(true)
                                                .setPrintWhenGroupChanges(group);
        rb.title(textField)
          .columns(col.column("column1", type.stringType())
                      .setPrintWhenDetailOverflows(true))
          .groupBy(group);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        JRElement textField = getJasperReport().getTitle()
                                               .getElementByKey("title.textField1");
        Assert.assertEquals("position type", PositionTypeEnum.FIX_RELATIVE_TO_TOP, textField.getPositionTypeValue());
        Assert.assertEquals("stretch type", StretchTypeEnum.NO_STRETCH, textField.getStretchTypeValue());
        Assert.assertTrue("print in first whole band", textField.isPrintInFirstWholeBand());
        Assert.assertTrue("print when detail overflows", textField.isPrintWhenDetailOverflows());
        Assert.assertEquals("print when group changes", "group1", textField.getPrintWhenGroupChanges()
                                                                           .getName());

        textField = getJasperReport().getDetailSection()
                                     .getBands()[0].getElementByKey("detail.column_column11");
        Assert.assertTrue("print when detail overflows", textField.isPrintWhenDetailOverflows());
    }

    @Override
    protected JRDataSource createDataSource() {
        return new JREmptyDataSource(1);
    }

}
