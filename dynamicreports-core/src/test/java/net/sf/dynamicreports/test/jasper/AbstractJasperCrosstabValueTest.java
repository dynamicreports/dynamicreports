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

import net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class AbstractJasperCrosstabValueTest extends AbstractJasperValueTest {
    private String crosstabBand;

    public void setCrosstabBand(String crosstabBand) {
        this.crosstabBand = crosstabBand;
    }

    protected void crosstabHeaderElementCountTest(String name, int expectedNumberOfElements) {
        elementCountTest(getPrefix(1) + "headercell." + name, expectedNumberOfElements);
    }

    protected void crosstabHeaderElementValueTest(String name, String... values) {
        elementValueTest(getPrefix(1) + "headercell." + name, values);
    }

    // group header
    protected void crosstabGroupHeaderCountTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int expectedNumberOfElements) {
        elementCountTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupHeaderName(group), expectedNumberOfElements);
    }

    protected void crosstabGroupHeaderValueTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, String... values) {
        elementValueTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupHeaderName(group), values);
    }

    protected void crosstabGroupHeaderFullValueTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, String... values) {
        elementFullValueTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupHeaderName(group), values);
    }

    // group total header
    protected void crosstabGroupTotalHeaderCountTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int expectedNumberOfElements) {
        elementCountTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTotalHeaderName(group), expectedNumberOfElements);
    }

    protected void crosstabGroupTotalHeaderValueTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, String... values) {
        elementValueTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTotalHeaderName(group), values);
    }

    protected void crosstabGroupTotalHeaderFullValueTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, String... values) {
        elementFullValueTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTotalHeaderName(group), values);
    }

    // group title header
    protected void crosstabGroupTitleHeaderCountTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, CrosstabMeasureBuilder<?> measure, int expectedNumberOfElements) {
        elementCountTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTitleHeaderName(group, measure), expectedNumberOfElements);
    }

    protected void crosstabGroupTitleHeaderValueTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, CrosstabMeasureBuilder<?> measure, String... values) {
        elementValueTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTitleHeaderName(group, measure), values);
    }

    // group title total header
    protected void crosstabGroupTitleTotalHeaderCountTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, CrosstabMeasureBuilder<?> measure, int expectedNumberOfElements) {
        elementCountTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTitleTotalHeaderName(group, measure), expectedNumberOfElements);
    }

    protected void crosstabGroupTitleTotalHeaderValueTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, CrosstabMeasureBuilder<?> measure, String... values) {
        elementValueTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTitleTotalHeaderName(group, measure), values);
    }

    // cell
    protected void crosstabCellCountTest(CrosstabMeasureBuilder<?> measure, CrosstabRowGroupBuilder<?> rowGroup, CrosstabColumnGroupBuilder<?> columnGroup, int expectedNumberOfElements) {
        elementCountTest(getPrefix(1) + JasperTestUtils.getCrosstabCellName(measure, rowGroup, columnGroup), expectedNumberOfElements);
    }

    protected void crosstabCellValueTest(CrosstabMeasureBuilder<?> measure, CrosstabRowGroupBuilder<?> rowGroup, CrosstabColumnGroupBuilder<?> columnGroup, String... values) {
        elementValueTest(getPrefix(1) + JasperTestUtils.getCrosstabCellName(measure, rowGroup, columnGroup), values);
    }

    protected void crosstabCellFullValueTest(CrosstabMeasureBuilder<?> measure, CrosstabRowGroupBuilder<?> rowGroup, CrosstabColumnGroupBuilder<?> columnGroup, String... values) {
        elementFullValueTest(getPrefix(1) + JasperTestUtils.getCrosstabCellName(measure, rowGroup, columnGroup), values);
    }

    protected String getPrefix(int index) {
        return crosstabBand + ".crosstab" + index + ".";
    }

}
