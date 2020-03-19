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
package net.sf.dynamicreports.design.definition.chart.dataset;

import net.sf.dynamicreports.design.definition.DRIDesignHyperLink;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;

/**
 * <p>DRIDesignHighLowDataset interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIDesignHighLowDataset extends DRIDesignChartDataset {

    /**
     * <p>getSeriesExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public DRIDesignExpression getSeriesExpression();

    /**
     * <p>getDateExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public DRIDesignExpression getDateExpression();

    /**
     * <p>getHighExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public DRIDesignExpression getHighExpression();

    /**
     * <p>getLowExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public DRIDesignExpression getLowExpression();

    /**
     * <p>getOpenExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public DRIDesignExpression getOpenExpression();

    /**
     * <p>getCloseExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public DRIDesignExpression getCloseExpression();

    /**
     * <p>getVolumeExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public DRIDesignExpression getVolumeExpression();

    /**
     * <p>getItemHyperLink.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignHyperLink} object.
     */
    public DRIDesignHyperLink getItemHyperLink();
}
