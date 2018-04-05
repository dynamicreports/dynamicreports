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

package net.sf.dynamicreports.design.base;

import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.definition.DRIDesignBand;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.SplitType;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignBand implements DRIDesignBand {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private SplitType splitType;
	private DRDesignList list;
	private DRDesignComponent bandComponent;
	private Integer height;
	private DRIDesignExpression printWhenExpression;

	public DRDesignBand(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public SplitType getSplitType() {
		return splitType;
	}

	public void setSplitType(SplitType splitType) {
		this.splitType = splitType;
	}

	public void setList(DRDesignList list) {
		this.list = list;
	}

	@Override
	public DRDesignList getList() {
		return list;
	}

	public void addComponent(DRDesignComponent component) {
		list.addComponent(component);
	}

	public void addComponent(int index, DRDesignComponent component) {
		list.addComponent(index, component);
	}

	@Override
	public DRDesignComponent getBandComponent() {
		return bandComponent;
	}

	public void setBandComponent(DRDesignComponent component) {
		this.bandComponent = component;
	}

	@Override
	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	@Override
	public DRIDesignExpression getPrintWhenExpression() {
		return printWhenExpression;
	}

	public void setPrintWhenExpression(DRIDesignExpression printWhenExpression) {
		this.printWhenExpression = printWhenExpression;
	}
}
