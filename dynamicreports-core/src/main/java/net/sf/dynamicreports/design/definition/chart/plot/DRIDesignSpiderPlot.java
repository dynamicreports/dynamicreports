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

package net.sf.dynamicreports.design.definition.chart.plot;

import java.awt.Color;

import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.style.DRIDesignFont;
import net.sf.dynamicreports.report.constant.SpiderRotation;
import net.sf.dynamicreports.report.constant.TableOrder;

/**
 * <p>DRIDesignSpiderPlot interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIDesignSpiderPlot extends DRIDesignPlot {

	/**
	 * <p>getMaxValueExpression.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
	 */
	public DRIDesignExpression getMaxValueExpression();

	/**
	 * <p>getRotation.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SpiderRotation} object.
	 */
	public SpiderRotation getRotation();

	/**
	 * <p>getTableOrder.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.TableOrder} object.
	 */
	public TableOrder getTableOrder();

	/**
	 * <p>getWebFilled.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getWebFilled();

	/**
	 * <p>getStartAngle.</p>
	 *
	 * @return a {@link java.lang.Double} object.
	 */
	public Double getStartAngle();

	/**
	 * <p>getHeadPercent.</p>
	 *
	 * @return a {@link java.lang.Double} object.
	 */
	public Double getHeadPercent();

	/**
	 * <p>getInteriorGap.</p>
	 *
	 * @return a {@link java.lang.Double} object.
	 */
	public Double getInteriorGap();

	/**
	 * <p>getAxisLineColor.</p>
	 *
	 * @return a {@link java.awt.Color} object.
	 */
	public Color getAxisLineColor();

	/**
	 * <p>getAxisLineWidth.</p>
	 *
	 * @return a {@link java.lang.Float} object.
	 */
	public Float getAxisLineWidth();

	/**
	 * <p>getLabelFont.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.definition.style.DRIDesignFont} object.
	 */
	public DRIDesignFont getLabelFont();

	/**
	 * <p>getLabelGap.</p>
	 *
	 * @return a {@link java.lang.Double} object.
	 */
	public Double getLabelGap();

	/**
	 * <p>getLabelColor.</p>
	 *
	 * @return a {@link java.awt.Color} object.
	 */
	public Color getLabelColor();
}
