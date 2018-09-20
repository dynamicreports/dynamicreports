/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.googlecharts.report.geomap;

import net.sf.dynamicreports.design.base.DRDesignDataset;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;

/**
 * <p>DRDesignGeoMapDataset class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignGeoMapDataset implements DRIDesignGeoMapDataset {
    private DRDesignDataset subDataset;
    private DRIDesignExpression locationExpression;
    private DRIDesignExpression valueExpression;
    private DRIDesignExpression labelExpression;
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
    public DRIDesignExpression getLocationExpression() {
        return locationExpression;
    }

    /**
     * <p>Setter for the field <code>locationExpression</code>.</p>
     *
     * @param locationExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setLocationExpression(DRIDesignExpression locationExpression) {
        this.locationExpression = locationExpression;
    }

    /**
     * {@inheritDoc}
     */
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
