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

package net.sf.dynamicreports.report.builder.barcode;

import net.sf.dynamicreports.report.base.barcode.DRBarbecue;
import net.sf.dynamicreports.report.builder.component.DimensionComponentBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.BarbecueType;
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class BarbecueBuilder extends DimensionComponentBuilder<BarbecueBuilder, DRBarbecue> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected BarbecueBuilder(BarbecueType type, String code) {
		super(new DRBarbecue());
		getObject().setType(type);
		setCode(code);
	}

	protected BarbecueBuilder(BarbecueType type, DRIExpression<String> codeExpression) {
		super(new DRBarbecue());
		getObject().setType(type);
		setCode(codeExpression);
	}

	public BarbecueBuilder setCode(String code) {
		getObject().setCodeExpression(Expressions.text(code));
		return this;
	}

	public BarbecueBuilder setCode(DRIExpression<String> codeExpression) {
		getObject().setCodeExpression(codeExpression);
		return this;
	}

	public BarbecueBuilder setApplicationIdentifierExpression(String applicationIdentifier) {
		getObject().setApplicationIdentifierExpression(Expressions.text(applicationIdentifier));
		return this;
	}

	public BarbecueBuilder setApplicationIdentifierExpression(DRIExpression<String> applicationIdentifierExpression) {
		getObject().setApplicationIdentifierExpression(applicationIdentifierExpression);
		return this;
	}

	public BarbecueBuilder setDrawText(Boolean drawText) {
		getObject().setDrawText(drawText);
		return this;
	}

	public BarbecueBuilder setChecksumRequired(Boolean checksumRequired) {
		getObject().setChecksumRequired(checksumRequired);
		return this;
	}

	public BarbecueBuilder setBarWidth(Integer barWidth) {
		getObject().setBarWidth(barWidth);
		return this;
	}

	public BarbecueBuilder setBarHeight(Integer barHeight) {
		getObject().setBarHeight(barHeight);
		return this;
	}

	public BarbecueBuilder setOrientation(BarcodeOrientation orientation) {
		getObject().setOrientation(orientation);
		return this;
	}
}
