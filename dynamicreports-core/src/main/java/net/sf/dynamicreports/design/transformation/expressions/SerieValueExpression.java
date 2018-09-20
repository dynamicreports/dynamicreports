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
package net.sf.dynamicreports.design.transformation.expressions;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.exception.DRDesignReportException;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>SerieValueExpression class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class SerieValueExpression extends AbstractSimpleExpression<Number> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIDesignExpression valueExpression;
    private DRIDesignExpression serieExpression;
    private ResetType resetType;
    private DRDesignGroup resetGroup;
    private String key;
    private Object resetValue;
    private Map<Object, Double> values;

    /**
     * <p>Constructor for SerieValueExpression.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     * @param serieExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     * @param resetType a {@link net.sf.dynamicreports.design.constant.ResetType} object.
     * @param resetGroup a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
     * @param key a {@link java.lang.String} object.
     */
    public SerieValueExpression(DRIDesignExpression valueExpression, DRIDesignExpression serieExpression, ResetType resetType, DRDesignGroup resetGroup, String key) {
        this.valueExpression = valueExpression;
        this.serieExpression = serieExpression;
        this.resetType = resetType;
        this.resetGroup = resetGroup;
        this.key = key;
    }

    /** {@inheritDoc} */
    @Override
    public Number evaluate(ReportParameters reportParameters) {
        if (reportParameters.getReportRowNumber() <= 1) {
            resetValue = null;
            values = new HashMap<Object, Double>();
        }

        Object resetValue = null;
        switch (resetType) {
            case NONE:
            case REPORT:
                break;
            case PAGE:
                resetValue = reportParameters.getPageNumber();
                break;
            case COLUMN:
                resetValue = reportParameters.getColumnNumber();
                break;
            case GROUP:
                resetValue = reportParameters.getValue(resetGroup.getGroupExpression()
                                                                 .getName());
                break;
            default:
                throw new DRDesignReportException("Reset type " + resetType.name() + " not supported");
        }
        if (this.resetValue != null && !this.resetValue.equals(resetValue)) {
            this.values = new HashMap<Object, Double>();
        }
        this.resetValue = resetValue;

        Object keyValue;
        if (key != null) {
            keyValue = reportParameters.getValue(valueExpression.getName()) + "_" + reportParameters.getValue(key);
        } else {
            keyValue = reportParameters.getValue(valueExpression.getName());
        }
        Number serieValue = reportParameters.getValue(serieExpression.getName());
        Double value = values.get(keyValue);
        if (serieValue != null) {
            if (value == null) {
                value = serieValue.doubleValue();
            } else {
                value += serieValue.doubleValue();
            }
            values.put(keyValue, value);
        }

        return value;
    }
}
