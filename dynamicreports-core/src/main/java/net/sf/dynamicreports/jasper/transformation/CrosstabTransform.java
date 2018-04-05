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

package net.sf.dynamicreports.jasper.transformation;

import java.util.Map;

import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstab;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabCell;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabCellContent;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabColumnGroup;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabDataset;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabGroup;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabMeasure;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabRowGroup;
import net.sf.dynamicreports.jasper.base.JasperCustomValues;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.dynamicreports.jasper.transformation.expression.CrosstabParametersExpression;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.jasperreports.crosstabs.design.JRDesignCellContents;
import net.sf.jasperreports.crosstabs.design.JRDesignCrosstab;
import net.sf.jasperreports.crosstabs.design.JRDesignCrosstabBucket;
import net.sf.jasperreports.crosstabs.design.JRDesignCrosstabCell;
import net.sf.jasperreports.crosstabs.design.JRDesignCrosstabColumnGroup;
import net.sf.jasperreports.crosstabs.design.JRDesignCrosstabDataset;
import net.sf.jasperreports.crosstabs.design.JRDesignCrosstabGroup;
import net.sf.jasperreports.crosstabs.design.JRDesignCrosstabMeasure;
import net.sf.jasperreports.crosstabs.design.JRDesignCrosstabParameter;
import net.sf.jasperreports.crosstabs.design.JRDesignCrosstabRowGroup;
import net.sf.jasperreports.crosstabs.type.CrosstabColumnPositionEnum;
import net.sf.jasperreports.crosstabs.type.CrosstabRowPositionEnum;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignElement;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class CrosstabTransform {
	private JasperTransformAccessor accessor;

	public CrosstabTransform(JasperTransformAccessor accessor) {
		this.accessor = accessor;
	}

	protected JRDesignElement transform(DRIDesignCrosstab crosstab) {
		JRDesignCrosstab jrCrosstab = new JRDesignCrosstab();

		dataset(crosstab.getDataset(), jrCrosstab.getDesignDataset());
		accessor.transformToDataset(crosstab.getDataset().getSubDataset());
		if (crosstab.isRepeatColumnHeaders() != null) {
			jrCrosstab.setRepeatColumnHeaders(crosstab.isRepeatColumnHeaders());
		}
		if (crosstab.isRepeatRowHeaders() != null) {
			jrCrosstab.setRepeatRowHeaders(crosstab.isRepeatRowHeaders());
		}
		if (crosstab.getColumnBreakOffset() != null) {
			jrCrosstab.setColumnBreakOffset(crosstab.getColumnBreakOffset());
		}
		jrCrosstab.setIgnoreWidth(crosstab.getIgnoreWidth());
		jrCrosstab.setRunDirection(ConstantTransform.runDirection(crosstab.getRunDirection()));
		jrCrosstab.setWhenNoDataCell(cellContent(crosstab.getWhenNoDataCell()));
		jrCrosstab.setHeaderCell(cellContent(crosstab.getHeaderCell()));
		for (DRIDesignCrosstabColumnGroup columnGroup : crosstab.getColumnGroups()) {
			addColumnGroup(jrCrosstab, columnGroup);
		}
		for (DRIDesignCrosstabRowGroup rowGroup : crosstab.getRowGroups()) {
			addRowGroup(jrCrosstab, rowGroup);
		}
		for (DRIDesignCrosstabCell cell : crosstab.getCells()) {
			addCell(jrCrosstab, cell);
		}
		for (DRIDesignCrosstabMeasure measure : crosstab.getMeasures()) {
			addMeasure(jrCrosstab, measure);
		}

		registerScriptletCrosstabParameter(jrCrosstab);
		accessor.transformToMainDataset();

		Map<String, Object> crosstabParameters;
		if (crosstab.getDataset().getSubDataset() == null) {
			crosstabParameters = accessor.getParameters();
		} else {
			crosstabParameters = accessor.getDatasetTransform().getDatasetParameters(crosstab.getDataset().getSubDataset());
		}
		CrosstabParametersExpression parametersExpression = new CrosstabParametersExpression(crosstabParameters);
		accessor.getExpressionTransform().addSimpleExpression(parametersExpression);
		jrCrosstab.setParametersMapExpression(accessor.getExpressionTransform().getExpression(parametersExpression));

		return jrCrosstab;
	}

	private void registerScriptletCrosstabParameter(JRDesignCrosstab jrCrosstab) {
		JRDesignCrosstabParameter jrParameter = new JRDesignCrosstabParameter();
		jrParameter.setName(JasperCustomValues.NAME);
		jrParameter.setValueClass(JasperCustomValues.class);

		try {
			jrCrosstab.addParameter(jrParameter);
		} catch (JRException e) {
			throw new JasperDesignException("Registration failed for scriptlet crosstab parameter", e);
		}
	}

	// dataset
	private void dataset(DRIDesignCrosstabDataset dataset, JRDesignCrosstabDataset jrDataset) {
		jrDataset.setDatasetRun(accessor.getDatasetTransform().datasetRun(dataset.getSubDataset()));
		if (dataset.getDataPreSorted() != null) {
			jrDataset.setDataPreSorted(dataset.getDataPreSorted());
		}
		ResetType resetType = dataset.getResetType();
		jrDataset.setResetType(ConstantTransform.variableResetType(resetType));
		if (resetType.equals(ResetType.GROUP) && dataset.getResetGroup() != null) {
			jrDataset.setResetGroup(accessor.getGroupTransform().getGroup(dataset.getResetGroup()));
		}
	}

	private JRDesignCellContents cellContent(DRIDesignCrosstabCellContent cellContent) {
		if (cellContent == null || cellContent.getComponent() == null) {
			return null;
		}

		JRDesignCellContents jrCellContents = new JRDesignCellContents();
		JRDesignElement[] jrElements = accessor.getComponentTransform().component(cellContent.getComponent(), ListType.VERTICAL);
		for (JRDesignElement jrElement : jrElements) {
			jrCellContents.addElement(jrElement);
		}
		jrCellContents.setStyle(accessor.getStyleTransform().getStyle(cellContent.getStyle()));
		return jrCellContents;
	}

	private void group(JRDesignCrosstabGroup jrGroup, DRIDesignCrosstabGroup group) {
		jrGroup.setName(group.getName());
		jrGroup.setTotalPosition(ConstantTransform.crosstabTotalPosition(group.getTotalPosition()));
		jrGroup.setBucket(bucket(group));
		jrGroup.setHeader(cellContent(group.getHeader()));
		jrGroup.setTotalHeader(cellContent(group.getTotalHeader()));
	}

	private JRDesignCrosstabBucket bucket(DRIDesignCrosstabGroup group) {
		JRDesignCrosstabBucket jrBucket = new JRDesignCrosstabBucket();
		if (group.getOrderType() != null) {
			jrBucket.setOrder(ConstantTransform.bucketOrderType(group.getOrderType()));
		}
		jrBucket.setExpression(accessor.getExpressionTransform().getExpression(group.getExpression()));
		jrBucket.setOrderByExpression(accessor.getExpressionTransform().getExpression(group.getOrderByExpression()));
		jrBucket.setComparatorExpression(accessor.getExpressionTransform().getExpression(group.getComparatorExpression()));
		jrBucket.setValueClassName(group.getExpression().getValueClass().getName());
		return jrBucket;
	}

	private void addColumnGroup(JRDesignCrosstab jrCrosstab, DRIDesignCrosstabColumnGroup columnGroup) {
		JRDesignCrosstabColumnGroup jrColumnGroup = new JRDesignCrosstabColumnGroup();
		group(jrColumnGroup, columnGroup);
		jrColumnGroup.setHeight(columnGroup.getHeight());
		jrColumnGroup.setPosition(CrosstabColumnPositionEnum.STRETCH);

		try {
			jrCrosstab.addColumnGroup(jrColumnGroup);
		} catch (JRException e) {
			throw new JasperDesignException("Registration failed for crosstab column group \"" + columnGroup.getName() + "\"", e);
		}
	}

	private void addRowGroup(JRDesignCrosstab jrCrosstab, DRIDesignCrosstabRowGroup rowGroup) {
		JRDesignCrosstabRowGroup jrRowGroup = new JRDesignCrosstabRowGroup();
		group(jrRowGroup, rowGroup);
		jrRowGroup.setWidth(rowGroup.getWidth());
		jrRowGroup.setPosition(CrosstabRowPositionEnum.STRETCH);

		try {
			jrCrosstab.addRowGroup(jrRowGroup);
		} catch (JRException e) {
			throw new JasperDesignException("Registration failed for crosstab row group \"" + rowGroup.getName() + "\"", e);
		}
	}

	private void addCell(JRDesignCrosstab jrCrosstab, DRIDesignCrosstabCell cell) {
		JRDesignCrosstabCell jrCell = new JRDesignCrosstabCell();
		jrCell.setWidth(cell.getContent().getWidth());
		jrCell.setHeight(cell.getContent().getHeight());
		jrCell.setRowTotalGroup(cell.getRowTotalGroup());
		jrCell.setColumnTotalGroup(cell.getColumnTotalGroup());
		jrCell.setContents(cellContent(cell.getContent()));

		try {
			jrCrosstab.addCell(jrCell);
		} catch (JRException e) {
			throw new JasperDesignException("Registration failed for crosstab cell \"" + cell.getName() + "\"", e);
		}
	}

	private void addMeasure(JRDesignCrosstab jrCrosstab, DRIDesignCrosstabMeasure measure) {
		JRDesignCrosstabMeasure jrMeasure = new JRDesignCrosstabMeasure();
		jrMeasure.setName(measure.getName());
		jrMeasure.setValueExpression(accessor.getExpressionTransform().getExpression(measure.getValueExpression()));
		jrMeasure.setValueClassName(measure.getValueClass().getName());
		jrMeasure.setCalculation(ConstantTransform.calculation(measure.getCalculation()));
		jrMeasure.setPercentageType(ConstantTransform.crosstabPercentageType(measure.getPercentageType()));

		try {
			jrCrosstab.addMeasure(jrMeasure);
		} catch (JRException e) {
			throw new JasperDesignException("Registration failed for crosstab measure \"" + measure.getName() + "\"", e);
		}
	}

}
