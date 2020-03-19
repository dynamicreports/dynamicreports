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
package net.sf.dynamicreports.report.builder.subtotal;

import net.sf.dynamicreports.report.base.DRSubtotal;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.constant.SubtotalPosition;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import org.apache.commons.lang3.Validate;

/**
 * <p>Abstract BaseSubtotalBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
@SuppressWarnings("unchecked")
public abstract class BaseSubtotalBuilder<T extends BaseSubtotalBuilder<T, U>, U> extends AbstractBuilder<T, DRSubtotal<U>> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<U> valueExpression;

    /**
     * <p>Constructor for BaseSubtotalBuilder.</p>
     *
     * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
     */
    protected BaseSubtotalBuilder(ColumnBuilder<?, ?> showInColumn) {
        super(new DRSubtotal<U>(showInColumn.build()));
    }

    /**
     * <p>Setter for the field <code>valueExpression</code>.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    protected void setValueExpression(DRIExpression<U> valueExpression) {
        this.valueExpression = valueExpression;
    }

    /**
     * <p>setShowInColumn.</p>
     *
     * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
     * @return a T object.
     */
    public T setShowInColumn(ColumnBuilder<?, ?> showInColumn) {
        Validate.notNull(showInColumn, "showInColumn must not be null");
        getObject().setShowInColumn(showInColumn.build());
        return (T) this;
    }

    /**
     * <p>setLabel.</p>
     *
     * @param labelExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setLabel(DRIExpression<?> labelExpression) {
        getObject().setLabelExpression(labelExpression);
        return (T) this;
    }

    /**
     * <p>setLabel.</p>
     *
     * @param label a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setLabel(String label) {
        getObject().setLabelExpression(Expressions.text(label));
        return (T) this;
    }

    /**
     * <p>setLabelStyle.</p>
     *
     * @param labelStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a T object.
     */
    public T setLabelStyle(ReportStyleBuilder labelStyle) {
        if (labelStyle != null) {
            getObject().setLabelStyle(labelStyle.getStyle());
        } else {
            getObject().setLabelStyle(null);
        }
        return (T) this;
    }

    /**
     * <p>setLabelPosition.</p>
     *
     * @param labelPosition a {@link net.sf.dynamicreports.report.constant.Position} object.
     * @return a T object.
     */
    public T setLabelPosition(Position labelPosition) {
        getObject().setLabelPosition(labelPosition);
        return (T) this;
    }

    /**
     * Sets the label component preferred width.
     *
     * @param width the label component preferred width >= 0
     * @return a T object.
     * @throws java.lang.IllegalArgumentException if <code>width</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public T setLabelWidth(Integer width) {
        getObject().setLabelWidth(width);
        return (T) this;
    }

    /**
     * Sets the label component fixed width.
     *
     * @param width the label component fixed width >= 0
     * @return a T object.
     * @throws java.lang.IllegalArgumentException if <code>width</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public T setLabelFixedWidth(Integer width) {
        getObject().setLabelWidth(width);
        getObject().setLabelWidthType(ComponentDimensionType.FIXED);
        return (T) this;
    }

    /**
     * Sets the label component minimum width.
     *
     * @param width the label component minimum width >= 0
     * @return a T object.
     * @throws java.lang.IllegalArgumentException if <code>width</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public T setLabelMinWidth(Integer width) {
        getObject().setLabelWidth(width);
        getObject().setLabelWidthType(ComponentDimensionType.EXPAND);
        return (T) this;
    }

    /**
     * <p>setPattern.</p>
     *
     * @param pattern a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setPattern(String pattern) {
        getObject().getValueField().setPattern(pattern);
        return (T) this;
    }

    /**
     * <p>setPattern.</p>
     *
     * @param patternExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setPattern(DRIExpression<String> patternExpression) {
        getObject().getValueField().setPatternExpression(patternExpression);
        return (T) this;
    }

    /**
     * <p>setValueFormatter.</p>
     *
     * @param valueFormatter a {@link net.sf.dynamicreports.report.definition.expression.DRIValueFormatter} object.
     * @return a T object.
     */
    public T setValueFormatter(DRIValueFormatter<?, ? super U> valueFormatter) {
        getObject().getValueField().setValueFormatter(valueFormatter);
        return (T) this;
    }

    /**
     * <p>setDataType.</p>
     *
     * @param dataType a {@link net.sf.dynamicreports.report.definition.datatype.DRIDataType} object.
     * @return a T object.
     */
    @SuppressWarnings("rawtypes")
    public T setDataType(DRIDataType dataType) {
        getObject().getValueField().setDataType(dataType);
        return (T) this;
    }

    /**
     * <p>setAnchorName.</p>
     *
     * @param anchorName a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setAnchorName(String anchorName) {
        getObject().getValueField().setAnchorNameExpression(Expressions.text(anchorName));
        return (T) this;
    }

    /**
     * <p>setAnchorName.</p>
     *
     * @param anchorNameExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setAnchorName(DRIExpression<String> anchorNameExpression) {
        getObject().getValueField().setAnchorNameExpression(anchorNameExpression);
        return (T) this;
    }

    /**
     * <p>setBookmarkLevel.</p>
     *
     * @param bookmarkLevel a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setBookmarkLevel(Integer bookmarkLevel) {
        getObject().getValueField().setBookmarkLevel(bookmarkLevel);
        return (T) this;
    }

    /**
     * <p>setHyperLink.</p>
     *
     * @param hyperLink a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
     * @return a T object.
     */
    public T setHyperLink(HyperLinkBuilder hyperLink) {
        if (hyperLink != null) {
            getObject().getValueField().setHyperLink(hyperLink.getHyperLink());
        } else {
            getObject().getValueField().setHyperLink(null);
        }
        return (T) this;
    }

    /**
     * <p>setRows.</p>
     *
     * @param rows a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setRows(Integer rows) {
        getObject().getValueField().setRows(rows);
        return (T) this;
    }

    /**
     * <p>setFixedRows.</p>
     *
     * @param rows a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setFixedRows(Integer rows) {
        getObject().getValueField().setRows(rows);
        getObject().getValueField().setHeightType(ComponentDimensionType.FIXED);
        return (T) this;
    }

    /**
     * <p>setMinRows.</p>
     *
     * @param rows a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setMinRows(Integer rows) {
        getObject().getValueField().setRows(rows);
        getObject().getValueField().setHeightType(ComponentDimensionType.EXPAND);
        return (T) this;
    }

    /**
     * <p>setHeight.</p>
     *
     * @param height a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setHeight(Integer height) {
        getObject().getValueField().setHeight(height);
        return (T) this;
    }

    /**
     * <p>setFixedHeight.</p>
     *
     * @param height a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setFixedHeight(Integer height) {
        getObject().getValueField().setHeight(height);
        getObject().getValueField().setHeightType(ComponentDimensionType.FIXED);
        return (T) this;
    }

    /**
     * <p>setMinHeight.</p>
     *
     * @param height a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setMinHeight(Integer height) {
        getObject().getValueField().setHeight(height);
        getObject().getValueField().setHeightType(ComponentDimensionType.EXPAND);
        return (T) this;
    }

    /**
     * <p>setStyle.</p>
     *
     * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a T object.
     */
    public T setStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getValueField().setStyle(style.getStyle());
        } else {
            getObject().getValueField().setStyle(null);
        }
        return (T) this;
    }

    /**
     * <p>setPrintWhenExpression.</p>
     *
     * @param printWhenExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getValueField().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * <p>setGroup.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.builder.group.GroupBuilder} object.
     * @return a T object.
     */
    public T setGroup(GroupBuilder<?> group) {
        if (group != null) {
            getObject().setGroup(group.getGroup());
        } else {
            getObject().setGroup(null);
        }
        return (T) this;
    }

    /**
     * <p>setPosition.</p>
     *
     * @param position a {@link net.sf.dynamicreports.report.constant.SubtotalPosition} object.
     * @return a T object.
     */
    public T setPosition(SubtotalPosition position) {
        getObject().setPosition(position);
        return (T) this;
    }

    /** {@inheritDoc} */
    @Override
    protected void configure() {
        super.configure();
        getObject().getValueField().setValueExpression(valueExpression);
    }

    /**
     * <p>getSubtotal.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.DRSubtotal} object.
     */
    public DRSubtotal<U> getSubtotal() {
        return build();
    }
}
