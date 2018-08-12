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

package net.sf.dynamicreports.report.builder.chart;

import java.awt.Color;

import net.sf.dynamicreports.report.base.chart.plot.DRAxisFormat;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * <p>AxisFormatBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class AxisFormatBuilder extends AbstractBuilder<AxisFormatBuilder, DRAxisFormat> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	/**
	 * <p>Constructor for AxisFormatBuilder.</p>
	 */
	protected AxisFormatBuilder() {
		super(new DRAxisFormat());
	}

	/**
	 * <p>setLabel.</p>
	 *
	 * @param label a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setLabel(String label) {
		getObject().setLabelExpression(Expressions.text(label));
		return this;
	}

	/**
	 * <p>setLabel.</p>
	 *
	 * @param labelExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setLabel(DRIExpression<String> labelExpression) {
		getObject().setLabelExpression(labelExpression);
		return this;
	}

	/**
	 * <p>setLabelFont.</p>
	 *
	 * @param labelFont a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setLabelFont(FontBuilder labelFont) {
		Validate.notNull(labelFont, "labelFont must not be null");
		getObject().setLabelFont(labelFont.build());
		return this;
	}

	/**
	 * <p>setLabelColor.</p>
	 *
	 * @param labelColor a {@link java.awt.Color} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setLabelColor(Color labelColor) {
		getObject().setLabelColor(labelColor);
		return this;
	}

	/**
	 * <p>setTickLabelFont.</p>
	 *
	 * @param tickLabelFont a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setTickLabelFont(FontBuilder tickLabelFont) {
		Validate.notNull(tickLabelFont, "tickLabelFont must not be null");
		getObject().setTickLabelFont(tickLabelFont.build());
		return this;
	}

	/**
	 * <p>setTickLabelColor.</p>
	 *
	 * @param tickLabelColor a {@link java.awt.Color} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setTickLabelColor(Color tickLabelColor) {
		getObject().setTickLabelColor(tickLabelColor);
		return this;
	}

	/**
	 * <p>setTickLabelMask.</p>
	 *
	 * @param tickLabelMask a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setTickLabelMask(String tickLabelMask) {
		getObject().setTickLabelMask(tickLabelMask);
		return this;
	}

	/**
	 * <p>setVerticalTickLabels.</p>
	 *
	 * @param verticalTickLabels a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setVerticalTickLabels(Boolean verticalTickLabels) {
		getObject().setVerticalTickLabels(verticalTickLabels);
		return this;
	}

	/**
	 * <p>setTickLabelRotation.</p>
	 *
	 * @param tickLabelRotation a {@link java.lang.Double} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setTickLabelRotation(Double tickLabelRotation) {
		getObject().setTickLabelRotation(tickLabelRotation);
		return this;
	}

	/**
	 * <p>setLineColor.</p>
	 *
	 * @param lineColor a {@link java.awt.Color} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setLineColor(Color lineColor) {
		getObject().setLineColor(lineColor);
		return this;
	}

	/**
	 * <p>setRangeMinValueExpression.</p>
	 *
	 * @param rangeMinValue a {@link java.lang.Number} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setRangeMinValueExpression(Number rangeMinValue) {
		getObject().setRangeMinValueExpression(Expressions.number(rangeMinValue));
		return this;
	}

	/**
	 * <p>setRangeMinValueExpression.</p>
	 *
	 * @param rangeMinValueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setRangeMinValueExpression(DRIExpression<? extends Number> rangeMinValueExpression) {
		getObject().setRangeMinValueExpression(rangeMinValueExpression);
		return this;
	}

	/**
	 * <p>setRangeMaxValueExpression.</p>
	 *
	 * @param rangeMaxValue a {@link java.lang.Number} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setRangeMaxValueExpression(Number rangeMaxValue) {
		getObject().setRangeMaxValueExpression(Expressions.number(rangeMaxValue));
		return this;
	}

	/**
	 * <p>setRangeMaxValueExpression.</p>
	 *
	 * @param rangeMaxValueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
	 */
	public AxisFormatBuilder setRangeMaxValueExpression(DRIExpression<? extends Number> rangeMaxValueExpression) {
		getObject().setRangeMaxValueExpression(rangeMaxValueExpression);
		return this;
	}

	/**
	 * <p>getAxisFormat.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.base.chart.plot.DRAxisFormat} object.
	 */
	public DRAxisFormat getAxisFormat() {
		return build();
	}
}
