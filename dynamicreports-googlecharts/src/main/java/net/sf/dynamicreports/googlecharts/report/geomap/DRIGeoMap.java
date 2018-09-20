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
package net.sf.dynamicreports.googlecharts.report.geomap;

import java.awt.Color;
import java.util.List;

import net.sf.dynamicreports.report.component.DRICustomComponent;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>DRIGeoMap interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIGeoMap extends DRICustomComponent {

	/**
	 * <p>getShowLegend.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getShowLegend();

	/**
	 * <p>getDataMode.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapDataMode} object.
	 */
	public GeoMapDataMode getDataMode();

	/**
	 * <p>getRegionExpression.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	public DRIExpression<String> getRegionExpression();

	/**
	 * <p>getValueLabelExpression.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	public DRIExpression<String> getValueLabelExpression();

	/**
	 * <p>getColors.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Color> getColors();

	/**
	 * <p>getDataset.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.DRIGeoMapDataset} object.
	 */
	public DRIGeoMapDataset getDataset();
}
