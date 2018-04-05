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

package net.sf.dynamicreports.report.base.style;

import java.awt.Color;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.constant.Rotation;
import net.sf.dynamicreports.report.constant.VerticalImageAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.definition.style.DRIBaseStyle;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class DRBaseStyle implements DRIBaseStyle {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Color foregroundColor;
	private Color backgroundColor;
	private Integer radius;
	private ImageScale imageScale;
	private HorizontalImageAlignment horizontalImageAlignment;
	private VerticalImageAlignment verticalImageAlignment;
	private HorizontalTextAlignment horizontalTextAlignment;
	private VerticalTextAlignment verticalTextAlignment;
	private DRBorder border;
	private DRPadding padding;
	private DRFont font;
	private Rotation rotation;
	private String pattern;
	private Markup markup;
	private DRParagraph paragraph;
	private DRPen linePen;

	public DRBaseStyle() {
		init();
	}

	protected void init() {
		font = new DRFont();
		border = new DRBorder();
		padding = new DRPadding();
		paragraph = new DRParagraph();
		linePen = new DRPen();
	}

	@Override
	public Color getForegroundColor() {
		return foregroundColor;
	}

	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
	}

	@Override
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	@Override
	public ImageScale getImageScale() {
		return imageScale;
	}

	public void setImageScale(ImageScale imageScale) {
		this.imageScale = imageScale;
	}

	@Override
	public HorizontalImageAlignment getHorizontalImageAlignment() {
		return horizontalImageAlignment;
	}

	public void setHorizontalImageAlignment(HorizontalImageAlignment horizontalImageAlignment) {
		this.horizontalImageAlignment = horizontalImageAlignment;
	}

	@Override
	public VerticalImageAlignment getVerticalImageAlignment() {
		return verticalImageAlignment;
	}

	public void setVerticalImageAlignment(VerticalImageAlignment verticalImageAlignment) {
		this.verticalImageAlignment = verticalImageAlignment;
	}

	@Override
	public HorizontalTextAlignment getHorizontalTextAlignment() {
		return horizontalTextAlignment;
	}

	public void setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		this.horizontalTextAlignment = horizontalTextAlignment;
	}

	@Override
	public VerticalTextAlignment getVerticalTextAlignment() {
		return verticalTextAlignment;
	}

	public void setVerticalTextAlignment(VerticalTextAlignment verticalTextAlignment) {
		this.verticalTextAlignment = verticalTextAlignment;
	}

	@Override
	public DRBorder getBorder() {
		return border;
	}

	public void setBorder(DRBorder border) {
		this.border = border;
	}

	@Override
	public DRPadding getPadding() {
		return padding;
	}

	public void setPadding(DRPadding padding) {
		this.padding = padding;
	}

	@Override
	public DRFont getFont() {
		return font;
	}

	public void setFont(DRFont font) {
		this.font = font;
	}

	@Override
	public Rotation getRotation() {
		return rotation;
	}

	public void setRotation(Rotation rotation) {
		this.rotation = rotation;
	}

	@Override
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public Markup getMarkup() {
		return markup;
	}

	public void setMarkup(Markup markup) {
		this.markup = markup;
	}

	@Override
	public DRParagraph getParagraph() {
		return paragraph;
	}

	public void setParagraph(DRParagraph paragraph) {
		this.paragraph = paragraph;
	}

	@Override
	public DRPen getLinePen() {
		return linePen;
	}

	public void setLinePen(DRPen linePen) {
		this.linePen = linePen;
	}

}
