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

import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignGanttChartSerie;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignGanttChartSerie class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignGanttChartSerie extends DRDesignChartSerie implements DRIDesignGanttChartSerie {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIDesignExpression startDateExpression;
    private DRIDesignExpression endDateExpression;
    private DRIDesignExpression percentExpression;
    private DRIDesignExpression labelExpression;

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getStartDateExpression() {
        return startDateExpression;
    }

    /**
     * <p>Setter for the field <code>startDateExpression</code>.</p>
     *
     * @param startDateExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setStartDateExpression(DRIDesignExpression startDateExpression) {
        this.startDateExpression = startDateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getEndDateExpression() {
        return endDateExpression;
    }

    /**
     * <p>Setter for the field <code>endDateExpression</code>.</p>
     *
     * @param endDateExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setEndDateExpression(DRIDesignExpression endDateExpression) {
        this.endDateExpression = endDateExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getPercentExpression() {
        return percentExpression;
    }

    /**
     * <p>Setter for the field <code>percentExpression</code>.</p>
     *
     * @param percentExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setPercentExpression(DRIDesignExpression percentExpression) {
        this.percentExpression = percentExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getLabelExpression() {
        return labelExpression;
    }

    /**
     * <p>Setter for the field <code>labelExpression</code>.</p>
     *
     * @param labelExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setLabelExpression(DRIDesignExpression labelExpression) {
        this.labelExpression = labelExpression;
    }

}
