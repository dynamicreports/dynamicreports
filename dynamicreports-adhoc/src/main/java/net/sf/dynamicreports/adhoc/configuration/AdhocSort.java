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
public class AdhocSort implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private AdhocOrderType orderType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdhocOrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(AdhocOrderType orderType) {
		this.orderType = orderType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (!(obj instanceof AdhocSort))
			return false;

		AdhocSort object = (AdhocSort) obj;
		if (!(name == null ? object.getName() == null : name.equals(object.getName()))) {
			return false;
		}
		if (!(orderType == null ? object.getOrderType() == null : orderType.equals(object.getOrderType()))) {
			return false;
		}

		return true;
	}

	@Override
	public AdhocSort clone() {
		AdhocSort clone;
		try {
			clone = (AdhocSort) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		return clone;
	}

}
