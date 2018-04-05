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

package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.report.base.component.DRMultiPageList;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.definition.ReportParameters;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class MultiPageListBuilder extends DimensionComponentBuilder<MultiPageListBuilder, DRMultiPageList> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected MultiPageListBuilder() {
		super(new DRMultiPageList());
	}

	public MultiPageListBuilder add(ComponentBuilder<?, ?>... components) {
		Validate.notNull(components, "components must not be null");
		Validate.noNullElements(components, "components must not contains null component");
		for (ComponentBuilder<?, ?> component : components) {
			getObject().addComponent(component.build());
		}
		return this;
	}

	public MultiPageListBuilder newPage() {
		BreakBuilder pageBreak = Components.pageBreak();
		pageBreak.setPrintWhenExpression(new PageBreakExpression());
		getObject().addComponent(pageBreak.build());
		return this;
	}

	public MultiPageListBuilder setSplitType(SplitType splitType) {
		getObject().setSplitType(splitType);
		return this;
	}

	private class PageBreakExpression extends AbstractSimpleExpression<Boolean> {
		private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

		@Override
		public Boolean evaluate(ReportParameters reportParameters) {
			return reportParameters.getMasterParameters().getPageRowNumber() > 0;
		}

	}
}
