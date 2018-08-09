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

package net.sf.dynamicreports.report.component;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.component.DRIDesignComponent;
import net.sf.dynamicreports.design.transformation.DesignTransformAccessor;
import net.sf.dynamicreports.jasper.transformation.JasperTransformAccessor;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRComponentElement;

/**
 * <p>CustomComponentTransform interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface CustomComponentTransform<T extends DRIComponent, U extends DRIDesignComponent> {

	/**
	 * <p>isTransform.</p>
	 *
	 * @param component a {@link java.lang.Object} object.
	 * @return a boolean.
	 */
	public boolean isTransform(Object component);

	/**
	 * <p>designComponent.</p>
	 *
	 * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
	 * @param component a T object.
	 * @param resetType a {@link net.sf.dynamicreports.design.constant.ResetType} object.
	 * @param resetGroup a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
	 * @return a U object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public U designComponent(DesignTransformAccessor accessor, T component, ResetType resetType, DRDesignGroup resetGroup) throws DRException;

	/**
	 * <p>jasperComponent.</p>
	 *
	 * @param accessor a {@link net.sf.dynamicreports.jasper.transformation.JasperTransformAccessor} object.
	 * @param component a U object.
	 * @return a {@link net.sf.jasperreports.engine.JRComponentElement} object.
	 */
	public JRComponentElement jasperComponent(JasperTransformAccessor accessor, U component);

}
