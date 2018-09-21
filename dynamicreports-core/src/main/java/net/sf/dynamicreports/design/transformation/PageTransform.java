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
package net.sf.dynamicreports.design.transformation;

import net.sf.dynamicreports.design.base.DRDesignMargin;
import net.sf.dynamicreports.design.base.DRDesignPage;
import net.sf.dynamicreports.report.definition.DRIMargin;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * <p>PageTransform class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class PageTransform {
    private TemplateTransform templateTransform;
    private DRDesignPage page;
    private int maxBandWidth;

    /**
     * <p>Constructor for PageTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public PageTransform(DesignTransformAccessor accessor) {
        this.templateTransform = accessor.getTemplateTransform();
        this.page = new DRDesignPage();
    }

    /**
     * <p>transform.</p>
     *
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public void transform() throws DRException {
        this.page.setHeight(templateTransform.getPageHeight());
        this.page.setOrientation(templateTransform.getPageOrientation());
        this.page.setMargin(margin(templateTransform.getPageMargin()));
        this.page.setColumnsPerPage(templateTransform.getPageColumnsPerPage());
        this.page.setColumnSpace(templateTransform.getPageColumnSpace());
    }

    private DRDesignMargin margin(DRIMargin margin) {
        DRDesignMargin designMargin = new DRDesignMargin();
        designMargin.setTop(margin.getTop());
        designMargin.setLeft(margin.getLeft());
        designMargin.setBottom(margin.getBottom());
        designMargin.setRight(margin.getRight());
        return designMargin;
    }

    /**
     * <p>Getter for the field <code>page</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignPage} object.
     */
    public DRDesignPage getPage() {
        return page;
    }

    /**
     * <p>transformPageWidth.</p>
     *
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public void transformPageWidth() throws DRException {
        int pageWidth = templateTransform.getPageWidth();
        maxBandWidth = pageWidth - getPage().getMargin()
                                            .getLeft() - getPage().getMargin()
                                                                  .getRight();
        this.page.setWidth(pageWidth);
        this.page.setColumnWidth(templateTransform.getPageColumnWidth(this.page));
    }

    /**
     * <p>Getter for the field <code>maxBandWidth</code>.</p>
     *
     * @return a int.
     */
    public int getMaxBandWidth() {
        return maxBandWidth;
    }
}
