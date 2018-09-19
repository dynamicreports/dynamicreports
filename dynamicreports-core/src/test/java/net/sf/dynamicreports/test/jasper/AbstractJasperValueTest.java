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

package net.sf.dynamicreports.test.jasper;

import junit.framework.Assert;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.builder.subtotal.BaseSubtotalBuilder;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.util.JRStyledTextUtil;

import java.util.List;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class AbstractJasperValueTest extends AbstractJasperTest {

    protected void elementCountTest(String name, int expectedNumberOfElements) {
        Assert.assertEquals("element count " + name, expectedNumberOfElements, findElement(name).size());
    }

    protected void elementValueTest(String name, int index, String value) {
        Assert.assertEquals("element value " + name, value, getElementValue(name, index));
    }

    protected void elementFullValueTest(String name, int index, String value) {
        Assert.assertEquals("element value " + name, value, getElementFullValue(name, index));
    }

    protected void elementValueTest(String name, String... values) {
        List<JRPrintElement> elements = findElement(name);
        Assert.assertTrue(values.length <= elements.size());
        for (int i = 0; i < values.length; i++) {
            JRPrintText textElement = (JRPrintText) elements.get(i);
            String value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance())
                                           .getTruncatedText(textElement);
            Assert.assertEquals("element value " + name, values[i], value);
        }
    }

    protected void elementFullValueTest(String name, String... values) {
        List<JRPrintElement> elements = findElement(name);
        Assert.assertTrue(values.length <= elements.size());
        for (int i = 0; i < values.length; i++) {
            String value = ((JRPrintText) elements.get(i)).getFullText();
            Assert.assertEquals("element value " + name, values[i], value);
        }
    }

    private String getElementValue(String key, int index) {
        JRPrintText textElement = (JRPrintText) getElementAt(key, index);
        String value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance())
                                       .getTruncatedText(textElement);
        return value;
    }

    private String getElementFullValue(String key, int index) {
        return ((JRPrintText) getElementAt(key, index)).getFullText();
    }

    // column detail
    protected void columnDetailCountTest(ColumnBuilder<?, ?> column, int expectedNumberOfElements) {
        elementCountTest(JasperTestUtils.getColumnDetailName(column), expectedNumberOfElements);
    }

    protected void columnDetailValueTest(ColumnBuilder<?, ?> column, int index, String value) {
        elementValueTest(JasperTestUtils.getColumnDetailName(column), index, value);
    }

    protected void columnDetailFullValueTest(ColumnBuilder<?, ?> column, int index, String value) {
        elementFullValueTest(JasperTestUtils.getColumnDetailName(column), index, value);
    }

    protected void columnDetailValueTest(ColumnBuilder<?, ?> column, String... values) {
        elementValueTest(JasperTestUtils.getColumnDetailName(column), values);
    }

    protected void columnDetailAtPageIndexTest(ColumnBuilder<?, ?> column, int pageIndex) {
        containsElement(JasperTestUtils.getColumnDetailName(column), pageIndex);
    }

    // column title
    protected void columnTitleCountTest(ColumnBuilder<?, ?> column, int expectedNumberOfElements) {
        elementCountTest(JasperTestUtils.getColumnTitleName(column), expectedNumberOfElements);
    }

    protected void columnTitleValueTest(ColumnBuilder<?, ?> column, int index, String value) {
        elementValueTest(JasperTestUtils.getColumnTitleName(column), index, value);
    }

    protected void columnTitleFullValueTest(ColumnBuilder<?, ?> column, int index, String value) {
        elementFullValueTest(JasperTestUtils.getColumnTitleName(column), index, value);
    }

    protected void columnTitleValueTest(ColumnBuilder<?, ?> column, String... values) {
        elementValueTest(JasperTestUtils.getColumnTitleName(column), values);
    }

    // subtotal label
    protected void subtotalLabelCountTest(BaseSubtotalBuilder<?, ?> subtotal, int expectedNumberOfElements) {
        elementCountTest(JasperTestUtils.getSubtotalLabelName(subtotal, 1), expectedNumberOfElements);
    }

    protected void subtotalLabelValueTest(BaseSubtotalBuilder<?, ?> subtotal, int index, String value) {
        elementValueTest(JasperTestUtils.getSubtotalLabelName(subtotal, 1), index, value);
    }

    protected void subtotalLabelValueTest(BaseSubtotalBuilder<?, ?> subtotal, String... values) {
        elementValueTest(JasperTestUtils.getSubtotalLabelName(subtotal, 1), values);
    }

    protected void subtotalLabelIndexCountTest(BaseSubtotalBuilder<?, ?> subtotal, int subtotalIndex, int expectedNumberOfElements) {
        elementCountTest(JasperTestUtils.getSubtotalLabelName(subtotal, subtotalIndex), expectedNumberOfElements);
    }

    protected void subtotalLabelIndexValueTest(BaseSubtotalBuilder<?, ?> subtotal, int subtotalIndex, int index, String value) {
        elementValueTest(JasperTestUtils.getSubtotalLabelName(subtotal, subtotalIndex), index, value);
    }

    protected void subtotalLabelIndexValueTest(BaseSubtotalBuilder<?, ?> subtotal, int subtotalIndex, String... values) {
        elementValueTest(JasperTestUtils.getSubtotalLabelName(subtotal, subtotalIndex), values);
    }

    // subtotal
    protected void subtotalCountTest(BaseSubtotalBuilder<?, ?> subtotal, int expectedNumberOfElements) {
        elementCountTest(JasperTestUtils.getSubtotalName(subtotal, 1), expectedNumberOfElements);
    }

    protected void subtotalValueTest(BaseSubtotalBuilder<?, ?> subtotal, int index, String value) {
        elementValueTest(JasperTestUtils.getSubtotalName(subtotal, 1), index, value);
    }

    protected void subtotalValueTest(BaseSubtotalBuilder<?, ?> subtotal, String... values) {
        elementValueTest(JasperTestUtils.getSubtotalName(subtotal, 1), values);
    }

    protected void subtotalIndexCountTest(BaseSubtotalBuilder<?, ?> subtotal, int subtotalIndex, int expectedNumberOfElements) {
        elementCountTest(JasperTestUtils.getSubtotalName(subtotal, subtotalIndex), expectedNumberOfElements);
    }

    protected void subtotalIndexValueTest(BaseSubtotalBuilder<?, ?> subtotal, int subtotalIndex, int index, String value) {
        elementValueTest(JasperTestUtils.getSubtotalName(subtotal, subtotalIndex), index, value);
    }

    protected void subtotalIndexValueTest(BaseSubtotalBuilder<?, ?> subtotal, int subtotalIndex, String... values) {
        elementValueTest(JasperTestUtils.getSubtotalName(subtotal, subtotalIndex), values);
    }

    // group header title
    protected void groupHeaderTitleCountTest(GroupBuilder<?> group, int expectedNumberOfElements) {
        elementCountTest(JasperTestUtils.getHeaderTitleGroupName(group), expectedNumberOfElements);
    }

    protected void groupHeaderTitleValueTest(GroupBuilder<?> group, int index, String value) {
        elementValueTest(JasperTestUtils.getHeaderTitleGroupName(group), index, value);
    }

    protected void groupHeaderTitleValueTest(GroupBuilder<?> group, String... values) {
        elementValueTest(JasperTestUtils.getHeaderTitleGroupName(group), values);
    }

    // group header
    protected void groupHeaderCountTest(GroupBuilder<?> group, int expectedNumberOfElements) {
        elementCountTest(JasperTestUtils.getHeaderGroupName(group), expectedNumberOfElements);
    }

    protected void groupHeaderValueTest(GroupBuilder<?> group, int index, String value) {
        elementValueTest(JasperTestUtils.getHeaderGroupName(group), index, value);
    }

    protected void groupHeaderValueTest(GroupBuilder<?> group, String... values) {
        elementValueTest(JasperTestUtils.getHeaderGroupName(group), values);
    }
}
