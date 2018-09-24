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
package net.sf.dynamicreports.design.base.chart.dataset;

import net.sf.dynamicreports.design.definition.DRIDesignHyperLink;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignHighLowDataset;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignHighLowDataset class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignHighLowDataset extends DRDesignChartDataset implements DRIDesignHighLowDataset {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIDesignExpression seriesExpression;
    private DRIDesignExpression dateExpression;
    private DRIDesignExpression highExpression;
    private DRIDesignExpression lowExpression;
    private DRIDesignExpression openExpression;
    private DRIDesignExpression closeExpression;
    private DRIDesignExpression volumeExpression;
    private DRIDesignHyperLink itemHyperLink;

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getSeriesExpression() {
        return seriesExpression;
    }

    /**
     * <p>Setter for the field <code>seriesExpression</code>.</p>
     *
     * @param seriesExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setSeriesExpression(DRIDesignExpression seriesExpression) {
        this.seriesExpression = seriesExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getDateExpression() {
        return dateExpression;
    }

    /**
     * <p>Setter for the field <code>dateExpression</code>.</p>
     *
     * @param dateExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setDateExpression(DRIDesignExpression dateExpression) {
        this.dateExpression = dateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getHighExpression() {
        return highExpression;
    }

    /**
     * <p>Setter for the field <code>highExpression</code>.</p>
     *
     * @param highExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setHighExpression(DRIDesignExpression highExpression) {
        this.highExpression = highExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getLowExpression() {
        return lowExpression;
    }

    /**
     * <p>Setter for the field <code>lowExpression</code>.</p>
     *
     * @param lowExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setLowExpression(DRIDesignExpression lowExpression) {
        this.lowExpression = lowExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getOpenExpression() {
        return openExpression;
    }

    /**
     * <p>Setter for the field <code>openExpression</code>.</p>
     *
     * @param openExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setOpenExpression(DRIDesignExpression openExpression) {
        this.openExpression = openExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getCloseExpression() {
        return closeExpression;
    }

    /**
     * <p>Setter for the field <code>closeExpression</code>.</p>
     *
     * @param closeExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setCloseExpression(DRIDesignExpression closeExpression) {
        this.closeExpression = closeExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getVolumeExpression() {
        return volumeExpression;
    }

    /**
     * <p>Setter for the field <code>volumeExpression</code>.</p>
     *
     * @param volumeExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setVolumeExpression(DRIDesignExpression volumeExpression) {
        this.volumeExpression = volumeExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignHyperLink getItemHyperLink() {
        return itemHyperLink;
    }

    /**
     * <p>Setter for the field <code>itemHyperLink</code>.</p>
     *
     * @param itemHyperLink a {@link net.sf.dynamicreports.design.definition.DRIDesignHyperLink} object.
     */
    public void setItemHyperLink(DRIDesignHyperLink itemHyperLink) {
        this.itemHyperLink = itemHyperLink;
    }

}
