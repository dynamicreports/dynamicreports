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

package net.sf.dynamicreports.report.constant;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public enum StretchType {
	NO_STRETCH,
	/**
	 * @deprecated use ELEMENT_GROUP_HEIGHT instead
	 */
	RELATIVE_TO_TALLEST_OBJECT,
	/**
	 * @deprecated use CONTAINER_HEIGHT instead
	 */
	RELATIVE_TO_BAND_HEIGHT, ELEMENT_GROUP_HEIGHT, ELEMENT_GROUP_BOTTOM, CONTAINER_HEIGHT, CONTAINER_BOTTOM;
}
