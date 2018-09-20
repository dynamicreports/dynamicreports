/*
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
package net.sf.dynamicreports.report.base;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.definition.DRIScriptlet;
import net.sf.dynamicreports.report.definition.ReportParameters;
import org.apache.commons.lang3.Validate;

/**
 * <p>Abstract AbstractScriptlet class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public abstract class AbstractScriptlet implements DRIScriptlet {
    private String name;

    /**
     * <p>Constructor for AbstractScriptlet.</p>
     */
    public AbstractScriptlet() {
        this.name = ReportUtils.generateUniqueName("scriptlet");
    }

    /**
     * <p>Constructor for AbstractScriptlet.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public AbstractScriptlet(String name) {
        Validate.notEmpty(name, "name must not be empty");
        this.name = name;
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return name;
    }

    /** {@inheritDoc} */
    @Override
    public void afterColumnInit(ReportParameters reportParameters) {
    }

    /** {@inheritDoc} */
    @Override
    public void afterDetailEval(ReportParameters reportParameters) {
    }

    /** {@inheritDoc} */
    @Override
    public void afterGroupInit(String groupName, ReportParameters reportParameters) {
    }

    /** {@inheritDoc} */
    @Override
    public void afterPageInit(ReportParameters reportParameters) {
    }

    /** {@inheritDoc} */
    @Override
    public void afterReportInit(ReportParameters reportParameters) {
    }

    /** {@inheritDoc} */
    @Override
    public void beforeColumnInit(ReportParameters reportParameters) {
    }

    /** {@inheritDoc} */
    @Override
    public void beforeDetailEval(ReportParameters reportParameters) {
    }

    /** {@inheritDoc} */
    @Override
    public void beforeGroupInit(String groupName, ReportParameters reportParameters) {
    }

    /** {@inheritDoc} */
    @Override
    public void beforePageInit(ReportParameters reportParameters) {
    }

    /** {@inheritDoc} */
    @Override
    public void beforeReportInit(ReportParameters reportParameters) {
    }
}
