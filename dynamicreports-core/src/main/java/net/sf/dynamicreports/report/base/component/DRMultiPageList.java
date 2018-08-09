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

package net.sf.dynamicreports.report.base.component;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.component.DRIMultiPageList;

/**
 * <p>DRMultiPageList class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRMultiPageList extends DRDimensionComponent implements DRIMultiPageList {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private List<DRIComponent> components;
	private SplitType splitType;

	/**
	 * <p>Constructor for DRMultiPageList.</p>
	 */
	public DRMultiPageList() {
		components = new ArrayList<DRIComponent>();
	}

	/** {@inheritDoc} */
	@Override
	public List<DRIComponent> getComponents() {
		return components;
	}

	/**
	 * <p>addComponent.</p>
	 *
	 * @param component a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public void addComponent(DRIComponent component) {
		components.add(component);
	}

	/**
	 * <p>Setter for the field <code>components</code>.</p>
	 *
	 * @param components a {@link java.util.List} object.
	 */
	public void setComponents(List<DRIComponent> components) {
		this.components = components;
	}

	/** {@inheritDoc} */
	@Override
	public SplitType getSplitType() {
		return splitType;
	}

	/**
	 * <p>Setter for the field <code>splitType</code>.</p>
	 *
	 * @param splitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public void setSplitType(SplitType splitType) {
		this.splitType = splitType;
	}

}
