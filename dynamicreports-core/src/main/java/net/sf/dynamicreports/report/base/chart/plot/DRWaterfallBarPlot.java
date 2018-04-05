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

package net.sf.dynamicreports.report.base.chart.plot;

import java.awt.Paint;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.chart.plot.DRIWaterfallBarPlot;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRWaterfallBarPlot extends DRBarPlot implements DRIWaterfallBarPlot {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Paint firstBarPaint;
	private Paint lastBarPaint;
	private Paint positiveBarPaint;
	private Paint negativeBarPaint;

	@Override
	public Paint getFirstBarPaint() {
		return firstBarPaint;
	}

	public void setFirstBarPaint(Paint firstBarPaint) {
		this.firstBarPaint = firstBarPaint;
	}

	@Override
	public Paint getLastBarPaint() {
		return lastBarPaint;
	}

	public void setLastBarPaint(Paint lastBarPaint) {
		this.lastBarPaint = lastBarPaint;
	}

	@Override
	public Paint getPositiveBarPaint() {
		return positiveBarPaint;
	}

	public void setPositiveBarPaint(Paint positiveBarPaint) {
		this.positiveBarPaint = positiveBarPaint;
	}

	@Override
	public Paint getNegativeBarPaint() {
		return negativeBarPaint;
	}

	public void setNegativeBarPaint(Paint negativeBarPaint) {
		this.negativeBarPaint = negativeBarPaint;
	}

}
