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

package net.sf.dynamicreports.report.builder.component;

import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import org.apache.commons.lang3.Validate;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.BreakType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.renderers.Renderable;

/**
 * A set of methods of creating components
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Components {

	// horizontal list
	public static HorizontalListBuilder horizontalList() {
		return new HorizontalListBuilder();
	}

	public static HorizontalListBuilder horizontalList(ComponentBuilder<?, ?>... components) {
		return new HorizontalListBuilder().add(components);
	}

	public static HorizontalListBuilder horizontalList(HorizontalListCellBuilder... cells) {
		return new HorizontalListBuilder().add(cells);
	}

	public static HorizontalListCellBuilder hListCell(ComponentBuilder<?, ?> component) {
		Validate.notNull(component, "component must not be null");
		return new HorizontalListCellBuilder(component);
	}

	// horizontal flow list
	public static HorizontalListBuilder horizontalFlowList() {
		return new HorizontalFlowListBuilder();
	}

	public static HorizontalListBuilder horizontalFlowList(ComponentBuilder<?, ?>... components) {
		return new HorizontalFlowListBuilder().add(components);
	}

	public static HorizontalListBuilder horizontalFlowList(HorizontalListCellBuilder... cells) {
		return new HorizontalFlowListBuilder().add(cells);
	}

	// vertical list
	public static VerticalListBuilder verticalList() {
		return new VerticalListBuilder();
	}

	public static VerticalListBuilder verticalList(ComponentBuilder<?, ?>... components) {
		return new VerticalListBuilder().add(components);
	}

	public static VerticalListBuilder verticalList(VerticalListCellBuilder... cells) {
		return new VerticalListBuilder().add(cells);
	}

	public static VerticalListCellBuilder vListCell(ComponentBuilder<?, ?> component) {
		Validate.notNull(component, "component must not be null");
		return new VerticalListCellBuilder(component);
	}

	// xy list
	public static XyListBuilder xyList() {
		return new XyListBuilder();
	}

	public static XyListBuilder xyList(XyListCellBuilder... cells) {
		return new XyListBuilder().add(cells);
	}

	public static XyListCellBuilder xyListCell(Integer x, Integer y, ComponentBuilder<?, ?> component) {
		Validate.notNull(component, "component must not be null");
		return new XyListCellBuilder(x, y, component);
	}

	public static XyListCellBuilder xyListCell(Integer x, Integer y, Integer width, Integer height, ComponentBuilder<?, ?> component) {
		Validate.notNull(component, "component must not be null");
		return new XyListCellBuilder(x, y, width, height, component);
	}

	// multi page list
	public static MultiPageListBuilder multiPageList() {
		return new MultiPageListBuilder();
	}

	public static MultiPageListBuilder multiPageList(ComponentBuilder<?, ?>... components) {
		return new MultiPageListBuilder().add(components);
	}

	public static CurrentDateBuilder currentDate() {
		return new CurrentDateBuilder();
	}

	public static PageNumberBuilder pageNumber() {
		return new PageNumberBuilder();
	}

	public static PageXofYBuilder pageXofY() {
		return new PageXofYBuilder();
	}

	public static PageXslashYBuilder pageXslashY() {
		return new PageXslashYBuilder();
	}

	public static TotalPagesBuilder totalPages() {
		return new TotalPagesBuilder();
	}

	// text
	public static TextFieldBuilder<String> text(String text) {
		return new TextFieldBuilder<String>().setText(text);
	}

	public static TextFieldBuilder<Date> text(Date date) {
		return new TextFieldBuilder<Date>().setText(date);
	}

	public static <T extends Number> TextFieldBuilder<T> text(T number) {
		return new TextFieldBuilder<T>().setText(number);
	}

	public static <T> TextFieldBuilder<T> text(FieldBuilder<T> field) {
		return new TextFieldBuilder<T>().setText(field);
	}

	public static <T> TextFieldBuilder<T> text(VariableBuilder<T> variable) {
		return new TextFieldBuilder<T>().setText(variable);
	}

	public static <T> TextFieldBuilder<T> text(DRIExpression<T> textExpression) {
		return new TextFieldBuilder<T>().setText(textExpression);
	}

	// filler
	public static FillerBuilder filler() {
		return new FillerBuilder();
	}

	public static FillerBuilder horizontalGap(int width) {
		return new FillerBuilder().setFixedWidth(width);
	}

	public static FillerBuilder verticalGap(int height) {
		return new FillerBuilder().setFixedHeight(height);
	}

	public static FillerBuilder gap(int width, int height) {
		return new FillerBuilder().setFixedDimension(width, height);
	}

	// image
	public static ImageBuilder image(DRIExpression<?> imageExpression) {
		return new ImageBuilder().setImage(imageExpression);
	}

	public static ImageBuilder image(String imagePath) {
		return new ImageBuilder().setImage(imagePath);
	}

	public static ImageBuilder image(Image image) {
		return new ImageBuilder().setImage(image);
	}

	public static ImageBuilder image(InputStream imageInputStream) {
		return new ImageBuilder().setImage(imageInputStream);
	}

	public static ImageBuilder image(URL imageUrl) {
		return new ImageBuilder().setImage(imageUrl);
	}

	public static ImageBuilder image(Renderable image) {
		return new ImageBuilder().setImage(Expressions.value(image, Renderable.class));
	}

	/**
	 * @deprecated use image(net.sf.jasperreports.renderers.Renderable image) instead
	 */
	@Deprecated
	public static ImageBuilder image(net.sf.jasperreports.engine.Renderable image) {
		return new ImageBuilder().setImage(Expressions.value(image, net.sf.jasperreports.engine.Renderable.class));
	}

	// subreport
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

	public static SubreportBuilder subreport(JasperReport jasperReport) {
		return new SubreportBuilder().setReport(jasperReport);
	}

	public static SubreportBuilder subreport(DRIExpression<?> reportExpression) {
		return new SubreportBuilder().setReport(reportExpression);
	}

	// line
	public static LineBuilder line() {
		return new LineBuilder();
	}

	// break
	public static BreakBuilder pageBreak() {
		return new BreakBuilder().setType(BreakType.PAGE);
	}

	public static BreakBuilder columnBreak() {
		return new BreakBuilder().setType(BreakType.COLUMN);
	}

	// generic element
	public static GenericElementBuilder genericElement(String namespace, String name) {
		return new GenericElementBuilder(namespace, name);
	}

	// boolean
	public static BooleanFieldBuilder booleanField(Boolean value) {
		return new BooleanFieldBuilder().setValue(value);
	}

	public static BooleanFieldBuilder booleanField(FieldBuilder<Boolean> field) {
		return new BooleanFieldBuilder().setValue(field);
	}

	public static BooleanFieldBuilder booleanField(DRIExpression<Boolean> valueExpression) {
		return new BooleanFieldBuilder().setValue(valueExpression);
	}

	// ellipse
	public static EllipseBuilder ellipse() {
		return new EllipseBuilder();
	}

	// rectangle
	public static RectangleBuilder rectangle() {
		return new RectangleBuilder();
	}

	public static RectangleBuilder roundRectangle() {
		return new RectangleBuilder().setRadius(10);
	}

	public static RectangleBuilder roundRectangle(int radius) {
		return new RectangleBuilder().setRadius(radius);
	}

	// map
	public static MapBuilder map() {
		return new MapBuilder();
	}

	public static MapBuilder map(Float latitude, Float longitude, Integer zoom) {
		MapBuilder mapBuilder = new MapBuilder();
		mapBuilder.setLatitude(latitude);
		mapBuilder.setLongitude(longitude);
		mapBuilder.setZoom(zoom);
		return mapBuilder;
	}

	// alignment
	public static HorizontalListBuilder centerHorizontal(ComponentBuilder<?, ?> component) {
		HorizontalListBuilder list = horizontalList();
		list.add(filler().setWidth(1));
		list.add(component);
		list.add(filler().setWidth(1));
		return list;
	}

	public static VerticalListBuilder centerVertical(ComponentBuilder<?, ?> component) {
		VerticalListBuilder list = verticalList();
		list.add(filler().setHeight(1));
		list.add(component);
		list.add(filler().setHeight(1));
		return list;
	}
}
