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
package net.sf.dynamicreports.report.base.style;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.constant.Rotation;
import net.sf.dynamicreports.report.constant.VerticalImageAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.definition.style.DRIBaseStyle;

import java.awt.Color;

/**
 * <p>Abstract DRBaseStyle class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
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

    /**
     * <p>Constructor for DRBaseStyle.</p>
     */
    public DRBaseStyle() {
        init();
    }

    /**
     * <p>init.</p>
     */
    protected void init() {
        font = new DRFont();
        border = new DRBorder();
        padding = new DRPadding();
        paragraph = new DRParagraph();
        linePen = new DRPen();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getForegroundColor() {
        return foregroundColor;
    }

    /**
     * <p>Setter for the field <code>foregroundColor</code>.</p>
     *
     * @param foregroundColor a {@link java.awt.Color} object.
     */
    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * <p>Setter for the field <code>backgroundColor</code>.</p>
     *
     * @param backgroundColor a {@link java.awt.Color} object.
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getRadius() {
        return radius;
    }

    /**
     * <p>Setter for the field <code>radius</code>.</p>
     *
     * @param radius a {@link java.lang.Integer} object.
     */
    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImageScale getImageScale() {
        return imageScale;
    }

    /**
     * <p>Setter for the field <code>imageScale</code>.</p>
     *
     * @param imageScale a {@link net.sf.dynamicreports.report.constant.ImageScale} object.
     */
    public void setImageScale(ImageScale imageScale) {
        this.imageScale = imageScale;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HorizontalImageAlignment getHorizontalImageAlignment() {
        return horizontalImageAlignment;
    }

    /**
     * <p>Setter for the field <code>horizontalImageAlignment</code>.</p>
     *
     * @param horizontalImageAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalImageAlignment} object.
     */
    public void setHorizontalImageAlignment(HorizontalImageAlignment horizontalImageAlignment) {
        this.horizontalImageAlignment = horizontalImageAlignment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VerticalImageAlignment getVerticalImageAlignment() {
        return verticalImageAlignment;
    }

    /**
     * <p>Setter for the field <code>verticalImageAlignment</code>.</p>
     *
     * @param verticalImageAlignment a {@link net.sf.dynamicreports.report.constant.VerticalImageAlignment} object.
     */
    public void setVerticalImageAlignment(VerticalImageAlignment verticalImageAlignment) {
        this.verticalImageAlignment = verticalImageAlignment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HorizontalTextAlignment getHorizontalTextAlignment() {
        return horizontalTextAlignment;
    }

    /**
     * <p>Setter for the field <code>horizontalTextAlignment</code>.</p>
     *
     * @param horizontalTextAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    public void setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
        this.horizontalTextAlignment = horizontalTextAlignment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VerticalTextAlignment getVerticalTextAlignment() {
        return verticalTextAlignment;
    }

    /**
     * <p>Setter for the field <code>verticalTextAlignment</code>.</p>
     *
     * @param verticalTextAlignment a {@link net.sf.dynamicreports.report.constant.VerticalTextAlignment} object.
     */
    public void setVerticalTextAlignment(VerticalTextAlignment verticalTextAlignment) {
        this.verticalTextAlignment = verticalTextAlignment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRBorder getBorder() {
        return border;
    }

    /**
     * <p>Setter for the field <code>border</code>.</p>
     *
     * @param border a {@link net.sf.dynamicreports.report.base.style.DRBorder} object.
     */
    public void setBorder(DRBorder border) {
        this.border = border;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRPadding getPadding() {
        return padding;
    }

    /**
     * <p>Setter for the field <code>padding</code>.</p>
     *
     * @param padding a {@link net.sf.dynamicreports.report.base.style.DRPadding} object.
     */
    public void setPadding(DRPadding padding) {
        this.padding = padding;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRFont getFont() {
        return font;
    }

    /**
     * <p>Setter for the field <code>font</code>.</p>
     *
     * @param font a {@link net.sf.dynamicreports.report.base.style.DRFont} object.
     */
    public void setFont(DRFont font) {
        this.font = font;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rotation getRotation() {
        return rotation;
    }

    /**
     * <p>Setter for the field <code>rotation</code>.</p>
     *
     * @param rotation a {@link net.sf.dynamicreports.report.constant.Rotation} object.
     */
    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPattern() {
        return pattern;
    }

    /**
     * <p>Setter for the field <code>pattern</code>.</p>
     *
     * @param pattern a {@link java.lang.String} object.
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Markup getMarkup() {
        return markup;
    }

    /**
     * <p>Setter for the field <code>markup</code>.</p>
     *
     * @param markup a {@link net.sf.dynamicreports.report.constant.Markup} object.
     */
    public void setMarkup(Markup markup) {
        this.markup = markup;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRParagraph getParagraph() {
        return paragraph;
    }

    /**
     * <p>Setter for the field <code>paragraph</code>.</p>
     *
     * @param paragraph a {@link net.sf.dynamicreports.report.base.style.DRParagraph} object.
     */
    public void setParagraph(DRParagraph paragraph) {
        this.paragraph = paragraph;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRPen getLinePen() {
        return linePen;
    }

    /**
     * <p>Setter for the field <code>linePen</code>.</p>
     *
     * @param linePen a {@link net.sf.dynamicreports.report.base.style.DRPen} object.
     */
    public void setLinePen(DRPen linePen) {
        this.linePen = linePen;
    }

}
