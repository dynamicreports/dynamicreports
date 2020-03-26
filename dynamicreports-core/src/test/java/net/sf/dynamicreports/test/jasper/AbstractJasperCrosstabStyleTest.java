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
package net.sf.dynamicreports.test.jasper;

import net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.LineStyleEnum;

import java.awt.Color;

/**
 * @author Ricardo Mariaca
 */
public abstract class AbstractJasperCrosstabStyleTest extends AbstractJasperStyleTest {
    private String crosstabBand;

    public void setCrosstabBand(String crosstabBand) {
        this.crosstabBand = crosstabBand;
    }

    // header
    protected void crosstabHeaderElementStyleTest(String name, int index, Color foreColor, Color backColor, String fontName, Float fontSize, Boolean bold, Boolean italic) {
        styleTest(getPrefix(1) + "headercell." + name, index, foreColor, backColor, fontName, fontSize, bold, italic);
    }

    protected void crosstabHeaderElementBorderTest(String name, int index, Color topColor, LineStyleEnum topLineStyle, float top, Color bottomColor, LineStyleEnum bottomLineStyle, float bottom,
                                                   Color leftColor, LineStyleEnum leftLineStyle, float left, Color rightColor, LineStyleEnum rightLineStyle, float right) {
        borderTest(getPrefix(1) + "headercell." + name, index, topColor, topLineStyle, top, bottomColor, bottomLineStyle, bottom, leftColor, leftLineStyle, left, rightColor, rightLineStyle, right);
    }

    protected void crosstabHeaderElementPaddingTest(String name, int index, Integer top, Integer bottom, Integer left, Integer right) {
        paddingTest(getPrefix(1) + "headercell." + name, index, top, bottom, left, right);
    }

    protected void crosstabHeaderElementHorizontalAlignmentTest(String name, int index, HorizontalTextAlignEnum horizontalAlignment) {
        horizontalAlignmentTest(getPrefix(1) + "headercell." + name, index, horizontalAlignment);
    }

    // group header
    protected void crosstabGroupHeaderStyleTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int index, Color foreColor, Color backColor, String fontName, Float fontSize, Boolean bold,
                                                Boolean italic) {
        styleTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupHeaderName(group), index, foreColor, backColor, fontName, fontSize, bold, italic);
    }

    protected void crosstabGroupHeaderBorderTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int index, Color topColor, LineStyleEnum topLineStyle, float top, Color bottomColor,
                                                 LineStyleEnum bottomLineStyle, float bottom, Color leftColor, LineStyleEnum leftLineStyle, float left, Color rightColor, LineStyleEnum rightLineStyle,
                                                 float right) {
        borderTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupHeaderName(group), index, topColor, topLineStyle, top, bottomColor, bottomLineStyle, bottom, leftColor, leftLineStyle, left,
                   rightColor, rightLineStyle, right);
    }

    protected void crosstabGroupHeaderPaddingTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int index, Integer top, Integer bottom, Integer left, Integer right) {
        paddingTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupHeaderName(group), index, top, bottom, left, right);
    }

    protected void crosstabGroupHeaderHorizontalAlignmentTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int index, HorizontalTextAlignEnum horizontalAlignment) {
        horizontalAlignmentTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupHeaderName(group), index, horizontalAlignment);
    }

    protected void crosstabGroupTitleHeaderStyleTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, CrosstabMeasureBuilder<?> measure, int index, Color foreColor, Color backColor, String fontName,
                                                     Float fontSize, Boolean bold, Boolean italic) {
        styleTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTitleHeaderName(group, measure), index, foreColor, backColor, fontName, fontSize, bold, italic);
    }

    // group total header
    protected void crosstabGroupTotalHeaderStyleTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int index, Color foreColor, Color backColor, String fontName, Float fontSize, Boolean bold,
                                                     Boolean italic) {
        styleTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTotalHeaderName(group), index, foreColor, backColor, fontName, fontSize, bold, italic);
    }

    protected void crosstabGroupTotalHeaderBorderTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int index, Color topColor, LineStyleEnum topLineStyle, float top, Color bottomColor,
                                                      LineStyleEnum bottomLineStyle, float bottom, Color leftColor, LineStyleEnum leftLineStyle, float left, Color rightColor,
                                                      LineStyleEnum rightLineStyle, float right) {
        borderTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTotalHeaderName(group), index, topColor, topLineStyle, top, bottomColor, bottomLineStyle, bottom, leftColor, leftLineStyle, left,
                   rightColor, rightLineStyle, right);
    }

    protected void crosstabGroupTotalHeaderPaddingTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int index, Integer top, Integer bottom, Integer left, Integer right) {
        paddingTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTotalHeaderName(group), index, top, bottom, left, right);
    }

    protected void crosstabGroupTotalHeaderHorizontalAlignmentTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, int index, HorizontalTextAlignEnum horizontalAlignment) {
        horizontalAlignmentTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTotalHeaderName(group), index, horizontalAlignment);
    }

    protected void crosstabGroupTitleTotalHeaderStyleTest(AbstractCrosstabGroupBuilder<?, ?, ?> group, CrosstabMeasureBuilder<?> measure, int index, Color foreColor, Color backColor, String fontName,
                                                          Float fontSize, Boolean bold, Boolean italic) {
        styleTest(getPrefix(1) + JasperTestUtils.getCrosstabGroupTitleTotalHeaderName(group, measure), index, foreColor, backColor, fontName, fontSize, bold, italic);
    }

    // cell
    protected void crosstabCellStyleTest(CrosstabMeasureBuilder<?> measure, CrosstabRowGroupBuilder<?> rowGroup, CrosstabColumnGroupBuilder<?> columnGroup, int index, Color foreColor, Color backColor,
                                         String fontName, Float fontSize, Boolean bold, Boolean italic) {
        styleTest(getPrefix(1) + JasperTestUtils.getCrosstabCellName(measure, rowGroup, columnGroup), index, foreColor, backColor, fontName, fontSize, bold, italic);
    }

    protected void crosstabCellBorderTest(CrosstabMeasureBuilder<?> measure, CrosstabRowGroupBuilder<?> rowGroup, CrosstabColumnGroupBuilder<?> columnGroup, int index, Color topColor,
                                          LineStyleEnum topLineStyle, float top, Color bottomColor, LineStyleEnum bottomLineStyle, float bottom, Color leftColor, LineStyleEnum leftLineStyle,
                                          float left, Color rightColor, LineStyleEnum rightLineStyle, float right) {
        borderTest(getPrefix(1) + JasperTestUtils.getCrosstabCellName(measure, rowGroup, columnGroup), index, topColor, topLineStyle, top, bottomColor, bottomLineStyle, bottom, leftColor,
                   leftLineStyle, left, rightColor, rightLineStyle, right);
    }

    protected void crosstabCellPaddingTest(CrosstabMeasureBuilder<?> measure, CrosstabRowGroupBuilder<?> rowGroup, CrosstabColumnGroupBuilder<?> columnGroup, int index, Integer top, Integer bottom,
                                           Integer left, Integer right) {
        paddingTest(getPrefix(1) + JasperTestUtils.getCrosstabCellName(measure, rowGroup, columnGroup), index, top, bottom, left, right);
    }

    protected void crosstabCellHorizontalAlignmentTest(CrosstabMeasureBuilder<?> measure, CrosstabRowGroupBuilder<?> rowGroup, CrosstabColumnGroupBuilder<?> columnGroup, int index,
                                                       HorizontalTextAlignEnum horizontalAlignment) {
        horizontalAlignmentTest(getPrefix(1) + JasperTestUtils.getCrosstabCellName(measure, rowGroup, columnGroup), index, horizontalAlignment);
    }

    private String getPrefix(int index) {
        return crosstabBand + ".crosstab" + index + ".";
    }
}
