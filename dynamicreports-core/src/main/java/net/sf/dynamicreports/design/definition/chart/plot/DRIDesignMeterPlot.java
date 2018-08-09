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
import java.util.List;

import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.style.DRIDesignFont;
import net.sf.dynamicreports.report.constant.MeterShape;

/**
 * <p>DRIDesignMeterPlot interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIDesignMeterPlot extends DRIDesignPlot {

	/**
	 * <p>getDataRangeLowExpression.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
	 */
	public DRIDesignExpression getDataRangeLowExpression();

	/**
	 * <p>getDataRangeHighExpression.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
	 */
	public DRIDesignExpression getDataRangeHighExpression();

	/**
	 * <p>getValueColor.</p>
	 *
	 * @return a {@link java.awt.Color} object.
	 */
	public Color getValueColor();

	/**
	 * <p>getValueMask.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getValueMask();

	/**
	 * <p>getValueFont.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.definition.style.DRIDesignFont} object.
	 */
	public DRIDesignFont getValueFont();

	/**
	 * <p>getShape.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.MeterShape} object.
	 */
	public MeterShape getShape();

	/**
	 * <p>getIntervals.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<DRIDesignMeterInterval> getIntervals();

	/**
	 * <p>getMeterAngle.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getMeterAngle();

	/**
	 * <p>getUnits.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getUnits();

	/**
	 * <p>getTickInterval.</p>
	 *
	 * @return a {@link java.lang.Double} object.
	 */
	public Double getTickInterval();

	/**
	 * <p>getMeterBackgroundColor.</p>
	 *
	 * @return a {@link java.awt.Color} object.
	 */
	public Color getMeterBackgroundColor();

	/**
	 * <p>getNeedleColor.</p>
	 *
	 * @return a {@link java.awt.Color} object.
	 */
	public Color getNeedleColor();

	/**
	 * <p>getTickColor.</p>
	 *
	 * @return a {@link java.awt.Color} object.
	 */
	public Color getTickColor();

	/**
	 * <p>getTickLabelFont.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.definition.style.DRIDesignFont} object.
	 */
	public DRIDesignFont getTickLabelFont();
}
