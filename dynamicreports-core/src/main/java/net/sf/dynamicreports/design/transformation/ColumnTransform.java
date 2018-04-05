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

package net.sf.dynamicreports.design.transformation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignTextField;
import net.sf.dynamicreports.design.base.style.DRDesignStyle;
import net.sf.dynamicreports.design.constant.DefaultStyleType;
import net.sf.dynamicreports.report.base.component.DRBooleanField;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.base.style.DRConditionalStyle;
import net.sf.dynamicreports.report.base.style.DRPadding;
import net.sf.dynamicreports.report.base.style.DRStyle;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.definition.column.DRIBooleanColumn;
import net.sf.dynamicreports.report.definition.column.DRIColumn;
import net.sf.dynamicreports.report.definition.column.DRIValueColumn;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIConditionalStyle;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import net.sf.dynamicreports.report.definition.style.DRISimpleStyle;
import net.sf.dynamicreports.report.definition.style.DRIStyle;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ColumnTransform {
	private DesignTransformAccessor accessor;
	private Map<DRIColumn<?>, DRIComponent> columnComponents;

	public ColumnTransform(DesignTransformAccessor accessor) {
		this.accessor = accessor;
	}

	// columns
	public void transform() throws DRException {
		columnComponents = getColumnComponents();
		boolean showColumnTitle = accessor.getTemplateTransform().isShowColumnTitle();
		boolean showColumnValues = accessor.getTemplateTransform().isShowColumnValues();
		boolean showColumnTitleForGroup = accessor.getBandTransform().getColumnHeaderForGroupBand() != null;

		ColumnGrid columnTitle = null;
		if (showColumnTitle) {
			columnTitle = accessor.getColumnGridTransform().createColumnTitleGrid(accessor.getStyleTransform().getDefaultStyle(DefaultStyleType.COLUMN_TITLE));
		}
		ColumnGrid columnTitleForGroup = null;
		if (showColumnTitleForGroup) {
			columnTitleForGroup = accessor.getColumnGridTransform()
					.createColumnTitleGrid(accessor.getStyleTransform().getDefaultStyle(DefaultStyleType.COLUMN_TITLE));
		}
		ColumnGrid detail = accessor.getColumnGridTransform().createColumnGrid();

		for (DRIColumn<?> column : accessor.getReport().getColumns()) {
			if (!accessor.getGroupTransform().getHideGroupColumns().contains(column)) {
				if (column.getTitleExpression() != null) {
					if (showColumnTitle) {
						columnTitle.addComponent(column, titleComponent(column));
					}
					if (showColumnTitleForGroup) {
						columnTitleForGroup.addComponent(column, titleComponent(column));
					}
				}
				DRDesignComponent detailComponent = null;
				if (column instanceof DRIValueColumn<?>) {
					detailComponent = detailValueComponent((DRIValueColumn<?>) column);
				} else if (column instanceof DRIBooleanColumn) {
					detailComponent = detailBooleanComponent((DRIBooleanColumn) column);
				} else {
					detailComponent = detailComponent(column);
				}
				detail.addComponent(column, detailComponent);
			}
		}

		if (showColumnTitle && !columnTitle.isEmpty()) {
			accessor.getBandTransform().getColumnHeaderBand().addComponent(0, columnTitle.getList());
		}
		if (showColumnTitleForGroup && !columnTitleForGroup.isEmpty()) {
			accessor.getBandTransform().getColumnHeaderForGroupBand().addComponent(0, columnTitleForGroup.getList());
		}
		if (showColumnValues) {
			accessor.getBandTransform().getDetailBand().addComponent(detail.getList());
		}
	}

	private Map<DRIColumn<?>, DRIComponent> getColumnComponents() throws DRException {
		Map<DRIColumn<?>, DRIComponent> columnComponents = new HashMap<DRIColumn<?>, DRIComponent>();
		for (DRIColumn<?> column : accessor.getReport().getColumns()) {
			if (!accessor.getGroupTransform().getHideGroupColumns().contains(column)) {
				DRIComponent component = column.getComponent();
				if (column instanceof DRIBooleanColumn) {
					component = createBooleanComponent((DRIBooleanColumn) column);
				}
				columnComponents.put(column, component);
			}
		}
		return columnComponents;
	}

	private DRIComponent createBooleanComponent(DRIBooleanColumn column) throws DRException {
		DRIReportStyle booleanColumnStyle = accessor.getTemplateTransform().getBooleanColumnStyle(column);
		if (booleanColumnStyle == null) {
			return column.getComponent();
		}
		DRBooleanField booleanField = new DRBooleanField();
		booleanField.setComponentType(column.getComponent().getComponentType());
		booleanField.setEmptyWhenNullValue(column.getComponent().getEmptyWhenNullValue());
		booleanField.setValueExpression(column.getComponent().getValueExpression());
		booleanField.setWidth(column.getComponent().getWidth());
		booleanField.setWidthType(column.getComponent().getWidthType());
		booleanField.setHeight(column.getComponent().getHeight());
		booleanField.setHeightType(column.getComponent().getHeightType());
		booleanField.setImageWidth(column.getComponent().getImageWidth());
		booleanField.setImageHeight(column.getComponent().getImageHeight());
		booleanField.setHorizontalImageAlignment(column.getComponent().getHorizontalImageAlignment());
		booleanField.setHorizontalTextAlignment(column.getComponent().getHorizontalTextAlignment());
		booleanField.setStyle(booleanColumnStyle);
		booleanField.setPrintWhenExpression(column.getComponent().getPrintWhenExpression());
		return booleanField;
	}

	// title
	@SuppressWarnings("unchecked")
	private DRDesignComponent titleComponent(DRIColumn<?> column) throws DRException {
		@SuppressWarnings("rawtypes")
		DRTextField titleField = new DRTextField();
		titleField.setValueExpression(column.getTitleExpression());
		titleField.setStyle(column.getTitleStyle());
		titleField.setWidth(accessor.getTemplateTransform().getColumnWidth(column, accessor.getStyleTransform().getDefaultStyle(DefaultStyleType.COLUMN)));
		titleField.setHeight(column.getTitleHeight());
		titleField.setHeightType(column.getTitleHeightType());
		titleField.setRows(column.getTitleRows());
		titleField.setStretchWithOverflow(column.getTitleStretchWithOverflow());
		titleField.setPropertyExpressions(column.getTitlePropertyExpressions());
		DRDesignTextField designTitleField = accessor.getComponentTransform().textField(titleField, DefaultStyleType.COLUMN_TITLE);
		designTitleField.setUniqueName("column_" + column.getName() + ".title");
		return designTitleField;
	}

	// detail
	private DRDesignComponent detailValueComponent(DRIValueColumn<?> column) throws DRException {
		DRDesignComponent detailComponent = detailComponent(column);
		((DRDesignTextField) detailComponent).setPrintRepeatedValues(accessor.getTemplateTransform().isColumnPrintRepeatedDetailValues(column));
		return detailComponent;
	}

	private DRDesignComponent detailBooleanComponent(DRIBooleanColumn column) throws DRException {
		DRDesignComponent detailComponent = detailComponent(column);

		return detailComponent;
	}

	private DRDesignComponent detailComponent(DRIColumn<?> column) throws DRException {
		DRDesignComponent designComponent = accessor.getComponentTransform().component(getColumnComponent(column), DefaultStyleType.COLUMN, null, null);
		designComponent.setUniqueName("column_" + column.getName());

		List<DRIConditionalStyle> rowHighlighters = new ArrayList<DRIConditionalStyle>();
		rowHighlighters.addAll(getDetailRowHighlighters());
		DRISimpleStyle detailOddRowStyle = accessor.getTemplateTransform().getDetailOddRowStyle();
		if (detailOddRowStyle != null) {
			rowHighlighters.add(detailRowConditionalStyle(detailOddRowStyle, Expressions.printInOddRow()));
		}
		DRISimpleStyle detailEvenRowStyle = accessor.getTemplateTransform().getDetailEvenRowStyle();
		if (detailEvenRowStyle != null) {
			rowHighlighters.add(detailRowConditionalStyle(detailEvenRowStyle, Expressions.printInEvenRow()));
		}
		if (!rowHighlighters.isEmpty()) {
			DRIReportStyle style = getColumnComponent(column).getStyle();
			if (style == null) {
				style = accessor.getTemplateTransform().getColumnStyle(column instanceof DRIValueColumn<?>);
			}
			DRStyle newStyle = new DRStyle();
			newStyle.setParentStyle(style);
			if (!(column instanceof DRIValueColumn<?>)) {
				newStyle.setPadding(new DRPadding(0));
			}
			List<DRIConditionalStyle> conditionalStyles = new ArrayList<DRIConditionalStyle>();
			if (style != null) {
				DRIStyle stl = accessor.getStyleTransform().getStyle(style);
				for (DRIConditionalStyle conditionalStyle : stl.getConditionalStyles()) {
					conditionalStyles.add(conditionalStyle);
				}
			}
			for (DRIConditionalStyle conditionalStyle : rowHighlighters) {
				conditionalStyles.add(conditionalStyle);
			}
			Color backgroundColor = StyleResolver.getBackgroundColor(style, accessor.getStyleTransform());
			for (DRIConditionalStyle conditionalStyle : conditionalStyles) {
				if (backgroundColor != null && conditionalStyle.getBackgroundColor() != null) {
					DRConditionalStyle newConditionalStyle = new DRConditionalStyle(conditionalStyle.getConditionExpression());
					accessor.getStyleTransform().copyStyle(newConditionalStyle, conditionalStyle);
					Color mergedColor = StyleResolver.mergeColors(backgroundColor, conditionalStyle.getBackgroundColor(), 0.25f);
					newConditionalStyle.setBackgroundColor(mergedColor);
					newStyle.addConditionalStyle(newConditionalStyle);
				} else {
					newStyle.addConditionalStyle((DRConditionalStyle) conditionalStyle);
				}
			}
			designComponent.setStyle(accessor.getStyleTransform().transformStyle(newStyle, true, DefaultStyleType.COLUMN));
		} else {
			if (designComponent.getStyle() == null && !(column instanceof DRIValueColumn<?>)) {
				DRIReportStyle columnStyle = accessor.getTemplateTransform().getColumnStyle(false);
				DRStyle newStyle = null;
				if (columnStyle != null) {
					newStyle = new DRStyle();
					newStyle.setParentStyle(columnStyle);
					newStyle.setPadding(new DRPadding(0));
				}
				DRDesignStyle designColumnStyle = accessor.getStyleTransform().transformStyle(newStyle, false, DefaultStyleType.NONE);
				designComponent.setStyle(designColumnStyle);
			}
		}

		return designComponent;
	}

	private List<? extends DRIConditionalStyle> getDetailRowHighlighters() {
		return accessor.getReport().getDetailRowHighlighters();
	}

	private DRConditionalStyle detailRowConditionalStyle(DRISimpleStyle style, DRIExpression<Boolean> expression) {
		DRConditionalStyle conditionalStyle = new DRConditionalStyle(expression);
		accessor.getStyleTransform().copyStyle(conditionalStyle, style);
		return conditionalStyle;
	}

	public DRIComponent getColumnComponent(DRIColumn<?> column) {
		return columnComponents.get(column);
	}
}
