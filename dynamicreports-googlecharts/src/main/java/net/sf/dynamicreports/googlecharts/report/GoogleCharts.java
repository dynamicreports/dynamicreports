/**
 * DynamicReports - googlecharts - DynamicReports google charts
 * Copyright © 2010 Ricardo Mariaca and the DynamicReports Contributors (${email})
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.dynamicreports.googlecharts.report;

import net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder;

/**
 * <p>GoogleCharts class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GoogleCharts {

	/**
	 * <p>geoMap.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
	 */
	public static GeoMapBuilder geoMap() {
		return new GeoMapBuilder();
	}
}
