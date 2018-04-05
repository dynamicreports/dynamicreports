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
public class AdhocGroup implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Boolean startInNewPage;
	private AdhocGroupHeaderLayout headerLayout;
	private AdhocStyle style;
	private AdhocStyle titleStyle;
	private AdhocProperties properties;

	public AdhocGroup() {
		properties = new AdhocProperties();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStartInNewPage() {
		return startInNewPage;
	}

	public void setStartInNewPage(Boolean startInNewPage) {
		this.startInNewPage = startInNewPage;
	}

	public AdhocGroupHeaderLayout getHeaderLayout() {
		return headerLayout;
	}

	public void setHeaderLayout(AdhocGroupHeaderLayout headerLayout) {
		this.headerLayout = headerLayout;
	}

	public AdhocStyle getStyle() {
		return style;
	}

	public void setStyle(AdhocStyle style) {
		this.style = style;
	}

	public AdhocStyle getTitleStyle() {
		return titleStyle;
	}

	public void setTitleStyle(AdhocStyle titleStyle) {
		this.titleStyle = titleStyle;
	}

	public AdhocProperties getProperties() {
		return properties;
	}

	public <T> T getProperty(String key) {
		return this.properties.getProperty(key);
	}

	public void setProperty(String key, Object value) {
		this.properties.setProperty(key, value);
	}

	public void setProperties(AdhocProperties properties) {
		this.properties = properties;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (!(obj instanceof AdhocGroup))
			return false;

		AdhocGroup object = (AdhocGroup) obj;
		if (!(name == null ? object.getName() == null : name.equals(object.getName()))) {
			return false;
		}
		if (!(startInNewPage == null ? object.getStartInNewPage() == null : startInNewPage.equals(object.getStartInNewPage()))) {
			return false;
		}
		if (!(headerLayout == null ? object.getHeaderLayout() == null : headerLayout.equals(object.getHeaderLayout()))) {
			return false;
		}
		if (!(style == null ? object.getStyle() == null : style.equals(object.getStyle()))) {
			return false;
		}
		if (!(titleStyle == null ? object.getTitleStyle() == null : titleStyle.equals(object.getTitleStyle()))) {
			return false;
		}
		if (!(properties == null ? object.getProperties() == null : properties.equals(object.getProperties()))) {
			return false;
		}

		return true;
	}

	@Override
	public AdhocGroup clone() {
		AdhocGroup clone;
		try {
			clone = (AdhocGroup) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		if (style != null) {
			clone.style = style.clone();
		}
		if (titleStyle != null) {
			clone.titleStyle = titleStyle.clone();
		}
		if (properties != null) {
			clone.properties = properties.clone();
		}

		return clone;
	}

}
