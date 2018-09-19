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

import net.sf.dynamicreports.design.definition.component.DRIDesignBreak;
import net.sf.dynamicreports.report.constant.BreakType;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignBreak class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignBreak extends DRDesignComponent implements DRIDesignBreak {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private BreakType breakType;

    /**
     * <p>Constructor for DRDesignBreak.</p>
     */
    public DRDesignBreak() {
        super("break");
    }

    /** {@inheritDoc} */
    @Override
    public BreakType getType() {
        return breakType;
    }

    /**
     * <p>setType.</p>
     *
     * @param breakType a {@link net.sf.dynamicreports.report.constant.BreakType} object.
     */
    public void setType(BreakType breakType) {
        this.breakType = breakType;
    }
}
