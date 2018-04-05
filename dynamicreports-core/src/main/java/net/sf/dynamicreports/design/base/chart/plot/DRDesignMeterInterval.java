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

package net.sf.dynamicreports.design.base.chart.plot;

import java.awt.Color;

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignMeterInterval;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignMeterInterval implements DRIDesignMeterInterval {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String label;
	private Color backgroundColor;
	private Double alpha;
	private DRIDesignExpression dataRangeLowExpression;
	private DRIDesignExpression dataRangeHighExpression;

	@Override
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	public Double getAlpha() {
		return alpha;
	}

	public void setAlpha(Double alpha) {
		this.alpha = alpha;
	}

	@Override
	public DRIDesignExpression getDataRangeLowExpression() {
		return dataRangeLowExpression;
	}

	public void setDataRangeLowExpression(DRIDesignExpression dataRangeLowExpression) {
		this.dataRangeLowExpression = dataRangeLowExpression;
	}

	@Override
	public DRIDesignExpression getDataRangeHighExpression() {
		return dataRangeHighExpression;
	}

	public void setDataRangeHighExpression(DRIDesignExpression dataRangeHighExpression) {
		this.dataRangeHighExpression = dataRangeHighExpression;
	}

}
