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
package net.sf.dynamicreports.googlecharts.jasper.geomap;

import java.io.Serializable;

import net.sf.jasperreports.engine.JRElementDataset;
import net.sf.jasperreports.engine.JRExpression;

/**
 * <p>GeoMapDataset interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface GeoMapDataset extends JRElementDataset, Serializable {

	/**
	 * <p>getLocationExpression.</p>
	 *
	 * @return a {@link net.sf.jasperreports.engine.JRExpression} object.
	 */
	public JRExpression getLocationExpression();

	/**
	 * <p>getValueExpression.</p>
	 *
	 * @return a {@link net.sf.jasperreports.engine.JRExpression} object.
	 */
	public JRExpression getValueExpression();

	/**
	 * <p>getLabelExpression.</p>
	 *
	 * @return a {@link net.sf.jasperreports.engine.JRExpression} object.
	 */
	public JRExpression getLabelExpression();

}
