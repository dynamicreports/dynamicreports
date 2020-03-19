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
package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.report.base.component.DRComponent;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsHeadingBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>Abstract ComponentBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
@SuppressWarnings("unchecked")
public abstract class ComponentBuilder<T extends ComponentBuilder<T, U>, U extends DRComponent> extends AbstractBuilder<T, U> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for ComponentBuilder.</p>
     *
     * @param object a U object.
     */
    protected ComponentBuilder(U object) {
        super(object);
    }

    /**
     * <p>setStyle.</p>
     *
     * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a T object.
     */
    public T setStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().setStyle(style.getStyle());
        } else {
            getObject().setStyle(null);
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
        getObject().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * <p>removeLineWhenBlank.</p>
     *
     * @return a T object.
     */
    public T removeLineWhenBlank() {
        return setRemoveLineWhenBlank(true);
    }

    /**
     * <p>setRemoveLineWhenBlank.</p>
     *
     * @param removeLineWhenBlank a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setRemoveLineWhenBlank(Boolean removeLineWhenBlank) {
        getObject().setRemoveLineWhenBlank(removeLineWhenBlank);
        return (T) this;
    }

    /**
     * <p>addProperty.</p>
     *
     * @param propertyExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression} object.
     * @return a T object.
     */
    public T addProperty(DRIPropertyExpression propertyExpression) {
        getComponent().addPropertyExpression(propertyExpression);
        return (T) this;
    }

    /**
     * <p>addProperty.</p>
     *
     * @param name            a {@link java.lang.String} object.
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T addProperty(String name, DRIExpression<String> valueExpression) {
        getComponent().addPropertyExpression(Expressions.property(name, valueExpression));
        return (T) this;
    }

    /**
     * <p>addProperty.</p>
     *
     * @param name  a {@link java.lang.String} object.
     * @param value a {@link java.lang.String} object.
     * @return a T object.
     */
    public T addProperty(String name, String value) {
        getComponent().addPropertyExpression(Expressions.property(name, value));
        return (T) this;
    }

    /**
     * <p>setTableOfContentsHeading.</p>
     *
     * @param label a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setTableOfContentsHeading(String label) {
        TableOfContentsHeadingBuilder tocHeading = DynamicReports.tableOfContentsHeading(label);
        return setTableOfContentsHeading(tocHeading);
    }

    /**
     * <p>setTableOfContentsHeading.</p>
     *
     * @param tocHeading a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsHeadingBuilder} object.
     * @return a T object.
     */
    public T setTableOfContentsHeading(TableOfContentsHeadingBuilder tocHeading) {
        Validate.notNull(tocHeading, "tocHeading must not be null");
        getComponent().setTableOfContentsHeading(tocHeading.build());
        return (T) this;
    }

    /**
     * <p>getComponent.</p>
     *
     * @return a U object.
     */
    public U getComponent() {
        return build();
    }
}
