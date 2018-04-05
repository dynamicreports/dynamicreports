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

import org.apache.commons.lang3.Validate;

import net.sf.dynamicreports.report.base.DRGroup;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.definition.component.DRITextField;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRTextField<T> extends DRHyperLinkComponent implements DRITextField<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIExpression<T> valueExpression;
	private String pattern;
	private DRIExpression<String> patternExpression;
	private HorizontalTextAlignment horizontalTextAlignment;
	private DRIValueFormatter<?, ? super T> valueFormatter;
	private DRIDataType<? super T, T> dataType;
	private Integer columns;
	private Integer rows;
	private Evaluation evaluationTime;
	private DRGroup evaluationGroup;
	private Markup markup;
	private Boolean stretchWithOverflow;
	private Boolean printRepeatedValues;

	@Override
	public DRIExpression<T> getValueExpression() {
		return valueExpression;
	}

	public void setValueExpression(DRIExpression<T> valueExpression) {
		Validate.notNull(valueExpression, "valueExpression must not be null");
		this.valueExpression = valueExpression;
	}

	@Override
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public DRIExpression<String> getPatternExpression() {
		return patternExpression;
	}

	public void setPatternExpression(DRIExpression<String> patternExpression) {
		this.patternExpression = patternExpression;
	}

	@Override
	public HorizontalTextAlignment getHorizontalTextAlignment() {
		return horizontalTextAlignment;
	}

	public void setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		this.horizontalTextAlignment = horizontalTextAlignment;
	}

	@Override
	public DRIValueFormatter<?, ? super T> getValueFormatter() {
		return valueFormatter;
	}

	public void setValueFormatter(DRIValueFormatter<?, ? super T> valueFormatter) {
		this.valueFormatter = valueFormatter;
	}

	@Override
	public DRIDataType<? super T, T> getDataType() {
		return dataType;
	}

	public void setDataType(DRIDataType<? super T, T> dataType) {
		this.dataType = dataType;
	}

	/**
	 * Returns the number of columns.
	 *
	 * @return the number of columns >= 0
	 */
	@Override
	public Integer getColumns() {
		return columns;
	}

	/**
	 * This method is used to define the width of a column.
	 * The width is set to the <code>columns</code> multiplied by width of the
	 * character <em>m</em> for the font used
	 *
	 * @param columns
	 *          the number of columns >= 0
	 * @exception IllegalArgumentException
	 *              if <code>columns</code> is < 0
	 */
	public void setColumns(Integer columns) {
		if (columns != null) {
			Validate.isTrue(columns >= 0, "columns must be >= 0");
		}
		this.columns = columns;
	}

	/**
	 * Returns the number of rows.
	 *
	 * @return the number of rows >= 0
	 */
	@Override
	public Integer getRows() {
		return rows;
	}

	/**
	 * This method is used to define the height of a column.
	 * The height is set to the <code>rows</code> multiplied by height of the font
	 *
	 * @param rows
	 *          the number of rows >= 0
	 * @exception IllegalArgumentException
	 *              if <code>rows</code> is < 0
	 */
	public void setRows(Integer rows) {
		if (rows != null) {
			Validate.isTrue(rows >= 0, "rows must be >= 0");
		}
		this.rows = rows;
	}

	@Override
	public Evaluation getEvaluationTime() {
		return evaluationTime;
	}

	public void setEvaluationTime(Evaluation evaluationTime) {
		this.evaluationTime = evaluationTime;
	}

	@Override
	public DRGroup getEvaluationGroup() {
		return evaluationGroup;
	}

	public void setEvaluationGroup(DRGroup evaluationGroup) {
		this.evaluationGroup = evaluationGroup;
	}

	@Override
	public Markup getMarkup() {
		return markup;
	}

	public void setMarkup(Markup markup) {
		this.markup = markup;
	}

	@Override
	public Boolean getStretchWithOverflow() {
		return stretchWithOverflow;
	}

	public void setStretchWithOverflow(Boolean stretchWithOverflow) {
		this.stretchWithOverflow = stretchWithOverflow;
	}

	@Override
	public Boolean getPrintRepeatedValues() {
		return printRepeatedValues;
	}

	public void setPrintRepeatedValues(Boolean printRepeatedValues) {
		this.printRepeatedValues = printRepeatedValues;
	}
}
