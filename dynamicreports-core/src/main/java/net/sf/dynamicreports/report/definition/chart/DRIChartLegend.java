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

package net.sf.dynamicreports.report.definition.chart;

import java.awt.Color;
import java.io.Serializable;

import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.definition.style.DRIFont;

/**
 * <p>DRIChartLegend interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIChartLegend extends Serializable {

	/**
	 * <p>getColor.</p>
	 *
	 * @return a {@link java.awt.Color} object.
	 */
	public Color getColor();

	/**
	 * <p>getBackgroundColor.</p>
	 *
	 * @return a {@link java.awt.Color} object.
	 */
	public Color getBackgroundColor();

	/**
	 * <p>getShowLegend.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getShowLegend();

	/**
	 * <p>getFont.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIFont} object.
	 */
	public DRIFont getFont();

	/**
	 * <p>getPosition.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.Position} object.
	 */
	public Position getPosition();
}
