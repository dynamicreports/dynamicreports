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
package net.sf.dynamicreports.design.transformation;

import net.sf.dynamicreports.design.base.component.DRDesignFiller;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.component.DRDesignListCell;
import net.sf.dynamicreports.design.base.component.DRDesignTextField;
import net.sf.dynamicreports.design.base.style.DRDesignStyle;
import net.sf.dynamicreports.design.constant.DefaultStyleType;
import net.sf.dynamicreports.design.exception.DRDesignReportException;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.base.grid.DRColumnGridList;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;
import net.sf.dynamicreports.report.definition.DRIReport;
import net.sf.dynamicreports.report.definition.column.DRIBooleanColumn;
import net.sf.dynamicreports.report.definition.column.DRIColumn;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.component.DRIDimensionComponent;
import net.sf.dynamicreports.report.definition.grid.DRIColumnGrid;
import net.sf.dynamicreports.report.definition.grid.DRIColumnGridComponent;
import net.sf.dynamicreports.report.definition.grid.DRIColumnGridList;
import net.sf.dynamicreports.report.definition.grid.DRIColumnGridListCell;
import net.sf.dynamicreports.report.definition.grid.DRIColumnTitleGroup;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * <p>ColumnGridTransform class.</p>
 *
 * @author Ricardo Mariaca, Jan Moxter
 * 
 */
public class ColumnGridTransform {
    private final DesignTransformAccessor accessor;
    private DRIColumnGridList columnGridList;

    /**
     * <p>Constructor for ColumnGridTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public ColumnGridTransform(final DesignTransformAccessor accessor) {
        this.accessor = accessor;
    }

    /**
     * <p>transform.</p>
     */
    public void transform() {
        final DRIReport report = accessor.getReport();
        final DRIColumnGrid columnGrid = report.getColumnGrid();
        if (columnGrid != null && !columnGrid.getList().getListCells().isEmpty()) {
            this.columnGridList = columnGrid.getList();
            return;
        }

        final DRColumnGridList columnGridList = new DRColumnGridList();
        if (columnGrid != null) {
            columnGridList.setGap(columnGrid.getList().getGap());
            columnGridList.setType(columnGrid.getList().getType());
        }
        addColumnsToGridList(columnGridList);
        this.columnGridList = columnGridList;
    }

    private void addColumnsToGridList(final DRColumnGridList columnGridList) {
        final DRIReport report = accessor.getReport();
        for (final DRIColumn<?> column : report.getColumns()) {
            if (!accessor.getGroupTransform().getHideGroupColumns().contains(column)) {
                columnGridList.addComponent(column);
            }
        }
    }

    /**
     * <p>createColumnGrid.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.transformation.ColumnGrid} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected ColumnGrid createColumnGrid() throws DRException {
        return createColumnGrid(columnGridList, null, false);
    }

    /**
     * <p>createColumnTitleGrid.</p>
     *
     * @param groupPaddingStyle a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a {@link net.sf.dynamicreports.design.transformation.ColumnGrid} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected ColumnGrid createColumnTitleGrid(final DRDesignStyle groupPaddingStyle) throws DRException {
        return createColumnGrid(columnGridList, groupPaddingStyle, true);
    }

    private ColumnGrid createColumnGrid(final DRIColumnGridList columnGridList, final DRDesignStyle groupPaddingStyle, final boolean titleGroup) throws DRException {
        final ColumnGrid columnGrid = new ColumnGrid();
        final DRDesignList list = list(columnGridList, columnGrid, titleGroup).getList();
        final int groupPadding = accessor.getGroupTransform().getGroupPadding();
        if (groupPadding > 0) {
            final DRDesignFiller filler = new DRDesignFiller();
            filler.setStyle(groupPaddingStyle);
            filler.setWidth(groupPadding);
            filler.setHeight(0);
            list.addComponent(0, HorizontalCellComponentAlignment.CENTER, null, filler);
        }
        columnGrid.setList(list);
        return columnGrid;
    }

    private GridList list(final DRIColumnGridComponent columnGridComponent, final ColumnGrid columnGrid, final boolean titleGroup) throws DRException {
        if (columnGridComponent instanceof DRIColumn<?>) {
            final DRDesignList list = new DRDesignList(ListType.VERTICAL);
            final DRIColumn<?> column = (DRIColumn<?>) columnGridComponent;
            list.setWidth(accessor.getTemplateTransform().getColumnWidth(column, accessor.getStyleTransform().getDefaultStyle(DefaultStyleType.COLUMN)));
            columnGrid.addList(column, list);
            return new GridList(list, null);
        } else if (columnGridComponent instanceof DRIColumnGridList) {
            return new GridList(columnGridList((DRIColumnGridList) columnGridComponent, columnGrid, titleGroup), null);
        } else if (columnGridComponent instanceof DRIColumnTitleGroup) {
            return columnGridTitleGroup((DRIColumnTitleGroup) columnGridComponent, columnGrid, titleGroup);
        } else {
            throw new DRDesignReportException("Column grid component " + columnGridComponent.getClass().getName() + " not supported");
        }
    }

    private DRDesignList columnGridList(final DRIColumnGridList columnGridList, final ColumnGrid columnGrid, final boolean titleGroup) throws DRException {
        final DRDesignList list = new DRDesignList();
        list.setType(columnGridList.getType());
        list.setGap(columnGridList.getGap());
        for (final DRIColumnGridListCell cell : columnGridList.getListCells()) {
            final DRIColumnGridComponent component = cell.getComponent();
            HorizontalCellComponentAlignment horizontalAlignment = cell.getHorizontalAlignment();
            VerticalCellComponentAlignment verticalAlignment = cell.getVerticalAlignment();
            if (component instanceof DRIColumn<?>) {
                final DRIColumn<?> column = (DRIColumn<?>) component;
                if (column instanceof DRIBooleanColumn) {
                    if (horizontalAlignment == null) {
                        horizontalAlignment = ConstantTransform.toHorizontalCellComponentAlignment(((DRIBooleanColumn) column).getComponent().getWidthType());
                    }
                    if (verticalAlignment == null) {
                        verticalAlignment = ConstantTransform.toVerticalCellComponentAlignment(((DRIBooleanColumn) column).getComponent().getHeightType());
                    }
                } else {
                    final DRIComponent columnComponent = accessor.getColumnTransform().getColumnComponent(column);
                    if (columnComponent instanceof DRIDimensionComponent) {
                        if (horizontalAlignment == null) {
                            horizontalAlignment = ConstantTransform.toHorizontalCellComponentAlignment(((DRIDimensionComponent) columnComponent).getWidthType());
                        }
                        if (verticalAlignment == null) {
                            verticalAlignment = ConstantTransform.toVerticalCellComponentAlignment(((DRIDimensionComponent) columnComponent).getHeightType());
                        }
                    }
                }
            }
            final GridList gridList = list(component, columnGrid, titleGroup);
            if (gridList.getHorizontalCellAlignment() != null) {
                list.addComponent(gridList.getHorizontalCellAlignment(), cell.getVerticalAlignment(), gridList.getList());
            } else {
                list.addComponent(horizontalAlignment, cell.getVerticalAlignment(), gridList.getList());
            }
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    private GridList columnGridTitleGroup(final DRIColumnTitleGroup columnGridTitleGroup, final ColumnGrid columnGrid, final boolean titleGroup) throws DRException {
        final DRDesignList columnList = list(columnGridTitleGroup.getList(), columnGrid, titleGroup).getList();

        @SuppressWarnings("rawtypes") final DRTextField titleGroupField = new DRTextField();
        titleGroupField.setValueExpression(columnGridTitleGroup.getTitleExpression());
        titleGroupField.setStyle(columnGridTitleGroup.getTitleStyle());
        titleGroupField.setHeight(columnGridTitleGroup.getTitleHeight());
        titleGroupField.setHeightType(columnGridTitleGroup.getTitleHeightType());
        titleGroupField.setRows(columnGridTitleGroup.getTitleRows());
        titleGroupField.setStretchWithOverflow(columnGridTitleGroup.getTitleStretchWithOverflow());
        titleGroupField.setTextAdjust(columnGridTitleGroup.getTitleTextAdjust());
        titleGroupField.setPropertyExpressions(columnGridTitleGroup.getTitlePropertyExpressions());

        HorizontalCellComponentAlignment hCellAlignment = null;
        if (columnGridTitleGroup.getTitleWidth() == null && columnGridTitleGroup.getTitleColumns() == null) {
            int totalWidth = 0;
            for (final DRDesignListCell cell : columnList.getListCells()) {
                final Integer width = cell.getComponent().getWidth();
                final HorizontalCellComponentAlignment horizontalAlignment = cell.getHorizontalAlignment();
                if (horizontalAlignment == null || horizontalAlignment.equals(HorizontalCellComponentAlignment.EXPAND) || horizontalAlignment.equals(HorizontalCellComponentAlignment.FLOAT)) {
                    totalWidth = 0;
                    break;
                }
                if (width != null) {
                    totalWidth += width;
                }
            }
            if (totalWidth > 0) {
                titleGroupField.setWidth(totalWidth);
                hCellAlignment = HorizontalCellComponentAlignment.LEFT;
            }
        } else {
            if (columnGridTitleGroup.getTitleWidth() != null) {
                titleGroupField.setWidth(columnGridTitleGroup.getTitleWidth());
            }
            if (columnGridTitleGroup.getTitleColumns() != null) {
                titleGroupField.setColumns(columnGridTitleGroup.getTitleColumns());
            }
            hCellAlignment = ConstantTransform.toHorizontalCellComponentAlignment(columnGridTitleGroup.getTitleWidthType());
        }

        final DRDesignTextField designTitleGroupField = accessor.getComponentTransform().textField(titleGroupField, DefaultStyleType.COLUMN_TITLE);
        designTitleGroupField.setUniqueName("columngroup.title");

        if (!titleGroup || columnGridTitleGroup.getTitleExpression() == null) {
            columnList.setRemovable(true);
            if (hCellAlignment != null) {
                final DRDesignList list = new DRDesignList();
                list.setType(ListType.VERTICAL);
                list.addComponent(columnList);
                list.setWidth(designTitleGroupField.getWidth());
                return new GridList(list, hCellAlignment);
            }
            return new GridList(columnList, null);
        }

        columnGrid.setEmpty(!titleGroup);

        final DRDesignList list = new DRDesignList();
        list.setType(ListType.VERTICAL);
        if (hCellAlignment != null) {
            list.addComponent(hCellAlignment, null, designTitleGroupField);
            list.addComponent(columnList);
            list.setWidth(designTitleGroupField.getWidth());
            return new GridList(list, hCellAlignment);
        } else {
            list.addComponent(designTitleGroupField);
            list.addComponent(columnList);
            return new GridList(list, null);
        }
    }

    private class GridList {
        private final HorizontalCellComponentAlignment horizontalCellAlignment;
        private final DRDesignList list;

        private GridList(final DRDesignList list, final HorizontalCellComponentAlignment horizontalCellAlignment) {
            this.list = list;
            this.horizontalCellAlignment = horizontalCellAlignment;
        }

        public HorizontalCellComponentAlignment getHorizontalCellAlignment() {
            return horizontalCellAlignment;
        }

        public DRDesignList getList() {
            return list;
        }
    }
}
