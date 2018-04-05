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

package net.sf.dynamicreports.googlecharts.report.geomap;

import net.sf.dynamicreports.design.base.DRDesignDataset;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignGeoMapDataset implements DRIDesignGeoMapDataset {
	private DRDesignDataset subDataset;
	private DRIDesignExpression locationExpression;
	private DRIDesignExpression valueExpression;
	private DRIDesignExpression labelExpression;
	private ResetType resetType;
	private DRDesignGroup resetGroup;

	@Override
	public DRDesignDataset getSubDataset() {
		return subDataset;
	}

	public void setSubDataset(DRDesignDataset subDataset) {
		this.subDataset = subDataset;
	}

	@Override
	public DRIDesignExpression getLocationExpression() {
		return locationExpression;
	}

	public void setLocationExpression(DRIDesignExpression locationExpression) {
		this.locationExpression = locationExpression;
	}

	@Override
	public DRIDesignExpression getValueExpression() {
		return valueExpression;
	}

	public void setValueExpression(DRIDesignExpression valueExpression) {
		this.valueExpression = valueExpression;
	}

	@Override
	public DRIDesignExpression getLabelExpression() {
		return labelExpression;
	}

	public void setLabelExpression(DRIDesignExpression labelExpression) {
		this.labelExpression = labelExpression;
	}

	@Override
	public ResetType getResetType() {
		return resetType;
	}

	public void setResetType(ResetType resetType) {
		this.resetType = resetType;
	}

	@Override
	public DRDesignGroup getResetGroup() {
		return resetGroup;
	}

	public void setResetGroup(DRDesignGroup resetGroup) {
		this.resetGroup = resetGroup;
	}
}
