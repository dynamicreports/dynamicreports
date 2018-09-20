/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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
package net.sf.dynamicreports.report.builder.group;

import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>CustomGroupBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class CustomGroupBuilder extends GroupBuilder<CustomGroupBuilder> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for CustomGroupBuilder.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     */
    protected CustomGroupBuilder(FieldBuilder<?> field) {
        Validate.notNull(field, "field must not be null");
        setValueExpression(field.build());
    }

    /**
     * <p>Constructor for CustomGroupBuilder.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     */
    protected CustomGroupBuilder(String name, FieldBuilder<?> field) {
        super(name);
        Validate.notNull(field, "field must not be null");
        setValueExpression(field.build());
    }

    /**
     * <p>Constructor for CustomGroupBuilder.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    protected CustomGroupBuilder(DRIExpression<?> valueExpression) {
        setValueExpression(valueExpression);
    }

    /**
     * <p>Constructor for CustomGroupBuilder.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    protected CustomGroupBuilder(String name, DRIExpression<?> valueExpression) {
        super(name);
        setValueExpression(valueExpression);
    }

    /**
     * <p>setTitle.</p>
     *
     * @param titleExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.CustomGroupBuilder} object.
     */
    public CustomGroupBuilder setTitle(DRIExpression<?> titleExpression) {
        getObject().setTitleExpression(titleExpression);
        getObject().setHeaderLayout(GroupHeaderLayout.TITLE_AND_VALUE);
        return this;
    }

    /**
     * <p>setTitle.</p>
     *
     * @param title a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.CustomGroupBuilder} object.
     */
    public CustomGroupBuilder setTitle(String title) {
        getObject().setTitleExpression(Expressions.text(title));
        getObject().setHeaderLayout(GroupHeaderLayout.TITLE_AND_VALUE);
        return this;
    }
}
