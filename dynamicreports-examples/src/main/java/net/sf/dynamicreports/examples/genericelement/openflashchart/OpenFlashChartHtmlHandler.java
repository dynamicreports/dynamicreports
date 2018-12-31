/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.examples.genericelement.openflashchart;

import net.sf.jasperreports.engine.JRGenericPrintElement;
import net.sf.jasperreports.engine.export.GenericElementHtmlHandler;
import net.sf.jasperreports.engine.export.JRHtmlExporterContext;
import net.sf.jasperreports.engine.util.JRColorUtil;
import net.sf.jasperreports.engine.util.JRStringUtil;

import java.awt.Color;

/**
 * <p>OpenFlashChartHtmlHandler class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class OpenFlashChartHtmlHandler implements GenericElementHtmlHandler {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toExport(JRGenericPrintElement element) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHtmlFragment(JRHtmlExporterContext exporterContext, JRGenericPrintElement element) {
        String divID = "ofc" + System.identityHashCode(element);
        int width = element.getWidth();
        int height = element.getHeight();
        Color backcolor = element.getBackcolor();
        String chartData = ((ChartGenerator) element.getParameterValue(ChartGenerator.PARAMETER_CHART_GENERATOR)).generateChart();
        String chartEncodedData = JRStringUtil.htmlEncode(chartData);

        StringBuilder result = new StringBuilder();
        result.append("<object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0\" ");
        result.append("width=\"" + width + "\" ");
        result.append("height=\"" + height + "\" ");
        result.append("id=\"" + divID + "\" ");
        result.append("align=\"middle\">");
        result.append("<param name=\"allowScriptAccess\" value=\"sameDomain\" /> ");
        result.append("<param name=\"movie\" value=\"");
        result.append(getSwfLocation());
        result.append("?width=" + width);
        result.append("&height=" + height);
        result.append("&inline_data=" + chartEncodedData);
        result.append("\" /> ");
        result.append("<param name=\"quality\" value=\"high\" />");
        result.append("<param name=\"bgcolor\" value=\"#" + JRColorUtil.getColorHexa(backcolor) + "\" /> ");
        result.append("<embed src=\"");
        result.append(getSwfLocation());
        result.append("?width=" + width);
        result.append("&height=" + height);
        result.append("&inline_data=" + chartEncodedData);
        result.append("\" quality=\"high\" ");
        result.append("bgcolor=\"#" + JRColorUtil.getColorHexa(backcolor) + "\" ");
        result.append("width=\"" + width + "\" ");
        result.append("height=\"" + height + "\" ");
        result.append(
            "name=\"open-flash-chart\" align=\"middle\" allowScriptAccess=\"sameDomain\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" /> " +
                "</object> ");

        return result.toString();
    }

    /**
     * <p>getSwfLocation.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSwfLocation() {
        return "open-flash-chart.swf";
    }
}
