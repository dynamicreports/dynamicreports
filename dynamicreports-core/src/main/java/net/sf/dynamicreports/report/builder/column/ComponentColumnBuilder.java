/**
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

package net.sf.dynamicreports.report.builder.column;

import net.sf.dynamicreports.report.base.column.DRColumn;
import net.sf.dynamicreports.report.base.component.DRComponent;
import net.sf.dynamicreports.report.base.component.DRDimensionComponent;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.component.DRIDimensionComponent;
import net.sf.dynamicreports.report.exception.DRReportException;

/**
 * It is used to display custom components (e.g. images or complex content) in columns.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ComponentColumnBuilder extends ColumnBuilder<ComponentColumnBuilder, DRColumn<DRComponent>> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	/**
	 * <p>Constructor for ComponentColumnBuilder.</p>
	 *
	 * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 */
	protected ComponentColumnBuilder(ComponentBuilder<?, ?> component) {
		super(new DRColumn<DRComponent>(component.getComponent()));
	}

	/**
	 * Sets the preferred width of a column.
	 *
	 * @see net.sf.dynamicreports.report.builder.Units
	 * @param width
	 *          the column preferred width >= 0
	 * @exception IllegalArgumentException
	 *              if <code>width</code> is < 0
	 * @return a column builder
	 */
	public ComponentColumnBuilder setWidth(Integer width) {
		getDimensionComponent().setWidth(width);
		return this;
	}

	/**
	 * Sets the fixed width of a column.
	 *
	 * @see net.sf.dynamicreports.report.builder.Units
	 * @param width
	 *          the column fixed width >= 0
	 * @exception IllegalArgumentException
	 *              if <code>width</code> is < 0
	 * @return a column builder
	 */
	public ComponentColumnBuilder setFixedWidth(Integer width) {
		getDimensionComponent().setWidth(width);
		getDimensionComponent().setWidthType(ComponentDimensionType.FIXED);
		return this;
	}

	/**
	 * Sets the minimum width of a column.
	 *
	 * @see net.sf.dynamicreports.report.builder.Units
	 * @param width
	 *          the column minimum width >= 0
	 * @exception IllegalArgumentException
	 *              if <code>width</code> is < 0
	 * @return a column builder
	 */
	public ComponentColumnBuilder setMinWidth(Integer width) {
		getDimensionComponent().setWidth(width);
		getDimensionComponent().setWidthType(ComponentDimensionType.EXPAND);
		return this;
	}

	/**
	 * Sets the preferred height of a column.
	 *
	 * @see net.sf.dynamicreports.report.builder.Units
	 * @param height
	 *          the column preferred height >= 0
	 * @exception IllegalArgumentException
	 *              if <code>height</code> is < 0
	 * @return a column builder
	 */
	public ComponentColumnBuilder setHeight(Integer height) {
		getDimensionComponent().setHeight(height);
		return this;
	}

	/**
	 * Sets the fixed height of a column.
	 *
	 * @see net.sf.dynamicreports.report.builder.Units
	 * @param height
	 *          the column fixed height >= 0
	 * @exception IllegalArgumentException
	 *              if <code>height</code> is < 0
	 * @return a column builder
	 */
	public ComponentColumnBuilder setFixedHeight(Integer height) {
		getDimensionComponent().setHeight(height);
		getDimensionComponent().setHeightType(ComponentDimensionType.FIXED);
		return this;
	}

	/**
	 * Sets the minimum height of a column.
	 *
	 * @see net.sf.dynamicreports.report.builder.Units
	 * @param height
	 *          the column minimum height >= 0
	 * @exception IllegalArgumentException
	 *              if <code>height</code> is < 0
	 * @return a column builder
	 */
	public ComponentColumnBuilder setMinHeight(Integer height) {
		getDimensionComponent().setHeight(height);
		getDimensionComponent().setHeightType(ComponentDimensionType.EXPAND);
		return this;
	}

	private DRDimensionComponent getDimensionComponent() {
		if (!(getObject().getComponent() instanceof DRIDimensionComponent)) {
			throw new DRReportException("Column component" + getObject().getComponent().getClass().getName() + "is not a dimension component.");
		}
		return (DRDimensionComponent) getObject().getComponent();
	}
}
