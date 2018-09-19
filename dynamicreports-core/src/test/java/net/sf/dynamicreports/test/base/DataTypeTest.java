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

package net.sf.dynamicreports.test.base;

import junit.framework.Assert;
import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;
import net.sf.dynamicreports.report.builder.datatype.StringType;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.exception.DRException;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DataTypeTest {

    @Test
    public void detectTypeTest() {
        try {
            detectTypeTest(type.bigDecimalType(), BigDecimal.class);
            detectTypeTest(type.bigIntegerType(), BigInteger.class);
            detectTypeTest(type.byteType(), Byte.class);
            detectTypeTest(type.doubleType(), Double.class);
            detectTypeTest(type.floatType(), Float.class);
            detectTypeTest(type.integerType(), Integer.class);
            detectTypeTest(type.longType(), Long.class);
            detectTypeTest(type.shortType(), Short.class);
            detectTypeTest(type.dateType(), Date.class);
            detectTypeTest(type.dateYearToMonthType(), "DateYearToMonth");
            detectTypeTest(type.dateYearToHourType(), "DateYearToHour");
            detectTypeTest(type.dateYearToMinuteType(), "DateYearToMinute");
            detectTypeTest(type.dateYearToSecondType(), "DateYearToSecond");
            detectTypeTest(type.dateYearToFractionType(), "DateYearToFraction");
            detectTypeTest(type.dateYearType(), "DateYear");
            detectTypeTest(type.dateMonthType(), "DateMonth");
            detectTypeTest(type.dateDayType(), "DateDay");
            detectTypeTest(type.timeHourToMinuteType(), "TimeHourToMinute");
            detectTypeTest(type.timeHourToSecondType(), "TimeHourToSecond");
            detectTypeTest(type.timeHourToFractionType(), "TimeHourToFraction");
            detectTypeTest(type.percentageType(), "Percentage");
            detectTypeTest(type.booleanType(), Boolean.class);
            detectTypeTest(type.characterType(), Character.class);
            detectTypeTest(type.stringType(), String.class);
            detectTypeTest(type.stringType(), "Text");
            detectTypeTest(type.listType(), List.class);

            @SuppressWarnings("unused") BigDecimalType bigDecimalType = type.detectType(BigDecimal.class);
            @SuppressWarnings("unused") StringType stringType = type.detectType(String.class);
        } catch (DRException e) {
            Assert.fail(e.getMessage());
        }
    }

    public <U, T extends U> void detectTypeTest(DRIDataType<U, T> dataType, Class<T> valueClass) throws DRException {
        detectTypeTest(dataType, valueClass.getSimpleName());
        Assert.assertEquals("Detect data type", dataType.getClass(), type.detectType(valueClass.getName())
                                                                         .getClass());
        Assert.assertEquals("Detect data type", dataType.getClass(), type.detectType(valueClass)
                                                                         .getClass());
    }

    public <U, T extends U> void detectTypeTest(DRIDataType<U, T> dataType, String... dataTypes) throws DRException {
        for (String stringDataType : dataTypes) {
            Assert.assertEquals("Detect data type", dataType.getClass(), type.detectType(stringDataType)
                                                                             .getClass());
            Assert.assertEquals("Detect data type", dataType.getClass(), type.detectType(stringDataType.toLowerCase())
                                                                             .getClass());
            Assert.assertEquals("Detect data type", dataType.getClass(), type.detectType(stringDataType.toUpperCase())
                                                                             .getClass());
        }
    }

    @Test
    public void valueConversionTest() {
        valueConversionTest("BigDecimal", type.bigDecimalType(), 1000, "1,000.00");
        valueConversionTest("BigInteger", type.bigIntegerType(), 1000, "1,000");
        valueConversionTest("Byte", type.byteType(), 100, "100");
        valueConversionTest("Double", type.doubleType(), 1000.1, "1,000.1");
        valueConversionTest("Float", type.floatType(), 1000.1, "1,000.1");
        valueConversionTest("Integer", type.integerType(), 1000, "1,000");
        valueConversionTest("Long", type.longType(), 1000, "1,000");
        valueConversionTest("Short", type.shortType(), 1000, "1,000");

        Calendar c = Calendar.getInstance();
        c.set(2010, 0, 2, 15, 5, 20);
        c.set(Calendar.MILLISECOND, 100);
        Date date = c.getTime();
        valueConversionTest("Date", type.dateType(), date, "01/02/2010");
        valueConversionTest("DateYearToMonth", type.dateYearToMonthType(), date, "01/2010");
        valueConversionTest("DateYearToHour", type.dateYearToHourType(), date, "01/02/2010 3 PM");
        valueConversionTest("DateYearToMinute", type.dateYearToMinuteType(), date, "01/02/2010 3:05 PM");
        valueConversionTest("DateYearToSecond", type.dateYearToSecondType(), date, "01/02/2010 3:05:20 PM");
        valueConversionTest("DateYearToFraction", type.dateYearToFractionType(), date, "01/02/2010 3:05:20,100 PM");
        valueConversionTest("DateYear", type.dateYearType(), date, "2010");
        valueConversionTest("DateMonth", type.dateMonthType(), date, "January");
        valueConversionTest("DateDay", type.dateDayType(), date, "02");
        valueConversionTest("TimeHourToMinute", type.timeHourToMinuteType(), date, "3:05 PM");
        valueConversionTest("TimeHourToSecond", type.timeHourToSecondType(), date, "3:05:20 PM");
        valueConversionTest("TimeHourToFraction", type.timeHourToFractionType(), date, "3:05:20,100 PM");

        valueConversionTest("Percentage", type.percentageType(), 0.89156, "89.16%");
        valueConversionTest("Boolean", type.booleanType(), true, "true");
        valueConversionTest("Character", type.characterType(), 'a', "a");
        valueConversionTest("String", type.stringType(), "text", "text");
    }

    private <U, T extends U> void valueConversionTest(String name, DRIDataType<U, T> dataType, U value, String stringValue) {
        Assert.assertEquals(name + " valueToString", stringValue, dataType.valueToString(value, Locale.ENGLISH));

        try {
            String stringResult = dataType.valueToString(value, Locale.ENGLISH);
            U stringToValue = dataType.stringToValue(stringValue, Locale.ENGLISH);
            Assert.assertTrue(name + " stringToValue class ", stringToValue.getClass()
                                                                           .equals(dataType.getValueClass()));
            Assert.assertEquals(name + " stringToValue", stringResult, dataType.valueToString(stringToValue, Locale.ENGLISH));
        } catch (DRException e) {
            Assert.fail(e.getMessage());
        }
    }
}
