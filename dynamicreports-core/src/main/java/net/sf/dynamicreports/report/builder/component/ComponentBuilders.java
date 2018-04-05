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

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.renderers.Renderable;

/**
 * A set of methods of creating components
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ComponentBuilders {

	// horizontal list
	public HorizontalListBuilder horizontalList() {
		return Components.horizontalList();
	}

	public HorizontalListBuilder horizontalList(ComponentBuilder<?, ?>... components) {
		return Components.horizontalList(components);
	}

	public HorizontalListBuilder horizontalList(HorizontalListCellBuilder... cells) {
		return Components.horizontalList(cells);
	}

	public HorizontalListCellBuilder hListCell(ComponentBuilder<?, ?> component) {
		return Components.hListCell(component);
	}

	// horizontal flow list
	public HorizontalListBuilder horizontalFlowList() {
		return Components.horizontalFlowList();
	}

	public HorizontalListBuilder horizontalFlowList(ComponentBuilder<?, ?>... components) {
		return Components.horizontalFlowList(components);
	}

	public HorizontalListBuilder horizontalFlowList(HorizontalListCellBuilder... cells) {
		return Components.horizontalFlowList(cells);
	}

	// vertical list
	public VerticalListBuilder verticalList() {
		return Components.verticalList();
	}

	public VerticalListBuilder verticalList(ComponentBuilder<?, ?>... components) {
		return Components.verticalList(components);
	}

	public VerticalListBuilder verticalList(VerticalListCellBuilder... cells) {
		return Components.verticalList(cells);
	}

	public VerticalListCellBuilder vListCell(ComponentBuilder<?, ?> component) {
		return Components.vListCell(component);
	}

	// xy list
	public XyListBuilder xyList() {
		return Components.xyList();
	}

	public XyListBuilder xyList(XyListCellBuilder... cells) {
		return Components.xyList(cells);
	}

	public XyListCellBuilder xyListCell(Integer x, Integer y, ComponentBuilder<?, ?> component) {
		return Components.xyListCell(x, y, component);
	}

	public XyListCellBuilder xyListCell(Integer x, Integer y, Integer width, Integer height, ComponentBuilder<?, ?> component) {
		return Components.xyListCell(x, y, width, height, component);
	}

	// multi page list
	public MultiPageListBuilder multiPageList() {
		return Components.multiPageList();
	}

	public MultiPageListBuilder multiPageList(ComponentBuilder<?, ?>... components) {
		return Components.multiPageList(components);
	}

	public CurrentDateBuilder currentDate() {
		return Components.currentDate();
	}

	public PageNumberBuilder pageNumber() {
		return Components.pageNumber();
	}

	public PageXofYBuilder pageXofY() {
		return Components.pageXofY();
	}

	public PageXslashYBuilder pageXslashY() {
		return Components.pageXslashY();
	}

	public TotalPagesBuilder totalPages() {
		return Components.totalPages();
	}

	// text
	public TextFieldBuilder<String> text(String text) {
		return Components.text(text);
	}

	public TextFieldBuilder<Date> text(Date date) {
		return Components.text(date);
	}

	public <T extends Number> TextFieldBuilder<T> text(T number) {
		return Components.text(number);
	}

	public <T> TextFieldBuilder<T> text(FieldBuilder<T> field) {
		return Components.text(field);
	}

	public <T> TextFieldBuilder<T> text(VariableBuilder<T> variable) {
		return Components.text(variable);
	}

	public <T> TextFieldBuilder<T> text(DRIExpression<T> textExpression) {
		return Components.text(textExpression);
	}

	// filler
	public FillerBuilder filler() {
		return Components.filler();
	}

	public FillerBuilder horizontalGap(int width) {
		return Components.horizontalGap(width);
	}

	public FillerBuilder verticalGap(int height) {
		return Components.verticalGap(height);
	}

	public FillerBuilder gap(int width, int height) {
		return Components.gap(width, height);
	}

	// image
	public ImageBuilder image(DRIExpression<?> imageExpression) {
		return Components.image(imageExpression);
	}

	public ImageBuilder image(String imagePath) {
		return Components.image(imagePath);
	}

	public ImageBuilder image(Image image) {
		return Components.image(image);
	}

	public ImageBuilder image(InputStream imageInputStream) {
		return Components.image(imageInputStream);
	}

	public ImageBuilder image(URL imageUrl) {
		return Components.image(imageUrl);
	}

	public ImageBuilder image(Renderable image) {
		return Components.image(image);
	}

	/**
	 * @deprecated use image(net.sf.jasperreports.renderers.Renderable image) instead
	 */
	@Deprecated
	public ImageBuilder image(net.sf.jasperreports.engine.Renderable image) {
		return Components.image(image);
	}

	// subreport
	public SubreportBuilder subreport(JasperReportBuilder reportBuilder) {
		return Components.subreport(reportBuilder);
	}

	public SubreportBuilder subreport(JasperReport jasperReport) {
		return Components.subreport(jasperReport);
	}

	public SubreportBuilder subreport(DRIExpression<?> reportExpression) {
		return Components.subreport(reportExpression);
	}

	// line
	public LineBuilder line() {
		return Components.line();
	}

	// break
	public BreakBuilder pageBreak() {
		return Components.pageBreak();
	}

	public BreakBuilder columnBreak() {
		return Components.columnBreak();
	}

	// generic element
	public GenericElementBuilder genericElement(String namespace, String name) {
		return Components.genericElement(namespace, name);
	}

	// boolean
	public BooleanFieldBuilder booleanField(Boolean value) {
		return Components.booleanField(value);
	}

	public BooleanFieldBuilder booleanField(FieldBuilder<Boolean> field) {
		return Components.booleanField(field);
	}

	public BooleanFieldBuilder booleanField(DRIExpression<Boolean> valueExpression) {
		return Components.booleanField(valueExpression);
	}

	// ellipse
	public EllipseBuilder ellipse() {
		return Components.ellipse();
	}

	// rectangle
	public RectangleBuilder rectangle() {
		return Components.rectangle();
	}

	public RectangleBuilder roundRectangle() {
		return Components.roundRectangle();
	}

	public RectangleBuilder roundRectangle(int radius) {
		return Components.roundRectangle(radius);
	}

	// map
	public MapBuilder map() {
		return Components.map();
	}

	public MapBuilder map(Float latitude, Float longitude, Integer zoom) {
		return Components.map(latitude, longitude, zoom);
	}

	// alignment
	public HorizontalListBuilder centerHorizontal(ComponentBuilder<?, ?> component) {
		return Components.centerHorizontal(component);
	}

	public VerticalListBuilder centerVertical(ComponentBuilder<?, ?> component) {
		return Components.centerVertical(component);
	}
}
