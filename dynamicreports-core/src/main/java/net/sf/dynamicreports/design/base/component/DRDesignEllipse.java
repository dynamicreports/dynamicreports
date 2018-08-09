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

package net.sf.dynamicreports.design.base.component;

import net.sf.dynamicreports.design.base.style.DRDesignPen;
import net.sf.dynamicreports.design.definition.component.DRIDesignEllipse;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignEllipse class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignEllipse extends DRDesignComponent implements DRIDesignEllipse {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRDesignPen pen;

	/**
	 * <p>Constructor for DRDesignEllipse.</p>
	 */
	public DRDesignEllipse() {
		super("ellipse");
	}

	/** {@inheritDoc} */
	@Override
	public DRDesignPen getPen() {
		return pen;
	}

	/**
	 * <p>Setter for the field <code>pen</code>.</p>
	 *
	 * @param pen a {@link net.sf.dynamicreports.design.base.style.DRDesignPen} object.
	 */
	public void setPen(DRDesignPen pen) {
		this.pen = pen;
	}
}
