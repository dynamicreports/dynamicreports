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

import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * A set of build in data types
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DataTypeBuilders {

    /**
     * <p>detectType.</p>
     *
     * @param dataType a {@link java.lang.Class} object.
     * @param <U> a U object.
     * @param <T> a T object.
     * @return a T object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public <U, T extends DRIDataType<? super U, U>> T detectType(Class<U> dataType) throws DRException {
        return DataTypes.detectType(dataType);
    }

    /**
     * <p>detectType.</p>
     *
     * @param dataType a {@link java.lang.String} object.
     * @param <T> a T object.
     * @return a T object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public <T extends DRIDataType<?, ?>> T detectType(String dataType) throws DRException {
        return DataTypes.detectType(dataType);
    }

    /**
     * <p>bigDecimalType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.BigDecimalType} object.
     */
    public BigDecimalType bigDecimalType() {
        return DataTypes.bigDecimalType();
    }

    /**
     * <p>bigIntegerType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.BigIntegerType} object.
     */
    public BigIntegerType bigIntegerType() {
        return DataTypes.bigIntegerType();
    }

    /**
     * <p>booleanType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.BooleanType} object.
     */
    public BooleanType booleanType() {
        return DataTypes.booleanType();
    }

    /**
     * <p>byteType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.ByteType} object.
     */
    public ByteType byteType() {
        return DataTypes.byteType();
    }

    /**
     * <p>dateType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.DateType} object.
     */
    public DateType dateType() {
        return DataTypes.dateType();
    }

    /**
     * <p>dateYearToFractionType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.DateYearToFractionType} object.
     */
    public DateYearToFractionType dateYearToFractionType() {
        return DataTypes.dateYearToFractionType();
    }

    /**
     * <p>dateYearToHourType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.DateYearToHourType} object.
     */
    public DateYearToHourType dateYearToHourType() {
        return DataTypes.dateYearToHourType();
    }

    /**
     * <p>dateYearToMinuteType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.DateYearToMinuteType} object.
     */
    public DateYearToMinuteType dateYearToMinuteType() {
        return DataTypes.dateYearToMinuteType();
    }

    /**
     * <p>dateYearToMonthType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.DateYearToMonthType} object.
     */
    public DateYearToMonthType dateYearToMonthType() {
        return DataTypes.dateYearToMonthType();
    }

    /**
     * <p>dateYearToSecondType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.DateYearToSecondType} object.
     */
    public DateYearToSecondType dateYearToSecondType() {
        return DataTypes.dateYearToSecondType();
    }

    /**
     * <p>dateYearType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.DateYearType} object.
     */
    public DateYearType dateYearType() {
        return DataTypes.dateYearType();
    }

    /**
     * <p>dateMonthType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.DateMonthType} object.
     */
    public DateMonthType dateMonthType() {
        return DataTypes.dateMonthType();
    }

    /**
     * <p>dateDayType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.DateDayType} object.
     */
    public DateDayType dateDayType() {
        return DataTypes.dateDayType();
    }

    /**
     * <p>doubleType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.DoubleType} object.
     */
    public DoubleType doubleType() {
        return DataTypes.doubleType();
    }

    /**
     * <p>floatType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.FloatType} object.
     */
    public FloatType floatType() {
        return DataTypes.floatType();
    }

    /**
     * <p>characterType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.CharacterType} object.
     */
    public CharacterType characterType() {
        return DataTypes.characterType();
    }

    /**
     * <p>integerType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.IntegerType} object.
     */
    public IntegerType integerType() {
        return DataTypes.integerType();
    }

    /**
     * <p>longType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.LongType} object.
     */
    public LongType longType() {
        return DataTypes.longType();
    }

    /**
     * <p>shortType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.ShortType} object.
     */
    public ShortType shortType() {
        return DataTypes.shortType();
    }

    /**
     * <p>stringType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.StringType} object.
     */
    public StringType stringType() {
        return DataTypes.stringType();
    }

    /**
     * <p>listType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.ListType} object.
     */
    public ListType listType() {
        return DataTypes.listType();
    }

    /**
     * <p>timeHourToFractionType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.TimeHourToFractionType} object.
     */
    public TimeHourToFractionType timeHourToFractionType() {
        return DataTypes.timeHourToFractionType();
    }

    /**
     * <p>timeHourToMinuteType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.TimeHourToMinuteType} object.
     */
    public TimeHourToMinuteType timeHourToMinuteType() {
        return DataTypes.timeHourToMinuteType();
    }

    /**
     * <p>timeHourToSecondType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.TimeHourToSecondType} object.
     */
    public TimeHourToSecondType timeHourToSecondType() {
        return DataTypes.timeHourToSecondType();
    }

    /**
     * <p>percentageType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.datatype.PercentageType} object.
     */
    public PercentageType percentageType() {
        return DataTypes.percentageType();
    }
}
