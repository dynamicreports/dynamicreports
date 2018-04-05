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

package net.sf.dynamicreports.design.base.style;

import java.awt.Color;

import net.sf.dynamicreports.design.definition.style.DRIDesignBaseStyle;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.constant.Rotation;
import net.sf.dynamicreports.report.constant.VerticalImageAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class DRDesignBaseStyle implements DRIDesignBaseStyle {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Color foregroundColor;
	private Color backgroundColor;
	private Integer radius;
	private ImageScale imageScale;
	private HorizontalTextAlignment horizontalTextAlignment;
	private VerticalTextAlignment verticalTextAlignment;
	private HorizontalImageAlignment horizontalImageAlignment;
	private VerticalImageAlignment verticalImageAlignment;
	private DRDesignBorder border;
	private DRDesignPadding padding;
	private DRDesignFont font;
	private Rotation rotation;
	private String pattern;
	private Markup markup;
	private DRDesignParagraph paragraph;
	private DRDesignPen linePen;

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
	public DRDesignBorder getBorder() {
		return border;
	}

	public void setBorder(DRDesignBorder border) {
		this.border = border;
	}

	@Override
	public DRDesignPadding getPadding() {
		return padding;
	}

	public void setPadding(DRDesignPadding padding) {
		this.padding = padding;
	}

	@Override
	public DRDesignFont getFont() {
		return font;
	}

	public void setFont(DRDesignFont font) {
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
	public DRDesignParagraph getParagraph() {
		return paragraph;
	}

	public void setParagraph(DRDesignParagraph paragraph) {
		this.paragraph = paragraph;
	}

	@Override
	public DRDesignPen getLinePen() {
		return linePen;
	}

	public void setLinePen(DRDesignPen linePen) {
		this.linePen = linePen;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		DRDesignBaseStyle o = (DRDesignBaseStyle) obj;
		EqualsBuilder equalsBuilder = new EqualsBuilder()
				.append(foregroundColor, o.foregroundColor)
				.append(backgroundColor, o.backgroundColor)
				.append(radius, o.radius)
				.append(imageScale, o.imageScale)
				.append(horizontalTextAlignment, o.horizontalTextAlignment)
				.append(verticalTextAlignment, o.verticalTextAlignment)
				.append(horizontalImageAlignment, o.horizontalImageAlignment)
				.append(verticalImageAlignment, o.verticalImageAlignment)
				.append(border, o.border)
				.append(padding, o.padding)
				.append(font, o.font)
				.append(rotation, o.rotation)
				.append(pattern, o.pattern)
				.append(markup, o.markup)
				.append(paragraph, o.paragraph)
				.append(linePen, o.linePen);
		return equalsBuilder.isEquals();
	}

}
