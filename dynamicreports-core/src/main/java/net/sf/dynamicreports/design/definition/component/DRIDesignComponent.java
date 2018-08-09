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

package net.sf.dynamicreports.design.definition.component;

import java.io.Serializable;
import java.util.List;

import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.DRIDesignTableOfContentsHeading;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignPropertyExpression;
import net.sf.dynamicreports.design.definition.style.DRIDesignStyle;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.StretchType;

/**
 * <p>DRIDesignComponent interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIDesignComponent extends Serializable {
	/**
	 * <p>getName.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getName();

	/**
	 * <p>getUniqueName.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getUniqueName();

	/**
	 * <p>getStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.definition.style.DRIDesignStyle} object.
	 */
	public DRIDesignStyle getStyle();

	/**
	 * <p>getX.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getX();

	/**
	 * <p>getY.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getY();

	/**
	 * <p>getWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getWidth();

	/**
	 * <p>getHeight.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getHeight();

	/**
	 * <p>getPrintWhenExpression.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
	 */
	public DRIDesignExpression getPrintWhenExpression();

	/**
	 * <p>isRemoveLineWhenBlank.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isRemoveLineWhenBlank();

	/**
	 * <p>getPropertyExpressions.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<DRIDesignPropertyExpression> getPropertyExpressions();

	/**
	 * <p>getPositionType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.ComponentPositionType} object.
	 */
	public ComponentPositionType getPositionType();

	/**
	 * <p>getStretchType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.StretchType} object.
	 */
	public StretchType getStretchType();

	/**
	 * <p>isPrintInFirstWholeBand.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isPrintInFirstWholeBand();

	/**
	 * <p>isPrintWhenDetailOverflows.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isPrintWhenDetailOverflows();

	/**
	 * <p>getPrintWhenGroupChanges.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignGroup} object.
	 */
	public DRIDesignGroup getPrintWhenGroupChanges();

	/**
	 * <p>getTableOfContentsHeading.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignTableOfContentsHeading} object.
	 */
	public DRIDesignTableOfContentsHeading getTableOfContentsHeading();
}
