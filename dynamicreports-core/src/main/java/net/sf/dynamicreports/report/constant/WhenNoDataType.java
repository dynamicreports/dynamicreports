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
package net.sf.dynamicreports.report.constant;

/**
 * <p>WhenNoDataType class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public enum WhenNoDataType {
    /**
     * Specifies that in case of empty datasources, there will be an empty report.
     */
    NO_PAGES, /**
     * Specifies that in case of empty datasources, there will be a report with just one blank page.
     */
    BLANK_PAGE, /**
     * Specifies that in case of empty datasources, all sections except detail will displayed.
     */
    ALL_SECTIONS_NO_DETAIL, /**
     * Specifies that in case of empty datasources, the NoData section will be displayed.
     */
    NO_DATA_SECTION
}
