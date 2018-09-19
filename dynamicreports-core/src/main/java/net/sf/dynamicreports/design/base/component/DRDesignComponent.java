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

package net.sf.dynamicreports.design.base.component;

import net.sf.dynamicreports.design.base.DRDesignTableOfContentsHeading;
import net.sf.dynamicreports.design.base.style.DRDesignStyle;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.component.DRIDesignComponent;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignPropertyExpression;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.StretchType;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Abstract DRDesignComponent class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public abstract class DRDesignComponent implements DRIDesignComponent {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private String name;
    private String uniqueName;
    private DRDesignStyle style;
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private DRIDesignExpression printWhenExpression;
    private boolean isRemoveLineWhenBlank;
    private List<DRIDesignPropertyExpression> propertyExpressions;
    private ComponentPositionType positionType;
    private StretchType stretchType;
    private boolean printInFirstWholeBand;
    private boolean printWhenDetailOverflows;
    private DRIDesignGroup printWhenGroupChanges;
    private DRDesignTableOfContentsHeading tableOfContentsHeading;

    /**
     * <p>Constructor for DRDesignComponent.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    protected DRDesignComponent(String name) {
        this.name = name;
        this.uniqueName = name;
        init();
    }

    /**
     * <p>init.</p>
     */
    protected void init() {
        propertyExpressions = new ArrayList<DRIDesignPropertyExpression>();
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return name;
    }

    /** {@inheritDoc} */
    @Override
    public String getUniqueName() {
        return uniqueName;
    }

    /**
     * <p>Setter for the field <code>uniqueName</code>.</p>
     *
     * @param uniqueName a {@link java.lang.String} object.
     */
    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignStyle getStyle() {
        return style;
    }

    /**
     * <p>Setter for the field <code>style</code>.</p>
     *
     * @param style a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     */
    public void setStyle(DRDesignStyle style) {
        this.style = style;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getX() {
        return x;
    }

    /**
     * <p>Setter for the field <code>x</code>.</p>
     *
     * @param x a {@link java.lang.Integer} object.
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getY() {
        return y;
    }

    /**
     * <p>Setter for the field <code>y</code>.</p>
     *
     * @param y a {@link java.lang.Integer} object.
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getWidth() {
        return width;
    }

    /**
     * <p>Setter for the field <code>width</code>.</p>
     *
     * @param width a {@link java.lang.Integer} object.
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getHeight() {
        return height;
    }

    /**
     * <p>Setter for the field <code>height</code>.</p>
     *
     * @param height a {@link java.lang.Integer} object.
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getPrintWhenExpression() {
        return printWhenExpression;
    }

    /**
     * <p>Setter for the field <code>printWhenExpression</code>.</p>
     *
     * @param printWhenExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setPrintWhenExpression(DRIDesignExpression printWhenExpression) {
        this.printWhenExpression = printWhenExpression;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isRemoveLineWhenBlank() {
        return isRemoveLineWhenBlank;
    }

    /**
     * <p>setRemoveLineWhenBlank.</p>
     *
     * @param isRemoveLineWhenBlank a boolean.
     */
    public void setRemoveLineWhenBlank(boolean isRemoveLineWhenBlank) {
        this.isRemoveLineWhenBlank = isRemoveLineWhenBlank;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIDesignPropertyExpression> getPropertyExpressions() {
        return propertyExpressions;
    }

    /**
     * <p>Setter for the field <code>propertyExpressions</code>.</p>
     *
     * @param propertyExpressions a {@link java.util.List} object.
     */
    public void setPropertyExpressions(List<DRIDesignPropertyExpression> propertyExpressions) {
        this.propertyExpressions = propertyExpressions;
    }

    /** {@inheritDoc} */
    @Override
    public ComponentPositionType getPositionType() {
        return positionType;
    }

    /**
     * <p>Setter for the field <code>positionType</code>.</p>
     *
     * @param positionType a {@link net.sf.dynamicreports.report.constant.ComponentPositionType} object.
     */
    public void setPositionType(ComponentPositionType positionType) {
        this.positionType = positionType;
    }

    /** {@inheritDoc} */
    @Override
    public StretchType getStretchType() {
        return stretchType;
    }

    /**
     * <p>Setter for the field <code>stretchType</code>.</p>
     *
     * @param stretchType a {@link net.sf.dynamicreports.report.constant.StretchType} object.
     */
    public void setStretchType(StretchType stretchType) {
        this.stretchType = stretchType;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isPrintInFirstWholeBand() {
        return printInFirstWholeBand;
    }

    /**
     * <p>Setter for the field <code>printInFirstWholeBand</code>.</p>
     *
     * @param printInFirstWholeBand a boolean.
     */
    public void setPrintInFirstWholeBand(boolean printInFirstWholeBand) {
        this.printInFirstWholeBand = printInFirstWholeBand;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isPrintWhenDetailOverflows() {
        return printWhenDetailOverflows;
    }

    /**
     * <p>Setter for the field <code>printWhenDetailOverflows</code>.</p>
     *
     * @param printWhenDetailOverflows a boolean.
     */
    public void setPrintWhenDetailOverflows(boolean printWhenDetailOverflows) {
        this.printWhenDetailOverflows = printWhenDetailOverflows;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignGroup getPrintWhenGroupChanges() {
        return printWhenGroupChanges;
    }

    /**
     * <p>Setter for the field <code>printWhenGroupChanges</code>.</p>
     *
     * @param printWhenGroupChanges a {@link net.sf.dynamicreports.design.definition.DRIDesignGroup} object.
     */
    public void setPrintWhenGroupChanges(DRIDesignGroup printWhenGroupChanges) {
        this.printWhenGroupChanges = printWhenGroupChanges;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignTableOfContentsHeading getTableOfContentsHeading() {
        return tableOfContentsHeading;
    }

    /**
     * <p>Setter for the field <code>tableOfContentsHeading</code>.</p>
     *
     * @param tableOfContentsHeading a {@link net.sf.dynamicreports.design.base.DRDesignTableOfContentsHeading} object.
     */
    public void setTableOfContentsHeading(DRDesignTableOfContentsHeading tableOfContentsHeading) {
        this.tableOfContentsHeading = tableOfContentsHeading;
    }

}
