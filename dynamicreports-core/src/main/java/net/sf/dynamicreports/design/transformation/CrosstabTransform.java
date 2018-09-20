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
package net.sf.dynamicreports.design.transformation;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.component.DRDesignTextField;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCell;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCellContent;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabColumnGroup;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabDataset;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabGroup;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabMeasure;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabRowGroup;
import net.sf.dynamicreports.design.constant.DefaultStyleType;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.transformation.expressions.CrosstabExpression;
import net.sf.dynamicreports.design.transformation.expressions.CrosstabMeasureExpression;
import net.sf.dynamicreports.design.transformation.expressions.CrosstabPrintInEvenRow;
import net.sf.dynamicreports.design.transformation.expressions.CrosstabPrintInOddRow;
import net.sf.dynamicreports.design.transformation.expressions.CrosstabRowCount;
import net.sf.dynamicreports.design.transformation.expressions.CrosstabRowCounter;
import net.sf.dynamicreports.report.base.DRHyperLink;
import net.sf.dynamicreports.report.base.component.DRFiller;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.base.crosstab.DRCrosstabCellContent;
import net.sf.dynamicreports.report.base.crosstab.DRCrosstabCellStyle;
import net.sf.dynamicreports.report.base.style.DRConditionalStyle;
import net.sf.dynamicreports.report.base.style.DRStyle;
import net.sf.dynamicreports.report.builder.expression.SystemMessageExpression;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.CrosstabPercentageType;
import net.sf.dynamicreports.report.constant.StretchType;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstab;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabCellContent;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabCellStyle;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabColumnGroup;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabDataset;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabGroup;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabMeasure;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabVariable;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIJasperExpression;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;
import net.sf.dynamicreports.report.definition.style.DRIConditionalStyle;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import net.sf.dynamicreports.report.definition.style.DRISimpleStyle;
import net.sf.dynamicreports.report.definition.style.DRIStyle;
import net.sf.dynamicreports.report.exception.DRException;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>CrosstabTransform class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class CrosstabTransform {
    private DesignTransformAccessor accessor;
    private Map<DRDesignCrosstab, DRICrosstab> crosstabs;
    private CrosstabRowCounter crosstabRowCounter;

    /**
     * <p>Constructor for CrosstabTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public CrosstabTransform(DesignTransformAccessor accessor) {
        this.accessor = accessor;
        init();
    }

    private void init() {
        crosstabs = new HashMap<DRDesignCrosstab, DRICrosstab>();
        crosstabRowCounter = new CrosstabRowCounter();
    }

    /**
     * <p>transform.</p>
     *
     * @param crosstab a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @param resetType a {@link net.sf.dynamicreports.design.constant.ResetType} object.
     * @param resetGroup a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
     * @return a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRDesignCrosstab transform(DRICrosstab crosstab, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignCrosstab designCrosstab = new DRDesignCrosstab();
        designCrosstab.setDataset(dataset(crosstab.getDataset(), resetType, resetGroup));
        accessor.transformToDataset(crosstab.getDataset()
                                            .getSubDataset());
        if (crosstab.getDataset() != null) {
            resetType = null;
            resetGroup = null;
        }
        DRDesignCrosstabCellContent whenNoDataCell = cellContent(crosstab.getWhenNoDataCell(), resetType, resetGroup);
        designCrosstab.setWidth(accessor.getTemplateTransform()
                                        .getCrosstabWidth(crosstab));
        designCrosstab.setHeight(accessor.getTemplateTransform()
                                         .getCrosstabHeight(crosstab, whenNoDataCell));
        designCrosstab.setRepeatColumnHeaders(crosstab.isRepeatColumnHeaders());
        designCrosstab.setRepeatRowHeaders(crosstab.isRepeatRowHeaders());
        designCrosstab.setColumnBreakOffset(crosstab.getColumnBreakOffset());
        designCrosstab.setIgnoreWidth(crosstab.getIgnoreWidth());
        designCrosstab.setRunDirection(crosstab.getRunDirection());
        designCrosstab.setWhenNoDataCell(whenNoDataCell);
        designCrosstab.setHeaderCell(cellContent(crosstab.getHeaderCell(), resetType, resetGroup));
        for (DRICrosstabColumnGroup<?> columnGroup : crosstab.getColumnGroups()) {
            addColumnGroup(crosstab, designCrosstab, columnGroup, resetType, resetGroup);
        }
        for (DRICrosstabRowGroup<?> rowGroup : crosstab.getRowGroups()) {
            addRowGroup(crosstab, designCrosstab, rowGroup, resetType, resetGroup);
        }
        addCells(crosstab, designCrosstab, resetType, resetGroup);
        for (DRICrosstabVariable<?> variable : crosstab.getVariables()) {
            addMeasure(designCrosstab, variable);
        }
        for (DRICrosstabMeasure<?> measure : crosstab.getMeasures()) {
            if (measure.getExpression() instanceof DRICrosstabVariable<?>) {
                addMeasure(designCrosstab, (DRICrosstabVariable<?>) measure.getExpression());
            }
        }
        accessor.getExpressionTransform()
                .transformExpression(crosstabRowCounter);
        addRowCountExpression(designCrosstab);
        crosstabs.put(designCrosstab, crosstab);
        accessor.transformToMainDataset();

        return designCrosstab;
    }

    // dataset
    private DRDesignCrosstabDataset dataset(DRICrosstabDataset dataset, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignCrosstabDataset designDataset = new DRDesignCrosstabDataset();
        designDataset.setSubDataset(accessor.getDatasetTransform()
                                            .transform(dataset.getSubDataset()));
        designDataset.setDataPreSorted(dataset.getDataPreSorted());
        if (resetType != null && resetType.equals(ResetType.NONE)) {
            designDataset.setResetType(ResetType.REPORT);
        } else {
            designDataset.setResetType(resetType);
        }
        designDataset.setResetGroup(resetGroup);
        return designDataset;
    }

    private void addRowCountExpression(DRDesignCrosstab designCrosstab) throws DRException {
        DRDesignCrosstabRowGroup lastRowGroup = getLastValue(designCrosstab.getRowGroups());
        DRFiller filler = new DRFiller();
        CrosstabRowCount rowCountExpression = new CrosstabRowCount();
        filler.setPrintWhenExpression(rowCountExpression);
        DRDesignComponent designTextField = accessor.getComponentTransform()
                                                    .filler(filler);
        lastRowGroup.getHeader()
                    .getList()
                    .addComponent(designTextField);
    }

    private DRDesignCrosstabCellContent cellContent(DRICrosstabCellContent cellContent, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignCrosstabCellContent designCellContents = new DRDesignCrosstabCellContent();
        designCellContents.setList(accessor.getComponentTransform()
                                           .list(cellContent.getList(), DefaultStyleType.TEXT, resetType, resetGroup));
        designCellContents.setStyle(accessor.getStyleTransform()
                                            .transformStyle(cellContent.getStyle(), false, DefaultStyleType.NONE));
        return designCellContents;
    }

    @SuppressWarnings( {"rawtypes", "unchecked"})
    private void group(DRDesignCrosstabGroup designGroup, DRICrosstab crosstab, DRICrosstabGroup group, boolean showTotal, ResetType resetType, DRDesignGroup resetGroup,
                       DRDesignComponent designTitleComponent, DRDesignComponent designTotalTitleComponent) throws DRException {
        designGroup.setName(group.getName());
        designGroup.setOrderType(group.getOrderType());

        designGroup.setExpression(accessor.getExpressionTransform()
                                          .transformExpression(group.getExpression()));
        if (group.getOrderByExpression() != null) {
            DRIExpression orderByExpression = getCrosstabExpression(crosstab, group.getOrderByExpression());
            designGroup.setOrderByExpression(accessor.getExpressionTransform()
                                                     .transformExpression(orderByExpression));
        }
        if (group.getComparatorExpression() != null) {
            DRIExpression comparatorExpression = getCrosstabExpression(crosstab, group.getComparatorExpression());
            designGroup.setComparatorExpression(accessor.getExpressionTransform()
                                                        .transformExpression(comparatorExpression));
        }

        DRTextField textField = new DRTextField();
        textField.setValueExpression(group);
        textField.setPattern(group.getHeaderPattern());
        textField.setHorizontalTextAlignment(group.getHeaderHorizontalTextAlignment());
        textField.setValueFormatter(group.getHeaderValueFormatter());
        textField.setDataType(group.getDataType());
        textField.setStretchWithOverflow(group.getHeaderStretchWithOverflow());
        textField.setHyperLink((DRHyperLink) group.getHeaderHyperLink());
        textField.setPropertyExpressions(group.getHeaderPropertyExpressions());

        boolean measureTitle = false;
        for (DRICrosstabMeasure<?> crosstabMeasure : crosstab.getMeasures()) {
            if (crosstabMeasure.getTitleExpression() != null) {
                measureTitle = true;
                break;
            }
        }

        if (group instanceof DRICrosstabRowGroup || (group instanceof DRICrosstabColumnGroup && !measureTitle)) {
            textField.setStretchType(StretchType.CONTAINER_HEIGHT);
        }
        DRIReportStyle groupStyle = group.getHeaderStyle();
        if (groupStyle == null) {
            groupStyle = accessor.getTemplateTransform()
                                 .getCrosstabGroupStyle(crosstab);
        }
        textField.setStyle(groupStyle);
        DRDesignCrosstabCellContent header = createCellContent(getCellStyle(groupStyle), resetType, resetGroup);
        DRDesignTextField designTextField = accessor.getComponentTransform()
                                                    .textField(textField, DefaultStyleType.TEXT);
        designTextField.setUniqueName("group_" + designGroup.getName() + ".header");
        header.getList()
              .addComponent(designTextField);
        if (designTitleComponent != null) {
            header.getList()
                  .addComponent(designTitleComponent);
        }
        designGroup.setHeader(header);
        if (showTotal) {
            DRIReportStyle totalStyle = group.getTotalHeaderStyle();
            if (totalStyle == null) {
                DRICrosstabGroup<?> firstGroup = null;
                if (group instanceof DRICrosstabRowGroup) {
                    firstGroup = getFirstValue(crosstab.getRowGroups());
                } else {
                    firstGroup = getFirstValue(crosstab.getColumnGroups());
                }
                if (firstGroup == group) {
                    totalStyle = accessor.getTemplateTransform()
                                         .getCrosstabGrandTotalStyle(crosstab);
                } else {
                    totalStyle = accessor.getTemplateTransform()
                                         .getCrosstabGroupTotalStyle(crosstab);
                }
            }

            textField = new DRTextField();
            DRIExpression<?> totalHeaderExpression = group.getTotalHeaderExpression();
            if (totalHeaderExpression == null) {
                totalHeaderExpression = new SystemMessageExpression("total");
            }
            textField.setValueExpression(totalHeaderExpression);
            textField.setStretchWithOverflow(group.getTotalHeaderStretchWithOverflow());
            textField.setPropertyExpressions(group.getTotalHeaderPropertyExpressions());
            textField.setStyle(totalStyle);
            if (group instanceof DRICrosstabRowGroup || (group instanceof DRICrosstabColumnGroup && !measureTitle)) {
                textField.setStretchType(StretchType.CONTAINER_HEIGHT);
            }

            DRDesignCrosstabCellContent totalHeader = createCellContent(getCellStyle(totalStyle), resetType, resetGroup);
            designTextField = accessor.getComponentTransform()
                                      .textField(textField, DefaultStyleType.TEXT);
            designTextField.setUniqueName("group_" + designGroup.getName() + ".totalheader");
            totalHeader.getList()
                       .addComponent(designTextField);
            if (designTotalTitleComponent != null) {
                totalHeader.getList()
                           .addComponent(designTotalTitleComponent);
            }
            designGroup.setTotalHeader(totalHeader);
        }
    }

    private void addColumnGroup(DRICrosstab crosstab, DRDesignCrosstab designCrosstab, DRICrosstabColumnGroup<?> columnGroup, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignCrosstabColumnGroup designColumnGroup = new DRDesignCrosstabColumnGroup();
        boolean showTotal = accessor.getTemplateTransform()
                                    .isCrosstabColumnGroupShowTotal(columnGroup);

        DRDesignComponent designTitleComponent = null;
        DRDesignComponent designTotalTitleComponent = null;
        boolean lastColumn = columnGroup == getLastValue(crosstab.getColumnGroups());
        if (showTotal || lastColumn) {
            boolean showTitle = false;
            for (DRICrosstabMeasure<?> measure : crosstab.getMeasures()) {
                if (measure.getTitleExpression() != null) {
                    showTitle = true;
                    break;
                }
            }

            if (showTitle) {
                if (lastColumn) {
                    DRIReportStyle groupStyle = columnGroup.getHeaderStyle();
                    if (groupStyle == null) {
                        groupStyle = accessor.getTemplateTransform()
                                             .getCrosstabGroupStyle(crosstab);
                    }
                    String name = "group_" + columnGroup.getName() + ".titleheader";
                    designTitleComponent = getMeasureTitleComponent(name, crosstab, groupStyle);
                }
                if (showTotal) {
                    DRIReportStyle totalStyle = columnGroup.getTotalHeaderStyle();
                    if (totalStyle == null) {
                        DRICrosstabGroup<?> firstGroup = getFirstValue(crosstab.getColumnGroups());
                        if (firstGroup == columnGroup) {
                            totalStyle = accessor.getTemplateTransform()
                                                 .getCrosstabGrandTotalStyle(crosstab);
                        } else {
                            totalStyle = accessor.getTemplateTransform()
                                                 .getCrosstabGroupTotalStyle(crosstab);
                        }
                    }
                    String name = "group_" + columnGroup.getName() + ".titletotalheader";
                    designTotalTitleComponent = getMeasureTitleComponent(name, crosstab, totalStyle);
                }
            }
        }

        group(designColumnGroup, crosstab, columnGroup, showTotal, resetType, resetGroup, designTitleComponent, designTotalTitleComponent);
        designColumnGroup.setTotalPosition(accessor.getTemplateTransform()
                                                   .getCrosstabColumnGroupTotalPosition(columnGroup));
        designCrosstab.getColumnGroups()
                      .add(designColumnGroup);
    }

    @SuppressWarnings( {"rawtypes", "unchecked"})
    private DRDesignComponent getMeasureTitleComponent(String name, DRICrosstab crosstab, DRIReportStyle defaultStyle) throws DRException {
        DRDesignList titleComponent = new DRDesignList();
        for (DRICrosstabMeasure<?> measure : crosstab.getMeasures()) {
            DRTextField textField = new DRTextField();
            if (measure.getTitleExpression() != null) {
                textField.setValueExpression(measure.getTitleExpression());
            }
            DRIReportStyle titleStyle = accessor.getTemplateTransform()
                                                .getCrosstabMeasureTitleStyle(crosstab, measure);
            if (titleStyle == null) {
                titleStyle = defaultStyle;
            }
            textField.setStyle(titleStyle);
            DRDesignTextField designTextField = accessor.getComponentTransform()
                                                        .textField(textField, DefaultStyleType.TEXT);
            designTextField.setUniqueName(name + "." + measure.getName());
            titleComponent.addComponent(designTextField);
        }

        return titleComponent;
    }

    private void addRowGroup(DRICrosstab crosstab, DRDesignCrosstab designCrosstab, DRICrosstabRowGroup<?> rowGroup, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignCrosstabRowGroup designRowGroup = new DRDesignCrosstabRowGroup();
        boolean showTotal = accessor.getTemplateTransform()
                                    .isCrosstabRowGroupShowTotal(rowGroup);
        group(designRowGroup, crosstab, rowGroup, showTotal, resetType, resetGroup, null, null);
        designRowGroup.setTotalPosition(accessor.getTemplateTransform()
                                                .getCrosstabRowGroupTotalPosition(rowGroup));
        designCrosstab.getRowGroups()
                      .add(designRowGroup);
    }

    private void addCells(DRICrosstab crosstab, DRDesignCrosstab designCrosstab, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        MeasuresStyles measuresStyle = new MeasuresStyles(crosstab, designCrosstab);

        DRIReportStyle groupTotalStyle = accessor.getTemplateTransform()
                                                 .getCrosstabGroupTotalStyle(crosstab);
        groupTotalStyle = getCellStyle(groupTotalStyle);
        DRIReportStyle grandTotalStyle = accessor.getTemplateTransform()
                                                 .getCrosstabGrandTotalStyle(crosstab);
        grandTotalStyle = getCellStyle(grandTotalStyle);
        DRIReportStyle cellStyle = accessor.getTemplateTransform()
                                           .getCrosstabCellStyle(crosstab);
        cellStyle = getCellStyle(cellStyle);

        DRICrosstabGroup<?> firstColumnGroup = getFirstValue(crosstab.getColumnGroups());
        DRICrosstabGroup<?> firstRowGroup = getFirstValue(crosstab.getRowGroups());

        DRDesignCrosstabCell designCell = cell(crosstab, cellStyle, measuresStyle, null, null, resetType, resetGroup);
        designCrosstab.getCells()
                      .add(designCell);

        DRIReportStyle style = null;
        for (DRICrosstabColumnGroup<?> columnGroup : crosstab.getColumnGroups()) {
            if (columnGroup == firstColumnGroup) {
                style = grandTotalStyle;
            } else {
                style = groupTotalStyle;
            }
            if (accessor.getTemplateTransform()
                        .isCrosstabColumnGroupShowTotal(columnGroup)) {
                designCell = cell(crosstab, style, measuresStyle, null, columnGroup, resetType, resetGroup);
                designCrosstab.getCells()
                              .add(designCell);
            }
        }

        for (DRICrosstabRowGroup<?> rowGroup : crosstab.getRowGroups()) {
            if (rowGroup == firstRowGroup) {
                style = grandTotalStyle;
            } else {
                style = groupTotalStyle;
            }
            if (accessor.getTemplateTransform()
                        .isCrosstabRowGroupShowTotal(rowGroup)) {
                designCell = cell(crosstab, style, measuresStyle, rowGroup, null, resetType, resetGroup);
                designCrosstab.getCells()
                              .add(designCell);

                for (DRICrosstabColumnGroup<?> columnGroup : crosstab.getColumnGroups()) {
                    if (accessor.getTemplateTransform()
                                .isCrosstabColumnGroupShowTotal(columnGroup)) {
                        DRIReportStyle totalStyle = style;
                        if (columnGroup == firstColumnGroup) {
                            totalStyle = grandTotalStyle;
                        }
                        designCell = cell(crosstab, totalStyle, measuresStyle, rowGroup, columnGroup, resetType, resetGroup);
                        designCrosstab.getCells()
                                      .add(designCell);
                    }
                }
            }
        }
    }

    private <T> T getFirstValue(List<T> values) {
        if (!values.isEmpty()) {
            return values.get(0);
        }

        return null;
    }

    private <T> T getLastValue(List<T> values) {
        if (!values.isEmpty()) {
            return values.get(values.size() - 1);
        }

        return null;
    }

    private DRIReportStyle getCellStyle(DRIReportStyle reportStyle) throws DRException {
        DRIStyle style = accessor.getStyleTransform()
                                 .getStyle(reportStyle);
        if (style == null || style.getBackgroundColor() == null) {
            return null;
        }

        DRStyle cellStyle = new DRStyle();
        cellStyle.setBackgroundColor(style.getBackgroundColor());
        return cellStyle;
    }

    private DRIReportStyle cellStyle(DRICrosstab crosstab, List<DRIConditionalStyle> rowHighlighters, DRIReportStyle reportStyle) throws DRException {
        DRIStyle style = accessor.getStyleTransform()
                                 .getStyle(reportStyle);
        if (rowHighlighters != null && !rowHighlighters.isEmpty() || !style.getConditionalStyles()
                                                                           .isEmpty()) {
            DRStyle newStyle = new DRStyle();
            if (style != null) {
                newStyle.setParentStyle(style);
                for (DRIConditionalStyle conditionalStyle : style.getConditionalStyles()) {
                    DRIExpression<Boolean> conditionalStyleExpression = getCrosstabExpression(crosstab, conditionalStyle.getConditionExpression());
                    DRConditionalStyle newConditionalStyle = new DRConditionalStyle(conditionalStyleExpression);
                    accessor.getStyleTransform()
                            .copyStyle(newConditionalStyle, conditionalStyle);
                    newStyle.addConditionalStyle(newConditionalStyle);
                }
            }
            if (rowHighlighters != null && !rowHighlighters.isEmpty()) {
                Color backgroundColor = StyleResolver.getBackgroundColor(style, accessor.getStyleTransform());
                for (DRIConditionalStyle conditionalStyle : rowHighlighters) {
                    if (backgroundColor != null && conditionalStyle.getBackgroundColor() != null) {
                        DRConditionalStyle newConditionalStyle = new DRConditionalStyle(conditionalStyle.getConditionExpression());
                        accessor.getStyleTransform()
                                .copyStyle(newConditionalStyle, conditionalStyle);
                        Color mergedColor = StyleResolver.mergeColors(backgroundColor, conditionalStyle.getBackgroundColor(), 0.25f);
                        newConditionalStyle.setBackgroundColor(mergedColor);
                        newStyle.addConditionalStyle(newConditionalStyle);
                    } else {
                        newStyle.addConditionalStyle((DRConditionalStyle) conditionalStyle);
                    }
                }
            }
            return newStyle;
        }

        return style;
    }

    @SuppressWarnings( {"rawtypes", "unchecked"})
    private DRDesignCrosstabCell cell(DRICrosstab crosstab, DRIReportStyle cellStyle, MeasuresStyles measuresStyle, DRICrosstabRowGroup<?> rowGroup, DRICrosstabColumnGroup<?> columnGroup,
                                      ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignCrosstabCell designCell = new DRDesignCrosstabCell();
        String rowTotalGroup = null;
        String columnTotalGroup = null;
        if (rowGroup != null) {
            rowTotalGroup = rowGroup.getName();
        }
        if (columnGroup != null) {
            columnTotalGroup = columnGroup.getName();
        }
        designCell.setRowTotalGroup(rowTotalGroup);
        designCell.setColumnTotalGroup(columnTotalGroup);

        DRDesignList designList = new DRDesignList();
        designList.setStretchType(StretchType.CONTAINER_HEIGHT);
        for (DRICrosstabMeasure<?> measure : crosstab.getMeasures()) {
            DRTextField textField = new DRTextField();

            if (measure.getExpression() instanceof DRICrosstabVariable<?>) {
                textField.setValueExpression(measure.getExpression());
            } else {
                DRIExpression valueExpression = getCrosstabExpression(crosstab, measure.getExpression());
                textField.setValueExpression(valueExpression);
            }

            textField.setPattern(measure.getPattern());
            textField.setHorizontalTextAlignment(measure.getHorizontalTextAlignment());
            textField.setValueFormatter(measure.getValueFormatter());
            textField.setDataType(measure.getDataType());
            textField.setStretchWithOverflow(measure.getStretchWithOverflow());
            textField.setStretchType(StretchType.CONTAINER_HEIGHT);
            textField.setHyperLink((DRHyperLink) measure.getHyperLink());
            textField.setPropertyExpressions(measure.getPropertyExpressions());
            textField.setStyle(measuresStyle.getStyle(measure, rowGroup, columnGroup));
            DRDesignTextField designTextField = accessor.getComponentTransform()
                                                        .textField(textField, DefaultStyleType.TEXT);
            String name = "cell_measure[" + measure.getName() + "]";
            if (rowTotalGroup != null) {
                name += "_rowgroup[" + rowTotalGroup + "]";
            }
            if (columnTotalGroup != null) {
                name += "_columngroup[" + columnTotalGroup + "]";
            }
            designTextField.setUniqueName(name);
            designList.addComponent(designTextField);
        }

        DRDesignCrosstabCellContent content = createCellContent(cellStyle, resetType, resetGroup);
        designCell.setContent(content);
        content.getList()
               .addComponent(designList);

        return designCell;
    }

    private DRConditionalStyle detailRowConditionalStyle(DRISimpleStyle style, DRISimpleExpression<Boolean> expression) {
        DRConditionalStyle conditionalStyle = new DRConditionalStyle(expression);
        accessor.getStyleTransform()
                .copyStyle(conditionalStyle, style);
        return conditionalStyle;
    }

    private boolean equalsGroup(DRICrosstabGroup<?> group1, DRICrosstabGroup<?> group2) {
        if (group1 == null && group2 == null) {
            return true;
        }
        if (group1 != null && group2 != null) {
            return group1.equals(group2);
        }
        return false;
    }

    private DRDesignCrosstabCellContent createCellContent(DRIReportStyle style, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRCrosstabCellContent cellContent = new DRCrosstabCellContent();
        cellContent.setStyle(style);
        return cellContent(cellContent, resetType, resetGroup);
    }

    private void addMeasure(DRDesignCrosstab designCrosstab, DRICrosstabVariable<?> variable) throws DRException {
        DRDesignCrosstabMeasure designMeasure = new DRDesignCrosstabMeasure();
        designMeasure.setName(variable.getName());
        DRIExpression<?> expression;
        if (variable.getPercentageType() != null && variable.getPercentageType()
                                                            .equals(CrosstabPercentageType.GRAND_TOTAL) && !variable.getCalculation()
                                                                                                                    .equals(Calculation.COUNT) && !variable.getCalculation()
                                                                                                                                                           .equals(Calculation.DISTINCT_COUNT)) {
            expression = new CrosstabMeasureExpression(variable.getValueExpression());
        } else {
            expression = variable.getValueExpression();
        }
        designMeasure.setValueExpression(accessor.getExpressionTransform()
                                                 .transformExpression(expression));
        designMeasure.setCalculation(variable.getCalculation());
        designMeasure.setPercentageType(accessor.getTemplateTransform()
                                                .getCrosstabPercentageType(variable));

        designCrosstab.getMeasures()
                      .add(designMeasure);
    }

    /**
     * <p>getCrosstab.</p>
     *
     * @param designCrosstab a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab} object.
     * @return a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     */
    protected DRICrosstab getCrosstab(DRDesignCrosstab designCrosstab) {
        return crosstabs.get(designCrosstab);
    }

    private <T> DRIExpression<T> getCrosstabExpression(DRICrosstab crosstab, DRIExpression<T> expression) throws DRException {
        if (expression instanceof DRIJasperExpression) {
            return expression;
        }
        accessor.getExpressionTransform()
                .transformExpression(expression);
        return new CrosstabExpression<T>(crosstab, expression);
    }

    private class MeasuresStyles {
        private Map<DRICrosstabMeasure<?>, List<DRICrosstabCellStyle>> measuresStyle;
        private DRIReportStyle defaultCellStyle;
        private DRIReportStyle defaultGroupTotalStyle;
        private DRIReportStyle defaultGrandTotalStyle;
        private DRIReportStyle defaultRowGroupTotalStyle;
        private DRIReportStyle defaultRowGrandTotalStyle;
        private DRICrosstabGroup<?> firstColumnGroup;
        private DRICrosstabGroup<?> firstRowGroup;

        private MeasuresStyles(DRICrosstab crosstab, DRDesignCrosstab designCrosstab) throws DRException {
            measuresStyle = new HashMap<DRICrosstabMeasure<?>, List<DRICrosstabCellStyle>>();
            init(crosstab, designCrosstab);
        }

        private void init(DRICrosstab crosstab, DRDesignCrosstab designCrosstab) throws DRException {
            List<DRIConditionalStyle> rowHighlighters = new ArrayList<DRIConditionalStyle>();
            DRISimpleStyle detailOddRowStyle = accessor.getTemplateTransform()
                                                       .getCrosstabOddRowStyle(crosstab);
            DRISimpleStyle detailEvenRowStyle = accessor.getTemplateTransform()
                                                        .getCrosstabEvenRowStyle(crosstab);
            if (detailOddRowStyle != null || detailEvenRowStyle != null) {
                if (detailOddRowStyle != null) {
                    rowHighlighters.add(detailRowConditionalStyle(detailOddRowStyle, new CrosstabPrintInOddRow()));
                }
                if (detailEvenRowStyle != null) {
                    rowHighlighters.add(detailRowConditionalStyle(detailEvenRowStyle, new CrosstabPrintInEvenRow()));
                }
            }

            for (DRICrosstabMeasure<?> measure : crosstab.getMeasures()) {
                List<DRICrosstabCellStyle> styles = new ArrayList<DRICrosstabCellStyle>();
                measuresStyle.put(measure, styles);

                for (DRICrosstabCellStyle cellStyle : measure.getStyles()) {
                    DRIReportStyle newStyle = cellStyle(crosstab, rowHighlighters, cellStyle.getStyle());
                    styles.add(new DRCrosstabCellStyle(newStyle, cellStyle.getRowGroup(), cellStyle.getColumnGroup()));
                }
            }

            DRIReportStyle groupTotalStyle = accessor.getTemplateTransform()
                                                     .getCrosstabGroupTotalStyle(crosstab);
            DRIReportStyle grandTotalStyle = accessor.getTemplateTransform()
                                                     .getCrosstabGrandTotalStyle(crosstab);
            DRIReportStyle cellStyle = accessor.getTemplateTransform()
                                               .getCrosstabCellStyle(crosstab);
            if (groupTotalStyle == null) {
                groupTotalStyle = cellStyle;
            }
            if (grandTotalStyle == null) {
                grandTotalStyle = cellStyle;
            }
            defaultGroupTotalStyle = cellStyle(crosstab, rowHighlighters, groupTotalStyle);
            defaultGrandTotalStyle = cellStyle(crosstab, rowHighlighters, grandTotalStyle);
            if (StyleResolver.getBackgroundColor(groupTotalStyle, accessor.getStyleTransform()) != null) {
                defaultRowGroupTotalStyle = cellStyle(crosstab, null, groupTotalStyle);
            }
            if (StyleResolver.getBackgroundColor(grandTotalStyle, accessor.getStyleTransform()) != null) {
                defaultRowGrandTotalStyle = cellStyle(crosstab, null, grandTotalStyle);
            }
            defaultCellStyle = cellStyle(crosstab, rowHighlighters, cellStyle);
            firstColumnGroup = getFirstValue(crosstab.getColumnGroups());
            firstRowGroup = getFirstValue(crosstab.getRowGroups());
        }

        public DRIReportStyle getStyle(DRICrosstabMeasure<?> measure, DRICrosstabRowGroup<?> rowGroup, DRICrosstabColumnGroup<?> columnGroup) {
            List<DRICrosstabCellStyle> styles = measuresStyle.get(measure);
            for (DRICrosstabCellStyle crosstabCellStyle : styles) {
                if (equalsGroup(rowGroup, crosstabCellStyle.getRowGroup()) && equalsGroup(columnGroup, crosstabCellStyle.getColumnGroup())) {
                    return crosstabCellStyle.getStyle();
                }
            }
            for (DRICrosstabCellStyle crosstabCellStyle : styles) {
                if (crosstabCellStyle.getRowGroup() == null && crosstabCellStyle.getColumnGroup() == null) {
                    return crosstabCellStyle.getStyle();
                }
            }

            if (rowGroup == null && columnGroup == null) {
                return defaultCellStyle;
            }
            if (rowGroup != null) {
                if ((columnGroup == firstColumnGroup || rowGroup == firstRowGroup) && defaultRowGrandTotalStyle != null) {
                    return defaultRowGrandTotalStyle;
                }
                if (defaultRowGroupTotalStyle != null) {
                    return defaultRowGroupTotalStyle;
                }
            }
            if (columnGroup == firstColumnGroup || rowGroup == firstRowGroup) {
                return defaultGrandTotalStyle;
            } else {
                return defaultGroupTotalStyle;
            }
        }
    }
}
