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

package net.sf.dynamicreports.report.base.component;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.component.DRIGenericElement;
import net.sf.dynamicreports.report.definition.expression.DRIParameterExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRGenericElement extends DRDimensionComponent implements DRIGenericElement {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String genericElementNamespace;
	private String genericElementName;
	private List<DRIParameterExpression> parameterExpressions;

	public DRGenericElement(String namespace, String name) {
		Validate.notEmpty(namespace, "namespace must not be empty");
		Validate.notEmpty(name, "name must not be empty");
		genericElementNamespace = namespace;
		genericElementName = name;
	}

	@Override
	protected void init() {
		super.init();
		parameterExpressions = new ArrayList<DRIParameterExpression>();
	}

	@Override
	public String getGenericElementNamespace() {
		return genericElementNamespace;
	}

	public void setGenericElementNamespace(String genericElementNamespace) {
		this.genericElementNamespace = genericElementNamespace;
	}

	@Override
	public String getGenericElementName() {
		return genericElementName;
	}

	public void setGenericElementName(String genericElementName) {
		this.genericElementName = genericElementName;
	}

	@Override
	public List<DRIParameterExpression> getParameterExpressions() {
		return parameterExpressions;
	}

	public void addParameterExpression(DRIParameterExpression parameterExpression) {
		Validate.notNull(parameterExpression, "parameterExpression must not be null");
		this.parameterExpressions.add(parameterExpression);
	}

	public void setParameterExpressions(List<DRIParameterExpression> parameterExpressions) {
		this.parameterExpressions = parameterExpressions;
	}

}
