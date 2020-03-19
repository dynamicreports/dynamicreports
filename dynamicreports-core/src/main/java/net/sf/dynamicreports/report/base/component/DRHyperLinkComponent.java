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
package net.sf.dynamicreports.report.base.component;

import net.sf.dynamicreports.report.base.DRHyperLink;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.component.DRIHyperLinkComponent;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>Abstract DRHyperLinkComponent class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public abstract class DRHyperLinkComponent extends DRDimensionComponent implements DRIHyperLinkComponent {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<String> anchorNameExpression;
    private Integer bookmarkLevel;
    private DRHyperLink hyperLink;

    /** {@inheritDoc} */
    @Override
    public DRIExpression<String> getAnchorNameExpression() {
        return anchorNameExpression;
    }

    /**
     * <p>Setter for the field <code>anchorNameExpression</code>.</p>
     *
     * @param anchorNameExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setAnchorNameExpression(DRIExpression<String> anchorNameExpression) {
        this.anchorNameExpression = anchorNameExpression;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getBookmarkLevel() {
        return bookmarkLevel;
    }

    /**
     * <p>Setter for the field <code>bookmarkLevel</code>.</p>
     *
     * @param bookmarkLevel a {@link java.lang.Integer} object.
     */
    public void setBookmarkLevel(Integer bookmarkLevel) {
        this.bookmarkLevel = bookmarkLevel;
    }

    /** {@inheritDoc} */
    @Override
    public DRHyperLink getHyperLink() {
        return hyperLink;
    }

    /**
     * <p>Setter for the field <code>hyperLink</code>.</p>
     *
     * @param hyperLink a {@link net.sf.dynamicreports.report.base.DRHyperLink} object.
     */
    public void setHyperLink(DRHyperLink hyperLink) {
        this.hyperLink = hyperLink;
    }
}
