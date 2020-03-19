/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.renderers.Renderable;

import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * A set of methods of creating components
 *
 * @author Ricardo Mariaca
 * 
 */
public class ComponentBuilders {

    // horizontal list

    /**
     * <p>horizontalList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public HorizontalListBuilder horizontalList() {
        return Components.horizontalList();
    }

    /**
     * <p>horizontalList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public HorizontalListBuilder horizontalList(ComponentBuilder<?, ?>... components) {
        return Components.horizontalList(components);
    }

    /**
     * <p>horizontalList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public HorizontalListBuilder horizontalList(HorizontalListCellBuilder... cells) {
        return Components.horizontalList(cells);
    }

    /**
     * <p>hListCell.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     */
    public HorizontalListCellBuilder hListCell(ComponentBuilder<?, ?> component) {
        return Components.hListCell(component);
    }

    // horizontal flow list

    /**
     * <p>horizontalFlowList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public HorizontalListBuilder horizontalFlowList() {
        return Components.horizontalFlowList();
    }

    /**
     * <p>horizontalFlowList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public HorizontalListBuilder horizontalFlowList(ComponentBuilder<?, ?>... components) {
        return Components.horizontalFlowList(components);
    }

    /**
     * <p>horizontalFlowList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public HorizontalListBuilder horizontalFlowList(HorizontalListCellBuilder... cells) {
        return Components.horizontalFlowList(cells);
    }

    // vertical list

    /**
     * <p>verticalList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListBuilder} object.
     */
    public VerticalListBuilder verticalList() {
        return Components.verticalList();
    }

    /**
     * <p>verticalList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListBuilder} object.
     */
    public VerticalListBuilder verticalList(ComponentBuilder<?, ?>... components) {
        return Components.verticalList(components);
    }

    /**
     * <p>verticalList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListBuilder} object.
     */
    public VerticalListBuilder verticalList(VerticalListCellBuilder... cells) {
        return Components.verticalList(cells);
    }

    /**
     * <p>vListCell.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     */
    public VerticalListCellBuilder vListCell(ComponentBuilder<?, ?> component) {
        return Components.vListCell(component);
    }

    // xy list

    /**
     * <p>xyList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListBuilder} object.
     */
    public XyListBuilder xyList() {
        return Components.xyList();
    }

    /**
     * <p>xyList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.component.XyListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListBuilder} object.
     */
    public XyListBuilder xyList(XyListCellBuilder... cells) {
        return Components.xyList(cells);
    }

    /**
     * <p>xyListCell.</p>
     *
     * @param x         a {@link java.lang.Integer} object.
     * @param y         a {@link java.lang.Integer} object.
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListCellBuilder} object.
     */
    public XyListCellBuilder xyListCell(Integer x, Integer y, ComponentBuilder<?, ?> component) {
        return Components.xyListCell(x, y, component);
    }

    /**
     * <p>xyListCell.</p>
     *
     * @param x         a {@link java.lang.Integer} object.
     * @param y         a {@link java.lang.Integer} object.
     * @param width     a {@link java.lang.Integer} object.
     * @param height    a {@link java.lang.Integer} object.
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListCellBuilder} object.
     */
    public XyListCellBuilder xyListCell(Integer x, Integer y, Integer width, Integer height, ComponentBuilder<?, ?> component) {
        return Components.xyListCell(x, y, width, height, component);
    }

    // multi page list

    /**
     * <p>multiPageList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.MultiPageListBuilder} object.
     */
    public MultiPageListBuilder multiPageList() {
        return Components.multiPageList();
    }

    /**
     * <p>multiPageList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.MultiPageListBuilder} object.
     */
    public MultiPageListBuilder multiPageList(ComponentBuilder<?, ?>... components) {
        return Components.multiPageList(components);
    }

    /**
     * <p>currentDate.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.CurrentDateBuilder} object.
     */
    public CurrentDateBuilder currentDate() {
        return Components.currentDate();
    }

    /**
     * <p>pageNumber.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.PageNumberBuilder} object.
     */
    public PageNumberBuilder pageNumber() {
        return Components.pageNumber();
    }

    /**
     * <p>pageXofY.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.PageXofYBuilder} object.
     */
    public PageXofYBuilder pageXofY() {
        return Components.pageXofY();
    }

    /**
     * <p>pageXslashY.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.PageXslashYBuilder} object.
     */
    public PageXslashYBuilder pageXslashY() {
        return Components.pageXslashY();
    }

    /**
     * <p>totalPages.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.TotalPagesBuilder} object.
     */
    public TotalPagesBuilder totalPages() {
        return Components.totalPages();
    }

    // text

    /**
     * <p>text.</p>
     *
     * @param text a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<String> text(String text) {
        return Components.text(text);
    }

    /**
     * <p>text.</p>
     *
     * @param date a {@link java.util.Date} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<Date> text(Date date) {
        return Components.text(date);
    }

    /**
     * <p>text.</p>
     *
     * @param number a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public <T extends Number> TextFieldBuilder<T> text(T number) {
        return Components.text(number);
    }

    /**
     * <p>text.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @param <T>   a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public <T> TextFieldBuilder<T> text(FieldBuilder<T> field) {
        return Components.text(field);
    }

    /**
     * <p>text.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @param <T>      a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public <T> TextFieldBuilder<T> text(VariableBuilder<T> variable) {
        return Components.text(variable);
    }

    /**
     * <p>text.</p>
     *
     * @param textExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param <T>            a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public <T> TextFieldBuilder<T> text(DRIExpression<T> textExpression) {
        return Components.text(textExpression);
    }

    // filler

    /**
     * <p>filler.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.FillerBuilder} object.
     */
    public FillerBuilder filler() {
        return Components.filler();
    }

    /**
     * <p>horizontalGap.</p>
     *
     * @param width a int.
     * @return a {@link net.sf.dynamicreports.report.builder.component.FillerBuilder} object.
     */
    public FillerBuilder horizontalGap(int width) {
        return Components.horizontalGap(width);
    }

    /**
     * <p>verticalGap.</p>
     *
     * @param height a int.
     * @return a {@link net.sf.dynamicreports.report.builder.component.FillerBuilder} object.
     */
    public FillerBuilder verticalGap(int height) {
        return Components.verticalGap(height);
    }

    /**
     * <p>gap.</p>
     *
     * @param width  a int.
     * @param height a int.
     * @return a {@link net.sf.dynamicreports.report.builder.component.FillerBuilder} object.
     */
    public FillerBuilder gap(int width, int height) {
        return Components.gap(width, height);
    }

    // image

    /**
     * <p>image.</p>
     *
     * @param imageExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public ImageBuilder image(DRIExpression<?> imageExpression) {
        return Components.image(imageExpression);
    }

    /**
     * <p>image.</p>
     *
     * @param imagePath a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public ImageBuilder image(String imagePath) {
        return Components.image(imagePath);
    }

    /**
     * <p>image.</p>
     *
     * @param image a {@link java.awt.Image} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public ImageBuilder image(Image image) {
        return Components.image(image);
    }

    /**
     * <p>image.</p>
     *
     * @param imageInputStream a {@link java.io.InputStream} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public ImageBuilder image(InputStream imageInputStream) {
        return Components.image(imageInputStream);
    }

    /**
     * <p>image.</p>
     *
     * @param imageUrl a {@link java.net.URL} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public ImageBuilder image(URL imageUrl) {
        return Components.image(imageUrl);
    }

    /**
     * <p>image.</p>
     *
     * @param image a {@link net.sf.jasperreports.renderers.Renderable} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public ImageBuilder image(Renderable image) {
        return Components.image(image);
    }

    /**
     * <p>image.</p>
     *
     * @param image a {@link net.sf.jasperreports.engine.Renderable} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     * @deprecated use image(net.sf.jasperreports.renderers.Renderable image) instead
     */
    @Deprecated
    public ImageBuilder image(net.sf.jasperreports.engine.Renderable image) {
        return Components.image(image);
    }

    // subreport

    /**
     * <p>subreport.</p>
     *
     * @param reportBuilder a {@link net.sf.dynamicreports.jasper.builder.JasperReportBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder subreport(JasperReportBuilder reportBuilder) {
        return Components.subreport(reportBuilder);
    }

    /**
     * <p>subreport.</p>
     *
     * @param jasperReport a {@link net.sf.jasperreports.engine.JasperReport} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder subreport(JasperReport jasperReport) {
        return Components.subreport(jasperReport);
    }

    /**
     * <p>subreport.</p>
     *
     * @param reportExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder subreport(DRIExpression<?> reportExpression) {
        return Components.subreport(reportExpression);
    }

    // line

    /**
     * <p>line.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.LineBuilder} object.
     */
    public LineBuilder line() {
        return Components.line();
    }

    // break

    /**
     * <p>pageBreak.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.BreakBuilder} object.
     */
    public BreakBuilder pageBreak() {
        return Components.pageBreak();
    }

    /**
     * <p>columnBreak.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.BreakBuilder} object.
     */
    public BreakBuilder columnBreak() {
        return Components.columnBreak();
    }

    // generic element

    /**
     * <p>genericElement.</p>
     *
     * @param namespace a {@link java.lang.String} object.
     * @param namespace a {@link java.lang.String} object.
     * @param name      a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.GenericElementBuilder} object.
     */
    public GenericElementBuilder genericElement(String namespace, String name) {
        return Components.genericElement(namespace, name);
    }

    // boolean

    /**
     * <p>booleanField.</p>
     *
     * @param value a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.BooleanFieldBuilder} object.
     */
    public BooleanFieldBuilder booleanField(Boolean value) {
        return Components.booleanField(value);
    }

    /**
     * <p>booleanField.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.BooleanFieldBuilder} object.
     */
    public BooleanFieldBuilder booleanField(FieldBuilder<Boolean> field) {
        return Components.booleanField(field);
    }

    /**
     * <p>booleanField.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.BooleanFieldBuilder} object.
     */
    public BooleanFieldBuilder booleanField(DRIExpression<Boolean> valueExpression) {
        return Components.booleanField(valueExpression);
    }

    // ellipse

    /**
     * <p>ellipse.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.EllipseBuilder} object.
     */
    public EllipseBuilder ellipse() {
        return Components.ellipse();
    }

    // rectangle

    /**
     * <p>rectangle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.RectangleBuilder} object.
     */
    public RectangleBuilder rectangle() {
        return Components.rectangle();
    }

    /**
     * <p>roundRectangle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.RectangleBuilder} object.
     */
    public RectangleBuilder roundRectangle() {
        return Components.roundRectangle();
    }

    /**
     * <p>roundRectangle.</p>
     *
     * @param radius a int.
     * @return a {@link net.sf.dynamicreports.report.builder.component.RectangleBuilder} object.
     */
    public RectangleBuilder roundRectangle(int radius) {
        return Components.roundRectangle(radius);
    }

    // map

    /**
     * <p>map.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.MapBuilder} object.
     */
    public MapBuilder map() {
        return Components.map();
    }

    /**
     * <p>map.</p>
     *
     * @param latitude  a {@link java.lang.Float} object.
     * @param longitude a {@link java.lang.Float} object.
     * @param zoom      a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.MapBuilder} object.
     */
    public MapBuilder map(Float latitude, Float longitude, Integer zoom) {
        return Components.map(latitude, longitude, zoom);
    }

    // alignment

    /**
     * <p>centerHorizontal.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public HorizontalListBuilder centerHorizontal(ComponentBuilder<?, ?> component) {
        return Components.centerHorizontal(component);
    }

    /**
     * <p>centerVertical.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListBuilder} object.
     */
    public VerticalListBuilder centerVertical(ComponentBuilder<?, ?> component) {
        return Components.centerVertical(component);
    }
}
