/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report.builder.datatype;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.base.datatype.AbstractDataType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.exception.DRException;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

/**
 * <p>Abstract NumberType class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public abstract class NumberType<T extends Number> extends AbstractDataType<Number, T> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /** {@inheritDoc} */
    @Override
    public String valueToString(Number value, Locale locale) {
        if (value != null) {
            return new DecimalFormat(getPattern(), new DecimalFormatSymbols(locale)).format(value);
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public T stringToValue(String value, Locale locale) throws DRException {
        if (value != null) {
            try {
                return numberToValue(new DecimalFormat(getPattern(), new DecimalFormatSymbols(locale)).parse(value));
            } catch (ParseException e) {
                throw new DRException("Unable to convert string value to date", e);
            }
        }
        return null;
    }

    /**
     * <p>numberToValue.</p>
     *
     * @param number a {@link java.lang.Number} object.
     * @return a T object.
     */
    protected abstract T numberToValue(Number number);

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getValueClass() {
        return (Class<T>) ReportUtils.getGenericClass(this, 0);
    }
}
