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

import net.sf.dynamicreports.report.constant.LineStyle;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * A set of methods of creating and customizing styles
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class StyleBuilders {

	// font
	public FontBuilder font() {
		return Styles.font();
	}

	public FontBuilder font(String fontName, boolean bold, boolean italic, int fontSize) {
		return Styles.font(fontName, bold, italic, fontSize);
	}

	public FontBuilder fontArial() {
		return Styles.fontArial();
	}

	public FontBuilder fontArialBold() {
		return Styles.fontArialBold();
	}

	public FontBuilder fontTimesNewRoman() {
		return Styles.fontTimesNewRoman();
	}

	public FontBuilder fontTimesNewRomanBold() {
		return Styles.fontTimesNewRomanBold();
	}

	public FontBuilder fontCourierNew() {
		return Styles.fontCourierNew();
	}

	public FontBuilder fontCourierNewBold() {
		return Styles.fontCourierNewBold();
	}

	// pen
	public PenBuilder pen() {
		return Styles.pen();
	}

	public PenBuilder pen(Float lineWidth, LineStyle lineStyle) {
		return Styles.pen(lineWidth, lineStyle);
	}

	public PenBuilder penThin() {
		return Styles.penThin();
	}

	public PenBuilder pen1Point() {
		return Styles.pen1Point();
	}

	public PenBuilder pen2Point() {
		return Styles.pen2Point();
	}

	public PenBuilder penDotted() {
		return Styles.penDotted();
	}

	public PenBuilder penDashed() {
		return Styles.penDashed();
	}

	public PenBuilder penDouble() {
		return Styles.penDouble();
	}

	// border
	public BorderBuilder border() {
		return Styles.border();
	}

	public BorderBuilder border(PenBuilder pen) {
		return Styles.border(pen);
	}

	// padding
	public PaddingBuilder padding() {
		return Styles.padding();
	}

	public PaddingBuilder padding(int padding) {
		return Styles.padding(padding);
	}

	// style
	public StyleBuilder style() {
		return Styles.style();
	}

	public StyleBuilder style(ReportStyleBuilder parentStyle) {
		return Styles.style(parentStyle);
	}

	public StyleBuilder style(FontBuilder font) {
		return Styles.style(font);
	}

	public StyleBuilder style(PenBuilder borderPen) {
		return Styles.style(borderPen);
	}

	public StyleBuilder style(Integer padding) {
		return Styles.style(padding);
	}

	public SimpleStyleBuilder simpleStyle() {
		return Styles.simpleStyle();
	}

	public TemplateStyleBuilder templateStyle(String name) {
		return Styles.templateStyle(name);
	}

	public ConditionalStyleBuilder conditionalStyle(DRIExpression<Boolean> conditionExpression) {
		return Styles.conditionalStyle(conditionExpression);
	}

	public TemplateStylesBuilder templateStyles() {
		return Styles.templateStyles();
	}

	public TemplateStylesBuilder loadStyles(InputStream inputStream) {
		return Styles.loadStyles(inputStream);
	}

	public TemplateStylesBuilder loadStyles(File file) {
		return Styles.loadStyles(file);
	}

	public TemplateStylesBuilder loadStyles(String fileName) throws DRException {
		return Styles.loadStyles(fileName);
	}

	public TemplateStylesBuilder loadStyles(URL url) {
		return Styles.loadStyles(url);
	}
}
