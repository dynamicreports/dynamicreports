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
package net.sf.dynamicreports.adhoc.configuration;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>AdhocChart class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class AdhocChart extends AdhocComponent {
    private static final long serialVersionUID = 1L;

    private AdhocChartType type;
    private String title;
    private AdhocFont titleFont;
    private Color titleColor;
    private Boolean showLegend;
    private String xValue;
    private List<AdhocChartSerie> series;
    private List<Color> seriesColors;
    private AdhocAxisFormat xAxisFormat;
    private AdhocAxisFormat yAxisFormat;
    private AdhocOrientation orientation;

    /**
     * <p>Constructor for AdhocChart.</p>
     */
    public AdhocChart() {
        series = new ArrayList<AdhocChartSerie>();
        seriesColors = new ArrayList<Color>();
    }

    /**
     * <p>Getter for the field <code>type</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocChartType} object.
     */
    public AdhocChartType getType() {
        return type;
    }

    /**
     * <p>Setter for the field <code>type</code>.</p>
     *
     * @param type a {@link net.sf.dynamicreports.adhoc.configuration.AdhocChartType} object.
     */
    public void setType(AdhocChartType type) {
        this.type = type;
    }

    /**
     * <p>Getter for the field <code>title</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTitle() {
        return title;
    }

    /**
     * <p>Setter for the field <code>title</code>.</p>
     *
     * @param title a {@link java.lang.String} object.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * <p>Getter for the field <code>titleFont</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocFont} object.
     */
    public AdhocFont getTitleFont() {
        return titleFont;
    }

    /**
     * <p>Setter for the field <code>titleFont</code>.</p>
     *
     * @param titleFont a {@link net.sf.dynamicreports.adhoc.configuration.AdhocFont} object.
     */
    public void setTitleFont(AdhocFont titleFont) {
        this.titleFont = titleFont;
    }

    /**
     * <p>Getter for the field <code>titleColor</code>.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getTitleColor() {
        return titleColor;
    }

    /**
     * <p>Setter for the field <code>titleColor</code>.</p>
     *
     * @param titleColor a {@link java.awt.Color} object.
     */
    public void setTitleColor(Color titleColor) {
        this.titleColor = titleColor;
    }

    /**
     * <p>Getter for the field <code>showLegend</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getShowLegend() {
        return showLegend;
    }

    /**
     * <p>Setter for the field <code>showLegend</code>.</p>
     *
     * @param showLegend a {@link java.lang.Boolean} object.
     */
    public void setShowLegend(Boolean showLegend) {
        this.showLegend = showLegend;
    }

    /**
     * <p>Getter for the field <code>xValue</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getXValue() {
        return xValue;
    }

    /**
     * <p>Setter for the field <code>xValue</code>.</p>
     *
     * @param xValue a {@link java.lang.String} object.
     */
    public void setXValue(String xValue) {
        this.xValue = xValue;
    }

    /**
     * <p>Getter for the field <code>series</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<AdhocChartSerie> getSeries() {
        return series;
    }

    /**
     * <p>Setter for the field <code>series</code>.</p>
     *
     * @param series a {@link java.util.List} object.
     */
    public void setSeries(List<AdhocChartSerie> series) {
        this.series = series;
    }

    /**
     * <p>addSerie.</p>
     *
     * @param serie a {@link net.sf.dynamicreports.adhoc.configuration.AdhocChartSerie} object.
     */
    public void addSerie(AdhocChartSerie serie) {
        this.series.add(serie);
    }

    /**
     * <p>Getter for the field <code>seriesColors</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Color> getSeriesColors() {
        return seriesColors;
    }

    /**
     * <p>Setter for the field <code>seriesColors</code>.</p>
     *
     * @param seriesColors a {@link java.util.List} object.
     */
    public void setSeriesColors(List<Color> seriesColors) {
        this.seriesColors = seriesColors;
    }

    /**
     * <p>addSeriesColor.</p>
     *
     * @param seriesColor a {@link java.awt.Color} object.
     */
    public void addSeriesColor(Color seriesColor) {
        this.seriesColors.add(seriesColor);
    }

    /**
     * <p>Getter for the field <code>xAxisFormat</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocAxisFormat} object.
     */
    public AdhocAxisFormat getXAxisFormat() {
        return xAxisFormat;
    }

    /**
     * <p>Setter for the field <code>xAxisFormat</code>.</p>
     *
     * @param xAxisFormat a {@link net.sf.dynamicreports.adhoc.configuration.AdhocAxisFormat} object.
     */
    public void setXAxisFormat(AdhocAxisFormat xAxisFormat) {
        this.xAxisFormat = xAxisFormat;
    }

    /**
     * <p>Getter for the field <code>yAxisFormat</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocAxisFormat} object.
     */
    public AdhocAxisFormat getYAxisFormat() {
        return yAxisFormat;
    }

    /**
     * <p>Setter for the field <code>yAxisFormat</code>.</p>
     *
     * @param yAxisFormat a {@link net.sf.dynamicreports.adhoc.configuration.AdhocAxisFormat} object.
     */
    public void setYAxisFormat(AdhocAxisFormat yAxisFormat) {
        this.yAxisFormat = yAxisFormat;
    }

    /**
     * <p>Getter for the field <code>orientation</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocOrientation} object.
     */
    public AdhocOrientation getOrientation() {
        return orientation;
    }

    /**
     * <p>Setter for the field <code>orientation</code>.</p>
     *
     * @param orientation a {@link net.sf.dynamicreports.adhoc.configuration.AdhocOrientation} object.
     */
    public void setOrientation(AdhocOrientation orientation) {
        this.orientation = orientation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = super.equals(obj);
        if (!equals) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdhocChart)) {
            return false;
        }

        AdhocChart object = (AdhocChart) obj;
        if (!(type == null ? object.getType() == null : type.equals(object.getType()))) {
            return false;
        }
        if (!(title == null ? object.getTitle() == null : title.equals(object.getTitle()))) {
            return false;
        }
        if (!(titleFont == null ? object.getTitleFont() == null : titleFont.equals(object.getTitleFont()))) {
            return false;
        }
        if (!(titleColor == null ? object.getTitleColor() == null : titleColor.equals(object.getTitleColor()))) {
            return false;
        }
        if (!(showLegend == null ? object.getShowLegend() == null : showLegend.equals(object.getShowLegend()))) {
            return false;
        }
        if (!(xValue == null ? object.getXValue() == null : xValue.equals(object.getXValue()))) {
            return false;
        }
        if (!(series == null ? object.getSeries() == null : series.equals(object.getSeries()))) {
            return false;
        }
        if (!(seriesColors == null ? object.getSeriesColors() == null : seriesColors.equals(object.getSeriesColors()))) {
            return false;
        }
        if (!(xAxisFormat == null ? object.getXAxisFormat() == null : xAxisFormat.equals(object.getXAxisFormat()))) {
            return false;
        }
        if (!(yAxisFormat == null ? object.getYAxisFormat() == null : yAxisFormat.equals(object.getYAxisFormat()))) {
            return false;
        }
        if (!(orientation == null ? object.getOrientation() == null : orientation.equals(object.getOrientation()))) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getTitleFont() != null ? getTitleFont().hashCode() : 0);
        result = 31 * result + (getTitleColor() != null ? getTitleColor().hashCode() : 0);
        result = 31 * result + (getShowLegend() != null ? getShowLegend().hashCode() : 0);
        result = 31 * result + (xValue != null ? xValue.hashCode() : 0);
        result = 31 * result + (getSeries() != null ? getSeries().hashCode() : 0);
        result = 31 * result + (getSeriesColors() != null ? getSeriesColors().hashCode() : 0);
        result = 31 * result + (xAxisFormat != null ? xAxisFormat.hashCode() : 0);
        result = 31 * result + (yAxisFormat != null ? yAxisFormat.hashCode() : 0);
        result = 31 * result + (getOrientation() != null ? getOrientation().hashCode() : 0);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdhocChart clone() {
        AdhocChart clone = (AdhocChart) super.clone();

        if (titleFont != null) {
            clone.titleFont = titleFont.clone();
        }
        if (series != null) {
            clone.series = new ArrayList<AdhocChartSerie>();
            for (AdhocChartSerie adhocCategoryChartSerie : series) {
                clone.addSerie(adhocCategoryChartSerie.clone());
            }
        }
        if (seriesColors != null) {
            clone.seriesColors = new ArrayList<Color>();
            for (Color adhocSeriesColor : seriesColors) {
                clone.addSeriesColor(adhocSeriesColor);
            }
        }
        if (xAxisFormat != null) {
            clone.xAxisFormat = xAxisFormat.clone();
        }
        if (yAxisFormat != null) {
            clone.yAxisFormat = yAxisFormat.clone();
        }

        return clone;
    }

}
