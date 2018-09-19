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
public abstract class AbstractJasperCrosstabPositionTest extends AbstractJasperPositionTest {
    private String crosstabBand;

    public void setCrosstabBand(String crosstabBand) {
        this.crosstabBand = crosstabBand;
    }

    protected void crosstabWhenNoDataElementPositionTest(String name, int index, int x, int y, int width, int height) {
        elementPositionTest(getPrefix(1) + "whennodatacell." + name, index, x, y, width, height);
    }

    protected void crosstabHeaderElementPositionTest(String name, int index, int x, int y, int width, int height) {
        elementPositionTest(getPrefix(1) + "headercell." + name, index, x, y, width, height);
    }

    // group header
    protected void crosstabGroupHeaderPositionTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int index, int x, int y, int width, int height) {
        elementPositionTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupHeaderName(group), index, x, y, width, height);
    }

    // group total header
    protected void crosstabGroupTotalHeaderPositionTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int index, int x, int y, int width, int height) {
        elementPositionTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTotalHeaderName(group), index, x, y, width, height);
    }

    // group title header
    protected void crosstabGroupTitleHeaderPositionTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, CrosstabMeasureBuilder<?> measure, int index, int x, int y, int width, int height) {
        elementPositionTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTitleHeaderName(group, measure), index, x, y, width, height);
    }

    // group title total header
    protected void crosstabGroupTitleTotalHeaderPositionTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, CrosstabMeasureBuilder<?> measure, int index, int x, int y, int width, int height) {
        elementPositionTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTitleTotalHeaderName(group, measure), index, x, y, width, height);
    }

    // cell
    protected void crosstabCellPositionTest(CrosstabMeasureBuilder<?> measure, CrosstabRowGroupBuilder<?> rowGroup, CrosstabColumnGroupBuilder<?> columnGroup, int index, int x, int y, int width,
                                            int height) {
        elementPositionTest(getPrefix(1) + JasperTestUtils.getCrosstabCellName(measure, rowGroup, columnGroup), index, x, y, width, height);
    }

    private String getPrefix(int index) {
        return crosstabBand + ".crosstab" + index + ".";
    }

}
