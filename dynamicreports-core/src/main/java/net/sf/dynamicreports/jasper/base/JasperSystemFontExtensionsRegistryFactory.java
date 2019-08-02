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
package net.sf.dynamicreports.jasper.base;

import net.sf.dynamicreports.report.defaults.Defaults;
import net.sf.jasperreports.engine.JRPropertiesMap;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JRPropertiesUtil.PropertySuffix;
import net.sf.jasperreports.engine.fonts.FontExtensionsRegistry;
import net.sf.jasperreports.extensions.DefaultExtensionsRegistry;
import net.sf.jasperreports.extensions.ExtensionsRegistry;
import net.sf.jasperreports.extensions.ExtensionsRegistryFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>JasperSystemFontExtensionsRegistryFactory class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperSystemFontExtensionsRegistryFactory implements ExtensionsRegistryFactory {
    /**
     * Constant <code>SYSTEM_FONT_FAMILIES_PROPERTY_PREFIX="DefaultExtensionsRegistry.PROPERTY_REGI"{trunked}</code>
     */
    public static final String SYSTEM_FONT_FAMILIES_PROPERTY_PREFIX = DefaultExtensionsRegistry.PROPERTY_REGISTRY_PREFIX + "system.font.families.";
    /**
     * Constant <code>PROPERTY_SYSTEM_FONT_FAMILIES_REGISTRY_FACTORY="DefaultExtensionsRegistry.PROPERTY_REGI"{trunked}</code>
     */
    public static final String PROPERTY_SYSTEM_FONT_FAMILIES_REGISTRY_FACTORY = DefaultExtensionsRegistry.PROPERTY_REGISTRY_FACTORY_PREFIX + "system.font.families";

    /** {@inheritDoc} */
    @Override
    public ExtensionsRegistry createRegistry(String registryId, JRPropertiesMap properties) {
        List<PropertySuffix> fontFamiliesProperties = JRPropertiesUtil.getProperties(properties, SYSTEM_FONT_FAMILIES_PROPERTY_PREFIX);
        List<String> fontFamiliesLocations = new ArrayList<String>();
        if (Defaults.getDefaults().isLoadSystemFonts()) {
            for (Iterator<PropertySuffix> it = fontFamiliesProperties.iterator(); it.hasNext(); ) {
                PropertySuffix fontFamiliesProp = it.next();
                String fontFamiliesLocation = fontFamiliesProp.getValue();
                fontFamiliesLocations.add(fontFamiliesLocation);
            }
        }

        return new FontExtensionsRegistry(fontFamiliesLocations);
    }

}
