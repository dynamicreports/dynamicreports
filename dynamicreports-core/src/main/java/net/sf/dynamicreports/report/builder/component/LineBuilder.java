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

package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.report.base.component.DRLine;
import net.sf.dynamicreports.report.builder.style.PenBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.LineDirection;

/**
 * <p>LineBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class LineBuilder extends DimensionComponentBuilder<LineBuilder, DRLine> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for LineBuilder.</p>
     */
    protected LineBuilder() {
        super(new DRLine());
    }

    /**
     * <p>setDirection.</p>
     *
     * @param lineDirection a {@link net.sf.dynamicreports.report.constant.LineDirection} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.LineBuilder} object.
     */
    public LineBuilder setDirection(LineDirection lineDirection) {
        getObject().setDirection(lineDirection);
        return this;
    }

    /**
     * <p>setPen.</p>
     *
     * @param pen a {@link net.sf.dynamicreports.report.builder.style.PenBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.LineBuilder} object.
     */
    public LineBuilder setPen(PenBuilder pen) {
        if (pen != null) {
            getObject().setPen(pen.build());
        } else {
            getObject().setPen(null);
        }
        return this;
    }
}
