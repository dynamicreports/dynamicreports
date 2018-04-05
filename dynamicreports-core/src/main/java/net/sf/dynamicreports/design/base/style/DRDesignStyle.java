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

package net.sf.dynamicreports.design.base.style;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.design.definition.style.DRIDesignStyle;
import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.constant.Constants;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignStyle extends DRDesignBaseStyle implements DRIDesignStyle {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private DRDesignStyle parentStyle;
	private List<DRDesignConditionalStyle> conditionalStyles;

	public DRDesignStyle() {
		this(ReportUtils.generateUniqueName("style"));
	}

	public DRDesignStyle(String name) {
		this.name = Validate.notBlank(name);
		this.conditionalStyles = new ArrayList<DRDesignConditionalStyle>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public DRDesignStyle getParentStyle() {
		return parentStyle;
	}

	public void setParentStyle(DRDesignStyle parentStyle) {
		this.parentStyle = parentStyle;
	}

	@Override
	public List<DRDesignConditionalStyle> getConditionalStyles() {
		return conditionalStyles;
	}

	public void setConditionalStyles(List<DRDesignConditionalStyle> conditionalStyles) {
		this.conditionalStyles = conditionalStyles;
	}

	public void addConditionalStyle(DRDesignConditionalStyle conditionalStyle) {
		this.conditionalStyles.add(conditionalStyle);
	}

	@Override
	public boolean equals(Object obj) {
		EqualsBuilder equalsBuilder = new EqualsBuilder().appendSuper(super.equals(obj));
		if (equalsBuilder.isEquals()) {
			DRDesignStyle o = (DRDesignStyle) obj;
			if (!(parentStyle == null ? o.getParentStyle() == null : parentStyle.getName().equals(o.getParentStyle().getName()))) {
				return false;
			}
			equalsBuilder
					.append(name, o.name)
					.append(conditionalStyles, o.conditionalStyles);
		}
		return equalsBuilder.isEquals();
	}
}
