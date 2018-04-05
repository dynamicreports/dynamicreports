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
public class AdhocPage implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private Integer width;
	private Integer height;
	private AdhocPageOrientation orientation;
	private Integer topMargin;
	private Integer bottomMargin;
	private Integer leftMargin;
	private Integer rightMargin;
	private Boolean ignorePageWidth;

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public AdhocPageOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(AdhocPageOrientation orientation) {
		this.orientation = orientation;
	}

	public Integer getTopMargin() {
		return topMargin;
	}

	public void setTopMargin(Integer topMargin) {
		this.topMargin = topMargin;
	}

	public Integer getBottomMargin() {
		return bottomMargin;
	}

	public void setBottomMargin(Integer bottomMargin) {
		this.bottomMargin = bottomMargin;
	}

	public Integer getLeftMargin() {
		return leftMargin;
	}

	public void setLeftMargin(Integer leftMargin) {
		this.leftMargin = leftMargin;
	}

	public Integer getRightMargin() {
		return rightMargin;
	}

	public void setRightMargin(Integer rightMargin) {
		this.rightMargin = rightMargin;
	}

	public Boolean getIgnorePageWidth() {
		return ignorePageWidth;
	}

	public void setIgnorePageWidth(Boolean ignorePageWidth) {
		this.ignorePageWidth = ignorePageWidth;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (!(obj instanceof AdhocPage))
			return false;

		AdhocPage object = (AdhocPage) obj;
		if (!(width == null ? object.getWidth() == null : width.equals(object.getWidth()))) {
			return false;
		}
		if (!(height == null ? object.getHeight() == null : height.equals(object.getHeight()))) {
			return false;
		}
		if (!(orientation == null ? object.getOrientation() == null : orientation.equals(object.getOrientation()))) {
			return false;
		}
		if (!(topMargin == null ? object.getTopMargin() == null : topMargin.equals(object.getTopMargin()))) {
			return false;
		}
		if (!(bottomMargin == null ? object.getBottomMargin() == null : bottomMargin.equals(object.getBottomMargin()))) {
			return false;
		}
		if (!(leftMargin == null ? object.getLeftMargin() == null : leftMargin.equals(object.getLeftMargin()))) {
			return false;
		}
		if (!(rightMargin == null ? object.getRightMargin() == null : rightMargin.equals(object.getRightMargin()))) {
			return false;
		}
		if (!(ignorePageWidth == null ? object.getIgnorePageWidth() == null : ignorePageWidth.equals(object.getIgnorePageWidth()))) {
			return false;
		}

		return true;
	}

	@Override
	public AdhocPage clone() {
		AdhocPage clone;
		try {
			clone = (AdhocPage) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		return clone;
	}

}
