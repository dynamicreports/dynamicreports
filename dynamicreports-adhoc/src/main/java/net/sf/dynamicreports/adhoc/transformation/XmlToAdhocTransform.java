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

package net.sf.dynamicreports.adhoc.transformation;

import java.awt.Color;
import java.util.List;

import net.sf.dynamicreports.adhoc.configuration.AdhocAxisFormat;
import net.sf.dynamicreports.adhoc.configuration.AdhocCalculation;
import net.sf.dynamicreports.adhoc.configuration.AdhocChart;
import net.sf.dynamicreports.adhoc.configuration.AdhocChartSerie;
import net.sf.dynamicreports.adhoc.configuration.AdhocChartType;
import net.sf.dynamicreports.adhoc.configuration.AdhocColumn;
import net.sf.dynamicreports.adhoc.configuration.AdhocComponent;
import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.configuration.AdhocFilter;
import net.sf.dynamicreports.adhoc.configuration.AdhocFont;
import net.sf.dynamicreports.adhoc.configuration.AdhocGroup;
import net.sf.dynamicreports.adhoc.configuration.AdhocGroupHeaderLayout;
import net.sf.dynamicreports.adhoc.configuration.AdhocHorizontalAlignment;
import net.sf.dynamicreports.adhoc.configuration.AdhocOrderType;
import net.sf.dynamicreports.adhoc.configuration.AdhocOrientation;
import net.sf.dynamicreports.adhoc.configuration.AdhocPage;
import net.sf.dynamicreports.adhoc.configuration.AdhocPageOrientation;
import net.sf.dynamicreports.adhoc.configuration.AdhocPen;
import net.sf.dynamicreports.adhoc.configuration.AdhocProperties;
import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.adhoc.configuration.AdhocRestriction;
import net.sf.dynamicreports.adhoc.configuration.AdhocSort;
import net.sf.dynamicreports.adhoc.configuration.AdhocStyle;
import net.sf.dynamicreports.adhoc.configuration.AdhocSubtotal;
import net.sf.dynamicreports.adhoc.configuration.AdhocSubtotalPosition;
import net.sf.dynamicreports.adhoc.configuration.AdhocTextField;
import net.sf.dynamicreports.adhoc.configuration.AdhocTimePeriod;
import net.sf.dynamicreports.adhoc.configuration.AdhocValueOperator;
import net.sf.dynamicreports.adhoc.configuration.AdhocValueRestriction;
import net.sf.dynamicreports.adhoc.configuration.AdhocVerticalAlignment;
import net.sf.dynamicreports.adhoc.exception.AdhocException;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocAxisFormat;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocCalculation;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocChart;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocChartSerie;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocChartType;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocColumn;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocComponent;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocFilter;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocFont;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocGroup;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocGroupHeaderLayout;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocHorizontalAlignment;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocOrderType;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocOrientation;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocPage;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocPageOrientation;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocPen;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocProperty;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocReport;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocRestriction;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocSort;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocStyle;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocSubtotal;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocSubtotalPosition;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocTextField;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocValueOperator;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocValueRestriction;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocVerticalAlignment;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class XmlToAdhocTransform {

	public AdhocConfiguration transform(XmlAdhocConfiguration xmlAdhocConfiguration) {
		AdhocConfiguration adhocConfiguration = new AdhocConfiguration();
		adhocConfiguration.setReport(report(xmlAdhocConfiguration.getReport()));
		adhocConfiguration.setFilter(filter(xmlAdhocConfiguration.getFilter()));
		return adhocConfiguration;
	}

	protected void properties(List<XmlAdhocProperty> xmlAdhocProperties, AdhocProperties properties) {
		for (XmlAdhocProperty xmlAdhocProperty : xmlAdhocProperties) {
			Object propertyValue = propertyStringToValue(xmlAdhocProperty.getValue(), xmlAdhocProperty.getValueClass());
			properties.setProperty(xmlAdhocProperty.getKey(), propertyValue);
		}
	}

	protected Object propertyStringToValue(String value, String valueClass) {
		if (value == null || StringUtils.isBlank(value) && valueClass == null) {
			return null;
		}
		if (valueClass == null || valueClass.equals(String.class.getName())) {
			return value;
		}
		if (valueClass.equals(Boolean.class.getName())) {
			return new Boolean(value);
		}
		if (valueClass.equals(Integer.class.getName())) {
			return new Integer(value);
		}
		if (valueClass.equals(AdhocTimePeriod.class.getName())) {
			return AdhocTimePeriod.valueOf(value);
		}
		throw new AdhocException("Property value type " + valueClass + " not supported");
	}

	protected AdhocReport report(XmlAdhocReport xmlAdhocReport) {
		if (xmlAdhocReport == null) {
			return null;
		}

		AdhocReport adhocReport = new AdhocReport();
		adhocReport.setTextStyle(style(xmlAdhocReport.getTextStyle()));
		adhocReport.setColumnStyle(style(xmlAdhocReport.getColumnStyle()));
		adhocReport.setColumnTitleStyle(style(xmlAdhocReport.getColumnTitleStyle()));
		adhocReport.setGroupStyle(style(xmlAdhocReport.getGroupStyle()));
		adhocReport.setGroupTitleStyle(style(xmlAdhocReport.getGroupTitleStyle()));
		adhocReport.setSubtotalStyle(style(xmlAdhocReport.getSubtotalStyle()));
		adhocReport.setDetailOddRowStyle(style(xmlAdhocReport.getDetailOddRowStyle()));
		adhocReport.setHighlightDetailOddRows(xmlAdhocReport.isHighlightDetailOddRows());
		adhocReport.setDetailEvenRowStyle(style(xmlAdhocReport.getDetailEvenRowStyle()));
		adhocReport.setHighlightDetailEvenRows(xmlAdhocReport.isHighlightDetailEvenRows());
		adhocReport.setIgnorePagination(xmlAdhocReport.isIgnorePagination());
		adhocReport.setTableOfContents(xmlAdhocReport.isTableOfContents());
		adhocReport.setPage(page(xmlAdhocReport.getPage()));
		if (xmlAdhocReport.getColumn() != null && !xmlAdhocReport.getColumn().isEmpty()) {
			for (XmlAdhocColumn xmlAdhocColumn : xmlAdhocReport.getColumn()) {
				adhocReport.addColumn(column(xmlAdhocColumn));
			}
		}
		if (xmlAdhocReport.getGroup() != null && !xmlAdhocReport.getGroup().isEmpty()) {
			for (XmlAdhocGroup xmlAdhocGroup : xmlAdhocReport.getGroup()) {
				adhocReport.addGroup(group(xmlAdhocGroup));
			}
		}
		if (xmlAdhocReport.getSort() != null && !xmlAdhocReport.getSort().isEmpty()) {
			for (XmlAdhocSort xmlAdhocSort : xmlAdhocReport.getSort()) {
				adhocReport.addSort(sort(xmlAdhocSort));
			}
		}
		if (xmlAdhocReport.getSubtotal() != null && !xmlAdhocReport.getSubtotal().isEmpty()) {
			for (XmlAdhocSubtotal xmlAdhocSubtotal : xmlAdhocReport.getSubtotal()) {
				adhocReport.addSubtotal(subtotal(xmlAdhocSubtotal));
			}
		}
		if (xmlAdhocReport.getComponent() != null && !xmlAdhocReport.getComponent().isEmpty()) {
			for (XmlAdhocComponent xmlAdhocComponent : xmlAdhocReport.getComponent()) {
				adhocReport.addComponent(component(xmlAdhocComponent));
			}
		}
		if (xmlAdhocReport.getProperty() != null && !xmlAdhocReport.getProperty().isEmpty()) {
			properties(xmlAdhocReport.getProperty(), adhocReport.getProperties());
		}
		return adhocReport;
	}

	protected AdhocColumn column(XmlAdhocColumn xmlAdhocColumn) {
		AdhocColumn adhocColumn = new AdhocColumn();
		adhocColumn.setName(xmlAdhocColumn.getName());
		adhocColumn.setTitle(xmlAdhocColumn.getTitle());
		adhocColumn.setWidth(xmlAdhocColumn.getWidth());
		adhocColumn.setStyle(style(xmlAdhocColumn.getStyle()));
		adhocColumn.setTitleStyle(style(xmlAdhocColumn.getTitleStyle()));
		if (xmlAdhocColumn.getProperty() != null && !xmlAdhocColumn.getProperty().isEmpty()) {
			properties(xmlAdhocColumn.getProperty(), adhocColumn.getProperties());
		}
		return adhocColumn;
	}

	protected AdhocGroup group(XmlAdhocGroup xmlAdhocGroup) {
		AdhocGroup adhocGroup = new AdhocGroup();
		adhocGroup.setName(xmlAdhocGroup.getName());
		adhocGroup.setStartInNewPage(xmlAdhocGroup.isStartInNewPage());
		adhocGroup.setHeaderLayout(groupHeaderLayout(xmlAdhocGroup.getHeaderLayout()));
		adhocGroup.setStyle(style(xmlAdhocGroup.getStyle()));
		adhocGroup.setTitleStyle(style(xmlAdhocGroup.getTitleStyle()));
		if (xmlAdhocGroup.getProperty() != null && !xmlAdhocGroup.getProperty().isEmpty()) {
			properties(xmlAdhocGroup.getProperty(), adhocGroup.getProperties());
		}
		return adhocGroup;
	}

	protected AdhocGroupHeaderLayout groupHeaderLayout(XmlAdhocGroupHeaderLayout xmlAdhocGroupHeaderLayout) {
		if (xmlAdhocGroupHeaderLayout == null) {
			return null;
		}

		switch (xmlAdhocGroupHeaderLayout) {
			case EMPTY:
				return AdhocGroupHeaderLayout.EMPTY;
			case VALUE:
				return AdhocGroupHeaderLayout.VALUE;
			case TITLE_AND_VALUE:
				return AdhocGroupHeaderLayout.TITLE_AND_VALUE;
			default:
				throw new AdhocException("Group header layout " + xmlAdhocGroupHeaderLayout.name() + " not supported");
		}
	}

	protected AdhocSubtotal subtotal(XmlAdhocSubtotal xmlAdhocSubtotal) {
		AdhocSubtotal adhocSubtotal = new AdhocSubtotal();
		adhocSubtotal.setName(xmlAdhocSubtotal.getName());
		adhocSubtotal.setLabel(xmlAdhocSubtotal.getLabel());
		adhocSubtotal.setCalculation(calculation(xmlAdhocSubtotal.getCalculation()));
		adhocSubtotal.setStyle(style(xmlAdhocSubtotal.getStyle()));
		adhocSubtotal.setLabelStyle(style(xmlAdhocSubtotal.getLabelStyle()));
		adhocSubtotal.setPosition(subtotalPosition(xmlAdhocSubtotal.getPosition()));
		adhocSubtotal.setGroupName(xmlAdhocSubtotal.getGroupName());
		return adhocSubtotal;
	}

	protected AdhocCalculation calculation(XmlAdhocCalculation xmlAdhocCalculation) {
		if (xmlAdhocCalculation == null) {
			return null;
		}

		switch (xmlAdhocCalculation) {
			case NOTHING:
				return AdhocCalculation.NOTHING;
			case COUNT:
				return AdhocCalculation.COUNT;
			case SUM:
				return AdhocCalculation.SUM;
			case AVERAGE:
				return AdhocCalculation.AVERAGE;
			case LOWEST:
				return AdhocCalculation.LOWEST;
			case HIGHEST:
				return AdhocCalculation.HIGHEST;
			case STANDARD_DEVIATION:
				return AdhocCalculation.STANDARD_DEVIATION;
			case VARIANCE:
				return AdhocCalculation.VARIANCE;
			case FIRST:
				return AdhocCalculation.FIRST;
			case DISTINCT_COUNT:
				return AdhocCalculation.DISTINCT_COUNT;
			default:
				throw new AdhocException("Calculation " + xmlAdhocCalculation.name() + " not supported");
		}
	}

	protected AdhocSubtotalPosition subtotalPosition(XmlAdhocSubtotalPosition xmlAdhocSubtotalPosition) {
		if (xmlAdhocSubtotalPosition == null) {
			return null;
		}

		switch (xmlAdhocSubtotalPosition) {
			case TITLE:
				return AdhocSubtotalPosition.TITLE;
			case PAGE_HEADER:
				return AdhocSubtotalPosition.PAGE_HEADER;
			case PAGE_FOOTER:
				return AdhocSubtotalPosition.PAGE_FOOTER;
			case COLUMN_HEADER:
				return AdhocSubtotalPosition.COLUMN_HEADER;
			case COLUMN_FOOTER:
				return AdhocSubtotalPosition.COLUMN_FOOTER;
			case GROUP_HEADER:
				return AdhocSubtotalPosition.GROUP_HEADER;
			case GROUP_FOOTER:
				return AdhocSubtotalPosition.GROUP_FOOTER;
			case FIRST_GROUP_HEADER:
				return AdhocSubtotalPosition.FIRST_GROUP_HEADER;
			case FIRST_GROUP_FOOTER:
				return AdhocSubtotalPosition.FIRST_GROUP_FOOTER;
			case LAST_GROUP_HEADER:
				return AdhocSubtotalPosition.LAST_GROUP_HEADER;
			case LAST_GROUP_FOOTER:
				return AdhocSubtotalPosition.LAST_GROUP_FOOTER;
			case LAST_PAGE_FOOTER:
				return AdhocSubtotalPosition.LAST_PAGE_FOOTER;
			case SUMMARY:
				return AdhocSubtotalPosition.SUMMARY;
			default:
				throw new AdhocException("SubtotalPosition " + xmlAdhocSubtotalPosition.name() + " not supported");
		}
	}

	protected AdhocSort sort(XmlAdhocSort xmlAdhocSort) {
		AdhocSort adhocSort = new AdhocSort();
		adhocSort.setName(xmlAdhocSort.getName());
		adhocSort.setOrderType(orderType(xmlAdhocSort.getOrderType()));
		return adhocSort;
	}

	protected AdhocOrderType orderType(XmlAdhocOrderType xmlAdhocOrderType) {
		if (xmlAdhocOrderType == null) {
			return null;
		}

		switch (xmlAdhocOrderType) {
			case ASCENDING:
				return AdhocOrderType.ASCENDING;
			case DESCENDING:
				return AdhocOrderType.DESCENDING;
			default:
				throw new AdhocException("Order type " + xmlAdhocOrderType.name() + " not supported");
		}
	}

	protected AdhocStyle style(XmlAdhocStyle xmlAdhocStyle) {
		if (xmlAdhocStyle == null) {
			return null;
		}

		AdhocStyle adhocStyle = new AdhocStyle();
		adhocStyle.setFont(font(xmlAdhocStyle.getFont()));
		adhocStyle.setTopBorder(pen(xmlAdhocStyle.getTopBorder()));
		adhocStyle.setLeftBorder(pen(xmlAdhocStyle.getLeftBorder()));
		adhocStyle.setBottomBorder(pen(xmlAdhocStyle.getBottomBorder()));
		adhocStyle.setRightBorder(pen(xmlAdhocStyle.getRightBorder()));
		adhocStyle.setForegroundColor(color(xmlAdhocStyle.getForegroundColor()));
		adhocStyle.setBackgroundColor(color(xmlAdhocStyle.getBackgroundColor()));
		adhocStyle.setHorizontalAlignment(horizontalAlignment(xmlAdhocStyle.getHorizontalAlignment()));
		adhocStyle.setVerticalAlignment(verticalAlignment(xmlAdhocStyle.getVerticalAlignment()));
		adhocStyle.setPattern(xmlAdhocStyle.getPattern());
		return adhocStyle;
	}

	protected Color color(String color) {
		if (color == null) {
			return null;
		}
		return Color.decode(color);
	}

	protected AdhocFont font(XmlAdhocFont xmlAdhocFont) {
		if (xmlAdhocFont == null) {
			return null;
		}

		AdhocFont adhocFont = new AdhocFont();
		adhocFont.setFontName(xmlAdhocFont.getFontName());
		adhocFont.setFontSize(xmlAdhocFont.getFontSize());
		adhocFont.setBold(xmlAdhocFont.isBold());
		adhocFont.setItalic(xmlAdhocFont.isItalic());
		adhocFont.setUnderline(xmlAdhocFont.isUnderline());
		adhocFont.setStrikeThrough(xmlAdhocFont.isStrikeThrough());
		return adhocFont;
	}

	protected AdhocPen pen(XmlAdhocPen xmlAdhocPen) {
		if (xmlAdhocPen == null) {
			return null;
		}

		AdhocPen adhocPen = new AdhocPen();
		adhocPen.setLineWidth(xmlAdhocPen.getLineWidth());
		adhocPen.setLineColor(color(xmlAdhocPen.getLineColor()));
		return adhocPen;
	}

	protected AdhocHorizontalAlignment horizontalAlignment(XmlAdhocHorizontalAlignment xmlAdhocHorizontalAlignment) {
		if (xmlAdhocHorizontalAlignment == null) {
			return null;
		}

		switch (xmlAdhocHorizontalAlignment) {
			case LEFT:
				return AdhocHorizontalAlignment.LEFT;
			case CENTER:
				return AdhocHorizontalAlignment.CENTER;
			case RIGHT:
				return AdhocHorizontalAlignment.RIGHT;
			case JUSTIFIED:
				return AdhocHorizontalAlignment.JUSTIFIED;
			default:
				throw new AdhocException("Horizontal alignment " + xmlAdhocHorizontalAlignment.name() + " not supported");
		}
	}

	protected AdhocVerticalAlignment verticalAlignment(XmlAdhocVerticalAlignment xmlAdhocVerticalAlignment) {
		if (xmlAdhocVerticalAlignment == null) {
			return null;
		}

		switch (xmlAdhocVerticalAlignment) {
			case TOP:
				return AdhocVerticalAlignment.TOP;
			case MIDDLE:
				return AdhocVerticalAlignment.MIDDLE;
			case BOTTOM:
				return AdhocVerticalAlignment.BOTTOM;
			case JUSTIFIED:
				return AdhocVerticalAlignment.JUSTIFIED;
			default:
				throw new AdhocException("Vertical alignment " + xmlAdhocVerticalAlignment.name() + " not supported");
		}
	}

	protected AdhocPage page(XmlAdhocPage xmlAdhocPage) {
		if (xmlAdhocPage == null) {
			return null;
		}

		AdhocPage adhocPage = new AdhocPage();
		adhocPage.setWidth(xmlAdhocPage.getWidth());
		adhocPage.setHeight(xmlAdhocPage.getHeight());
		adhocPage.setOrientation(pageOrientation(xmlAdhocPage.getOrientation()));
		adhocPage.setTopMargin(xmlAdhocPage.getTopMargin());
		adhocPage.setBottomMargin(xmlAdhocPage.getBottomMargin());
		adhocPage.setLeftMargin(xmlAdhocPage.getLeftMargin());
		adhocPage.setRightMargin(xmlAdhocPage.getRightMargin());
		adhocPage.setIgnorePageWidth(xmlAdhocPage.isIgnorePageWidth());
		return adhocPage;
	}

	protected AdhocPageOrientation pageOrientation(XmlAdhocPageOrientation xmlAdhocPageOrientation) {
		if (xmlAdhocPageOrientation == null) {
			return null;
		}

		switch (xmlAdhocPageOrientation) {
			case PORTRAIT:
				return AdhocPageOrientation.PORTRAIT;
			case LANDSCAPE:
				return AdhocPageOrientation.LANDSCAPE;
			default:
				throw new AdhocException("Page orientation " + xmlAdhocPageOrientation.name() + " not supported");
		}
	}

	protected AdhocComponent component(XmlAdhocComponent xmlAdhocComponent) {
		if (xmlAdhocComponent instanceof XmlAdhocTextField) {
			AdhocTextField adhocComponent = new AdhocTextField();
			textField((XmlAdhocTextField) xmlAdhocComponent, adhocComponent);
			return adhocComponent;
		}
		if (xmlAdhocComponent instanceof XmlAdhocChart) {
			AdhocChart adhocComponent = new AdhocChart();
			chart((XmlAdhocChart) xmlAdhocComponent, adhocComponent);
			return adhocComponent;
		} else {
			AdhocComponent adhocComponent = new AdhocComponent();
			component(xmlAdhocComponent, adhocComponent);
			return adhocComponent;
		}
	}

	protected void component(XmlAdhocComponent xmlAdhocComponent, AdhocComponent adhocComponent) {
		adhocComponent.setKey(xmlAdhocComponent.getKey());
		adhocComponent.setStyle(style(xmlAdhocComponent.getStyle()));
		adhocComponent.setWidth(xmlAdhocComponent.getWidth());
		adhocComponent.setHeight(xmlAdhocComponent.getHeight());
		if (xmlAdhocComponent.getProperty() != null && !xmlAdhocComponent.getProperty().isEmpty()) {
			properties(xmlAdhocComponent.getProperty(), adhocComponent.getProperties());
		}
	}

	protected void textField(XmlAdhocTextField xmlAdhocTextField, AdhocTextField adhocTextField) {
		component(xmlAdhocTextField, adhocTextField);
		adhocTextField.setText(xmlAdhocTextField.getText());
	}

	protected void chart(XmlAdhocChart xmlAdhocChart, AdhocChart adhocChart) {
		component(xmlAdhocChart, adhocChart);
		adhocChart.setType(chartType(xmlAdhocChart.getType()));
		adhocChart.setTitle(xmlAdhocChart.getTitle());
		adhocChart.setTitleFont(font(xmlAdhocChart.getTitleFont()));
		adhocChart.setTitleColor(color(xmlAdhocChart.getTitleColor()));
		adhocChart.setShowLegend(xmlAdhocChart.isShowLegend());
		adhocChart.setXValue(xmlAdhocChart.getXValue());
		if (xmlAdhocChart.getSerie() != null && !xmlAdhocChart.getSerie().isEmpty()) {
			for (XmlAdhocChartSerie xmlAdhocChartSerie : xmlAdhocChart.getSerie()) {
				adhocChart.addSerie(chartSerie(xmlAdhocChartSerie));
			}
		}
		if (xmlAdhocChart.getSeriesColors() != null && !xmlAdhocChart.getSeriesColors().isEmpty()) {
			for (String xmlAdhocSeriesColor : xmlAdhocChart.getSeriesColors()) {
				adhocChart.addSeriesColor(color(xmlAdhocSeriesColor));
			}
		}
		adhocChart.setXAxisFormat(axisFormat(xmlAdhocChart.getXAxisFormat()));
		adhocChart.setYAxisFormat(axisFormat(xmlAdhocChart.getYAxisFormat()));
		adhocChart.setOrientation(orientation(xmlAdhocChart.getOrientation()));
	}

	protected AdhocOrientation orientation(XmlAdhocOrientation xmlAdhocOrientation) {
		if (xmlAdhocOrientation == null) {
			return null;
		}

		switch (xmlAdhocOrientation) {
			case HORIZONTAL:
				return AdhocOrientation.HORIZONTAL;
			case VERTICAL:
				return AdhocOrientation.VERTICAL;
			default:
				throw new AdhocException("Orientation " + xmlAdhocOrientation.name() + " not supported");
		}
	}

	protected AdhocAxisFormat axisFormat(XmlAdhocAxisFormat xmlAdhocAxisFormat) {
		if (xmlAdhocAxisFormat == null) {
			return null;
		}

		AdhocAxisFormat adhocAxisFormat = new AdhocAxisFormat();
		adhocAxisFormat.setLabel(xmlAdhocAxisFormat.getLabel());
		adhocAxisFormat.setLabelFont(font(xmlAdhocAxisFormat.getLabelFont()));
		adhocAxisFormat.setLabelColor(color(xmlAdhocAxisFormat.getLabelColor()));
		return adhocAxisFormat;
	}

	protected AdhocChartSerie chartSerie(XmlAdhocChartSerie xmlAdhocChartSerie) {
		AdhocChartSerie adhocChartSerie = new AdhocChartSerie();
		adhocChartSerie.setSeries(xmlAdhocChartSerie.getSeries());
		adhocChartSerie.setXValue(xmlAdhocChartSerie.getXValue());
		adhocChartSerie.setYValue(xmlAdhocChartSerie.getYValue());
		adhocChartSerie.setZValue(xmlAdhocChartSerie.getZValue());
		adhocChartSerie.setLabel(xmlAdhocChartSerie.getLabel());
		if (xmlAdhocChartSerie.getProperty() != null && !xmlAdhocChartSerie.getProperty().isEmpty()) {
			properties(xmlAdhocChartSerie.getProperty(), adhocChartSerie.getProperties());
		}
		return adhocChartSerie;
	}

	protected AdhocChartType chartType(XmlAdhocChartType xmlAdhocChartType) {
		if (xmlAdhocChartType == null) {
			return null;
		}

		switch (xmlAdhocChartType) {
			case AREA:
				return AdhocChartType.AREA;
			case STACKEDAREA:
				return AdhocChartType.STACKEDAREA;
			case BAR:
				return AdhocChartType.BAR;
			case STACKEDBAR:
				return AdhocChartType.STACKEDBAR;
			case GROUPEDSTACKEDBAR:
				return AdhocChartType.GROUPEDSTACKEDBAR;
			case BAR_3_D:
				return AdhocChartType.BAR3D;
			case STACKEDBAR_3_D:
				return AdhocChartType.STACKEDBAR3D;
			case LINE:
				return AdhocChartType.LINE;
			case LAYEREDBAR:
				return AdhocChartType.LAYEREDBAR;
			case WATERFALLBAR:
				return AdhocChartType.WATERFALLBAR;
			case DIFFERENCE:
				return AdhocChartType.DIFFERENCE;
			case PIE:
				return AdhocChartType.PIE;
			case PIE_3_D:
				return AdhocChartType.PIE3D;
			case SCATTER:
				return AdhocChartType.SCATTER;
			case SPIDER:
				return AdhocChartType.SPIDER;
			case TIMESERIES:
				return AdhocChartType.TIMESERIES;
			case XYAREA:
				return AdhocChartType.XYAREA;
			case XYBAR:
				return AdhocChartType.XYBAR;
			case XYLINE:
				return AdhocChartType.XYLINE;
			case XYSTEP:
				return AdhocChartType.XYSTEP;
			case BUBBLE:
				return AdhocChartType.BUBBLE;
			default:
				throw new AdhocException("Chart type " + xmlAdhocChartType.name() + " not supported");
		}
	}

	protected AdhocFilter filter(XmlAdhocFilter xmlAdhocFilter) {
		if (xmlAdhocFilter == null) {
			return null;
		}

		AdhocFilter adhocFilter = new AdhocFilter();
		if (xmlAdhocFilter.getRestriction() != null && !xmlAdhocFilter.getRestriction().isEmpty()) {
			for (XmlAdhocRestriction xmlAdhocRestriction : xmlAdhocFilter.getRestriction()) {
				adhocFilter.addRestriction(restriction(xmlAdhocRestriction));
			}
		}
		return adhocFilter;
	}

	protected AdhocRestriction restriction(XmlAdhocRestriction xmlAdhocRestriction) {
		if (xmlAdhocRestriction instanceof XmlAdhocValueRestriction) {
			AdhocValueRestriction adhocRestriction = new AdhocValueRestriction();
			valueRestriction((XmlAdhocValueRestriction) xmlAdhocRestriction, adhocRestriction);
			return adhocRestriction;
		} else {
			AdhocRestriction adhocRestriction = new AdhocRestriction();
			restriction(xmlAdhocRestriction, adhocRestriction);
			return adhocRestriction;
		}
	}

	protected void restriction(XmlAdhocRestriction xmlAdhocRestriction, AdhocRestriction adhocRestriction) {
		adhocRestriction.setKey(xmlAdhocRestriction.getKey());
		if (xmlAdhocRestriction.getProperty() != null && !xmlAdhocRestriction.getProperty().isEmpty()) {
			properties(xmlAdhocRestriction.getProperty(), adhocRestriction.getProperties());
		}
	}

	protected void valueRestriction(XmlAdhocValueRestriction xmlAdhocValueRestriction, AdhocValueRestriction adhocValueRestriction) {
		restriction(xmlAdhocValueRestriction, adhocValueRestriction);
		adhocValueRestriction.setName(xmlAdhocValueRestriction.getName());
		adhocValueRestriction.setOperator(valueOperator(xmlAdhocValueRestriction.getOperator()));
		if (xmlAdhocValueRestriction.getValue() != null && !xmlAdhocValueRestriction.getValue().isEmpty()) {
			for (String value : xmlAdhocValueRestriction.getValue()) {
				adhocValueRestriction.addValue(value);
			}
		}
	}

	protected AdhocValueOperator valueOperator(XmlAdhocValueOperator xmlAdhocValueOperator) {
		if (xmlAdhocValueOperator == null) {
			return null;
		}

		switch (xmlAdhocValueOperator) {
			case EQUAL:
				return AdhocValueOperator.EQUAL;
			case UNEQUAL:
				return AdhocValueOperator.UNEQUAL;
			case IN:
				return AdhocValueOperator.IN;
			case NOT_IN:
				return AdhocValueOperator.NOT_IN;
			case LIKE:
				return AdhocValueOperator.LIKE;
			case NOT_LIKE:
				return AdhocValueOperator.NOT_LIKE;
			case START_WITH:
				return AdhocValueOperator.START_WITH;
			case NOT_START_WITH:
				return AdhocValueOperator.NOT_START_WITH;
			case END_WITH:
				return AdhocValueOperator.END_WITH;
			case NOT_END_WITH:
				return AdhocValueOperator.NOT_END_WITH;
			case GREATER:
				return AdhocValueOperator.GREATER;
			case GREATER_OR_EQUAL:
				return AdhocValueOperator.GREATER_OR_EQUAL;
			case SMALLER:
				return AdhocValueOperator.SMALLER;
			case SMALLER_OR_EQUAL:
				return AdhocValueOperator.SMALLER_OR_EQUAL;
			case BETWEEN:
				return AdhocValueOperator.BETWEEN;
			case NOT_BETWEEN:
				return AdhocValueOperator.NOT_BETWEEN;
			case IS_NOT_NULL:
				return AdhocValueOperator.IS_NOT_NULL;
			case IS_NULL:
				return AdhocValueOperator.IS_NULL;
			default:
				throw new AdhocException("Value operator " + xmlAdhocValueOperator.name() + " not supported");
		}
	}
}
