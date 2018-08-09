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

package net.sf.dynamicreports.report.definition;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>DRIDataset interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIDataset extends Serializable {

	/**
	 * <p>getFields.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<? extends DRIField<?>> getFields();

	/**
	 * <p>getVariables.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<? extends DRIVariable<?>> getVariables();

	/**
	 * <p>getSorts.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<? extends DRISort> getSorts();

	/**
	 * <p>getQuery.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.DRIQuery} object.
	 */
	public DRIQuery getQuery();

	/**
	 * <p>getConnectionExpression.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	public DRIExpression<Connection> getConnectionExpression();

	/**
	 * <p>getDataSourceExpression.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	public DRIExpression<?> getDataSourceExpression();

	/**
	 * <p>getFilterExpression.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	public DRIExpression<Boolean> getFilterExpression();
}
