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
import net.sf.dynamicreports.design.definition.component.DRIDesignTextField;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Markup;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignTextField extends DRDesignHyperlinkComponent implements DRIDesignTextField {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String pattern;
	private DRIDesignExpression patternExpression;
	private HorizontalTextAlignment horizontalTextAlignment;
	private DRIDesignExpression valueExpression;
	private boolean printRepeatedValues;
	private EvaluationTime evaluationTime;
	private DRDesignGroup evaluationGroup;
	private Markup markup;
	private boolean stretchWithOverflow;

	public DRDesignTextField() {
		super("textField");
	}

	@Override
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public DRIDesignExpression getPatternExpression() {
		return patternExpression;
	}

	public void setPatternExpression(DRIDesignExpression patternExpression) {
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
	public DRIDesignExpression getValueExpression() {
		return valueExpression;
	}

	public void setValueExpression(DRIDesignExpression valueExpression) {
		this.valueExpression = valueExpression;
	}

	@Override
	public boolean isPrintRepeatedValues() {
		return printRepeatedValues;
	}

	public void setPrintRepeatedValues(boolean printRepeatedValues) {
		this.printRepeatedValues = printRepeatedValues;
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
	public Markup getMarkup() {
		return markup;
	}

	public void setMarkup(Markup markup) {
		this.markup = markup;
	}

	@Override
	public boolean isStretchWithOverflow() {
		return stretchWithOverflow;
	}

	public void setStretchWithOverflow(boolean stretchWithOverflow) {
		this.stretchWithOverflow = stretchWithOverflow;
	}
}
