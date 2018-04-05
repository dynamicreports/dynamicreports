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

package net.sf.dynamicreports.design.base.component;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.component.DRIDesignMap;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignMap extends DRDesignComponent implements DRIDesignMap {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private EvaluationTime evaluationTime;
	private DRDesignGroup evaluationGroup;
	private DRIDesignExpression latitudeExpression;
	private DRIDesignExpression longitudeExpression;
	private DRIDesignExpression zoomExpression;

	public DRDesignMap() {
		super("map");
	}

	@Override
	public EvaluationTime getEvaluationTime() {
		return evaluationTime;
	}

	public void setEvaluationTime(EvaluationTime evaluationTime) {
		this.evaluationTime = evaluationTime;
	}

	@Override
	public DRDesignGroup getEvaluationGroup() {
		return evaluationGroup;
	}

	public void setEvaluationGroup(DRDesignGroup evaluationGroup) {
		this.evaluationGroup = evaluationGroup;
	}

	@Override
	public DRIDesignExpression getLatitudeExpression() {
		return latitudeExpression;
	}

	public void setLatitudeExpression(DRIDesignExpression latitudeExpression) {
		this.latitudeExpression = latitudeExpression;
	}

	@Override
	public DRIDesignExpression getLongitudeExpression() {
		return longitudeExpression;
	}

	public void setLongitudeExpression(DRIDesignExpression longitudeExpression) {
		this.longitudeExpression = longitudeExpression;
	}

	@Override
	public DRIDesignExpression getZoomExpression() {
		return zoomExpression;
	}

	public void setZoomExpression(DRIDesignExpression zoomExpression) {
		this.zoomExpression = zoomExpression;
	}
}
