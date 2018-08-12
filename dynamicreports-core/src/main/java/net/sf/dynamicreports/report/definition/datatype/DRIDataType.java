/**
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

package net.sf.dynamicreports.report.definition.datatype;

import java.io.Serializable;
import java.util.Locale;

import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * <p>DRIDataType interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIDataType<U, T extends U> extends Serializable {

	/**
	 * <p>getPattern.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getPattern();

	/**
	 * <p>getValueFormatter.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIValueFormatter} object.
	 */
	public DRIValueFormatter<?, ? extends U> getValueFormatter();

	/**
	 * <p>getHorizontalTextAlignment.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
	 */
	public HorizontalTextAlignment getHorizontalTextAlignment();

	/**
	 * <p>valueToString.</p>
	 *
	 * @param value a U object.
	 * @param locale a {@link java.util.Locale} object.
	 * @return a {@link java.lang.String} object.
	 */
	public String valueToString(U value, Locale locale);

	/**
	 * <p>valueToString.</p>
	 *
	 * @param value a {@link net.sf.dynamicreports.report.definition.DRIValue} object.
	 * @param reportParameters a {@link net.sf.dynamicreports.report.definition.ReportParameters} object.
	 * @return a {@link java.lang.String} object.
	 */
	public String valueToString(DRIValue<? extends U> value, ReportParameters reportParameters);

	/**
	 * <p>valueToString.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param reportParameters a {@link net.sf.dynamicreports.report.definition.ReportParameters} object.
	 * @return a {@link java.lang.String} object.
	 */
	public String valueToString(String name, ReportParameters reportParameters);

	/**
	 * <p>stringToValue.</p>
	 *
	 * @param value a {@link java.lang.String} object.
	 * @param locale a {@link java.util.Locale} object.
	 * @return a T object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public T stringToValue(String value, Locale locale) throws DRException;

	/**
	 * <p>stringToValue.</p>
	 *
	 * @param value a {@link net.sf.dynamicreports.report.definition.DRIValue} object.
	 * @param reportParameters a {@link net.sf.dynamicreports.report.definition.ReportParameters} object.
	 * @return a T object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public T stringToValue(DRIValue<String> value, ReportParameters reportParameters) throws DRException;

	/**
	 * <p>stringToValue.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param reportParameters a {@link net.sf.dynamicreports.report.definition.ReportParameters} object.
	 * @return a T object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public T stringToValue(String name, ReportParameters reportParameters) throws DRException;

	/**
	 * <p>getValueClass.</p>
	 *
	 * @return a {@link java.lang.Class} object.
	 */
	public Class<T> getValueClass();
}
