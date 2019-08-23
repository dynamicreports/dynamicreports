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

import net.sf.dynamicreports.report.base.column.DRValueColumn;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import org.apache.commons.lang3.Validate;

/**
 * <p>ColumnGroupBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ColumnGroupBuilder extends GroupBuilder<ColumnGroupBuilder> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRValueColumn<?> column;

    /**
     * <p>Constructor for ColumnGroupBuilder.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     */
    protected ColumnGroupBuilder(ValueColumnBuilder<?, ?> column) {
        Validate.notNull(column, "column must not be null");
        this.column = column.build();
        init();
    }

    /**
     * <p>Constructor for ColumnGroupBuilder.</p>
     *
     * @param name   a {@link java.lang.String} object.
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     */
    protected ColumnGroupBuilder(String name, ValueColumnBuilder<?, ?> column) {
        super(name);
        Validate.notNull(column, "column must not be null");
        this.column = column.build();
        init();
    }

    @SuppressWarnings("unchecked")
    private void init() {
        @SuppressWarnings("rawtypes") DRIDataType dataType = column.getComponent().getDataType();
        getObject().getValueField().setDataType(dataType);
        getObject().getValueField().setStyle(column.getComponent().getStyle());
        getObject().getValueField().setPattern(column.getComponent().getPattern());
        getObject().getValueField().setPatternExpression(column.getComponent().getPatternExpression());
        getObject().getValueField().setHorizontalTextAlignment(column.getComponent().getHorizontalTextAlignment());
        getObject().setTitleExpression(column.getTitleExpression());
        getObject().setTitleStyle(column.getTitleStyle());
        getObject().setTitleWidth(column.getComponent().getWidth());
    }

    /**
     * <p>setHideColumn.</p>
     *
     * @param hideColumn a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder} object.
     */
    public ColumnGroupBuilder setHideColumn(Boolean hideColumn) {
        getObject().setHideColumn(hideColumn);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    protected void configure() {
        setValueExpression(column);
        super.configure();
    }
}
