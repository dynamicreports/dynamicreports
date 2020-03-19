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
package net.sf.dynamicreports.jasper.base;

import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;
import net.sf.jasperreports.engine.JRVariable;

/**
 * <p>StartPageNumberScriptlet class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class StartPageNumberScriptlet extends JRDefaultScriptlet {

    private JasperCustomValues getCustomValues() {
        try {
            return (JasperCustomValues) getParameterValue(JasperCustomValues.NAME, false);
        } catch (JRScriptletException e) {
            throw new JasperDesignException("Custom values not found", e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void afterReportInit() throws JRScriptletException {
        super.afterReportInit();
        JasperCustomValues customValues = getCustomValues();
        if (customValues != null && customValues.getStartPageNumber() != null) {
            setVariableValue(JRVariable.PAGE_NUMBER, customValues.getStartPageNumber());
        }
    }
}
