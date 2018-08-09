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

package net.sf.dynamicreports.report.base.crosstab;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup;

/**
 * <p>DRCrosstabRowGroup class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRCrosstabRowGroup<T> extends DRCrosstabGroup<T> implements DRICrosstabRowGroup<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Integer headerWidth;
	private Integer totalHeaderHeight;

	/** {@inheritDoc} */
	@Override
	public Integer getHeaderWidth() {
		return headerWidth;
	}

	/**
	 * <p>Setter for the field <code>headerWidth</code>.</p>
	 *
	 * @param headerWidth a {@link java.lang.Integer} object.
	 */
	public void setHeaderWidth(Integer headerWidth) {
		this.headerWidth = headerWidth;
	}

	/** {@inheritDoc} */
	@Override
	public Integer getTotalHeaderHeight() {
		return totalHeaderHeight;
	}

	/**
	 * <p>Setter for the field <code>totalHeaderHeight</code>.</p>
	 *
	 * @param totalHeaderHeight a {@link java.lang.Integer} object.
	 */
	public void setTotalHeaderHeight(Integer totalHeaderHeight) {
		this.totalHeaderHeight = totalHeaderHeight;
	}
}
