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

package net.sf.dynamicreports.design.base;

import java.util.Collection;

import net.sf.dynamicreports.design.definition.DRIDesignDataset;
import net.sf.dynamicreports.design.definition.DRIDesignField;
import net.sf.dynamicreports.design.definition.DRIDesignSort;
import net.sf.dynamicreports.design.definition.DRIDesignVariable;
import net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignJasperExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSystemExpression;
import net.sf.dynamicreports.design.transformation.DatasetExpressionTransform;
import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignDataset implements DRIDesignDataset {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private DatasetExpressionTransform datasetExpressionTransform;
	private DRDesignQuery query;
	private DRIDesignExpression connectionExpression;
	private DRIDesignExpression dataSourceExpression;
	private DRIDesignExpression filterExpression;

	public DRDesignDataset(DatasetExpressionTransform datasetExpressionTransform) {
		this.datasetExpressionTransform = datasetExpressionTransform;
		this.name = ReportUtils.generateUniqueName("dataset");
	}

	@Override
	public String getName() {
		return name;
	}

	public DatasetExpressionTransform getDatasetExpressionTransform() {
		return datasetExpressionTransform;
	}

	@Override
	public Collection<DRIDesignField> getFields() {
		return datasetExpressionTransform.getFields();
	}

	@Override
	public Collection<DRIDesignVariable> getVariables() {
		return datasetExpressionTransform.getVariables();
	}

	@Override
	public Collection<DRIDesignSystemExpression> getSystemExpressions() {
		return datasetExpressionTransform.getSystemExpressions();
	}

	@Override
	public Collection<DRIDesignJasperExpression> getJasperExpressions() {
		return datasetExpressionTransform.getJasperExpressions();
	}

	@Override
	public Collection<DRIDesignSimpleExpression> getSimpleExpressions() {
		return datasetExpressionTransform.getSimpleExpressions();
	}

	@Override
	public Collection<DRIDesignComplexExpression> getComplexExpressions() {
		return datasetExpressionTransform.getComplexExpressions();
	}

	@Override
	public Collection<DRIDesignSort> getSorts() {
		return datasetExpressionTransform.getSorts();
	}

	@Override
	public DRDesignQuery getQuery() {
		return query;
	}

	public void setQuery(DRDesignQuery query) {
		this.query = query;
	}

	@Override
	public DRIDesignExpression getConnectionExpression() {
		return connectionExpression;
	}

	public void setConnectionExpression(DRIDesignExpression connectionExpression) {
		this.connectionExpression = connectionExpression;
	}

	@Override
	public DRIDesignExpression getDataSourceExpression() {
		return dataSourceExpression;
	}

	public void setDataSourceExpression(DRIDesignExpression dataSourceExpression) {
		this.dataSourceExpression = dataSourceExpression;
	}

	@Override
	public DRIDesignExpression getFilterExpression() {
		return filterExpression;
	}

	public void setFilterExpression(DRIDesignExpression filterExpression) {
		this.filterExpression = filterExpression;
	}
}
