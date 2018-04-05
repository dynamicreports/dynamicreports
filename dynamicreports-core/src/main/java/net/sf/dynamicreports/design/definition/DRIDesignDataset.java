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

package net.sf.dynamicreports.design.definition;

import java.io.Serializable;
import java.util.Collection;

import net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignJasperExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSystemExpression;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public interface DRIDesignDataset extends Serializable {

	public String getName();

	public Collection<DRIDesignField> getFields();

	public Collection<DRIDesignVariable> getVariables();

	public Collection<DRIDesignSystemExpression> getSystemExpressions();

	public Collection<DRIDesignJasperExpression> getJasperExpressions();

	public Collection<DRIDesignSimpleExpression> getSimpleExpressions();

	public Collection<DRIDesignComplexExpression> getComplexExpressions();

	public Collection<DRIDesignSort> getSorts();

	public DRIDesignQuery getQuery();

	public DRIDesignExpression getConnectionExpression();

	public DRIDesignExpression getDataSourceExpression();

	public DRIDesignExpression getFilterExpression();
}
