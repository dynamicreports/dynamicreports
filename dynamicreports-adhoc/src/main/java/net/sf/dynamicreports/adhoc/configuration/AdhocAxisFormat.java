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

import java.awt.Color;
import java.io.Serializable;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class AdhocAxisFormat implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private String label;
	private AdhocFont labelFont;
	private Color labelColor;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public AdhocFont getLabelFont() {
		return labelFont;
	}

	public void setLabelFont(AdhocFont labelFont) {
		this.labelFont = labelFont;
	}

	public Color getLabelColor() {
		return labelColor;
	}

	public void setLabelColor(Color labelColor) {
		this.labelColor = labelColor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (!(obj instanceof AdhocAxisFormat))
			return false;

		AdhocAxisFormat object = (AdhocAxisFormat) obj;
		if (!(label == null ? object.getLabel() == null : label.equals(object.getLabel()))) {
			return false;
		}
		if (!(labelFont == null ? object.getLabelFont() == null : labelFont.equals(object.getLabelFont()))) {
			return false;
		}
		if (!(labelColor == null ? object.getLabelColor() == null : labelColor.equals(object.getLabelColor()))) {
			return false;
		}

		return true;
	}

	@Override
	public AdhocAxisFormat clone() {
		AdhocAxisFormat clone;
		try {
			clone = (AdhocAxisFormat) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		if (labelFont != null) {
			clone.labelFont = labelFont.clone();
		}

		return clone;
	}

}
