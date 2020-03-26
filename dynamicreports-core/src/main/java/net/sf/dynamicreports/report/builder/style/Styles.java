/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import net.sf.dynamicreports.report.constant.FontName;
import net.sf.dynamicreports.report.constant.LineStyle;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRException;
import org.apache.commons.lang3.Validate;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * A set of methods of creating and customizing styles
 *
 * @author Ricardo Mariaca
 * 
 */
public class Styles {

    // font

    /**
     * <p>font.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     */
    public static FontBuilder font() {
        return new FontBuilder();
    }

    /**
     * <p>font.</p>
     *
     * @param fontName a {@link java.lang.String} object.
     * @param bold     a boolean.
     * @param italic   a boolean.
     * @param fontSize a int.
     * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     */
    public static FontBuilder font(String fontName, boolean bold, boolean italic, int fontSize) {
        return new FontBuilder(fontName, bold, italic, fontSize);
    }

    /**
     * <p>fontArial.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     */
    public static FontBuilder fontArial() {
        return new FontBuilder(FontName.ARIAL, false, false, 10);
    }

    /**
     * <p>fontArialBold.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     */
    public static FontBuilder fontArialBold() {
        return new FontBuilder(FontName.ARIAL, true, false, 10);
    }

    /**
     * <p>fontTimesNewRoman.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     */
    public static FontBuilder fontTimesNewRoman() {
        return new FontBuilder(FontName.TIMES_NEW_ROMAN, false, false, 10);
    }

    /**
     * <p>fontTimesNewRomanBold.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     */
    public static FontBuilder fontTimesNewRomanBold() {
        return new FontBuilder(FontName.TIMES_NEW_ROMAN, true, false, 10);
    }

    /**
     * <p>fontCourierNew.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     */
    public static FontBuilder fontCourierNew() {
        return new FontBuilder(FontName.COURIER_NEW, false, false, 10);
    }

    /**
     * <p>fontCourierNewBold.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     */
    public static FontBuilder fontCourierNewBold() {
        return new FontBuilder(FontName.COURIER_NEW, true, false, 10);
    }

    // pen

    /**
     * <p>pen.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     */
    public static PenBuilder pen() {
        return new PenBuilder();
    }

    /**
     * <p>pen.</p>
     *
     * @param lineWidth a {@link java.lang.Float} object.
     * @param lineStyle a {@link net.sf.dynamicreports.report.constant.LineStyle} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     */
    public static PenBuilder pen(Float lineWidth, LineStyle lineStyle) {
        return new PenBuilder(lineWidth, lineStyle);
    }

    /**
     * <p>penThin.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     */
    public static PenBuilder penThin() {
        return new PenBuilder(0.5f, LineStyle.SOLID);
    }

    /**
     * <p>pen1Point.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     */
    public static PenBuilder pen1Point() {
        return new PenBuilder(1f, LineStyle.SOLID);
    }

    /**
     * <p>pen2Point.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     */
    public static PenBuilder pen2Point() {
        return new PenBuilder(2f, LineStyle.SOLID);
    }

    /**
     * <p>penDotted.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     */
    public static PenBuilder penDotted() {
        return new PenBuilder(1f, LineStyle.DOTTED);
    }

    /**
     * <p>penDashed.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     */
    public static PenBuilder penDashed() {
        return new PenBuilder(1f, LineStyle.DASHED);
    }

    /**
     * <p>penDouble.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     */
    public static PenBuilder penDouble() {
        return new PenBuilder(1f, LineStyle.DOUBLE);
    }

    // border

    /**
     * <p>border.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.BorderBuilder} object.
     */
    public static BorderBuilder border() {
        return new BorderBuilder();
    }

    /**
     * <p>border.</p>
     *
     * @param pen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.BorderBuilder} object.
     */
    public static BorderBuilder border(PenBuilder pen) {
        Validate.notNull(pen, "pen must not be null");
        return new BorderBuilder(pen);
    }

    // padding

    /**
     * <p>padding.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.PaddingBuilder} object.
     */
    public static PaddingBuilder padding() {
        return new PaddingBuilder();
    }

    /**
     * <p>padding.</p>
     *
     * @param padding a int.
     * @return a {@link net.sf.dynamicreports.report.builder.style.PaddingBuilder} object.
     */
    public static PaddingBuilder padding(int padding) {
        return new PaddingBuilder(padding);
    }

    // style

    /**
     * <p>style.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
     */
    public static StyleBuilder style() {
        return new StyleBuilder();
    }

    /**
     * <p>style.</p>
     *
     * @param parentStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
     */
    public static StyleBuilder style(ReportStyleBuilder parentStyle) {
        return new StyleBuilder().setParentStyle(parentStyle);
    }

    /**
     * <p>style.</p>
     *
     * @param font a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
     */
    public static StyleBuilder style(FontBuilder font) {
        return new StyleBuilder().setFont(font);
    }

    /**
     * <p>style.</p>
     *
     * @param borderPen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
     */
    public static StyleBuilder style(PenBuilder borderPen) {
        return new StyleBuilder().setBorder(borderPen);
    }

    /**
     * <p>style.</p>
     *
     * @param padding a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
     */
    public static StyleBuilder style(Integer padding) {
        return new StyleBuilder().setPadding(padding);
    }

    /**
     * <p>simpleStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder} object.
     */
    public static SimpleStyleBuilder simpleStyle() {
        return new SimpleStyleBuilder();
    }

    /**
     * <p>templateStyle.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStyleBuilder} object.
     */
    public static TemplateStyleBuilder templateStyle(String name) {
        return new TemplateStyleBuilder(name);
    }

    /**
     * <p>conditionalStyle.</p>
     *
     * @param conditionExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.ConditionalStyleBuilder} object.
     */
    public static ConditionalStyleBuilder conditionalStyle(DRIExpression<Boolean> conditionExpression) {
        return new ConditionalStyleBuilder(conditionExpression);
    }

    /**
     * <p>templateStyles.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     */
    public static TemplateStylesBuilder templateStyles() {
        return new TemplateStylesBuilder();
    }

    /**
     * <p>loadStyles.</p>
     *
     * @param inputStream a {@link java.io.InputStream} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     */
    public static TemplateStylesBuilder loadStyles(InputStream inputStream) {
        return new TemplateStylesBuilder().loadStyles(inputStream);
    }

    /**
     * <p>loadStyles.</p>
     *
     * @param file a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     */
    public static TemplateStylesBuilder loadStyles(File file) {
        return new TemplateStylesBuilder().loadStyles(file);
    }

    /**
     * <p>loadStyles.</p>
     *
     * @param fileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public static TemplateStylesBuilder loadStyles(String fileName) throws DRException {
        return new TemplateStylesBuilder().loadStyles(fileName);
    }

    /**
     * <p>loadStyles.</p>
     *
     * @param url a {@link java.net.URL} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
     */
    public static TemplateStylesBuilder loadStyles(URL url) {
        return new TemplateStylesBuilder().loadStyles(url);
    }
}
