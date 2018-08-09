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

package net.sf.dynamicreports.design.base;

import net.sf.dynamicreports.design.definition.DRIDesignMargin;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignMargin class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignMargin implements DRIDesignMargin {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private int top;
	private int left;
	private int bottom;
	private int right;

	/** {@inheritDoc} */
	@Override
	public int getTop() {
		return top;
	}

	/**
	 * <p>Setter for the field <code>top</code>.</p>
	 *
	 * @param top a int.
	 */
	public void setTop(int top) {
		this.top = top;
	}

	/** {@inheritDoc} */
	@Override
	public int getLeft() {
		return left;
	}

	/**
	 * <p>Setter for the field <code>left</code>.</p>
	 *
	 * @param left a int.
	 */
	public void setLeft(int left) {
		this.left = left;
	}

	/** {@inheritDoc} */
	@Override
	public int getBottom() {
		return bottom;
	}

	/**
	 * <p>Setter for the field <code>bottom</code>.</p>
	 *
	 * @param bottom a int.
	 */
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	/** {@inheritDoc} */
	@Override
	public int getRight() {
		return right;
	}

	/**
	 * <p>Setter for the field <code>right</code>.</p>
	 *
	 * @param right a int.
	 */
	public void setRight(int right) {
		this.right = right;
	}
}
