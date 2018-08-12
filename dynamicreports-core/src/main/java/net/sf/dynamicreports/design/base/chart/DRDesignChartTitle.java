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

package net.sf.dynamicreports.design.base.chart;

import net.sf.dynamicreports.design.definition.chart.DRIDesignChartTitle;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Position;

/**
 * <p>DRDesignChartTitle class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignChartTitle extends DRDesignChartSubtitle implements DRIDesignChartTitle {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Position position;

	/** {@inheritDoc} */
	@Override
	public Position getPosition() {
		return position;
	}

	/**
	 * <p>Setter for the field <code>position</code>.</p>
	 *
	 * @param position a {@link net.sf.dynamicreports.report.constant.Position} object.
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
}
