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
package net.sf.dynamicreports.report.builder.group;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * A set of methods of creating report groups
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class Groups {

    // column

    /**
     * <p>group.</p>
     *
     * @param groupColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder} object.
     */
    public static ColumnGroupBuilder group(ValueColumnBuilder<?, ?> groupColumn) {
        return new ColumnGroupBuilder(groupColumn);
    }

    /**
     * <p>group.</p>
     *
     * @param name        a {@link java.lang.String} object.
     * @param groupColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder} object.
     */
    public static ColumnGroupBuilder group(String name, ValueColumnBuilder<?, ?> groupColumn) {
        return new ColumnGroupBuilder(name, groupColumn);
    }

    // custom

    /**
     * <p>group.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.CustomGroupBuilder} object.
     */
    public static CustomGroupBuilder group(String fieldName, Class<?> valueClass) {
        return group(DynamicReports.field(fieldName, valueClass));
    }

    /**
     * <p>group.</p>
     *
     * @param name       a {@link java.lang.String} object.
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.CustomGroupBuilder} object.
     */
    public static CustomGroupBuilder group(String name, String fieldName, Class<?> valueClass) {
        return group(name, DynamicReports.field(fieldName, valueClass));
    }

    /**
     * <p>group.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.CustomGroupBuilder} object.
     */
    public static CustomGroupBuilder group(FieldBuilder<?> field) {
        return new CustomGroupBuilder(field);
    }

    /**
     * <p>group.</p>
     *
     * @param name  a {@link java.lang.String} object.
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.CustomGroupBuilder} object.
     */
    public static CustomGroupBuilder group(String name, FieldBuilder<?> field) {
        return new CustomGroupBuilder(name, field);
    }

    /**
     * <p>group.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.CustomGroupBuilder} object.
     */
    public static CustomGroupBuilder group(DRIExpression<?> expression) {
        return new CustomGroupBuilder(expression);
    }

    /**
     * <p>group.</p>
     *
     * @param name       a {@link java.lang.String} object.
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.CustomGroupBuilder} object.
     */
    public static CustomGroupBuilder group(String name, DRIExpression<?> expression) {
        return new CustomGroupBuilder(name, expression);
    }
}
