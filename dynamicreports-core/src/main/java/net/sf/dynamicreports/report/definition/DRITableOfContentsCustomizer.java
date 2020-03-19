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
package net.sf.dynamicreports.report.definition;

import net.sf.dynamicreports.jasper.base.tableofcontents.JasperTocHeading;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.constant.TableOfContentsPosition;

import java.io.Serializable;
import java.util.List;

/**
 * <p>DRITableOfContentsCustomizer interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public interface DRITableOfContentsCustomizer extends Serializable {

    /**
     * <p>setReport.</p>
     *
     * @param report a {@link net.sf.dynamicreports.report.builder.ReportBuilder} object.
     */
    public void setReport(ReportBuilder<?> report);

    /**
     * <p>setHeadingList.</p>
     *
     * @param headingList a {@link java.util.List} object.
     */
    public void setHeadingList(List<JasperTocHeading> headingList);

    /**
     * <p>setHeadings.</p>
     *
     * @param headings a int.
     */
    public void setHeadings(int headings);

    /**
     * <p>setLevels.</p>
     *
     * @param levels a int.
     */
    public void setLevels(int levels);

    /**
     * <p>customize.</p>
     */
    public void customize();

    /**
     * <p>getPosition.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.TableOfContentsPosition} object.
     */
    public TableOfContentsPosition getPosition();
}
