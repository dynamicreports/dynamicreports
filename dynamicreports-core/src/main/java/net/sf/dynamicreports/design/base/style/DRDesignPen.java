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

import java.awt.Color;

import net.sf.dynamicreports.design.definition.style.DRIDesignPen;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.LineStyle;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignPen implements DRIDesignPen {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Float lineWidth;
	private LineStyle lineStyle;
	private Color lineColor;

	@Override
	public Float getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(Float lineWidth) {
		this.lineWidth = lineWidth;
	}

	@Override
	public LineStyle getLineStyle() {
		return lineStyle;
	}

	public void setLineStyle(LineStyle lineStyle) {
		this.lineStyle = lineStyle;
	}

	@Override
	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		DRDesignPen o = (DRDesignPen) obj;
		EqualsBuilder equalsBuilder = new EqualsBuilder()
				.append(lineWidth, o.lineWidth)
				.append(lineStyle, o.lineStyle)
				.append(lineColor, o.lineColor);
		return equalsBuilder.isEquals();
	}
}
