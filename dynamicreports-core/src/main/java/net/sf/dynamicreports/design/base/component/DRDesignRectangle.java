/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.design.base.component;

import net.sf.dynamicreports.design.base.style.DRDesignPen;
import net.sf.dynamicreports.design.definition.component.DRIDesignRectangle;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignRectangle class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignRectangle extends DRDesignComponent implements DRIDesignRectangle {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Integer radius;
    private DRDesignPen pen;

    /**
     * <p>Constructor for DRDesignRectangle.</p>
     */
    public DRDesignRectangle() {
        super("rectangle");
    }

    /** {@inheritDoc} */
    @Override
    public Integer getRadius() {
        return radius;
    }

    /**
     * <p>Setter for the field <code>radius</code>.</p>
     *
     * @param radius a {@link java.lang.Integer} object.
     */
    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignPen getPen() {
        return pen;
    }

    /**
     * <p>Setter for the field <code>pen</code>.</p>
     *
     * @param pen a {@link net.sf.dynamicreports.design.base.style.DRDesignPen} object.
     */
    public void setPen(DRDesignPen pen) {
        this.pen = pen;
    }
}
