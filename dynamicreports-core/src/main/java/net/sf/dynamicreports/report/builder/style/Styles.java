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

package net.sf.dynamicreports.report.builder.style;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import net.sf.dynamicreports.report.constant.FontName;
import net.sf.dynamicreports.report.constant.LineStyle;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRException;

import org.apache.commons.lang3.Validate;

/**
 * A set of methods of creating and customizing styles
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Styles {

	// font
	public static FontBuilder font() {
		return new FontBuilder();
	}

	public static FontBuilder font(String fontName, boolean bold, boolean italic, int fontSize) {
		return new FontBuilder(fontName, bold, italic, fontSize);
	}

	public static FontBuilder fontArial() {
		return new FontBuilder(FontName.ARIAL, false, false, 10);
	}

	public static FontBuilder fontArialBold() {
		return new FontBuilder(FontName.ARIAL, true, false, 10);
	}

	public static FontBuilder fontTimesNewRoman() {
		return new FontBuilder(FontName.TIMES_NEW_ROMAN, false, false, 10);
	}

	public static FontBuilder fontTimesNewRomanBold() {
		return new FontBuilder(FontName.TIMES_NEW_ROMAN, true, false, 10);
	}

	public static FontBuilder fontCourierNew() {
		return new FontBuilder(FontName.COURIER_NEW, false, false, 10);
	}

	public static FontBuilder fontCourierNewBold() {
		return new FontBuilder(FontName.COURIER_NEW, true, false, 10);
	}

	// pen
	public static PenBuilder pen() {
		return new PenBuilder();
	}

	public static PenBuilder pen(Float lineWidth, LineStyle lineStyle) {
		return new PenBuilder(lineWidth, lineStyle);
	}

	public static PenBuilder penThin() {
		return new PenBuilder(0.5f, LineStyle.SOLID);
	}

	public static PenBuilder pen1Point() {
		return new PenBuilder(1f, LineStyle.SOLID);
	}

	public static PenBuilder pen2Point() {
		return new PenBuilder(2f, LineStyle.SOLID);
	}

	public static PenBuilder penDotted() {
		return new PenBuilder(1f, LineStyle.DOTTED);
	}

	public static PenBuilder penDashed() {
		return new PenBuilder(1f, LineStyle.DASHED);
	}

	public static PenBuilder penDouble() {
		return new PenBuilder(1f, LineStyle.DOUBLE);
	}

	// border
	public static BorderBuilder border() {
		return new BorderBuilder();
	}

	public static BorderBuilder border(PenBuilder pen) {
		Validate.notNull(pen, "pen must not be null");
		return new BorderBuilder(pen);
	}

	// padding
	public static PaddingBuilder padding() {
		return new PaddingBuilder();
	}

	public static PaddingBuilder padding(int padding) {
		return new PaddingBuilder(padding);
	}

	// style
	public static StyleBuilder style() {
		return new StyleBuilder();
	}

	public static StyleBuilder style(ReportStyleBuilder parentStyle) {
		return new StyleBuilder().setParentStyle(parentStyle);
	}

	public static StyleBuilder style(FontBuilder font) {
		return new StyleBuilder().setFont(font);
	}

	public static StyleBuilder style(PenBuilder borderPen) {
		return new StyleBuilder().setBorder(borderPen);
	}

	public static StyleBuilder style(Integer padding) {
		return new StyleBuilder().setPadding(padding);
	}

	public static SimpleStyleBuilder simpleStyle() {
		return new SimpleStyleBuilder();
	}

	public static TemplateStyleBuilder templateStyle(String name) {
		return new TemplateStyleBuilder(name);
	}

	public static ConditionalStyleBuilder conditionalStyle(DRIExpression<Boolean> conditionExpression) {
		return new ConditionalStyleBuilder(conditionExpression);
	}

	public static TemplateStylesBuilder templateStyles() {
		return new TemplateStylesBuilder();
	}

	public static TemplateStylesBuilder loadStyles(InputStream inputStream) {
		return new TemplateStylesBuilder().loadStyles(inputStream);
	}

	public static TemplateStylesBuilder loadStyles(File file) {
		return new TemplateStylesBuilder().loadStyles(file);
	}

	public static TemplateStylesBuilder loadStyles(String fileName) throws DRException {
		return new TemplateStylesBuilder().loadStyles(fileName);
	}

	public static TemplateStylesBuilder loadStyles(URL url) {
		return new TemplateStylesBuilder().loadStyles(url);
	}
}
