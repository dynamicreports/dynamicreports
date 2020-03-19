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
package net.sf.dynamicreports.report.base.grid;

import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import net.sf.dynamicreports.report.definition.grid.DRIColumnGridComponent;
import net.sf.dynamicreports.report.definition.grid.DRIColumnTitleGroup;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRColumnTitleGroup class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DRColumnTitleGroup implements DRIColumnTitleGroup {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRColumnGridList list;

    private DRIExpression<?> titleExpression;
    private DRIReportStyle titleStyle;
    private Integer titleWidth;
    private ComponentDimensionType titleWidthType;
    private Integer titleColumns;
    private Integer titleHeight;
    private ComponentDimensionType titleHeightType;
    private Integer titleRows;
    private Boolean titleStretchWithOverflow;
    private List<DRIPropertyExpression> titlePropertyExpressions;

    /**
     * <p>Constructor for DRColumnTitleGroup.</p>
     */
    public DRColumnTitleGroup() {
        this.list = new DRColumnGridList(ListType.HORIZONTAL);
        titlePropertyExpressions = new ArrayList<DRIPropertyExpression>();
    }

    /** {@inheritDoc} */
    @Override
    public DRColumnGridList getList() {
        return list;
    }

    /**
     * <p>addComponent.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.grid.DRIColumnGridComponent} object.
     */
    public void addComponent(DRIColumnGridComponent component) {
        list.addComponent(component);
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getTitleExpression() {
        return titleExpression;
    }

    /**
     * <p>Setter for the field <code>titleExpression</code>.</p>
     *
     * @param titleExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setTitleExpression(DRIExpression<?> titleExpression) {
        this.titleExpression = titleExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getTitleStyle() {
        return titleStyle;
    }

    /**
     * <p>Setter for the field <code>titleStyle</code>.</p>
     *
     * @param titleStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setTitleStyle(DRIReportStyle titleStyle) {
        this.titleStyle = titleStyle;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Returns the column title width.
     */
    @Override
    public Integer getTitleWidth() {
        return titleWidth;
    }

    /**
     * Sets the column title width.
     *
     * @param titleWidth the column title width >= 0
     * @throws java.lang.IllegalArgumentException if <code>titleWidth</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public void setTitleWidth(Integer titleWidth) {
        if (titleWidth != null) {
            Validate.isTrue(titleWidth >= 0, "titleWidth must be >= 0");
        }
        this.titleWidth = titleWidth;
    }

    /** {@inheritDoc} */
    @Override
    public ComponentDimensionType getTitleWidthType() {
        return titleWidthType;
    }

    /**
     * <p>Setter for the field <code>titleWidthType</code>.</p>
     *
     * @param titleWidthType a {@link net.sf.dynamicreports.report.constant.ComponentDimensionType} object.
     */
    public void setTitleWidthType(ComponentDimensionType titleWidthType) {
        this.titleWidthType = titleWidthType;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Returns the number of title columns.
     */
    @Override
    public Integer getTitleColumns() {
        return titleColumns;
    }

    /**
     * This method is used to define the width of a column title. The width is set to the <code>columns</code> multiplied by width of the character <em>m</em> for the font used
     *
     * @param titleColumns the number of columns >= 0
     * @throws java.lang.IllegalArgumentException if <code>columns</code> is < 0
     */
    public void setTitleColumns(Integer titleColumns) {
        if (titleColumns != null) {
            Validate.isTrue(titleColumns >= 0, "titleColumns must be >= 0");
        }
        this.titleColumns = titleColumns;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Returns the column title height.
     */
    @Override
    public Integer getTitleHeight() {
        return titleHeight;
    }

    /**
     * Sets the column title height.
     *
     * @param titleHeight the column title height >= 0
     * @throws java.lang.IllegalArgumentException if <code>titleHeight</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public void setTitleHeight(Integer titleHeight) {
        if (titleHeight != null) {
            Validate.isTrue(titleHeight >= 0, "titleHeight must be >= 0");
        }
        this.titleHeight = titleHeight;
    }

    /** {@inheritDoc} */
    @Override
    public ComponentDimensionType getTitleHeightType() {
        return titleHeightType;
    }

    /**
     * <p>Setter for the field <code>titleHeightType</code>.</p>
     *
     * @param titleHeightType a {@link net.sf.dynamicreports.report.constant.ComponentDimensionType} object.
     */
    public void setTitleHeightType(ComponentDimensionType titleHeightType) {
        this.titleHeightType = titleHeightType;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Returns the number of title rows.
     */
    @Override
    public Integer getTitleRows() {
        return titleRows;
    }

    /**
     * This method is used to define the height of a column title. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param titleRows the number of rows >= 0
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public void setTitleRows(Integer titleRows) {
        if (titleRows != null) {
            Validate.isTrue(titleRows >= 0, "titleRows must be >= 0");
        }
        this.titleRows = titleRows;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getTitleStretchWithOverflow() {
        return titleStretchWithOverflow;
    }

    /**
     * <p>Setter for the field <code>titleStretchWithOverflow</code>.</p>
     *
     * @param titleStretchWithOverflow a {@link java.lang.Boolean} object.
     */
    public void setTitleStretchWithOverflow(Boolean titleStretchWithOverflow) {
        this.titleStretchWithOverflow = titleStretchWithOverflow;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIPropertyExpression> getTitlePropertyExpressions() {
        return titlePropertyExpressions;
    }

    /**
     * <p>Setter for the field <code>titlePropertyExpressions</code>.</p>
     *
     * @param titlePropertyExpressions a {@link java.util.List} object.
     */
    public void setTitlePropertyExpressions(List<DRIPropertyExpression> titlePropertyExpressions) {
        this.titlePropertyExpressions = titlePropertyExpressions;
    }

    /**
     * <p>addTitlePropertyExpression.</p>
     *
     * @param propertyExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression} object.
     */
    public void addTitlePropertyExpression(DRIPropertyExpression propertyExpression) {
        Validate.notNull(propertyExpression, "propertyExpression must not be null");
        this.titlePropertyExpressions.add(propertyExpression);
    }
}
