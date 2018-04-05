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

package net.sf.dynamicreports.design.base.barcode;

import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.barcode.DRIDesignBarbecue;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.BarbecueType;
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignBarbecue extends DRDesignComponent implements DRIDesignBarbecue {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private BarbecueType type;
	private DRIDesignExpression codeExpression;
	private DRIDesignExpression applicationIdentifierExpression;
	private Boolean drawText;
	private Boolean checksumRequired;
	private Integer barWidth;
	private Integer barHeight;
	private BarcodeOrientation orientation;
	private EvaluationTime evaluationTime;
	private DRIDesignGroup evaluationGroup;

	public DRDesignBarbecue() {
		super("barbecue");
	}

	@Override
	public BarbecueType getType() {
		return type;
	}

	public void setType(BarbecueType type) {
		this.type = type;
	}

	@Override
	public DRIDesignExpression getCodeExpression() {
		return codeExpression;
	}

	public void setCodeExpression(DRIDesignExpression codeExpression) {
		this.codeExpression = codeExpression;
	}

	@Override
	public DRIDesignExpression getApplicationIdentifierExpression() {
		return applicationIdentifierExpression;
	}

	public void setApplicationIdentifierExpression(DRIDesignExpression applicationIdentifierExpression) {
		this.applicationIdentifierExpression = applicationIdentifierExpression;
	}

	@Override
	public Boolean getDrawText() {
		return drawText;
	}

	public void setDrawText(Boolean drawText) {
		this.drawText = drawText;
	}

	@Override
	public Boolean getChecksumRequired() {
		return checksumRequired;
	}

	public void setChecksumRequired(Boolean checksumRequired) {
		this.checksumRequired = checksumRequired;
	}

	@Override
	public Integer getBarWidth() {
		return barWidth;
	}

	public void setBarWidth(Integer barWidth) {
		this.barWidth = barWidth;
	}

	@Override
	public Integer getBarHeight() {
		return barHeight;
	}

	public void setBarHeight(Integer barHeight) {
		this.barHeight = barHeight;
	}

	@Override
	public BarcodeOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(BarcodeOrientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public EvaluationTime getEvaluationTime() {
		return evaluationTime;
	}

	public void setEvaluationTime(EvaluationTime evaluationTime) {
		this.evaluationTime = evaluationTime;
	}

	@Override
	public DRIDesignGroup getEvaluationGroup() {
		return evaluationGroup;
	}

	public void setEvaluationGroup(DRIDesignGroup evaluationGroup) {
		this.evaluationGroup = evaluationGroup;
	}
}
