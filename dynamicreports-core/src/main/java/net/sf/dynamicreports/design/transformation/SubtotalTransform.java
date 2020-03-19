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

import net.sf.dynamicreports.design.base.DRDesignBand;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.component.DRDesignTextField;
import net.sf.dynamicreports.design.constant.DefaultStyleType;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.exception.DRDesignReportException;
import net.sf.dynamicreports.report.base.component.DRFiller;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.constant.SubtotalPosition;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;
import net.sf.dynamicreports.report.definition.DRIBand;
import net.sf.dynamicreports.report.definition.DRIGroup;
import net.sf.dynamicreports.report.definition.DRISubtotal;
import net.sf.dynamicreports.report.definition.column.DRIColumn;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <p>SubtotalTransform class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class SubtotalTransform {
    private DesignTransformAccessor accessor;

    /**
     * <p>Constructor for SubtotalTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public SubtotalTransform(DesignTransformAccessor accessor) {
        this.accessor = accessor;
    }

    // subtotals

    /**
     * <p>transform.</p>
     *
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public void transform() throws DRException {
        ColumnGrid title = accessor.getColumnGridTransform().createColumnGrid();
        ColumnGrid pageHeader = accessor.getColumnGridTransform().createColumnGrid();
        ColumnGrid pageFooter = accessor.getColumnGridTransform().createColumnGrid();
        ColumnGrid columnHeader = accessor.getColumnGridTransform().createColumnGrid();
        ColumnGrid columnFooter = accessor.getColumnGridTransform().createColumnGrid();
        Map<DRIGroup, ColumnGrid> groupHeader = new HashMap<DRIGroup, ColumnGrid>();
        Map<DRIGroup, ColumnGrid> groupFooter = new HashMap<DRIGroup, ColumnGrid>();
        ColumnGrid lastPageFooter = accessor.getColumnGridTransform().createColumnGrid();
        ColumnGrid summary = accessor.getColumnGridTransform().createColumnGrid();

        HorizontalCellComponentAlignment horizontalAlignment = HorizontalCellComponentAlignment.FLOAT;
        VerticalCellComponentAlignment verticalAlignment = VerticalCellComponentAlignment.TOP;
        for (DRISubtotal<?> subtotal : accessor.getReport().getSubtotals()) {
            SubtotalPosition position = subtotal.getPosition();
            DRIColumn<?> showInColumn = subtotal.getShowInColumn();
            DRDesignTextField subtotalValueComponent = valueComponent(subtotal);
            DRDesignComponent subtotalComponent = subtotalValueComponent;
            if (subtotal.getLabelExpression() != null) {
                subtotalComponent = subtotalWithLabelComponent(subtotal, subtotalComponent);
            }
            switch (position) {
                case TITLE:
                    title.addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    break;
                case PAGE_HEADER:
                    pageHeader.addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    break;
                case PAGE_FOOTER:
                    pageFooter.addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    break;
                case COLUMN_HEADER:
                    columnHeader.addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    break;
                case COLUMN_FOOTER:
                    columnFooter.addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    break;
                case GROUP_HEADER:
                    EvaluationTime evaluationTime = accessor.getComponentTransform().detectEvaluationTime(subtotalValueComponent.getValueExpression());
                    if (evaluationTime == null || !evaluationTime.equals(EvaluationTime.AUTO)) {
                        subtotalValueComponent.setEvaluationTime(EvaluationTime.GROUP);
                        subtotalValueComponent.setEvaluationGroup(accessor.getGroupTransform().getGroup(subtotal.getGroup()));
                    }
                    getGroupGrid(subtotal.getGroup(), groupHeader).addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    break;
                case GROUP_FOOTER:
                    evaluationTime = accessor.getComponentTransform().detectEvaluationTime(subtotalValueComponent.getValueExpression());
                    if (evaluationTime == null || !evaluationTime.equals(EvaluationTime.AUTO)) {
                        subtotalValueComponent.setEvaluationTime(EvaluationTime.NOW);
                    }
                    getGroupGrid(subtotal.getGroup(), groupFooter).addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    break;
                case FIRST_GROUP_HEADER:
                    DRIGroup firstGroup = accessor.getGroupTransform().getFirstGroup();
                    evaluationTime = accessor.getComponentTransform().detectEvaluationTime(subtotalValueComponent.getValueExpression());
                    if (evaluationTime == null || !evaluationTime.equals(EvaluationTime.AUTO)) {
                        subtotalValueComponent.setEvaluationTime(EvaluationTime.GROUP);
                        subtotalValueComponent.setEvaluationGroup(accessor.getGroupTransform().getGroup(firstGroup));
                    }
                    if (firstGroup != null) {
                        getGroupGrid(firstGroup, groupHeader).addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    }
                    break;
                case FIRST_GROUP_FOOTER:
                    firstGroup = accessor.getGroupTransform().getFirstGroup();
                    if (firstGroup != null) {
                        evaluationTime = accessor.getComponentTransform().detectEvaluationTime(subtotalValueComponent.getValueExpression());
                        if (evaluationTime == null || !evaluationTime.equals(EvaluationTime.AUTO)) {
                            subtotalValueComponent.setEvaluationTime(EvaluationTime.NOW);
                        }
                        getGroupGrid(firstGroup, groupFooter).addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    }
                    break;
                case LAST_GROUP_HEADER:
                    DRIGroup lastGroup = accessor.getGroupTransform().getLastGroup();
                    evaluationTime = accessor.getComponentTransform().detectEvaluationTime(subtotalValueComponent.getValueExpression());
                    if (evaluationTime == null || !evaluationTime.equals(EvaluationTime.AUTO)) {
                        subtotalValueComponent.setEvaluationTime(EvaluationTime.GROUP);
                        subtotalValueComponent.setEvaluationGroup(accessor.getGroupTransform().getGroup(lastGroup));
                    }
                    if (lastGroup != null) {
                        getGroupGrid(lastGroup, groupHeader).addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    }
                    break;
                case LAST_GROUP_FOOTER:
                    lastGroup = accessor.getGroupTransform().getLastGroup();
                    if (lastGroup != null) {
                        evaluationTime = accessor.getComponentTransform().detectEvaluationTime(subtotalValueComponent.getValueExpression());
                        if (evaluationTime == null || !evaluationTime.equals(EvaluationTime.AUTO)) {
                            subtotalValueComponent.setEvaluationTime(EvaluationTime.NOW);
                        }
                        getGroupGrid(lastGroup, groupFooter).addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    }
                    break;
                case LAST_PAGE_FOOTER:
                    lastPageFooter.addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    break;
                case SUMMARY:
                    subtotalValueComponent.setEvaluationTime(EvaluationTime.NOW);
                    summary.addComponent(showInColumn, horizontalAlignment, verticalAlignment, subtotalComponent);
                    break;
                default:
                    throw new DRDesignReportException("Subtotal position " + position.name() + " not supported");
            }
        }

        DRFiller filler = null;
        TemplateTransform templateTransform = accessor.getTemplateTransform();
        if (templateTransform.getPageColumnsPerPage() > 1) {
            int fillerWidth = accessor.getPageTransform().getMaxBandWidth() - accessor.getPageTransform().getPage().getColumnWidth();
            filler = new DRFiller();
            filler.setWidth(fillerWidth);
        }

        addAfterBandComponent(accessor.getBandTransform().getTitleBand(), title, filler);
        addAfterBandComponent(accessor.getBandTransform().getPageHeaderBand(), pageHeader, filler);
        addBeforeBandComponent(accessor.getBandTransform().getPageFooterBand(), pageFooter, filler);
        addAfterBandComponent(accessor.getBandTransform().getColumnHeaderBand(), columnHeader, null);
        addBeforeBandComponent(accessor.getBandTransform().getColumnFooterBand(), columnFooter, null);
        for (Entry<DRIGroup, ColumnGrid> entry : groupHeader.entrySet()) {
            DRIGroup group = entry.getKey();
            DRIBand bnd = group.getHeaderBand();
            DRDesignGroup designGroup = accessor.getGroupTransform().getGroup(group);
            DRDesignBand band = accessor.getBandTransform()
                                        .band("subtotalGroupHeader", bnd, templateTransform.getGroupHeaderSplitType(bnd), templateTransform.getGroupHeaderStyle(bnd),
                                              templateTransform.getGroupHeaderBackgroundComponent(bnd));
            addAfterBandComponent(band, entry.getValue(), null);
            setPrintGroupSubtotalsWhenExpression(group, entry.getValue());
            designGroup.addHeaderBand(band);
        }
        for (Entry<DRIGroup, ColumnGrid> entry : groupFooter.entrySet()) {
            DRIGroup group = entry.getKey();
            DRIBand bnd = group.getFooterBand();
            DRDesignGroup designGroup = accessor.getGroupTransform().getGroup(group);
            DRDesignBand band = accessor.getBandTransform()
                                        .band("subtotalGroupFooter", bnd, templateTransform.getGroupFooterSplitType(bnd), templateTransform.getGroupFooterStyle(bnd),
                                              templateTransform.getGroupFooterBackgroundComponent(bnd));
            addBeforeBandComponent(band, entry.getValue(), null);
            setPrintGroupSubtotalsWhenExpression(group, entry.getValue());
            designGroup.addFooterBand(0, band);
        }
        addBeforeBandComponent(accessor.getBandTransform().getLastPageFooterBand(), lastPageFooter, filler);
        addBeforeBandComponent(accessor.getBandTransform().getSummaryBand(), summary, filler);
    }

    private DRDesignComponent subtotalWithLabelComponent(DRISubtotal<?> subtotal, DRDesignComponent subtotalComponent) throws DRException {
        HorizontalCellComponentAlignment horizontalAlignment = HorizontalCellComponentAlignment.FLOAT;
        VerticalCellComponentAlignment verticalAlignment = VerticalCellComponentAlignment.TOP;
        DRDesignList list = new DRDesignList();

        Position labelPosition = accessor.getTemplateTransform().getSubtotalLabelPosition(subtotal);
        switch (labelPosition) {
            case TOP:
                list.setType(ListType.VERTICAL);
                list.addComponent(horizontalAlignment, verticalAlignment, labelComponent(subtotal));
                list.addComponent(horizontalAlignment, verticalAlignment, subtotalComponent);
                break;
            case BOTTOM:
                list.setType(ListType.VERTICAL);
                list.addComponent(horizontalAlignment, verticalAlignment, subtotalComponent);
                list.addComponent(horizontalAlignment, verticalAlignment, labelComponent(subtotal));
                break;
            case LEFT:
                list.setType(ListType.HORIZONTAL);
                DRDesignComponent labelComponent = labelComponent(subtotal);
                if (subtotal.getLabelWidth() != null) {
                    labelComponent.setWidth(subtotal.getLabelWidth());
                }
                HorizontalCellComponentAlignment labelHorizontalAlignment = horizontalAlignment;
                if (subtotal.getLabelWidthType() != null) {
                    labelHorizontalAlignment = ConstantTransform.toHorizontalCellComponentAlignment(subtotal.getLabelWidthType());
                }
                list.addComponent(labelHorizontalAlignment, VerticalCellComponentAlignment.EXPAND, labelComponent);
                list.addComponent(horizontalAlignment, VerticalCellComponentAlignment.EXPAND, subtotalComponent);
                break;
            case RIGHT:
                list.setType(ListType.HORIZONTAL);
                labelComponent = labelComponent(subtotal);
                if (subtotal.getLabelWidth() != null) {
                    labelComponent.setWidth(subtotal.getLabelWidth());
                }
                labelHorizontalAlignment = horizontalAlignment;
                if (subtotal.getLabelWidthType() != null) {
                    labelHorizontalAlignment = ConstantTransform.toHorizontalCellComponentAlignment(subtotal.getLabelWidthType());
                }
                list.addComponent(horizontalAlignment, VerticalCellComponentAlignment.EXPAND, subtotalComponent);
                list.addComponent(labelHorizontalAlignment, VerticalCellComponentAlignment.EXPAND, labelComponent);
                break;
            default:
                throw new DRDesignReportException("Subtotal label position " + labelPosition.name() + " not supported");
        }

        return list;
    }

    private ColumnGrid getGroupGrid(DRIGroup group, Map<DRIGroup, ColumnGrid> groupList) throws DRException {
        if (!groupList.containsKey(group)) {
            groupList.put(group, accessor.getColumnGridTransform().createColumnGrid());
        }
        return groupList.get(group);
    }

    private void setPrintGroupSubtotalsWhenExpression(DRIGroup group, ColumnGrid grid) throws DRException {
        DRIExpression<Boolean> printSubtotalsWhenExpression = group.getPrintSubtotalsWhenExpression();
        if (grid.isEmpty() || printSubtotalsWhenExpression == null) {
            return;
        }
        grid.getList().setPrintWhenExpression(accessor.getExpressionTransform().transformExpression(printSubtotalsWhenExpression));
    }

    private void addAfterBandComponent(DRDesignBand band, ColumnGrid grid, DRFiller filler) throws DRException {
        if (grid.isEmpty()) {
            return;
        }
        DRDesignList list = grid.getList();
        if (filler != null) {
            list = new DRDesignList();
            list.addComponent(grid.getList());
            list.addComponent(HorizontalCellComponentAlignment.LEFT, null, accessor.getComponentTransform().filler(filler));
        }

        band.addComponent(list);
    }

    private void addBeforeBandComponent(DRDesignBand band, ColumnGrid grid, DRFiller filler) throws DRException {
        if (grid.isEmpty()) {
            return;
        }
        DRDesignList list = grid.getList();
        if (filler != null) {
            list = new DRDesignList();
            list.addComponent(grid.getList());
            list.addComponent(HorizontalCellComponentAlignment.LEFT, null, accessor.getComponentTransform().filler(filler));
        }
        band.addComponent(0, list);
    }

    // label
    @SuppressWarnings("unchecked")
    private DRDesignComponent labelComponent(DRISubtotal<?> subtotal) throws DRException {
        @SuppressWarnings("rawtypes") DRTextField labelField = new DRTextField();
        labelField.setValueExpression(subtotal.getLabelExpression());
        labelField.setStyle(subtotal.getLabelStyle());
        labelField.setWidth(accessor.getTemplateTransform().getColumnWidth(subtotal.getShowInColumn(), accessor.getStyleTransform().getDefaultStyle(DefaultStyleType.COLUMN)));
        DRDesignTextField designLabelField = accessor.getComponentTransform().textField(labelField, DefaultStyleType.TEXT);
        designLabelField.setUniqueName("column_" + subtotal.getShowInColumn().getName() + ".subtotal.label");
        return designLabelField;
    }

    // value
    private DRDesignTextField valueComponent(DRISubtotal<?> subtotal) throws DRException {
        DRDesignTextField designValueField = accessor.getComponentTransform().textField(subtotal.getValueField(), DefaultStyleType.SUBTOTAL);
        designValueField.setUniqueName("column_" + subtotal.getShowInColumn().getName() + ".subtotal");
        designValueField.setWidth(accessor.getTemplateTransform().getColumnWidth(subtotal.getShowInColumn(), accessor.getStyleTransform().getDefaultStyle(DefaultStyleType.COLUMN)));
        return designValueField;
    }
}
