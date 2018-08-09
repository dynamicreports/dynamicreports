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
 * @version $Id: $Id
 */
public class StyleBuilders {

	// font
	/**
	 * <p>font.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 */
	public FontBuilder font() {
		return Styles.font();
	}

	/**
	 * <p>font.</p>
	 *
	 * @param fontName a {@link java.lang.String} object.
	 * @param bold a boolean.
	 * @param italic a boolean.
	 * @param fontSize a int.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 */
	public FontBuilder font(String fontName, boolean bold, boolean italic, int fontSize) {
		return Styles.font(fontName, bold, italic, fontSize);
	}

	/**
	 * <p>fontArial.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 */
	public FontBuilder fontArial() {
		return Styles.fontArial();
	}

	/**
	 * <p>fontArialBold.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 */
	public FontBuilder fontArialBold() {
		return Styles.fontArialBold();
	}

	/**
	 * <p>fontTimesNewRoman.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 */
	public FontBuilder fontTimesNewRoman() {
		return Styles.fontTimesNewRoman();
	}

	/**
	 * <p>fontTimesNewRomanBold.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 */
	public FontBuilder fontTimesNewRomanBold() {
		return Styles.fontTimesNewRomanBold();
	}

	/**
	 * <p>fontCourierNew.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 */
	public FontBuilder fontCourierNew() {
		return Styles.fontCourierNew();
	}

	/**
	 * <p>fontCourierNewBold.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 */
	public FontBuilder fontCourierNewBold() {
		return Styles.fontCourierNewBold();
	}

	// pen
	/**
	 * <p>pen.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
	 */
	public PenBuilder pen() {
		return Styles.pen();
	}

	/**
	 * <p>pen.</p>
	 *
	 * @param lineWidth a {@link java.lang.Float} object.
	 * @param lineStyle a {@link net.sf.dynamicreports.report.constant.LineStyle} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
	 */
	public PenBuilder pen(Float lineWidth, LineStyle lineStyle) {
		return Styles.pen(lineWidth, lineStyle);
	}

	/**
	 * <p>penThin.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
	 */
	public PenBuilder penThin() {
		return Styles.penThin();
	}

	/**
	 * <p>pen1Point.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
	 */
	public PenBuilder pen1Point() {
		return Styles.pen1Point();
	}

	/**
	 * <p>pen2Point.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
	 */
	public PenBuilder pen2Point() {
		return Styles.pen2Point();
	}

	/**
	 * <p>penDotted.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
	 */
	public PenBuilder penDotted() {
		return Styles.penDotted();
	}

	/**
	 * <p>penDashed.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
	 */
	public PenBuilder penDashed() {
		return Styles.penDashed();
	}

	/**
	 * <p>penDouble.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
	 */
	public PenBuilder penDouble() {
		return Styles.penDouble();
	}

	// border
	/**
	 * <p>border.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.BorderBuilder} object.
	 */
	public BorderBuilder border() {
		return Styles.border();
	}

	/**
	 * <p>border.</p>
	 *
	 * @param pen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.BorderBuilder} object.
	 */
	public BorderBuilder border(PenBuilder pen) {
		return Styles.border(pen);
	}

	// padding
	/**
	 * <p>padding.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.PaddingBuilder} object.
	 */
	public PaddingBuilder padding() {
		return Styles.padding();
	}

	/**
	 * <p>padding.</p>
	 *
	 * @param padding a int.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.PaddingBuilder} object.
	 */
	public PaddingBuilder padding(int padding) {
		return Styles.padding(padding);
	}

	// style
	/**
	 * <p>style.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
	 */
	public StyleBuilder style() {
		return Styles.style();
	}

	/**
	 * <p>style.</p>
	 *
	 * @param parentStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
	 */
	public StyleBuilder style(ReportStyleBuilder parentStyle) {
		return Styles.style(parentStyle);
	}

	/**
	 * <p>style.</p>
	 *
	 * @param font a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
	 */
	public StyleBuilder style(FontBuilder font) {
		return Styles.style(font);
	}

	/**
	 * <p>style.</p>
	 *
	 * @param borderPen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
	 */
	public StyleBuilder style(PenBuilder borderPen) {
		return Styles.style(borderPen);
	}

	/**
	 * <p>style.</p>
	 *
	 * @param padding a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
	 */
	public StyleBuilder style(Integer padding) {
		return Styles.style(padding);
	}

	/**
	 * <p>simpleStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder} object.
	 */
	public SimpleStyleBuilder simpleStyle() {
		return Styles.simpleStyle();
	}

	/**
	 * <p>templateStyle.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStyleBuilder} object.
	 */
	public TemplateStyleBuilder templateStyle(String name) {
		return Styles.templateStyle(name);
	}

	/**
	 * <p>conditionalStyle.</p>
	 *
	 * @param conditionExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.ConditionalStyleBuilder} object.
	 */
	public ConditionalStyleBuilder conditionalStyle(DRIExpression<Boolean> conditionExpression) {
		return Styles.conditionalStyle(conditionExpression);
	}

	/**
	 * <p>templateStyles.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
	 */
	public TemplateStylesBuilder templateStyles() {
		return Styles.templateStyles();
	}

	/**
	 * <p>loadStyles.</p>
	 *
	 * @param inputStream a {@link java.io.InputStream} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
	 */
	public TemplateStylesBuilder loadStyles(InputStream inputStream) {
		return Styles.loadStyles(inputStream);
	}

	/**
	 * <p>loadStyles.</p>
	 *
	 * @param file a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
	 */
	public TemplateStylesBuilder loadStyles(File file) {
		return Styles.loadStyles(file);
	}

	/**
	 * <p>loadStyles.</p>
	 *
	 * @param fileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public TemplateStylesBuilder loadStyles(String fileName) throws DRException {
		return Styles.loadStyles(fileName);
	}

	/**
	 * <p>loadStyles.</p>
	 *
	 * @param url a {@link java.net.URL} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
	 */
	public TemplateStylesBuilder loadStyles(URL url) {
		return Styles.loadStyles(url);
	}
}
