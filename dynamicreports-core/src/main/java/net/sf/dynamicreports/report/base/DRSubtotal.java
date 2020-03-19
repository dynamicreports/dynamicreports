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
package net.sf.dynamicreports.report.base;

import net.sf.dynamicreports.report.base.column.DRColumn;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.constant.SubtotalPosition;
import net.sf.dynamicreports.report.definition.DRISubtotal;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import org.apache.commons.lang3.Validate;

/**
 * <p>DRSubtotal class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DRSubtotal<T> implements DRISubtotal<T> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRColumn<?> showInColumn;
    private DRTextField<T> valueField;
    private SubtotalPosition position;
    private DRGroup group;

    private DRIExpression<?> labelExpression;
    private DRIReportStyle labelStyle;
    private Position labelPosition;
    private Integer labelWidth;
    private ComponentDimensionType labelWidthType;

    /**
     * <p>Constructor for DRSubtotal.</p>
     *
     * @param showInColumn a {@link net.sf.dynamicreports.report.base.column.DRColumn} object.
     */
    public DRSubtotal(DRColumn<?> showInColumn) {
        setShowInColumn(showInColumn);
        init();
    }

    private void init() {
        valueField = new DRTextField<T>();
    }

    /** {@inheritDoc} */
    @Override
    public DRColumn<?> getShowInColumn() {
        return showInColumn;
    }

    /**
     * <p>Setter for the field <code>showInColumn</code>.</p>
     *
     * @param showInColumn a {@link net.sf.dynamicreports.report.base.column.DRColumn} object.
     */
    public void setShowInColumn(DRColumn<?> showInColumn) {
        Validate.notNull(showInColumn, "showInColumn must not be null");
        this.showInColumn = showInColumn;
    }

    /** {@inheritDoc} */
    @Override
    public DRTextField<T> getValueField() {
        return valueField;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getLabelExpression() {
        return labelExpression;
    }

    /**
     * <p>Setter for the field <code>labelExpression</code>.</p>
     *
     * @param labelExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setLabelExpression(DRIExpression<?> labelExpression) {
        this.labelExpression = labelExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getLabelStyle() {
        return labelStyle;
    }

    /**
     * <p>Setter for the field <code>labelStyle</code>.</p>
     *
     * @param labelStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setLabelStyle(DRIReportStyle labelStyle) {
        this.labelStyle = labelStyle;
    }

    /** {@inheritDoc} */
    @Override
    public Position getLabelPosition() {
        return labelPosition;
    }

    /**
     * <p>Setter for the field <code>labelPosition</code>.</p>
     *
     * @param labelPosition a {@link net.sf.dynamicreports.report.constant.Position} object.
     */
    public void setLabelPosition(Position labelPosition) {
        this.labelPosition = labelPosition;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getLabelWidth() {
        return labelWidth;
    }

    /**
     * <p>Setter for the field <code>labelWidth</code>.</p>
     *
     * @param labelWidth a {@link java.lang.Integer} object.
     */
    public void setLabelWidth(Integer labelWidth) {
        this.labelWidth = labelWidth;
    }

    /** {@inheritDoc} */
    @Override
    public ComponentDimensionType getLabelWidthType() {
        return labelWidthType;
    }

    /**
     * <p>Setter for the field <code>labelWidthType</code>.</p>
     *
     * @param labelWidthType a {@link net.sf.dynamicreports.report.constant.ComponentDimensionType} object.
     */
    public void setLabelWidthType(ComponentDimensionType labelWidthType) {
        this.labelWidthType = labelWidthType;
    }

    /** {@inheritDoc} */
    @Override
    public SubtotalPosition getPosition() {
        return position;
    }

    /**
     * <p>Setter for the field <code>position</code>.</p>
     *
     * @param position a {@link net.sf.dynamicreports.report.constant.SubtotalPosition} object.
     */
    public void setPosition(SubtotalPosition position) {
        Validate.notNull(position, "position must not be null");
        this.position = position;
    }

    /** {@inheritDoc} */
    @Override
    public DRGroup getGroup() {
        return group;
    }

    /**
     * <p>Setter for the field <code>group</code>.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.base.DRGroup} object.
     */
    public void setGroup(DRGroup group) {
        this.group = group;
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return valueField.getValueExpression().getName();
    }

    /** {@inheritDoc} */
    @Override
    public Class<? super T> getValueClass() {
        return valueField.getValueExpression().getValueClass();
    }
}
