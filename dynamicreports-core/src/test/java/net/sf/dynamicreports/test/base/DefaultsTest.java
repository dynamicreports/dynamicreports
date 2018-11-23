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
package net.sf.dynamicreports.test.base;

import junit.framework.Assert;
import net.sf.dynamicreports.report.base.datatype.DRDataType;
import net.sf.dynamicreports.report.base.style.DRFont;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.defaults.Default;
import net.sf.dynamicreports.report.defaults.DefaultBinder;
import net.sf.dynamicreports.report.defaults.xml.XmlDynamicReports;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DefaultsTest {

    private Default load() {
        InputStream is = DefaultsTest.class.getResourceAsStream("dynamicreports-defaults.xml");
        try {
            Unmarshaller unmarshaller = JAXBContext.newInstance(XmlDynamicReports.class).createUnmarshaller();
            JAXBElement<XmlDynamicReports> root = unmarshaller.unmarshal(new StreamSource(is), XmlDynamicReports.class);
            return DefaultBinder.bind(root.getValue());
        } catch (JAXBException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        return null;
    }

    @Test
    public void test() {
        DefaultBinder.bind(null);
        Default defaults = load();

        DRFont font = defaults.getFont();
        /*Assert.assertEquals("Font name", "SansSerif", font.getFontName());*/
        Assert.assertEquals("Font name", "Arial", font.getFontName());
        Assert.assertEquals("Font size", Integer.valueOf(15), font.getFontSize());
        Assert.assertEquals("Pdf font name", "Courier New", font.getPdfFontName());
        Assert.assertEquals("Pdf encoding", "Cp1250", font.getPdfEncoding());
        Assert.assertTrue("Pdf embedded", font.getPdfEmbedded());

        testDataType("BigDecimal", defaults.getBigDecimalType(), "#,###.00#", HorizontalTextAlignment.LEFT);
        testDataType("BigInteger", defaults.getBigIntegerType(), "#,###", HorizontalTextAlignment.LEFT);
        testDataType("Byte", defaults.getByteType(), "#,###", HorizontalTextAlignment.LEFT);
        testDataType("Double", defaults.getDoubleType(), "#,###.#", HorizontalTextAlignment.LEFT);
        testDataType("Float", defaults.getFloatType(), "#,###.#", HorizontalTextAlignment.LEFT);
        testDataType("Integer", defaults.getIntegerType(), "#,###", HorizontalTextAlignment.LEFT);
        testDataType("Long", defaults.getLongType(), "#,###", HorizontalTextAlignment.LEFT);
        testDataType("Short", defaults.getShortType(), "#,###", HorizontalTextAlignment.LEFT);
        testDataType("Date", defaults.getDateType(), "MM.dd.yyyy", HorizontalTextAlignment.LEFT);
        testDataType("DateYearToMonth", defaults.getDateYearToMonthType(), "MM.yyyy", HorizontalTextAlignment.LEFT);
        testDataType("DateYearToHour", defaults.getDateYearToHourType(), "MM.dd.yyyy h a", HorizontalTextAlignment.LEFT);
        testDataType("DateYearToMinute", defaults.getDateYearToMinuteType(), "MM.dd.yyyy h:mm a", HorizontalTextAlignment.LEFT);
        testDataType("DateYearToSecond", defaults.getDateYearToSecondType(), "MM.dd.yyyy h:mm:ss a", HorizontalTextAlignment.LEFT);
        testDataType("DateYearToFraction", defaults.getDateYearToFractionType(), "MM.dd.yyyy h:mm:ss,SSS a", HorizontalTextAlignment.LEFT);
        testDataType("DateYear", defaults.getDateYearType(), "yy", HorizontalTextAlignment.LEFT);
        testDataType("DateMonth", defaults.getDateMonthType(), "MM", HorizontalTextAlignment.LEFT);
        testDataType("DateDay", defaults.getDateDayType(), "d", HorizontalTextAlignment.LEFT);
        testDataType("TimeHourToMinute", defaults.getTimeHourToMinuteType(), "hh:mm a", HorizontalTextAlignment.LEFT);
        testDataType("TimeHourToSecond", defaults.getTimeHourToSecondType(), "hh:mm:ss a", HorizontalTextAlignment.LEFT);
        testDataType("TimeHourToFraction", defaults.getTimeHourToFractionType(), "hh:mm:ss,SSS a", HorizontalTextAlignment.LEFT);
        testDataType("Percentage", defaults.getPercentageType(), "#,###.00%", HorizontalTextAlignment.LEFT);
        testDataType("Boolean", defaults.getBooleanType(), null, HorizontalTextAlignment.RIGHT);
        testDataType("Character", defaults.getCharacterType(), null, HorizontalTextAlignment.RIGHT);
        testDataType("String", defaults.getStringType(), null, HorizontalTextAlignment.RIGHT);
    }

    private void testDataType(String name, DRDataType<?, ?> dataType, String pattern, HorizontalTextAlignment horizontalTextAlignment) {
        Assert.assertEquals(name + " pattern", pattern, dataType.getPattern());
        Assert.assertEquals(name + " horizontal alignment", horizontalTextAlignment, dataType.getHorizontalTextAlignment());
    }
}
