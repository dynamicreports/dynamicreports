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

package net.sf.dynamicreports.report.base.chart;

import java.awt.Color;

import net.sf.dynamicreports.report.base.style.DRFont;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.chart.DRIChartSubtitle;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>DRChartSubtitle class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRChartSubtitle implements DRIChartSubtitle {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Color color;
	private DRFont font;
	private DRIExpression<String> title;

	/** {@inheritDoc} */
	@Override
	public Color getColor() {
		return color;
	}

	/**
	 * <p>Setter for the field <code>color</code>.</p>
	 *
	 * @param color a {@link java.awt.Color} object.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/** {@inheritDoc} */
	@Override
	public DRFont getFont() {
		return font;
	}

	/**
	 * <p>Setter for the field <code>font</code>.</p>
	 *
	 * @param font a {@link net.sf.dynamicreports.report.base.style.DRFont} object.
	 */
	public void setFont(DRFont font) {
		this.font = font;
	}

	/** {@inheritDoc} */
	@Override
	public DRIExpression<String> getTitle() {
		return title;
	}

	/**
	 * <p>Setter for the field <code>title</code>.</p>
	 *
	 * @param title a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	public void setTitle(DRIExpression<String> title) {
		this.title = title;
	}
}
