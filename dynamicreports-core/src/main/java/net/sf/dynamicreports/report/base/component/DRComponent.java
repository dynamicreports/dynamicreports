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
package net.sf.dynamicreports.report.base.component;

import net.sf.dynamicreports.report.base.DRTableOfContentsHeading;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Abstract DRComponent class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public abstract class DRComponent implements DRIComponent {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIReportStyle style;
    private DRIExpression<Boolean> printWhenExpression;
    private Boolean removeLineWhenBlank;
    private List<DRIPropertyExpression> propertyExpressions;
    private DRTableOfContentsHeading tableOfContentsHeading;

    /**
     * <p>Constructor for DRComponent.</p>
     */
    public DRComponent() {
        init();
    }

    /**
     * <p>init.</p>
     */
    protected void init() {
        propertyExpressions = new ArrayList<DRIPropertyExpression>();
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getStyle() {
        return style;
    }

    /**
     * <p>Setter for the field <code>style</code>.</p>
     *
     * @param style a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setStyle(DRIReportStyle style) {
        this.style = style;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<Boolean> getPrintWhenExpression() {
        return printWhenExpression;
    }

    /**
     * <p>Setter for the field <code>printWhenExpression</code>.</p>
     *
     * @param printWhenExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        this.printWhenExpression = printWhenExpression;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getRemoveLineWhenBlank() {
        return removeLineWhenBlank;
    }

    /**
     * <p>Setter for the field <code>removeLineWhenBlank</code>.</p>
     *
     * @param removeLineWhenBlank a {@link java.lang.Boolean} object.
     */
    public void setRemoveLineWhenBlank(Boolean removeLineWhenBlank) {
        this.removeLineWhenBlank = removeLineWhenBlank;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIPropertyExpression> getPropertyExpressions() {
        return propertyExpressions;
    }

    /**
     * <p>Setter for the field <code>propertyExpressions</code>.</p>
     *
     * @param propertyExpressions a {@link java.util.List} object.
     */
    public void setPropertyExpressions(List<DRIPropertyExpression> propertyExpressions) {
        this.propertyExpressions = propertyExpressions;
    }

    /**
     * <p>addPropertyExpression.</p>
     *
     * @param propertyExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression} object.
     */
    public void addPropertyExpression(DRIPropertyExpression propertyExpression) {
        Validate.notNull(propertyExpression, "propertyExpression must not be null");
        this.propertyExpressions.add(propertyExpression);
    }

    /** {@inheritDoc} */
    @Override
    public DRTableOfContentsHeading getTableOfContentsHeading() {
        return tableOfContentsHeading;
    }

    /**
     * <p>Setter for the field <code>tableOfContentsHeading</code>.</p>
     *
     * @param tableOfContentsHeading a {@link net.sf.dynamicreports.report.base.DRTableOfContentsHeading} object.
     */
    public void setTableOfContentsHeading(DRTableOfContentsHeading tableOfContentsHeading) {
        this.tableOfContentsHeading = tableOfContentsHeading;
    }

}
