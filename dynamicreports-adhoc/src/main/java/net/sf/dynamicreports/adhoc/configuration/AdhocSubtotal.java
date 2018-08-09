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
 * <p>AdhocSubtotal class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
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

	/**
	 * <p>Getter for the field <code>name</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>Setter for the field <code>name</code>.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>Getter for the field <code>label</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <p>Setter for the field <code>label</code>.</p>
	 *
	 * @param label a {@link java.lang.String} object.
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * <p>Getter for the field <code>calculation</code>.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocCalculation} object.
	 */
	public AdhocCalculation getCalculation() {
		return calculation;
	}

	/**
	 * <p>Setter for the field <code>calculation</code>.</p>
	 *
	 * @param calculation a {@link net.sf.dynamicreports.adhoc.configuration.AdhocCalculation} object.
	 */
	public void setCalculation(AdhocCalculation calculation) {
		this.calculation = calculation;
	}

	/**
	 * <p>Getter for the field <code>style</code>.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
	 */
	public AdhocStyle getStyle() {
		return style;
	}

	/**
	 * <p>Setter for the field <code>style</code>.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
	 */
	public void setStyle(AdhocStyle style) {
		this.style = style;
	}

	/**
	 * <p>Getter for the field <code>labelStyle</code>.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
	 */
	public AdhocStyle getLabelStyle() {
		return labelStyle;
	}

	/**
	 * <p>Setter for the field <code>labelStyle</code>.</p>
	 *
	 * @param labelStyle a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
	 */
	public void setLabelStyle(AdhocStyle labelStyle) {
		this.labelStyle = labelStyle;
	}

	/**
	 * <p>Getter for the field <code>position</code>.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocSubtotalPosition} object.
	 */
	public AdhocSubtotalPosition getPosition() {
		return position;
	}

	/**
	 * <p>Setter for the field <code>position</code>.</p>
	 *
	 * @param position a {@link net.sf.dynamicreports.adhoc.configuration.AdhocSubtotalPosition} object.
	 */
	public void setPosition(AdhocSubtotalPosition position) {
		this.position = position;
	}

	/**
	 * <p>Getter for the field <code>groupName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * <p>Setter for the field <code>groupName</code>.</p>
	 *
	 * @param groupName a {@link java.lang.String} object.
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/** {@inheritDoc} */
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

	/** {@inheritDoc} */
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
