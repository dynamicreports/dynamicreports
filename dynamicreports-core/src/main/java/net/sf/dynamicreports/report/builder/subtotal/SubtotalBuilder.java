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
package net.sf.dynamicreports.report.builder.subtotal;

import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>Abstract SubtotalBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public abstract class SubtotalBuilder<T extends SubtotalBuilder<T, U>, U> extends BaseSubtotalBuilder<T, U> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for SubtotalBuilder.</p>
     *
     * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
     */
    protected SubtotalBuilder(ColumnBuilder<?, ?> showInColumn) {
        super(showInColumn);
    }
}
