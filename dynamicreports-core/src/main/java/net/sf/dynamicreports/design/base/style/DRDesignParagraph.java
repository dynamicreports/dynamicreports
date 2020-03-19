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
package net.sf.dynamicreports.design.base.style;

import net.sf.dynamicreports.design.definition.style.DRIDesignParagraph;
import net.sf.dynamicreports.design.definition.style.DRIDesignTabStop;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.LineSpacing;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.List;

/**
 * <p>DRDesignParagraph class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DRDesignParagraph implements DRIDesignParagraph {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private LineSpacing lineSpacing;
    private Float lineSpacingSize;
    private Integer firstLineIndent;
    private Integer leftIndent;
    private Integer rightIndent;
    private Integer spacingBefore;
    private Integer spacingAfter;
    private Integer tabStopWidth;
    private List<DRIDesignTabStop> tabStops;

    /** {@inheritDoc} */
    @Override
    public LineSpacing getLineSpacing() {
        return lineSpacing;
    }

    /**
     * <p>Setter for the field <code>lineSpacing</code>.</p>
     *
     * @param lineSpacing a {@link net.sf.dynamicreports.report.constant.LineSpacing} object.
     */
    public void setLineSpacing(LineSpacing lineSpacing) {
        this.lineSpacing = lineSpacing;
    }

    /** {@inheritDoc} */
    @Override
    public Float getLineSpacingSize() {
        return lineSpacingSize;
    }

    /**
     * <p>Setter for the field <code>lineSpacingSize</code>.</p>
     *
     * @param lineSpacingSize a {@link java.lang.Float} object.
     */
    public void setLineSpacingSize(Float lineSpacingSize) {
        this.lineSpacingSize = lineSpacingSize;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getFirstLineIndent() {
        return firstLineIndent;
    }

    /**
     * <p>Setter for the field <code>firstLineIndent</code>.</p>
     *
     * @param firstLineIndent a {@link java.lang.Integer} object.
     */
    public void setFirstLineIndent(Integer firstLineIndent) {
        this.firstLineIndent = firstLineIndent;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getLeftIndent() {
        return leftIndent;
    }

    /**
     * <p>Setter for the field <code>leftIndent</code>.</p>
     *
     * @param leftIndent a {@link java.lang.Integer} object.
     */
    public void setLeftIndent(Integer leftIndent) {
        this.leftIndent = leftIndent;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getRightIndent() {
        return rightIndent;
    }

    /**
     * <p>Setter for the field <code>rightIndent</code>.</p>
     *
     * @param rightIndent a {@link java.lang.Integer} object.
     */
    public void setRightIndent(Integer rightIndent) {
        this.rightIndent = rightIndent;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getSpacingBefore() {
        return spacingBefore;
    }

    /**
     * <p>Setter for the field <code>spacingBefore</code>.</p>
     *
     * @param spacingBefore a {@link java.lang.Integer} object.
     */
    public void setSpacingBefore(Integer spacingBefore) {
        this.spacingBefore = spacingBefore;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getSpacingAfter() {
        return spacingAfter;
    }

    /**
     * <p>Setter for the field <code>spacingAfter</code>.</p>
     *
     * @param spacingAfter a {@link java.lang.Integer} object.
     */
    public void setSpacingAfter(Integer spacingAfter) {
        this.spacingAfter = spacingAfter;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getTabStopWidth() {
        return tabStopWidth;
    }

    /**
     * <p>Setter for the field <code>tabStopWidth</code>.</p>
     *
     * @param tabStopWidth a {@link java.lang.Integer} object.
     */
    public void setTabStopWidth(Integer tabStopWidth) {
        this.tabStopWidth = tabStopWidth;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIDesignTabStop> getTabStops() {
        return tabStops;
    }

    /**
     * <p>Setter for the field <code>tabStops</code>.</p>
     *
     * @param tabStops a {@link java.util.List} object.
     */
    public void setTabStops(List<DRIDesignTabStop> tabStops) {
        this.tabStops = tabStops;
    }

    /** {@inheritDoc} */
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

        DRDesignParagraph o = (DRDesignParagraph) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder().append(lineSpacing, o.lineSpacing)
                                                         .append(lineSpacingSize, o.lineSpacingSize)
                                                         .append(firstLineIndent, o.firstLineIndent)
                                                         .append(leftIndent, o.leftIndent)
                                                         .append(rightIndent, o.rightIndent)
                                                         .append(spacingBefore, o.spacingBefore)
                                                         .append(spacingAfter, o.spacingAfter)
                                                         .append(tabStopWidth, o.tabStopWidth)
                                                         .append(tabStops, o.tabStops);
        return equalsBuilder.isEquals();
    }
}
