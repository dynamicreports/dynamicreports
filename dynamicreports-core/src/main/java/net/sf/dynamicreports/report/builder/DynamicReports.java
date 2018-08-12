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

package net.sf.dynamicreports.report.builder;

import net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.ExporterBuilders;
import net.sf.dynamicreports.jasper.definition.JasperReportHandler;
import net.sf.dynamicreports.report.builder.barcode.BarcodeBuilders;
import net.sf.dynamicreports.report.builder.chart.ChartBuilders;
import net.sf.dynamicreports.report.builder.column.ColumnBuilders;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilders;
import net.sf.dynamicreports.report.builder.condition.ConditionBuilders;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilders;
import net.sf.dynamicreports.report.builder.datatype.DataTypeBuilders;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.expression.ExpressionBuilders;
import net.sf.dynamicreports.report.builder.grid.GridBuilders;
import net.sf.dynamicreports.report.builder.group.GroupBuilders;
import net.sf.dynamicreports.report.builder.style.StyleBuilders;
import net.sf.dynamicreports.report.builder.subtotal.SubtotalBuilders;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsHeadingBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRException;

import org.apache.commons.lang3.Validate;

/**
 * <p>DynamicReports class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DynamicReports {
	/**
	 * A set of methods of creating report columns.<br/>
	 * It is used to display data in a multi-column layout.
	 */
	public static final ColumnBuilders col = new ColumnBuilders();
	/**
	 * A set of methods of customizing columns layout.
	 */
	public static final GridBuilders grid = new GridBuilders();
	/**
	 * A set of methods of creating report groups.
	 */
	public static final GroupBuilders grp = new GroupBuilders();
	/**
	 * A set of methods of creating column subtotals.
	 */
	public static final SubtotalBuilders sbt = new SubtotalBuilders();
	/**
	 * A set of methods of creating and customizing styles.
	 */
	public static final StyleBuilders stl = new StyleBuilders();
	/**
	 * A set of methods of creating components.
	 */
	public static final ComponentBuilders cmp = new ComponentBuilders();
	/**
	 * A set of build in expressions.<br/>
	 * Expressions are used to define various calculations, conditions, text field content, specific report groups, etc.
	 */
	public static final ExpressionBuilders exp = new ExpressionBuilders();
	/**
	 * A set of build in condition expressions.
	 */
	public static final ConditionBuilders cnd = new ConditionBuilders();
	/**
	 * A set of build in data types.
	 */
	public static final DataTypeBuilders type = new DataTypeBuilders();
	/**
	 * A set of methods of creating and customizing charts.
	 */
	public static final ChartBuilders cht = new ChartBuilders();
	/**
	 * A set of methods of creating exporters.
	 */
	public static final ExporterBuilders export = new ExporterBuilders();
	/**
	 * A set of methods of creating barcodes.
	 */
	public static final BarcodeBuilders bcode = new BarcodeBuilders();
	/**
	 * A set of methods of creating and customizing crosstabs.
	 */
	public static final CrosstabBuilders ctab = new CrosstabBuilders();

	/**
	 * Creates a new report builder.
	 * The most used report builder for creating reports. It allows constructing and customizing the whole report content.
	 *
	 * @return a report builder
	 */
	public static JasperReportBuilder report() {
		return new JasperReportBuilder();
	}

	/**
	 * Creates a new concatenated report builder.
	 * This report builder allows concatenating several separated reports into one single document.
	 *
	 * @return a report builder
	 */
	public static JasperConcatenatedReportBuilder concatenatedReport() {
		return new JasperConcatenatedReportBuilder();
	}

	/**
	 * Creates a new concatenated report builder.
	 * This report builder allows concatenating several separated reports into one single document.
	 *
	 * @return a report builder
	 * @param jasperReportHandler a {@link net.sf.dynamicreports.jasper.definition.JasperReportHandler} object.
	 */
	public static JasperConcatenatedReportBuilder concatenatedReport(JasperReportHandler jasperReportHandler) {
		return new JasperConcatenatedReportBuilder(jasperReportHandler);
	}

	// field
	/**
	 * <p>field.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 */
	public static <T> FieldBuilder<T> field(String name, Class valueClass) {
		FieldBuilder<T> fieldBuilder = new FieldBuilder<T>(name, valueClass);
		try {
			DRIDataType<? super T, T> dataType = DataTypes.detectType(valueClass);
			fieldBuilder.setDataType(dataType);
		} catch (DRException e) {
		}
		return fieldBuilder;
	}

	/**
	 * <p>field.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param dataType a {@link net.sf.dynamicreports.report.definition.datatype.DRIDataType} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 */
	public static <T> FieldBuilder<T> field(String name, DRIDataType dataType) {
		Validate.notNull(dataType, "dataType must not be null");
		FieldBuilder<T> fieldBuilder = new FieldBuilder<T>(name, dataType.getValueClass());
		fieldBuilder.setDataType(dataType);
		return fieldBuilder;
	}

	// variable
	/**
	 * <p>variable.</p>
	 *
	 * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
	 */
	public static <T> VariableBuilder<T> variable(ValueColumnBuilder<?, ?> column, Calculation calculation) {
		Validate.notNull(column, "column must not be null");
		return new VariableBuilder<T>(column, calculation);
	}

	/**
	 * <p>variable.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
	 */
	public static <T> VariableBuilder<T> variable(String name, ValueColumnBuilder<?, ?> column, Calculation calculation) {
		Validate.notNull(column, "column must not be null");
		return new VariableBuilder<T>(name, column, calculation);
	}

	/**
	 * <p>variable.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
	 */
	public static <T> VariableBuilder<T> variable(FieldBuilder<T> field, Calculation calculation) {
		Validate.notNull(field, "field must not be null");
		return new VariableBuilder<T>(field, calculation);
	}

	/**
	 * <p>variable.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
	 */
	public static <T> VariableBuilder<T> variable(String name, FieldBuilder<T> field, Calculation calculation) {
		return new VariableBuilder<T>(name, field, calculation);
	}

	/**
	 * <p>variable.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
	 */
	public static <T> VariableBuilder<T> variable(String fieldName, Class<?> valueClass, Calculation calculation) {
		return new VariableBuilder<T>(field(fieldName, valueClass), calculation);
	}

	/**
	 * <p>variable.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
	 */
	public static <T> VariableBuilder<T> variable(String name, String fieldName, Class<?> valueClass, Calculation calculation) {
		return new VariableBuilder<T>(name, field(fieldName, valueClass), calculation);
	}

	/**
	 * <p>variable.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
	 */
	public static <T> VariableBuilder<T> variable(DRIExpression<?> expression, Calculation calculation) {
		return new VariableBuilder<T>(expression, calculation);
	}

	/**
	 * <p>variable.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
	 */
	public static <T> VariableBuilder<T> variable(String name, DRIExpression<?> expression, Calculation calculation) {
		return new VariableBuilder<T>(name, expression, calculation);
	}

	// sort
	/**
	 * <p>asc.</p>
	 *
	 * @param column a {@link net.sf.dynamicreports.report.builder.column.TextColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.SortBuilder} object.
	 */
	public static SortBuilder asc(TextColumnBuilder<?> column) {
		return new SortBuilder(column).setOrderType(OrderType.ASCENDING);
	}

	/**
	 * <p>asc.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.SortBuilder} object.
	 */
	public static SortBuilder asc(FieldBuilder<?> field) {
		return new SortBuilder(field).setOrderType(OrderType.ASCENDING);
	}

	/**
	 * <p>asc.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.SortBuilder} object.
	 */
	public static SortBuilder asc(String fieldName, Class<?> valueClass) {
		return new SortBuilder(field(fieldName, valueClass)).setOrderType(OrderType.ASCENDING);
	}

	/**
	 * <p>asc.</p>
	 *
	 * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.SortBuilder} object.
	 */
	public static SortBuilder asc(VariableBuilder<?> variable) {
		return new SortBuilder(variable).setOrderType(OrderType.ASCENDING);
	}

	/**
	 * <p>asc.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.SortBuilder} object.
	 */
	public static SortBuilder asc(DRIExpression<?> expression) {
		return new SortBuilder(expression).setOrderType(OrderType.ASCENDING);
	}

	/**
	 * <p>desc.</p>
	 *
	 * @param column a {@link net.sf.dynamicreports.report.builder.column.TextColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.SortBuilder} object.
	 */
	public static SortBuilder desc(TextColumnBuilder<?> column) {
		return new SortBuilder(column).setOrderType(OrderType.DESCENDING);
	}

	/**
	 * <p>desc.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.SortBuilder} object.
	 */
	public static SortBuilder desc(FieldBuilder<?> field) {
		return new SortBuilder(field).setOrderType(OrderType.DESCENDING);
	}

	/**
	 * <p>desc.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.SortBuilder} object.
	 */
	public static SortBuilder desc(String fieldName, Class<?> valueClass) {
		return new SortBuilder(field(fieldName, valueClass)).setOrderType(OrderType.DESCENDING);
	}

	/**
	 * <p>desc.</p>
	 *
	 * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.SortBuilder} object.
	 */
	public static SortBuilder desc(VariableBuilder<?> variable) {
		return new SortBuilder(variable).setOrderType(OrderType.DESCENDING);
	}

	/**
	 * <p>desc.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.SortBuilder} object.
	 */
	public static SortBuilder desc(DRIExpression<?> expression) {
		return new SortBuilder(expression).setOrderType(OrderType.DESCENDING);
	}

	// hyperLink
	/**
	 * <p>hyperLink.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public static HyperLinkBuilder hyperLink() {
		return new HyperLinkBuilder();
	}

	/**
	 * <p>hyperLink.</p>
	 *
	 * @param link a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public static HyperLinkBuilder hyperLink(String link) {
		return new HyperLinkBuilder(link);
	}

	/**
	 * <p>hyperLink.</p>
	 *
	 * @param linkExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
	 */
	public static HyperLinkBuilder hyperLink(DRIExpression<String> linkExpression) {
		return new HyperLinkBuilder(linkExpression);
	}

	// margin
	/**
	 * <p>margin.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.MarginBuilder} object.
	 */
	public static MarginBuilder margin() {
		return new MarginBuilder();
	}

	/**
	 * <p>margin.</p>
	 *
	 * @param margin a int.
	 * @return a {@link net.sf.dynamicreports.report.builder.MarginBuilder} object.
	 */
	public static MarginBuilder margin(int margin) {
		return new MarginBuilder(margin);
	}

	// parameter
	/**
	 * <p>parameter.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param value a T object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ParameterBuilder} object.
	 */
	public static <T> ParameterBuilder<T> parameter(String name, T value) {
		return new ParameterBuilder<T>(name, value);
	}

	/**
	 * <p>parameter.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ParameterBuilder} object.
	 */
	public static <T> ParameterBuilder<T> parameter(String name, Class<T> valueClass) {
		return new ParameterBuilder<T>(name, valueClass);
	}

	// query
	/**
	 * <p>query.</p>
	 *
	 * @param text a {@link java.lang.String} object.
	 * @param language a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.QueryBuilder} object.
	 */
	public static QueryBuilder query(String text, String language) {
		return new QueryBuilder(text, language);
	}

	// units
	/**
	 * <p>cm.</p>
	 *
	 * @param value a {@link java.lang.Number} object.
	 * @return a int.
	 */
	public static int cm(Number value) {
		return Units.cm(value);
	}

	/**
	 * <p>inch.</p>
	 *
	 * @param value a {@link java.lang.Number} object.
	 * @return a int.
	 */
	public static int inch(Number value) {
		return Units.inch(value);
	}

	/**
	 * <p>mm.</p>
	 *
	 * @param value a {@link java.lang.Number} object.
	 * @return a int.
	 */
	public static int mm(Number value) {
		return Units.mm(value);
	}

	// template
	/**
	 * <p>template.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public static ReportTemplateBuilder template() {
		return new ReportTemplateBuilder();
	}

	// table of contents
	/**
	 * <p>tableOfContentsCustomizer.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder} object.
	 */
	public static TableOfContentsCustomizerBuilder tableOfContentsCustomizer() {
		return new TableOfContentsCustomizerBuilder();
	}

	/**
	 * <p>tableOfContentsHeading.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsHeadingBuilder} object.
	 */
	public static TableOfContentsHeadingBuilder tableOfContentsHeading() {
		return new TableOfContentsHeadingBuilder();
	}

	/**
	 * <p>tableOfContentsHeading.</p>
	 *
	 * @param label a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsHeadingBuilder} object.
	 */
	public static TableOfContentsHeadingBuilder tableOfContentsHeading(String label) {
		return new TableOfContentsHeadingBuilder().setLabel(label);
	}

	// dataset
	/**
	 * <p>dataset.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.DatasetBuilder} object.
	 */
	public static DatasetBuilder dataset() {
		return new DatasetBuilder();
	}
}
