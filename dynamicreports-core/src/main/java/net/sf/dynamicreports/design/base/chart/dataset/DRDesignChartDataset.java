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

import net.sf.dynamicreports.design.base.DRDesignDataset;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignChartDataset;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignChartDataset class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignChartDataset implements DRIDesignChartDataset {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRDesignDataset subDataset;
    private ResetType resetType;
    private DRDesignGroup resetGroup;

    /**
     * {@inheritDoc}
     */
    @Override
    public DRDesignDataset getSubDataset() {
        return subDataset;
    }

    /**
     * <p>Setter for the field <code>subDataset</code>.</p>
     *
     * @param subDataset a {@link net.sf.dynamicreports.design.base.DRDesignDataset} object.
     */
    public void setSubDataset(DRDesignDataset subDataset) {
        this.subDataset = subDataset;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResetType getResetType() {
        return resetType;
    }

    /**
     * <p>Setter for the field <code>resetType</code>.</p>
     *
     * @param resetType a {@link net.sf.dynamicreports.design.constant.ResetType} object.
     */
    public void setResetType(ResetType resetType) {
        this.resetType = resetType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRDesignGroup getResetGroup() {
        return resetGroup;
    }

    /**
     * <p>Setter for the field <code>resetGroup</code>.</p>
     *
     * @param resetGroup a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
     */
    public void setResetGroup(DRDesignGroup resetGroup) {
        this.resetGroup = resetGroup;
    }
}
