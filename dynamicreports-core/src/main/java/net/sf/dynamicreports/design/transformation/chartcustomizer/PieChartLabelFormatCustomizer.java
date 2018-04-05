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

package net.sf.dynamicreports.design.transformation.chartcustomizer;

import java.io.Serializable;
import java.text.DecimalFormat;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class PieChartLabelFormatCustomizer implements DRIChartCustomizer, Serializable {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String labelFormat;
	private String valuePattern;
	private String percentValuePattern;

	public PieChartLabelFormatCustomizer(String labelFormat, String valuePattern, String percentValuePattern) {
		this.labelFormat = labelFormat;
		this.valuePattern = valuePattern;
		this.percentValuePattern = percentValuePattern;
	}

	@Override
	public void customize(JFreeChart chart, ReportParameters reportParameters) {
		PiePlot plot = (PiePlot) chart.getPlot();
		if (labelFormat == null) {
			plot.setLabelGenerator(null);
		} else {
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator(labelFormat, new DecimalFormat(valuePattern), new DecimalFormat(percentValuePattern + "%")));
		}
	}
}
