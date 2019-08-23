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

import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignChartSerie;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignSeriesDataset;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRDesignSeriesDataset class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignSeriesDataset extends DRDesignChartDataset implements DRIDesignSeriesDataset {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIDesignExpression valueExpression;
    private List<DRIDesignChartSerie> series;

    /**
     * <p>Constructor for DRDesignSeriesDataset.</p>
     */
    public DRDesignSeriesDataset() {
        series = new ArrayList<DRIDesignChartSerie>();
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getValueExpression() {
        return valueExpression;
    }

    /**
     * <p>Setter for the field <code>valueExpression</code>.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setValueExpression(DRIDesignExpression valueExpression) {
        this.valueExpression = valueExpression;
    }

    /**
     * <p>addSerie.</p>
     *
     * @param serie a {@link net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignChartSerie} object.
     */
    public void addSerie(DRIDesignChartSerie serie) {
        series.add(serie);
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIDesignChartSerie> getSeries() {
        return series;
    }

}
