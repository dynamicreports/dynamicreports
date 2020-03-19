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
package net.sf.dynamicreports.report.base.chart.dataset;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRIHyperLink;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIHighLowDataset;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>DRHighLowDataset class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DRHighLowDataset extends DRChartDataset implements DRIHighLowDataset {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<?> seriesExpression;
    private DRIExpression<?> dateExpression;
    private DRIExpression<?> highExpression;
    private DRIExpression<?> lowExpression;
    private DRIExpression<?> openExpression;
    private DRIExpression<?> closeExpression;
    private DRIExpression<?> volumeExpression;
    private DRIHyperLink itemHyperLink;

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getSeriesExpression() {
        return seriesExpression;
    }

    /**
     * <p>Setter for the field <code>seriesExpression</code>.</p>
     *
     * @param seriesExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setSeriesExpression(DRIExpression<?> seriesExpression) {
        this.seriesExpression = seriesExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getDateExpression() {
        return dateExpression;
    }

    /**
     * <p>Setter for the field <code>dateExpression</code>.</p>
     *
     * @param dateExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setDateExpression(DRIExpression<?> dateExpression) {
        this.dateExpression = dateExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getHighExpression() {
        return highExpression;
    }

    /**
     * <p>Setter for the field <code>highExpression</code>.</p>
     *
     * @param highExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setHighExpression(DRIExpression<?> highExpression) {
        this.highExpression = highExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getLowExpression() {
        return lowExpression;
    }

    /**
     * <p>Setter for the field <code>lowExpression</code>.</p>
     *
     * @param lowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setLowExpression(DRIExpression<?> lowExpression) {
        this.lowExpression = lowExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getOpenExpression() {
        return openExpression;
    }

    /**
     * <p>Setter for the field <code>openExpression</code>.</p>
     *
     * @param openExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setOpenExpression(DRIExpression<?> openExpression) {
        this.openExpression = openExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getCloseExpression() {
        return closeExpression;
    }

    /**
     * <p>Setter for the field <code>closeExpression</code>.</p>
     *
     * @param closeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setCloseExpression(DRIExpression<?> closeExpression) {
        this.closeExpression = closeExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getVolumeExpression() {
        return volumeExpression;
    }

    /**
     * <p>Setter for the field <code>volumeExpression</code>.</p>
     *
     * @param volumeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setVolumeExpression(DRIExpression<?> volumeExpression) {
        this.volumeExpression = volumeExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIHyperLink getItemHyperLink() {
        return itemHyperLink;
    }

    /**
     * <p>Setter for the field <code>itemHyperLink</code>.</p>
     *
     * @param itemHyperLink a {@link net.sf.dynamicreports.report.definition.DRIHyperLink} object.
     */
    public void setItemHyperLink(DRIHyperLink itemHyperLink) {
        this.itemHyperLink = itemHyperLink;
    }

}
