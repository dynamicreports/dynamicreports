/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.BreakType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.renderers.Renderable;
import org.apache.commons.lang3.Validate;

import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * A set of methods of creating components
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class Components {

    // horizontal list

    /**
     * <p>horizontalList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public static HorizontalListBuilder horizontalList() {
        return new HorizontalListBuilder();
    }

    /**
     * <p>horizontalList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public static HorizontalListBuilder horizontalList(ComponentBuilder<?, ?>... components) {
        return new HorizontalListBuilder().add(components);
    }

    /**
     * <p>horizontalList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public static HorizontalListBuilder horizontalList(HorizontalListCellBuilder... cells) {
        return new HorizontalListBuilder().add(cells);
    }

    /**
     * <p>hListCell.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     */
    public static HorizontalListCellBuilder hListCell(ComponentBuilder<?, ?> component) {
        Validate.notNull(component, "component must not be null");
        return new HorizontalListCellBuilder(component);
    }

    // horizontal flow list

    /**
     * <p>horizontalFlowList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public static HorizontalListBuilder horizontalFlowList() {
        return new HorizontalFlowListBuilder();
    }

    /**
     * <p>horizontalFlowList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public static HorizontalListBuilder horizontalFlowList(ComponentBuilder<?, ?>... components) {
        return new HorizontalFlowListBuilder().add(components);
    }

    /**
     * <p>horizontalFlowList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public static HorizontalListBuilder horizontalFlowList(HorizontalListCellBuilder... cells) {
        return new HorizontalFlowListBuilder().add(cells);
    }

    // vertical list

    /**
     * <p>verticalList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListBuilder} object.
     */
    public static VerticalListBuilder verticalList() {
        return new VerticalListBuilder();
    }

    /**
     * <p>verticalList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListBuilder} object.
     */
    public static VerticalListBuilder verticalList(ComponentBuilder<?, ?>... components) {
        return new VerticalListBuilder().add(components);
    }

    /**
     * <p>verticalList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListBuilder} object.
     */
    public static VerticalListBuilder verticalList(VerticalListCellBuilder... cells) {
        return new VerticalListBuilder().add(cells);
    }

    /**
     * <p>vListCell.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     */
    public static VerticalListCellBuilder vListCell(ComponentBuilder<?, ?> component) {
        Validate.notNull(component, "component must not be null");
        return new VerticalListCellBuilder(component);
    }

    // xy list

    /**
     * <p>xyList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListBuilder} object.
     */
    public static XyListBuilder xyList() {
        return new XyListBuilder();
    }

    /**
     * <p>xyList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.component.XyListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListBuilder} object.
     */
    public static XyListBuilder xyList(XyListCellBuilder... cells) {
        return new XyListBuilder().add(cells);
    }

    /**
     * <p>xyListCell.</p>
     *
     * @param x a {@link java.lang.Integer} object.
     * @param y a {@link java.lang.Integer} object.
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListCellBuilder} object.
     */
    public static XyListCellBuilder xyListCell(Integer x, Integer y, ComponentBuilder<?, ?> component) {
        Validate.notNull(component, "component must not be null");
        return new XyListCellBuilder(x, y, component);
    }

    /**
     * <p>xyListCell.</p>
     *
     * @param x a {@link java.lang.Integer} object.
     * @param y a {@link java.lang.Integer} object.
     * @param width a {@link java.lang.Integer} object.
     * @param height a {@link java.lang.Integer} object.
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListCellBuilder} object.
     */
    public static XyListCellBuilder xyListCell(Integer x, Integer y, Integer width, Integer height, ComponentBuilder<?, ?> component) {
        Validate.notNull(component, "component must not be null");
        return new XyListCellBuilder(x, y, width, height, component);
    }

    // multi page list

    /**
     * <p>multiPageList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.MultiPageListBuilder} object.
     */
    public static MultiPageListBuilder multiPageList() {
        return new MultiPageListBuilder();
    }

    /**
     * <p>multiPageList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.MultiPageListBuilder} object.
     */
    public static MultiPageListBuilder multiPageList(ComponentBuilder<?, ?>... components) {
        return new MultiPageListBuilder().add(components);
    }

    /**
     * <p>currentDate.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.CurrentDateBuilder} object.
     */
    public static CurrentDateBuilder currentDate() {
        return new CurrentDateBuilder();
    }

    /**
     * <p>pageNumber.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.PageNumberBuilder} object.
     */
    public static PageNumberBuilder pageNumber() {
        return new PageNumberBuilder();
    }

    /**
     * <p>pageXofY.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.PageXofYBuilder} object.
     */
    public static PageXofYBuilder pageXofY() {
        return new PageXofYBuilder();
    }

    /**
     * <p>pageXslashY.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.PageXslashYBuilder} object.
     */
    public static PageXslashYBuilder pageXslashY() {
        return new PageXslashYBuilder();
    }

    /**
     * <p>totalPages.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.TotalPagesBuilder} object.
     */
    public static TotalPagesBuilder totalPages() {
        return new TotalPagesBuilder();
    }

    // text

    /**
     * <p>text.</p>
     *
     * @param text a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public static TextFieldBuilder<String> text(String text) {
        return new TextFieldBuilder<String>().setText(text);
    }

    /**
     * <p>text.</p>
     *
     * @param date a {@link java.util.Date} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public static TextFieldBuilder<Date> text(Date date) {
        return new TextFieldBuilder<Date>().setText(date);
    }

    /**
     * <p>text.</p>
     *
     * @param number a T object.
     * @param <T> a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public static <T extends Number> TextFieldBuilder<T> text(T number) {
        return new TextFieldBuilder<T>().setText(number);
    }

    /**
     * <p>text.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @param <T> a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public static <T> TextFieldBuilder<T> text(FieldBuilder<T> field) {
        return new TextFieldBuilder<T>().setText(field);
    }

    /**
     * <p>text.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @param <T> a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public static <T> TextFieldBuilder<T> text(VariableBuilder<T> variable) {
        return new TextFieldBuilder<T>().setText(variable);
    }

    /**
     * <p>text.</p>
     *
     * @param textExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param <T> a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public static <T> TextFieldBuilder<T> text(DRIExpression<T> textExpression) {
        return new TextFieldBuilder<T>().setText(textExpression);
    }

    // filler

    /**
     * <p>filler.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.FillerBuilder} object.
     */
    public static FillerBuilder filler() {
        return new FillerBuilder();
    }

    /**
     * <p>horizontalGap.</p>
     *
     * @param width a int.
     * @return a {@link net.sf.dynamicreports.report.builder.component.FillerBuilder} object.
     */
    public static FillerBuilder horizontalGap(int width) {
        return new FillerBuilder().setFixedWidth(width);
    }

    /**
     * <p>verticalGap.</p>
     *
     * @param height a int.
     * @return a {@link net.sf.dynamicreports.report.builder.component.FillerBuilder} object.
     */
    public static FillerBuilder verticalGap(int height) {
        return new FillerBuilder().setFixedHeight(height);
    }

    /**
     * <p>gap.</p>
     *
     * @param width a int.
     * @param height a int.
     * @return a {@link net.sf.dynamicreports.report.builder.component.FillerBuilder} object.
     */
    public static FillerBuilder gap(int width, int height) {
        return new FillerBuilder().setFixedDimension(width, height);
    }

    // image

    /**
     * <p>image.</p>
     *
     * @param imageExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public static ImageBuilder image(DRIExpression<?> imageExpression) {
        return new ImageBuilder().setImage(imageExpression);
    }

    /**
     * <p>image.</p>
     *
     * @param imagePath a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public static ImageBuilder image(String imagePath) {
        return new ImageBuilder().setImage(imagePath);
    }

    /**
     * <p>image.</p>
     *
     * @param image a {@link java.awt.Image} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public static ImageBuilder image(Image image) {
        return new ImageBuilder().setImage(image);
    }

    /**
     * <p>image.</p>
     *
     * @param imageInputStream a {@link java.io.InputStream} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public static ImageBuilder image(InputStream imageInputStream) {
        return new ImageBuilder().setImage(imageInputStream);
    }

    /**
     * <p>image.</p>
     *
     * @param imageUrl a {@link java.net.URL} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public static ImageBuilder image(URL imageUrl) {
        return new ImageBuilder().setImage(imageUrl);
    }

    /**
     * <p>image.</p>
     *
     * @param image a {@link net.sf.jasperreports.renderers.Renderable} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    public static ImageBuilder image(Renderable image) {
        return new ImageBuilder().setImage(Expressions.value(image, Renderable.class));
    }

    /**
     * <p>image.</p>
     *
     * @deprecated use image(net.sf.jasperreports.renderers.Renderable image) instead
     * @param image a {@link net.sf.jasperreports.engine.Renderable} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.ImageBuilder} object.
     */
    @Deprecated
    public static ImageBuilder image(net.sf.jasperreports.engine.Renderable image) {
        return new ImageBuilder().setImage(Expressions.value(image, net.sf.jasperreports.engine.Renderable.class));
    }

    // subreport

    /**
     * <p>subreport.</p>
     *
     * @param reportBuilder a {@link net.sf.dynamicreports.jasper.builder.JasperReportBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public static SubreportBuilder subreport(JasperReportBuilder reportBuilder) {
        SubreportBuilder subreport = new SubreportBuilder();
        subreport.setReport(reportBuilder);
        if (reportBuilder.getConnection() != null) {
            subreport.setConnection(reportBuilder.getConnection());
        }
        if (reportBuilder.getDataSource() != null) {
            subreport.setDataSource(reportBuilder.getDataSource());
        }
        return subreport;
    }

    /**
     * <p>subreport.</p>
     *
     * @param jasperReport a {@link net.sf.jasperreports.engine.JasperReport} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public static SubreportBuilder subreport(JasperReport jasperReport) {
        return new SubreportBuilder().setReport(jasperReport);
    }

    /**
     * <p>subreport.</p>
     *
     * @param reportExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public static SubreportBuilder subreport(DRIExpression<?> reportExpression) {
        return new SubreportBuilder().setReport(reportExpression);
    }

    // line

    /**
     * <p>line.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.LineBuilder} object.
     */
    public static LineBuilder line() {
        return new LineBuilder();
    }

    // break

    /**
     * <p>pageBreak.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.BreakBuilder} object.
     */
    public static BreakBuilder pageBreak() {
        return new BreakBuilder().setType(BreakType.PAGE);
    }

    /**
     * <p>columnBreak.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.BreakBuilder} object.
     */
    public static BreakBuilder columnBreak() {
        return new BreakBuilder().setType(BreakType.COLUMN);
    }

    // generic element

    /**
     * <p>genericElement.</p>
     *
     * @param namespace a {@link java.lang.String} object.
     * @param name a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.GenericElementBuilder} object.
     */
    public static GenericElementBuilder genericElement(String namespace, String name) {
        return new GenericElementBuilder(namespace, name);
    }

    // boolean

    /**
     * <p>booleanField.</p>
     *
     * @param value a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.BooleanFieldBuilder} object.
     */
    public static BooleanFieldBuilder booleanField(Boolean value) {
        return new BooleanFieldBuilder().setValue(value);
    }

    /**
     * <p>booleanField.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.BooleanFieldBuilder} object.
     */
    public static BooleanFieldBuilder booleanField(FieldBuilder<Boolean> field) {
        return new BooleanFieldBuilder().setValue(field);
    }

    /**
     * <p>booleanField.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.BooleanFieldBuilder} object.
     */
    public static BooleanFieldBuilder booleanField(DRIExpression<Boolean> valueExpression) {
        return new BooleanFieldBuilder().setValue(valueExpression);
    }

    // ellipse

    /**
     * <p>ellipse.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.EllipseBuilder} object.
     */
    public static EllipseBuilder ellipse() {
        return new EllipseBuilder();
    }

    // rectangle

    /**
     * <p>rectangle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.RectangleBuilder} object.
     */
    public static RectangleBuilder rectangle() {
        return new RectangleBuilder();
    }

    /**
     * <p>roundRectangle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.RectangleBuilder} object.
     */
    public static RectangleBuilder roundRectangle() {
        return new RectangleBuilder().setRadius(10);
    }

    /**
     * <p>roundRectangle.</p>
     *
     * @param radius a int.
     * @return a {@link net.sf.dynamicreports.report.builder.component.RectangleBuilder} object.
     */
    public static RectangleBuilder roundRectangle(int radius) {
        return new RectangleBuilder().setRadius(radius);
    }

    // map

    /**
     * <p>map.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.MapBuilder} object.
     */
    public static MapBuilder map() {
        return new MapBuilder();
    }

    /**
     * <p>map.</p>
     *
     * @param latitude a {@link java.lang.Float} object.
     * @param longitude a {@link java.lang.Float} object.
     * @param zoom a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.MapBuilder} object.
     */
    public static MapBuilder map(Float latitude, Float longitude, Integer zoom) {
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.setLatitude(latitude);
        mapBuilder.setLongitude(longitude);
        mapBuilder.setZoom(zoom);
        return mapBuilder;
    }

    // alignment

    /**
     * <p>centerHorizontal.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListBuilder} object.
     */
    public static HorizontalListBuilder centerHorizontal(ComponentBuilder<?, ?> component) {
        HorizontalListBuilder list = horizontalList();
        list.add(filler().setWidth(1));
        list.add(component);
        list.add(filler().setWidth(1));
        return list;
    }

    /**
     * <p>centerVertical.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListBuilder} object.
     */
    public static VerticalListBuilder centerVertical(ComponentBuilder<?, ?> component) {
        VerticalListBuilder list = verticalList();
        list.add(filler().setHeight(1));
        list.add(component);
        list.add(filler().setHeight(1));
        return list;
    }
}
