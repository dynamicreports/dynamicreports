/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
import org.slf4j.Logger;

import java.awt.Color;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>XmlToAdhocTransform class.</p>
 * Used by the library to convert {@code XmlAdhocConfiguration} which is an JAXB generated type, that contains data that is unmarshalled from an xml datasource at runtime, into {@code
 * AdhocConfiguration}, a POJO which is internally used by the library to maintain configurations. This is applied in the AdhocManager like so:
 * <pre>
 *     {@code
 *          Unmarshaller unmarshaller = JAXBContext.newInstance(XmlAdhocConfiguration.class).createUnmarshaller();
 *          JAXBElement<XmlAdhocConfiguration> element = unmarshaller.unmarshal(new StreamSource(is), XmlAdhocConfiguration.class);
 *          XmlAdhocConfiguration xmlAdhocConfiguration = element.getValue();
 *          AdhocConfiguration adhocConfiguration = xmlToAdhocTransform.transform(xmlAdhocConfiguration);
 *     }
 * </pre>
 *
 * @author Ricardo Mariaca
 * 
 */
public class XmlToAdhocTransform implements IXmlToAdhocTransform {

    private static final Logger log = getLogger(XmlToAdhocTransform.class);

    /**
     * <p>transform.</p>
     *
     * @param xmlAdhocConfiguration a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocConfiguration} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration} object.
     */
    @Override
    public AdhocConfiguration transform(XmlAdhocConfiguration xmlAdhocConfiguration) {
        log.debug("Transforming XmlAdhocConfiguration : {} to adhocConfiguration", xmlAdhocConfiguration);
        AdhocConfiguration adhocConfiguration = new AdhocConfiguration();
        adhocConfiguration.setReport(report(xmlAdhocConfiguration.getReport()));
        adhocConfiguration.setFilter(filter(xmlAdhocConfiguration.getFilter()));
        log.debug("XmlAdhocConfiguration : {} has been transformed into AdhocConfiguration object: {}", xmlAdhocConfiguration, adhocConfiguration);
        return adhocConfiguration;
    }

    /**
     * <p>properties.</p>
     *
     * @param xmlAdhocProperties a {@link java.util.List} object.
     * @param properties         a {@link net.sf.dynamicreports.adhoc.configuration.AdhocProperties} object.
     */
    protected void properties(List<XmlAdhocProperty> xmlAdhocProperties, AdhocProperties properties) {
        for (XmlAdhocProperty xmlAdhocProperty : xmlAdhocProperties) {
            Object propertyValue = propertyStringToValue(xmlAdhocProperty.getValue(), xmlAdhocProperty.getValueClass());
            properties.setProperty(xmlAdhocProperty.getKey(), propertyValue);
        }
    }

    /**
     * <p>propertyStringToValue.</p>
     *
     * @param value      a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.String} object.
     * @return a {@link java.lang.Object} object.
     */
    protected Object propertyStringToValue(String value, String valueClass) {
        if (value == null || StringUtils.isBlank(value) && valueClass == null) {
            return null;
        }
        if (valueClass == null || valueClass.equals(String.class.getName())) {
            return value;
        }
        if (valueClass.equals(Boolean.class.getName())) {
            return Boolean.valueOf(value);
        }
        if (valueClass.equals(Integer.class.getName())) {
            return new Integer(value);
        }
        if (valueClass.equals(AdhocTimePeriod.class.getName())) {
            return AdhocTimePeriod.valueOf(value);
        }
        throw new AdhocException("Property value type " + valueClass + " not supported");
    }

    /**
     * <p>report.</p>
     *
     * @param xmlAdhocReport a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocReport} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocReport} object.
     */
    protected AdhocReport report(XmlAdhocReport xmlAdhocReport) {
        log.debug("Converting xmlAdhocReport :{} into AdhocReport", xmlAdhocReport);
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
        log.debug("XmlAdhocReport : {} has been converted to AdhocReport: {}", xmlAdhocReport, adhocReport);
        return adhocReport;
    }

    /**
     * <p>column.</p>
     *
     * @param xmlAdhocColumn a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocColumn} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocColumn} object.
     */
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

    /**
     * <p>group.</p>
     *
     * @param xmlAdhocGroup a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocGroup} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocGroup} object.
     */
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

    /**
     * <p>groupHeaderLayout.</p>
     *
     * @param xmlAdhocGroupHeaderLayout a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocGroupHeaderLayout} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocGroupHeaderLayout} object.
     */
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

    /**
     * <p>subtotal.</p>
     *
     * @param xmlAdhocSubtotal a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocSubtotal} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocSubtotal} object.
     */
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

    /**
     * <p>calculation.</p>
     *
     * @param xmlAdhocCalculation a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocCalculation} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocCalculation} object.
     */
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

    /**
     * <p>subtotalPosition.</p>
     *
     * @param xmlAdhocSubtotalPosition a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocSubtotalPosition} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocSubtotalPosition} object.
     */
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

    /**
     * <p>sort.</p>
     *
     * @param xmlAdhocSort a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocSort} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocSort} object.
     */
    protected AdhocSort sort(XmlAdhocSort xmlAdhocSort) {
        AdhocSort adhocSort = new AdhocSort();
        adhocSort.setName(xmlAdhocSort.getName());
        adhocSort.setOrderType(orderType(xmlAdhocSort.getOrderType()));
        return adhocSort;
    }

    /**
     * <p>orderType.</p>
     *
     * @param xmlAdhocOrderType a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocOrderType} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocOrderType} object.
     */
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

    /**
     * <p>style.</p>
     *
     * @param xmlAdhocStyle a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocStyle} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
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

    /**
     * <p>color.</p>
     *
     * @param color a {@link java.lang.String} object.
     * @return a {@link java.awt.Color} object.
     */
    protected Color color(String color) {
        if (color == null) {
            return null;
        }
        return Color.decode(color);
    }

    /**
     * <p>font.</p>
     *
     * @param xmlAdhocFont a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocFont} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocFont} object.
     */
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

    /**
     * <p>pen.</p>
     *
     * @param xmlAdhocPen a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocPen} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPen} object.
     */
    protected AdhocPen pen(XmlAdhocPen xmlAdhocPen) {
        if (xmlAdhocPen == null) {
            return null;
        }

        AdhocPen adhocPen = new AdhocPen();
        adhocPen.setLineWidth(xmlAdhocPen.getLineWidth());
        adhocPen.setLineColor(color(xmlAdhocPen.getLineColor()));
        return adhocPen;
    }

    /**
     * <p>horizontalAlignment.</p>
     *
     * @param xmlAdhocHorizontalAlignment a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocHorizontalAlignment} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocHorizontalAlignment} object.
     */
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

    /**
     * <p>verticalAlignment.</p>
     *
     * @param xmlAdhocVerticalAlignment a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocVerticalAlignment} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocVerticalAlignment} object.
     */
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

    /**
     * <p>page.</p>
     *
     * @param xmlAdhocPage a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocPage} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPage} object.
     */
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

    /**
     * <p>pageOrientation.</p>
     *
     * @param xmlAdhocPageOrientation a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocPageOrientation} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPageOrientation} object.
     */
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

    /**
     * <p>component.</p>
     *
     * @param xmlAdhocComponent a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocComponent} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocComponent} object.
     */
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

    /**
     * <p>component.</p>
     *
     * @param xmlAdhocComponent a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocComponent} object.
     * @param adhocComponent    a {@link net.sf.dynamicreports.adhoc.configuration.AdhocComponent} object.
     */
    protected void component(XmlAdhocComponent xmlAdhocComponent, AdhocComponent adhocComponent) {
        adhocComponent.setKey(xmlAdhocComponent.getKey());
        adhocComponent.setStyle(style(xmlAdhocComponent.getStyle()));
        adhocComponent.setWidth(xmlAdhocComponent.getWidth());
        adhocComponent.setHeight(xmlAdhocComponent.getHeight());
        if (xmlAdhocComponent.getProperty() != null && !xmlAdhocComponent.getProperty().isEmpty()) {
            properties(xmlAdhocComponent.getProperty(), adhocComponent.getProperties());
        }
    }

    /**
     * <p>textField.</p>
     *
     * @param xmlAdhocTextField a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocTextField} object.
     * @param adhocTextField    a {@link net.sf.dynamicreports.adhoc.configuration.AdhocTextField} object.
     */
    protected void textField(XmlAdhocTextField xmlAdhocTextField, AdhocTextField adhocTextField) {
        component(xmlAdhocTextField, adhocTextField);
        adhocTextField.setText(xmlAdhocTextField.getText());
    }

    /**
     * <p>chart.</p>
     *
     * @param xmlAdhocChart a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocChart} object.
     * @param adhocChart    a {@link net.sf.dynamicreports.adhoc.configuration.AdhocChart} object.
     */
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

    /**
     * <p>orientation.</p>
     *
     * @param xmlAdhocOrientation a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocOrientation} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocOrientation} object.
     */
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

    /**
     * <p>axisFormat.</p>
     *
     * @param xmlAdhocAxisFormat a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocAxisFormat} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocAxisFormat} object.
     */
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

    /**
     * <p>chartSerie.</p>
     *
     * @param xmlAdhocChartSerie a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocChartSerie} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocChartSerie} object.
     */
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

    /**
     * <p>chartType.</p>
     *
     * @param xmlAdhocChartType a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocChartType} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocChartType} object.
     */
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

    /**
     * <p>filter.</p>
     *
     * @param xmlAdhocFilter a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocFilter} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocFilter} object.
     */
    protected AdhocFilter filter(XmlAdhocFilter xmlAdhocFilter) {
        log.debug("Converting XmlAdhocFilter : {} to AdhocFilter", xmlAdhocFilter);
        if (xmlAdhocFilter == null) {
            return null;
        }

        AdhocFilter adhocFilter = new AdhocFilter();
        if (xmlAdhocFilter.getRestriction() != null && !xmlAdhocFilter.getRestriction().isEmpty()) {
            for (XmlAdhocRestriction xmlAdhocRestriction : xmlAdhocFilter.getRestriction()) {
                adhocFilter.addRestriction(restriction(xmlAdhocRestriction));
            }
        }
        log.debug("XmlAdhocFilter: {} converted to AdhocFilter: {}", xmlAdhocFilter, adhocFilter);
        return adhocFilter;
    }

    /**
     * <p>restriction.</p>
     *
     * @param xmlAdhocRestriction a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocRestriction} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocRestriction} object.
     */
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

    /**
     * <p>restriction.</p>
     *
     * @param xmlAdhocRestriction a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocRestriction} object.
     * @param adhocRestriction    a {@link net.sf.dynamicreports.adhoc.configuration.AdhocRestriction} object.
     */
    protected void restriction(XmlAdhocRestriction xmlAdhocRestriction, AdhocRestriction adhocRestriction) {
        adhocRestriction.setKey(xmlAdhocRestriction.getKey());
        if (xmlAdhocRestriction.getProperty() != null && !xmlAdhocRestriction.getProperty().isEmpty()) {
            properties(xmlAdhocRestriction.getProperty(), adhocRestriction.getProperties());
        }
    }

    /**
     * <p>valueRestriction.</p>
     *
     * @param xmlAdhocValueRestriction a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocValueRestriction} object.
     * @param adhocValueRestriction    a {@link net.sf.dynamicreports.adhoc.configuration.AdhocValueRestriction} object.
     */
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

    /**
     * <p>valueOperator.</p>
     *
     * @param xmlAdhocValueOperator a {@link net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocValueOperator} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocValueOperator} object.
     */
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
