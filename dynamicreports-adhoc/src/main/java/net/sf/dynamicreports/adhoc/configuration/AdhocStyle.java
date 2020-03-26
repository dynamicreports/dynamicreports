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
package net.sf.dynamicreports.adhoc.configuration;

import java.awt.Color;
import java.io.Serializable;

/**
 * <p>AdhocStyle class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class AdhocStyle implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private AdhocFont font;
    private AdhocPen topBorder;
    private AdhocPen leftBorder;
    private AdhocPen bottomBorder;
    private AdhocPen rightBorder;
    private Color foregroundColor;
    private Color backgroundColor;
    private AdhocHorizontalAlignment horizontalAlignment;
    private AdhocVerticalAlignment verticalAlignment;
    private String pattern;

    /**
     * <p>Getter for the field <code>font</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocFont} object.
     */
    public AdhocFont getFont() {
        return font;
    }

    /**
     * <p>Setter for the field <code>font</code>.</p>
     *
     * @param font a {@link net.sf.dynamicreports.adhoc.configuration.AdhocFont} object.
     */
    public void setFont(AdhocFont font) {
        this.font = font;
    }

    /**
     * <p>Getter for the field <code>topBorder</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPen} object.
     */
    public AdhocPen getTopBorder() {
        return topBorder;
    }

    /**
     * <p>Setter for the field <code>topBorder</code>.</p>
     *
     * @param topBorder a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPen} object.
     */
    public void setTopBorder(AdhocPen topBorder) {
        this.topBorder = topBorder;
    }

    /**
     * <p>Getter for the field <code>leftBorder</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPen} object.
     */
    public AdhocPen getLeftBorder() {
        return leftBorder;
    }

    /**
     * <p>Setter for the field <code>leftBorder</code>.</p>
     *
     * @param leftBorder a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPen} object.
     */
    public void setLeftBorder(AdhocPen leftBorder) {
        this.leftBorder = leftBorder;
    }

    /**
     * <p>Getter for the field <code>bottomBorder</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPen} object.
     */
    public AdhocPen getBottomBorder() {
        return bottomBorder;
    }

    /**
     * <p>Setter for the field <code>bottomBorder</code>.</p>
     *
     * @param bottomBorder a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPen} object.
     */
    public void setBottomBorder(AdhocPen bottomBorder) {
        this.bottomBorder = bottomBorder;
    }

    /**
     * <p>Getter for the field <code>rightBorder</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPen} object.
     */
    public AdhocPen getRightBorder() {
        return rightBorder;
    }

    /**
     * <p>Setter for the field <code>rightBorder</code>.</p>
     *
     * @param rightBorder a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPen} object.
     */
    public void setRightBorder(AdhocPen rightBorder) {
        this.rightBorder = rightBorder;
    }

    /**
     * <p>Getter for the field <code>foregroundColor</code>.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
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
     * <p>Getter for the field <code>backgroundColor</code>.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
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
     * <p>Getter for the field <code>horizontalAlignment</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocHorizontalAlignment} object.
     */
    public AdhocHorizontalAlignment getHorizontalAlignment() {
        return horizontalAlignment;
    }

    /**
     * <p>Setter for the field <code>horizontalAlignment</code>.</p>
     *
     * @param horizontalAlignment a {@link net.sf.dynamicreports.adhoc.configuration.AdhocHorizontalAlignment} object.
     */
    public void setHorizontalAlignment(AdhocHorizontalAlignment horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    /**
     * <p>Getter for the field <code>verticalAlignment</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocVerticalAlignment} object.
     */
    public AdhocVerticalAlignment getVerticalAlignment() {
        return verticalAlignment;
    }

    /**
     * <p>Setter for the field <code>verticalAlignment</code>.</p>
     *
     * @param verticalAlignment a {@link net.sf.dynamicreports.adhoc.configuration.AdhocVerticalAlignment} object.
     */
    public void setVerticalAlignment(AdhocVerticalAlignment verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
    }

    /**
     * <p>Getter for the field <code>pattern</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdhocStyle)) {
            return false;
        }

        AdhocStyle object = (AdhocStyle) obj;
        if (!(font == null ? object.getFont() == null : font.equals(object.getFont()))) {
            return false;
        }
        if (!(topBorder == null ? object.getTopBorder() == null : topBorder.equals(object.getTopBorder()))) {
            return false;
        }
        if (!(leftBorder == null ? object.getLeftBorder() == null : leftBorder.equals(object.getLeftBorder()))) {
            return false;
        }
        if (!(bottomBorder == null ? object.getBottomBorder() == null : bottomBorder.equals(object.getBottomBorder()))) {
            return false;
        }
        if (!(rightBorder == null ? object.getRightBorder() == null : rightBorder.equals(object.getRightBorder()))) {
            return false;
        }
        if (!(foregroundColor == null ? object.getForegroundColor() == null : foregroundColor.equals(object.getForegroundColor()))) {
            return false;
        }
        if (!(backgroundColor == null ? object.getBackgroundColor() == null : backgroundColor.equals(object.getBackgroundColor()))) {
            return false;
        }
        if (!(horizontalAlignment == null ? object.getHorizontalAlignment() == null : horizontalAlignment.equals(object.getHorizontalAlignment()))) {
            return false;
        }
        if (!(verticalAlignment == null ? object.getVerticalAlignment() == null : verticalAlignment.equals(object.getVerticalAlignment()))) {
            return false;
        }
        if (!(pattern == null ? object.getPattern() == null : pattern.equals(object.getPattern()))) {
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdhocStyle clone() {
        AdhocStyle clone;
        try {
            clone = (AdhocStyle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        if (font != null) {
            clone.font = font.clone();
        }
        if (topBorder != null) {
            clone.topBorder = topBorder.clone();
        }
        if (leftBorder != null) {
            clone.leftBorder = leftBorder.clone();
        }
        if (bottomBorder != null) {
            clone.bottomBorder = bottomBorder.clone();
        }
        if (rightBorder != null) {
            clone.rightBorder = rightBorder.clone();
        }

        return clone;
    }

}
