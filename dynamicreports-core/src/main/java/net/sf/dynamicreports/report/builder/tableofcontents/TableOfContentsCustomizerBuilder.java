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
package net.sf.dynamicreports.report.builder.tableofcontents;

import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.TableOfContentsPosition;

/**
 * <p>TableOfContentsCustomizerBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class TableOfContentsCustomizerBuilder extends AbstractBuilder<TableOfContentsCustomizerBuilder, TableOfContentsCustomizer> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for TableOfContentsCustomizerBuilder.</p>
     */
    public TableOfContentsCustomizerBuilder() {
        super(new TableOfContentsCustomizer());
    }

    /**
     * <p>getTableOfContents.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizer} object.
     */
    public TableOfContentsCustomizer getTableOfContents() {
        return build();
    }

    /**
     * <p>setTitleStyle.</p>
     *
     * @param titleStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder} object.
     */
    public TableOfContentsCustomizerBuilder setTitleStyle(ReportStyleBuilder titleStyle) {
        this.getObject().setTitleStyle(titleStyle);
        return this;
    }

    /**
     * <p>setHeadingStyle.</p>
     *
     * @param headingStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder} object.
     */
    public TableOfContentsCustomizerBuilder setHeadingStyle(ReportStyleBuilder headingStyle) {
        this.getObject().setHeadingStyle(headingStyle);
        return this;
    }

    /**
     * <p>setHeadingStyle.</p>
     *
     * @param level        a int.
     * @param headingStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder} object.
     */
    public TableOfContentsCustomizerBuilder setHeadingStyle(int level, ReportStyleBuilder headingStyle) {
        this.getObject().setHeadingStyle(level, headingStyle);
        return this;
    }

    /**
     * <p>setTextFixedWidth.</p>
     *
     * @param textFixedWidth a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder} object.
     */
    public TableOfContentsCustomizerBuilder setTextFixedWidth(Integer textFixedWidth) {
        this.getObject().setTextFixedWidth(textFixedWidth);
        return this;
    }

    /**
     * <p>setDotsFixedWidth.</p>
     *
     * @param dotsFixedWidth a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder} object.
     */
    public TableOfContentsCustomizerBuilder setDotsFixedWidth(Integer dotsFixedWidth) {
        this.getObject().setDotsFixedWidth(dotsFixedWidth);
        return this;
    }

    /**
     * <p>setPageIndexFixedWidth.</p>
     *
     * @param pageIndexFixedWidth a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder} object.
     */
    public TableOfContentsCustomizerBuilder setPageIndexFixedWidth(Integer pageIndexFixedWidth) {
        this.getObject().setPageIndexFixedWidth(pageIndexFixedWidth);
        return this;
    }

    /**
     * <p>setPosition.</p>
     *
     * @param position a {@link net.sf.dynamicreports.report.constant.TableOfContentsPosition} object.
     * @return a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder} object.
     */
    public TableOfContentsCustomizerBuilder setPosition(TableOfContentsPosition position) {
        this.getObject().setPosition(position);
        return this;
    }
}
