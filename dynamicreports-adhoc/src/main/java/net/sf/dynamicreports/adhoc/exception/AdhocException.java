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

package net.sf.dynamicreports.adhoc.exception;

import net.sf.dynamicreports.adhoc.configuration.AdhocCalculation;
import net.sf.dynamicreports.adhoc.configuration.AdhocChartType;
import net.sf.dynamicreports.adhoc.configuration.AdhocGroupHeaderLayout;
import net.sf.dynamicreports.adhoc.configuration.AdhocHorizontalAlignment;
import net.sf.dynamicreports.adhoc.configuration.AdhocOrderType;
import net.sf.dynamicreports.adhoc.configuration.AdhocOrientation;
import net.sf.dynamicreports.adhoc.configuration.AdhocPageOrientation;
import net.sf.dynamicreports.adhoc.configuration.AdhocSubtotalPosition;
import net.sf.dynamicreports.adhoc.configuration.AdhocTimePeriod;
import net.sf.dynamicreports.adhoc.configuration.AdhocValueOperator;
import net.sf.dynamicreports.adhoc.configuration.AdhocVerticalAlignment;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocCalculation;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocChartType;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocGroupHeaderLayout;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocHorizontalAlignment;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocOrderType;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocOrientation;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocPageOrientation;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocSubtotalPosition;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocValueOperator;
import net.sf.dynamicreports.adhoc.xmlconfiguration.XmlAdhocVerticalAlignment;
import net.sf.dynamicreports.report.constant.Constants;

import static java.lang.String.format;

/**
 * <p>AdhocException class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class AdhocException extends RuntimeException {
	//todo add tests
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	/**
	 * <p>Constructor for AdhocException.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 */
	public AdhocException(String message) {
		super(format("%s not supported", message));
	}

	public static void unsupportedPageOrientationException(final AdhocPageOrientation adhocPageOrientation) {

		throw new AdhocException(format("Page orientation: %s", adhocPageOrientation.name()));
	}

	public static void unSupportedGroupHeaderLayout(final AdhocGroupHeaderLayout groupHeaderLayout) {

		throw new AdhocException(format("GroupHeader layout: %s", groupHeaderLayout.name()));
	}

	public static void unSupportedCalculationException(final AdhocCalculation adhocCalculation) {

		throw new AdhocException(format("AdhocCalculation: %s", adhocCalculation.name()));
	}

	public static void unSupportedValueOperatorException(final AdhocValueOperator adhocValueOperator) {

		throw new AdhocException(format("AdhocValueOperator: %s", adhocValueOperator.name()));
	}

	public static void unSupportedOrderTypeException(final AdhocOrderType adhocOrderType) {

		throw new AdhocException(format("AdhocOrderType: %s", adhocOrderType.name()));
	}

	public static void unSupportedOrientationException(final AdhocOrientation adhocOrientation) {

		throw new AdhocException(format("AdhocOrientation: %s", adhocOrientation.name()));
	}

	public static void unSupportedSubtotalPositionException(final AdhocSubtotalPosition adhocSubtotalPosition) {

		throw new AdhocException(format("AdhocSubstotalPosition: %s", adhocSubtotalPosition.name()));
	}

    public static void unSupportedVerticalTextAlignment(final AdhocVerticalAlignment adhocVerticalAlignment) {

	    throw new AdhocException(format("AdhocVerticalAlignment: %s", adhocVerticalAlignment.name()));
    }

    public static void unSupportedVerticalAlignmentException(final XmlAdhocVerticalAlignment xmlAdhocVerticalAlignment) {

	    throw new AdhocException(format("Vertical alignment: %s", xmlAdhocVerticalAlignment.name()));
    }

    public static void unSupportedChartTypeException(final AdhocChartType type) {

	    throw new AdhocException(format("ChartType: %s", type.name()));
    }

    public static void unSupportedHorizontalAlignmentException(final AdhocHorizontalAlignment adhocHorizontalAlignment) {

        throw new AdhocException(format("AdhocHorizontalAlignment: %s", adhocHorizontalAlignment.name()));
    }

    public static void unSupportedSubtotalPositionException(final XmlAdhocSubtotalPosition xmlAdhocSubtotalPosition) {

        throw new AdhocException(format("xmlAdhocSubtotalPosition: %s", xmlAdhocSubtotalPosition.name()));
    }

    public static void unsupportedPageOrientationException(final XmlAdhocPageOrientation xmlAdhocPageOrientation) {

        throw new AdhocException(format("XmlAdhocPageOrientation: %s", xmlAdhocPageOrientation.name()));
    }

    public static void unSupportedCalculationException(final XmlAdhocCalculation xmlAdhocCalculation) {

        throw new AdhocException(format("XmlAdhocCalculation: %s", xmlAdhocCalculation.name()));
    }

    public static void unSupportedHorizontalAlignmentException(final XmlAdhocHorizontalAlignment xmlAdhocHorizontalAlignment) {

        throw new AdhocException(format("XmlAdhocHorizontalAlignment: %s", xmlAdhocHorizontalAlignment.name()));
    }

    public static void unSupportedTimePeriodException(final AdhocTimePeriod timePeriod) {

        throw new AdhocException(format("AdhocTimePeriod: %s", timePeriod.name()));
    }

    public static void unSupportedOrderTypeException(final XmlAdhocOrderType xmlAdhocOrderType) {

        throw new AdhocException(format("XmlAdhocOrderType: %s", xmlAdhocOrderType.name()));
    }

    public static void unSupportedChartTypeException(final XmlAdhocChartType xmlAdhocChartType) {

        throw new AdhocException(format("XmlAdhocChartType: %s", xmlAdhocChartType.name()));
    }

    public static void unSupportedHorizontalTextAlignment(final AdhocHorizontalAlignment adhocHorizontalAlignment) {

        throw new AdhocException(format("HorizontalTextAlignment: %s", adhocHorizontalAlignment.name()));
    }

    public static void unSupportedOrientationException(final XmlAdhocOrientation xmlAdhocOrientation) {

        throw new AdhocException(format("XmlAdhocOrientation: %s", xmlAdhocOrientation.name()));
    }

    public static void unSupportedGroupHeaderLayout(final XmlAdhocGroupHeaderLayout xmlAdhocGroupHeaderLayout) {

        throw new AdhocException(format("XmlAdhocGroupHeaderLayout: %s", xmlAdhocGroupHeaderLayout.name()));
    }

    public static void unSupportedValueOperatorException(final XmlAdhocValueOperator xmlAdhocValueOperator) {

        throw new AdhocException(format("XmlAdhocValueOperator: %s", xmlAdhocValueOperator.name()));
    }
}
