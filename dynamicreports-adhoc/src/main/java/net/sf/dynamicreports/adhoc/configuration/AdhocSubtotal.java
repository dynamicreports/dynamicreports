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

package net.sf.dynamicreports.adhoc.configuration;

import java.io.Serializable;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class AdhocSubtotal implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String label;
	private AdhocCalculation calculation;
	private AdhocStyle style;
	private AdhocStyle labelStyle;
	private AdhocSubtotalPosition position;
	private String groupName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public AdhocCalculation getCalculation() {
		return calculation;
	}

	public void setCalculation(AdhocCalculation calculation) {
		this.calculation = calculation;
	}

	public AdhocStyle getStyle() {
		return style;
	}

	public void setStyle(AdhocStyle style) {
		this.style = style;
	}

	public AdhocStyle getLabelStyle() {
		return labelStyle;
	}

	public void setLabelStyle(AdhocStyle labelStyle) {
		this.labelStyle = labelStyle;
	}

	public AdhocSubtotalPosition getPosition() {
		return position;
	}

	public void setPosition(AdhocSubtotalPosition position) {
		this.position = position;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AdhocSubtotal)) {
			return false;
		}

		AdhocSubtotal object = (AdhocSubtotal) obj;
		if (!(name == null ? object.getName() == null : name.equals(object.getName()))) {
			return false;
		}
		if (!(label == null ? object.getLabel() == null : label.equals(object.getLabel()))) {
			return false;
		}
		if (!(calculation == null ? object.getCalculation() == null : calculation.equals(object.getCalculation()))) {
			return false;
		}
		if (!(style == null ? object.getStyle() == null : style.equals(object.getStyle()))) {
			return false;
		}
		if (!(labelStyle == null ? object.getLabelStyle() == null : labelStyle.equals(object.getLabelStyle()))) {
			return false;
		}
		if (!(position == null ? object.getPosition() == null : position.equals(object.getPosition()))) {
			return false;
		}
		if (!(groupName == null ? object.getGroupName() == null : groupName.equals(object.getGroupName()))) {
			return false;
		}

		return true;
	}

	@Override
	public AdhocSubtotal clone() {
		AdhocSubtotal clone;
		try {
			clone = (AdhocSubtotal) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		if (style != null) {
			clone.style = style.clone();
		}
		if (labelStyle != null) {
			clone.labelStyle = labelStyle.clone();
		}

		return clone;
	}

}
