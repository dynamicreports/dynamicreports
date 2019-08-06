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
package net.sf.dynamicreports.adhoc.exception;

import net.sf.dynamicreports.report.exception.DRException;

import java.io.InputStream;

/**
 * Exception thrown when reading configurations from a given InputStream
 */
public class ConfigurationUnMarshallerException extends DRException {


    /**
     * Constructs a ConfigurationUnMarshallerException using the inputStream from which we are reading configurations when the exceptional event occurs. For instance it is used in the adhocManager to
     * capture exceptions when loading data from an xml file like so:
     * <pre>
     *     {@code
     *     try {
     *          Unmarshaller unmarshaller = JAXBContext.newInstance(XmlAdhocConfiguration.class).createUnmarshaller();
     *          JAXBElement<XmlAdhocConfiguration> element = unmarshaller.unmarshal(new StreamSource(is), XmlAdhocConfiguration.class);
     *          XmlAdhocConfiguration xmlAdhocConfiguration = element.getValue();
     *          AdhocConfiguration adhocConfiguration = xmlToAdhocTransform.transform(xmlAdhocConfiguration);
     *          return adhocConfiguration;
     *       } catch (JAXBException e) {
     *          // time to throw our exception
     *          throw new ConfigurationUnMarshallerException(is);
     *       }
     *     }
     * </pre>
     *
     * @param is The InputStream from which we are reading configuration data
     */
    public ConfigurationUnMarshallerException(final InputStream is) {

        super(String.format("Exception encountered when reading configuration from the source : %s", is));
    }

    public ConfigurationUnMarshallerException(String message) {
        super(message);
    }
}
