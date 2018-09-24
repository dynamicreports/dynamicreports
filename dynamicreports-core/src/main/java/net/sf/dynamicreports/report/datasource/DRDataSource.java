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
package net.sf.dynamicreports.report.datasource;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRRewindableDataSource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>DRDataSource class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDataSource implements JRRewindableDataSource, Serializable {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private String[] columns;
    private List<Map<String, Object>> values;
    private Iterator<Map<String, Object>> iterator;
    private Map<String, Object> currentRecord;

    /**
     * <p>Constructor for DRDataSource.</p>
     *
     * @param columns a {@link java.lang.String} object.
     */
    public DRDataSource(String... columns) {
        this.columns = columns;
        this.values = new ArrayList<Map<String, Object>>();
    }

    /**
     * <p>add.</p>
     *
     * @param values a {@link java.lang.Object} object.
     */
    public void add(Object... values) {
        Map<String, Object> row = new HashMap<String, Object>();
        for (int i = 0; i < values.length; i++) {
            row.put(columns[i], values[i]);
        }
        this.values.add(row);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getFieldValue(JRField field) throws JRException {
        return currentRecord.get(field.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean next() throws JRException {
        if (iterator == null) {
            this.iterator = values.iterator();
        }
        boolean hasNext = iterator.hasNext();
        if (hasNext) {
            currentRecord = iterator.next();
        }
        return hasNext;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveFirst() throws JRException {
        iterator = null;
    }
}
