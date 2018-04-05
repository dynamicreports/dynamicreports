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

package net.sf.dynamicreports.report.builder.datatype;

import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * A set of build in data types
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DataTypeBuilders {

	public <U, T extends DRIDataType<? super U, U>> T detectType(Class<U> dataType) throws DRException {
		return DataTypes.detectType(dataType);
	}

	public <T extends DRIDataType<?, ?>> T detectType(String dataType) throws DRException {
		return DataTypes.detectType(dataType);
	}

	public BigDecimalType bigDecimalType() {
		return DataTypes.bigDecimalType();
	}

	public BigIntegerType bigIntegerType() {
		return DataTypes.bigIntegerType();
	}

	public BooleanType booleanType() {
		return DataTypes.booleanType();
	}

	public ByteType byteType() {
		return DataTypes.byteType();
	}

	public DateType dateType() {
		return DataTypes.dateType();
	}

	public DateYearToFractionType dateYearToFractionType() {
		return DataTypes.dateYearToFractionType();
	}

	public DateYearToHourType dateYearToHourType() {
		return DataTypes.dateYearToHourType();
	}

	public DateYearToMinuteType dateYearToMinuteType() {
		return DataTypes.dateYearToMinuteType();
	}

	public DateYearToMonthType dateYearToMonthType() {
		return DataTypes.dateYearToMonthType();
	}

	public DateYearToSecondType dateYearToSecondType() {
		return DataTypes.dateYearToSecondType();
	}

	public DateYearType dateYearType() {
		return DataTypes.dateYearType();
	}

	public DateMonthType dateMonthType() {
		return DataTypes.dateMonthType();
	}

	public DateDayType dateDayType() {
		return DataTypes.dateDayType();
	}

	public DoubleType doubleType() {
		return DataTypes.doubleType();
	}

	public FloatType floatType() {
		return DataTypes.floatType();
	}

	public CharacterType characterType() {
		return DataTypes.characterType();
	}

	public IntegerType integerType() {
		return DataTypes.integerType();
	}

	public LongType longType() {
		return DataTypes.longType();
	}

	public ShortType shortType() {
		return DataTypes.shortType();
	}

	public StringType stringType() {
		return DataTypes.stringType();
	}

	public ListType listType() {
		return DataTypes.listType();
	}

	public TimeHourToFractionType timeHourToFractionType() {
		return DataTypes.timeHourToFractionType();
	}

	public TimeHourToMinuteType timeHourToMinuteType() {
		return DataTypes.timeHourToMinuteType();
	}

	public TimeHourToSecondType timeHourToSecondType() {
		return DataTypes.timeHourToSecondType();
	}

	public PercentageType percentageType() {
		return DataTypes.percentageType();
	}
}
