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

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignSpiderPlot;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.style.DRIDesignFont;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.SpiderRotation;
import net.sf.dynamicreports.report.constant.TableOrder;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignSpiderPlot implements DRIDesignSpiderPlot {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIDesignExpression maxValueExpression;
	private SpiderRotation rotation;
	private TableOrder tableOrder;
	private Boolean webFilled;
	private Double startAngle;
	private Double headPercent;
	private Double interiorGap;
	private Color axisLineColor;
	private Float axisLineWidth;
	private DRIDesignFont labelFont;
	private Double labelGap;
	private Color labelColor;

	@Override
	public DRIDesignExpression getMaxValueExpression() {
		return maxValueExpression;
	}

	public void setMaxValueExpression(DRIDesignExpression maxValueExpression) {
		this.maxValueExpression = maxValueExpression;
	}

	@Override
	public SpiderRotation getRotation() {
		return rotation;
	}

	public void setRotation(SpiderRotation rotation) {
		this.rotation = rotation;
	}

	@Override
	public TableOrder getTableOrder() {
		return tableOrder;
	}

	public void setTableOrder(TableOrder tableOrder) {
		this.tableOrder = tableOrder;
	}

	@Override
	public Boolean getWebFilled() {
		return webFilled;
	}

	public void setWebFilled(Boolean webFilled) {
		this.webFilled = webFilled;
	}

	@Override
	public Double getStartAngle() {
		return startAngle;
	}

	public void setStartAngle(Double startAngle) {
		this.startAngle = startAngle;
	}

	@Override
	public Double getHeadPercent() {
		return headPercent;
	}

	public void setHeadPercent(Double headPercent) {
		this.headPercent = headPercent;
	}

	@Override
	public Double getInteriorGap() {
		return interiorGap;
	}

	public void setInteriorGap(Double interiorGap) {
		this.interiorGap = interiorGap;
	}

	@Override
	public Color getAxisLineColor() {
		return axisLineColor;
	}

	public void setAxisLineColor(Color axisLineColor) {
		this.axisLineColor = axisLineColor;
	}

	@Override
	public Float getAxisLineWidth() {
		return axisLineWidth;
	}

	public void setAxisLineWidth(Float axisLineWidth) {
		this.axisLineWidth = axisLineWidth;
	}

	@Override
	public DRIDesignFont getLabelFont() {
		return labelFont;
	}

	public void setLabelFont(DRIDesignFont labelFont) {
		this.labelFont = labelFont;
	}

	@Override
	public Double getLabelGap() {
		return labelGap;
	}

	public void setLabelGap(Double labelGap) {
		this.labelGap = labelGap;
	}

	@Override
	public Color getLabelColor() {
		return labelColor;
	}

	public void setLabelColor(Color labelColor) {
		this.labelColor = labelColor;
	}
}
