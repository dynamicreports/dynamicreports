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
import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.RectangleAnchor;
import net.sf.dynamicreports.report.definition.chart.plot.DRIPaintScale;
import net.sf.dynamicreports.report.definition.chart.plot.DRIXyBlockPlot;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRXyBlockPlot extends DRAxisPlot implements DRIXyBlockPlot {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Double blockWidth;
	private Double blockHeight;
	private RectangleAnchor blockAnchor;
	private double defaultLowerBound;
	private double defaultUpperBound;
	private Paint defaultPaint;
	private List<DRIPaintScale> paintScales;

	public DRXyBlockPlot() {
		paintScales = new ArrayList<DRIPaintScale>();
	}

	@Override
	public Double getBlockWidth() {
		return blockWidth;
	}

	public void setBlockWidth(Double blockWidth) {
		this.blockWidth = blockWidth;
	}

	@Override
	public Double getBlockHeight() {
		return blockHeight;
	}

	public void setBlockHeight(Double blockHeight) {
		this.blockHeight = blockHeight;
	}

	@Override
	public RectangleAnchor getBlockAnchor() {
		return blockAnchor;
	}

	public void setBlockAnchor(RectangleAnchor blockAnchor) {
		this.blockAnchor = blockAnchor;
	}

	@Override
	public double getDefaultLowerBound() {
		return defaultLowerBound;
	}

	public void setDefaultLowerBound(double defaultLowerBound) {
		this.defaultLowerBound = defaultLowerBound;
	}

	@Override
	public double getDefaultUpperBound() {
		return defaultUpperBound;
	}

	public void setDefaultUpperBound(double defaultUpperBound) {
		this.defaultUpperBound = defaultUpperBound;
	}

	@Override
	public Paint getDefaultPaint() {
		return defaultPaint;
	}

	public void setDefaultPaint(Paint defaultPaint) {
		Validate.notNull(defaultPaint, "defaultPaint must not be null");
		this.defaultPaint = defaultPaint;
	}

	@Override
	public List<DRIPaintScale> getPaintScales() {
		return paintScales;
	}

	public void addPaintScale(DRIPaintScale paintScale) {
		Validate.notNull(paintScale, "paintScale must not be null");
		this.paintScales.add(paintScale);
	}

	public void setPaintScales(List<DRIPaintScale> paintScales) {
		Validate.notNull(paintScales, "paintScales must not be null");
		Validate.noNullElements(paintScales, "paintScales must not contain null paintScale");
		this.paintScales = paintScales;
	}

}
